import * as React from 'react';
import { useState, useEffect } from "react";
import { request, setAuthToken, getAuthToken } from '../axios_helper.js';
import { TableContainer, Table, TableHead, TableRow, TableCell, TableBody } from '@mui/material';
import "./button.css"
import { Paper, Button } from "@mui/material";
import { Unstable_Popup as BasePopup } from '@mui/base/Unstable_Popup';
import { styled } from '@mui/system';

let b = 0;

export default function Diet() {
  const Boxdiv = document.getElementById("BigBox");
  const [error, setError] = useState('');
  const [jsonData, setJsonData] = useState([]);
  const [jsonMealKitData, setJsonMealKitData] = useState([]);
  const [shoppingList, setShoppingList] = useState([]);
  const [list, setList] = useState([]);

  useEffect(() => async () => {
    const AuthToken = getAuthToken();

    if (AuthToken === null || AuthToken === "null" || AuthToken === "undefined") {
      setError("Nie jesteś zalogowany! Powrót do strony logowania...");
      const delay = ms => new Promise(res => setTimeout(res, ms));
      await delay(3000);

      window.location.href = '/login';
    } else {
      postDiet();
    }
  }, []);

  function showDiv(divId) {
    if (divId == 'option1') {
      postDiet();
      buttonElement.style.display = 'none';
    }
    else if (b > 1) {
      buttonElement.style.display = 'block';
    }
    var divs = document.querySelectorAll('.content > div'); // Get all content divs
    for (var i = 0; i < divs.length; i++) {
      if (divs[i].id === divId) {
        divs[i].style.display = 'block'; // Show the selected div
      } else {
        divs[i].style.display = 'none'; // Hide other divs
      }
    }
  }

  const countCalories = (list) => {
    let l = 0;

    for (const o of list) {
      l += o.calories;
    }

    return l;
  };

  const postDiet = () => {
    request("GET",
      "http://localhost:8080/postOneDayDiet",
      null
    )
      .then((response) => {
        const ingredientInfo = response.data.flatMap((item) => item.ingredientAssoc.flatMap(ingredient => ingredient.split('g ')));
        const sortedIngredientInfo = ingredientInfo.sort((a, b) => a.localeCompare(b));

        const ingredientFrequencyMap = new Map();
        sortedIngredientInfo.forEach(ingredient => {
          if (ingredientFrequencyMap.has(ingredient)) {
            ingredientFrequencyMap.set(ingredient, ingredientFrequencyMap.get(ingredient) + 1);
          } else {
            ingredientFrequencyMap.set(ingredient, 1);
          }
        });

        const aggregatedIngredients = new Map();

        ingredientFrequencyMap.forEach((count, ingredient) => {
          const name = ingredient.substr(0, ingredient.indexOf(':'));
          const value = parseInt(ingredient.substring(ingredient.indexOf(':') + 1).slice(0, -1));

          if (aggregatedIngredients.has(name)) {
            aggregatedIngredients.set(name, aggregatedIngredients.get(name) + value * count);
          } else {
            aggregatedIngredients.set(name, value * count);
          }
        });

        setList(aggregatedIngredients);

        setJsonData(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
        window.alert("Najpierw dodaj profil użytkownika!");
        window.location.href = '/addBmi';
      });
  };
  useEffect(() => {
    console.log("shoppingList: ", shoppingList);
  }, [shoppingList]);

  const getMealKitInfo = () => {
    request("GET",
      "http://localhost:8080/GetMealKitInfo",
      null
    )
      .then((response) => {
        const updatedMealKitData = response.data.filter(item => item.mealGroup !== 0);
        const ingredientInfo = response.data.flatMap((item) => item.ingredientAssoc.flatMap(ingredient => ingredient.split('g ')));
        // setShoppingList(ingredientInfo);
        const sortedIngredientInfo = ingredientInfo.sort((a, b) => a.localeCompare(b));

        const ingredientFrequencyMap = new Map();
        sortedIngredientInfo.forEach(ingredient => {
          if (ingredientFrequencyMap.has(ingredient)) {
            ingredientFrequencyMap.set(ingredient, ingredientFrequencyMap.get(ingredient) + 1);
          } else {
            ingredientFrequencyMap.set(ingredient, 1);
          }
        });

        const aggregatedIngredients = new Map();

        ingredientFrequencyMap.forEach((count, ingredient) => {
          const name = ingredient.substr(0, ingredient.indexOf(':'));
          const value = parseInt(ingredient.substring(ingredient.indexOf(':') + 1).slice(0, -1));

          if (aggregatedIngredients.has(name)) {
            aggregatedIngredients.set(name, aggregatedIngredients.get(name) + value * count);
          } else {
            aggregatedIngredients.set(name, value * count);
          }
        });

        // aggregatedIngredients.forEach((totalValue, ingredient) => {
        //   console.log(`${ingredient}: ${totalValue}g`);
        // });

        setShoppingList(aggregatedIngredients);
        setJsonMealKitData(updatedMealKitData);
        console.log(shoppingList);
      })
      .catch((error) => {
        console.log(error);
        window.alert("@@@@@@@@@@@@@@@@@@@@!");
        window.location.href = '/addBmi';
      });
  };

  const downloadOneList = () => {
    const textContent = Array.from(list.entries())
      .map(([key, value]) => `${key}: ${value}g`)
      .join('\n');

    const blob = new Blob([textContent], { type: 'text/plain' });
    const link = document.createElement('a');
    link.href = window.URL.createObjectURL(blob);
    link.download = 'ListaZakupów.txt';

    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  };

  const downloadList = () => {
    const textContent = Array.from(shoppingList.entries())
      .map(([key, value]) => `${key}: ${value}g`)
      .join('\n');

    const blob = new Blob([textContent], { type: 'text/plain' });
    const link = document.createElement('a');
    link.href = window.URL.createObjectURL(blob);
    link.download = 'ListaZakupów.txt';

    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  };

  const postSevenDiet = () => {
    request("GET",
      "http://localhost:8080/postSevenDayDiet",
      null
    )
      .then((response) => {
        setJsonData(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
        window.alert("aaaaaaaaaaaa!");
        window.location.href = '/addBmi';
      });
  };

  const deleteDiet = () => {
    request("GET",
      `http://localhost:8080/deleteDiet`,
      null
    )
      .then((response) => {
        window.alert("Pomyślnie zmieniono dietę!");
        postDiet();
      })
      .catch((error) => {
        console.log(error);
        window.alert("Najpierw dodaj dietę!");
      });
  };

  const deleteSevenDiet = () => {
    request("DELETE",
      `http://localhost:8080/deleteSevenDiet`,
      null
    )
      .then((response) => {
        window.alert("Pomyślnie zmieniono dietę!");
        postSevenDiet();
      })
      .catch((error) => {
        console.log(error);
        window.alert("Najpierw dodaj dietę!");
      });
  };

  const [anchors, setAnchors] = React.useState(Array(7).fill(null).map(() => React.createRef()));

  const handleClick = (event, index) => {
    if (Boxdiv.style.filter === "blur(3px)") {
      Boxdiv.style.filter = "blur(0)";
      Boxdiv.style.pointerEvents = "auto";
    } else {
      Boxdiv.style.filter = "blur(3px)";
      Boxdiv.style.pointerEvents = "none";
    }

    const newAnchors = anchors.slice();
    newAnchors[index].current = newAnchors[index].current ? null : event.currentTarget;
    setAnchors(newAnchors);
  };

  const open = (index) => Boolean(anchors[index].current);
  const id = (index) => open(index) ? `simple-popup-${index}` : undefined;

  const mealsSevenList = () => (
    <div>
      <br /><br />
      <TableContainer component={Paper}>
        {Array.from({ length: 7 }, (_, i) => (
          <div key={i} style={{ maxWidth: 450, display: 'inline-block', margin: '10px' }}>
            <Button variant="outlined" style={{ float: "right" }} onClick={(e) => handleClick(e, i)} size="small">
              Szczegóły
            </Button>
            {open(i) && (
              <React.Fragment>
                <BasePopup
                  id={id(i)}
                  open={open(i)}
                  anchor={anchors[i].current}
                  ref={anchors[i]}
                  style={{
                    backgroundColor: "grey",
                    position: "fixed",
                    top: "50%",
                    left: "50%",
                    transform: "translate(-50%, -50%)",
                    minWidth: "1600px",
                  }}
                >
                  <div className="popup-content">
                    <button className="close-button" onClick={() => handleClick(null, i)}>X</button>
                    <table>
                      <thead>
                        <tr>
                          <th>Nazwa</th>
                          <th>Kalorie</th>
                          <th>Tłuszcze</th>
                          <th>Białka</th>
                          <th>Węgle</th>
                          <th>Przepis</th>
                        </tr>
                      </thead>
                      <tbody>
                        {jsonMealKitData
                          .filter((mealKit) => mealKit.mealGroup === i + 1)
                          .map((mealKit, ii) => (
                            <React.Fragment key={ii}>
                              <tr>
                                <td>{mealKit.mealName}</td>
                                <td>{mealKit.calories}</td>
                                <td>{mealKit.fats}</td>
                                <td>{mealKit.proteins}</td>
                                <td>{mealKit.carbohydrates}</td>
                                <td>{mealKit.recipe}</td>
                              </tr>
                              {ii < jsonMealKitData.length - 1 && (
                                <tr className="row-divider">
                                  <td colSpan="6"></td>
                                </tr>
                              )}
                            </React.Fragment>
                          ))}
                      </tbody>
                    </table>
                  </div>
                </BasePopup>
              </React.Fragment>
            )}
            <h3>Dzień {i + 1} </h3>
            <Table sx={{ maxWidth: '100%' }} size="small" aria-label="a dense table">
              <TableHead>
                <TableRow style={{ fontWeight: 'bold' }}>
                  <TableCell><b>Nazwa posiłku</b></TableCell>
                  <TableCell><b>Kalorie</b></TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {jsonMealKitData
                  .filter((mealKit) => mealKit.mealGroup === i + 1)
                  .map((mealKit, ii) => (
                    <TableRow key={`${i + 1}-${ii}`}>
                      <TableCell>{mealKit.mealName}</TableCell>
                      <TableCell>{mealKit.calories}</TableCell>
                    </TableRow>
                  ))}
              </TableBody>
            </Table>
          </div>
        ))}
      </TableContainer>
    </div>
  )

  const mealsList = () => (
    <div>
      <p>Łącznie kalorii: {countCalories(jsonData)}</p>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
          <TableHead>
            <TableRow style={{ fontWeight: 'bold' }}>
              <TableCell><b>Nazwa posiłku</b></TableCell>
              <TableCell align="right"><b>Kilo kalorie</b></TableCell>
              <TableCell align="right"><b>Białka (g)</b></TableCell>
              <TableCell align="right"><b>Węglowodany (g)</b></TableCell>
              <TableCell align="right"><b>Tłuszcze (g)</b></TableCell>
              <TableCell><b>Przepis</b></TableCell>
              <TableCell><b>Składniki</b></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {jsonData.map((meal, index) => (
              <TableRow key={index}>
                <TableCell>{meal.mealName}</TableCell>
                <TableCell align="right">{meal.calories}</TableCell>
                <TableCell align="right">{meal.proteins}</TableCell>
                <TableCell align="right">{meal.carbohydrates}</TableCell>
                <TableCell align="right">{meal.fats}</TableCell>
                <TableCell>{meal.recipe}</TableCell>
                <TableCell>
                  <ul>
                    {meal.ingredientAssoc.map((ingredient, i) => (
                      <li key={i}>{ingredient}</li>
                    ))}
                  </ul>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );

  const mealsSevenList2 = () => (
    <div>
      {/* <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
          <TableHead>
            <TableRow style={{ fontWeight: 'bold' }}>
              <TableCell><b>X</b></TableCell>
              <TableCell><b>Nazwa posiłku</b></TableCell>
              <TableCell align="right"><b>Kilo kalorie</b></TableCell>
              <TableCell align="right"><b>Białka (g)</b></TableCell>
              <TableCell align="right"><b>Węglowodany (g)</b></TableCell>
              <TableCell align="right"><b>Tłuszcze (g)</b></TableCell>
              <TableCell><b>Przepis</b></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
          {jsonData.map((meal, index) => (
              <TableRow key={index}>
                <TableCell>
                  <input
                    type="checkbox"
                    checked={checkedRows.includes(index)}
                    onChange={() => handleCheckboxChange(index)}
                  />
                </TableCell>
                <TableCell>{meal.mealName}</TableCell>
                <TableCell align="right">{meal.calories}</TableCell>
                <TableCell align="right">{meal.proteins}</TableCell>
                <TableCell align="right">{meal.carbohydrates}</TableCell>
                <TableCell align="right">{meal.fats}</TableCell>
                <TableCell>{meal.recipe}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer> */}

      <TableContainer component={Paper}>
        {Array.from({ length: 7 }, (_, i) => (
          <div key={i} style={{display: 'inline-block', margin: '10px' }}>
            <h3>Dzień {i + 1} </h3>
            <Table sx={{ maxWidth: '100%' }} size="small" aria-label="a dense table">
              <TableHead>
                <TableRow style={{ fontWeight: 'bold' }}>
                  <TableCell><b>X</b></TableCell>
                  <TableCell><b>Nazwa posiłku</b></TableCell>
                  <TableCell><b>Kilo kalorie</b></TableCell>
                  <TableCell><b>Białka (g)</b></TableCell>
                  <TableCell><b>Węglowodany (g)</b></TableCell>
                  <TableCell><b>Tłuszcze (g)</b></TableCell>
                  <TableCell><b>Przepis</b></TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {jsonMealKitData
                  .filter((mealKit) => mealKit.mealGroup === i + 1)
                  .map((mealKit, ii) => (
                    <TableRow key={`${i + 1}-${ii}`}>
                      <TableCell>
                        <input
                          type="checkbox"
                          checked={checkedRows.includes(i)}
                          onChange={() => handleCheckboxChange(i)}
                        />
                      </TableCell>
                      <TableCell>{mealKit.mealName}</TableCell>
                      <TableCell>{mealKit.calories}</TableCell>
                      <TableCell>{mealKit.proteins}</TableCell>
                      <TableCell>{mealKit.carbohydrates}</TableCell>
                      <TableCell>{mealKit.fats}</TableCell>
                      <TableCell>{mealKit.recipe}</TableCell>
                    </TableRow>
                  ))}
              </TableBody>
            </Table>
          </div>
        ))}
      </TableContainer>

      <p style={{ float: 'right' }}>Łącznie kalorii: {countCalories(jsonData)}</p>
    </div>
  );

  const [checkedRows, setCheckedRows] = useState([]);

  const handleCheckboxChange = (index) => {
    const isChecked = checkedRows.includes(index);

    if (isChecked) {
      setCheckedRows(checkedRows.filter((item) => item !== index));
      b--;
    } else {
      setCheckedRows([...checkedRows, index]);
      b++;
    }
    if (b > 1) buttonElement.style.display = 'block';
    else buttonElement.style.display = 'none';
    console.log(b);
  };

  const selectedMeals = jsonData.filter((meal, index) => checkedRows.includes(index));

  const editDiet = () => {
    const mealNames = selectedMeals.map((meal) => meal.mealName);

    const mealNamesData = {
      mealNames
    };

    request(
      "POST",
      "http://localhost:8080/changeMeal",
      JSON.stringify(mealNamesData)
    )
      .then((response) => {
        console.log("Success:", response.data);
        window.alert("Zmieniono posiłki!");
        window.location.href = '/Diet';
      })
      .catch((error) => {
        console.error("Error:", error);
        window.alert("PROBLEMO");
      });
  };

  const mealsList2 = () => (
    <div>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
          <TableHead>
            <TableRow style={{ fontWeight: 'bold' }}>
              <TableCell><b>X</b></TableCell>
              <TableCell><b>Nazwa posiłku</b></TableCell>
              <TableCell align="right"><b>Kilo kalorie</b></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {jsonData.map((meal, index) => (
              <TableRow key={index}>
                <TableCell>
                  <input
                    type="checkbox"
                    checked={checkedRows.includes(index)}
                    onChange={() => handleCheckboxChange(index)}
                  />
                </TableCell>
                <TableCell>{meal.mealName}</TableCell>
                <TableCell align="right">{meal.calories}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      <p style={{ float: 'right' }}>Łącznie kalorii: {countCalories(jsonData)}</p>
    </div>
  );

  const buttonElement = document.getElementById('submitButton');

  return (
    <div>
      <h1>{error}</h1>
      <div className="BigBox" id="BigBox">

        <br /><br />
        <Paper className="menu" elevation={3}>
          <h3 onClick={() => showDiv('option1')} className="clickable-text">Jednodniowa dieta</h3>
          <h3 onClick={() => { showDiv('option3'); postSevenDiet(); getMealKitInfo(); }} className="clickable-text">Siedmiodniowa dieta</h3>
        </Paper>

        <Paper className="content" elevation={3}>
          <div className="dataDisplay" style={{ display: "block" }} id="option1">
            <Button variant="outlined" onClick={deleteDiet} size="large">Generuj nową dietę</Button>
            <Button variant="outlined" onClick={downloadOneList} size="large">Lista zakupów</Button>
            <Button variant="outlined" style={{ float: "right" }} onClick={() => showDiv('option2')} size="large">Edytuj dietę</Button>
            {mealsList()}

          </div>
          <div className="dataDisplay" style={{ display: "none" }} id="option2">
            <Button variant="outlined" style={{ float: "right" }} onClick={() => showDiv('option1')} size="large">Powrót</Button>
            <h2 style={{ paddingBottom: "25px" }}>Zaznacz posiłki, które chcesz wymienić.</h2>

            {mealsList2()}
          </div>
          <div className="dataDisplay" style={{ display: "none" }} id="option3">
            <Button variant="outlined" onClick={deleteSevenDiet} size="large">Generuj nową dietę</Button>
            <Button variant="outlined" onClick={downloadList} size="large">Lista zakupów</Button>
            <Button variant="outlined" style={{ float: "right" }} onClick={() => { showDiv('option4'); }} size="large">Edytuj dietę</Button>

            {mealsSevenList()}

          </div>
          <div className="dataDisplay" style={{ display: "none" }} id="option4">
            <h2 style={{ paddingBottom: "25px" }}>Zaznacz posiłki, które chcesz wymienić.</h2>
            {mealsSevenList2()}
          </div>
          <br></br>
          <button className="myButton" id="submitButton" style={{ display: "none" }} onClick={editDiet}>Submit</button>
        </Paper>
      </div >
    </div >
  );
}

const grey = {
  50: '#F3F6F9',
  100: '#E5EAF2',
  200: '#DAE2ED',
  300: '#C7D0DD',
  400: '#B0B8C4',
  500: '#9DA8B7',
  600: '#6B7A90',
  700: '#434D5B',
  800: '#303740',
  900: '#1C2025',
};

const blue = {
  200: '#99CCFF',
  300: '#66B2FF',
  400: '#3399FF',
  500: '#007FFF',
  600: '#0072E5',
  700: '#0066CC',
};

const x = styled('div')(
  ({ theme }) => `
  width: max-content;
  padding: 12px 16px;
  margin: 8px;
  border-radius: 8px;
  border: 1px solid ${theme.palette.mode === 'dark' ? grey[700] : grey[200]};
  background-color: ${theme.palette.mode === 'dark' ? grey[900] : '#fff'};
  box-shadow: ${theme.palette.mode === 'dark'
      ? `0px 4px 8px rgb(0 0 0 / 0.7)`
      : `0px 4px 8px rgb(0 0 0 / 0.1)`
    };
  font-family: 'IBM Plex Sans', sans-serif;
  font-weight: 500;
  font-size: 0.875rem;
  z-index: 1;
`,
);
