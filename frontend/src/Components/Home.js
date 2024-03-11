import * as React from 'react';
import { Paper, Button } from '@mui/material';
import "./paperStyles.css";
import { useState, useEffect } from "react";
import { request, getAuthToken } from '../axios_helper.js';
import './pieChart.js';
import { Pie } from 'react-chartjs-2';
import { TableContainer, Table, TableHead, TableRow, TableCell, TableBody } from '@mui/material';
import { Unstable_Popup as BasePopup } from '@mui/base/Unstable_Popup';

export default function Home() {

  const [error, setError] = useState('');
  const [showDiv, setShowDiv] = useState(true);
  const [jsonData, setJsonData] = useState([]);
  const [jsonSevenData, setJsonSevenData] = useState([]);
  const [x, setX] = useState(1);
  
  const [numArr, setNumArr] = useState([1, 2, 3]);

  const [data, setData] = useState({
    labels: ['Białko', 'Węglowodany', 'Tłuszcze'],
    datasets: [
      {
        label: '% zawartość w diecie',
        data: numArr,
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
        ],
        borderWidth: 1,
      },
    ],
  });

  const getMealKitInfo = () => {
    request("GET",
      "http://localhost:8080/GetMealKitInfo",
      null
    )
      .then((response) => {
        const updatedMealKitData = response.data.filter(item => item.mealGroup !== 0);
        setJsonSevenData(updatedMealKitData);
      })
      .catch((error) => {
        console.log(error);
        window.alert("@@@@@@@@@@@@@@@@@@@@!");
        window.location.href = '/addBmi';
      });
  };

  useEffect(() => {
    let y = countMakros(jsonData);
    setData({
      labels: ['Białko', 'Węglowodany', 'Tłuszcze'],
      datasets: [
        {
          label: '% zawartość w diecie',
          data: y,
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
          ],
          borderWidth: 1,
        },
      ],
    });
  }, [jsonData]);

  useEffect(() => async () => {
    const AuthToken = getAuthToken();

    if (AuthToken === null || AuthToken === "null" || AuthToken === "undefined") {
      setError("Nie jesteś zalogowany! Powrót do strony logowania...");
      setShowDiv(false);
      const delay = ms => new Promise(res => setTimeout(res, ms));
      await delay(3000);

      window.location.href = '/login';
    } else {
      getDiet();
      getMealKitInfo();
    }
  }, []);

  const countMakros = (list) => {
    let c = 0;
    let p = 0;
    let f = 0;

    for (const o of list) {
      c += o.carbohydrates;
      p += o.proteins;
      f += o.fats;
    }

    let z = countCalories(jsonData);

    c = Math.trunc(100 * (parseInt(c) * 4) / z);
    p = Math.trunc(100 * (parseInt(p) * 4) / z);
    f = Math.trunc(100 * (parseInt(f) * 9) / z);

    return [p, c, f];
  };

  const mealsSevenList = () => (
    <div>
      <h1>{countCalories(jsonSevenData) == 0 ? "Obecnie nie posiadasz diety do wyświetlenia." : "Twoja obecna dieta 7 dniowa:"}</h1>
      <br /><br />
      <TableContainer component={Paper}>
        {Array.from({ length: 7 }, (_, i) => (
          <div key={i} style={{ margin: '10px' }}>
            <h3>Dzień {i + 1} </h3>
            <Table sx={{ maxWidth: '100%' }} size="small">
              <TableHead>
                <TableRow style={{ fontWeight: 'bold'}}>
                  <TableCell><b>Nazwa posiłku</b></TableCell>
                  <TableCell><b>Kilo kalorie</b></TableCell>
                  <TableCell><b>Białka (g)</b></TableCell>
                  <TableCell><b>Węglowodany (g)</b></TableCell>
                  <TableCell><b>Tłuszcze (g)</b></TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {jsonSevenData
                  .filter((mealKit) => mealKit.mealGroup === i + 1)
                  .map((mealKit, ii) => (
                    <TableRow key={`${i + 1}-${ii}`}>
                      <TableCell>{mealKit.mealName}</TableCell>
                      <TableCell>{mealKit.calories}</TableCell>
                      <TableCell>{mealKit.proteins}</TableCell>
                      <TableCell>{mealKit.carbohydrates}</TableCell>
                      <TableCell>{mealKit.fats}</TableCell>
                    </TableRow>
                  ))}
              </TableBody>
            </Table>
          </div>
        ))}
      </TableContainer>
    </div>
  );

  const countCalories = (list) => {
    let l = 0;
    for (const o of list) {
      l += o.calories;
    }
    return l;
  };

  const mealsList = () => (
    <div>
      <h1>{countCalories(jsonData) == 0 ? "Obecnie nie posiadasz diety do wyświetlenia." : "Twoja obecna dieta 1 dniowa:"}</h1>
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
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );

  const getDiet = () => {
    request("GET",
      "http://localhost:8080/getUserDiet",
      null
    )
      .then((response) => {
        setJsonData(response.data);
        //window.location.href = '/addBmi';
        // mealsList();
        // window.location.reload(false);
      })
      .catch((error) => {
        console.log(error);
        window.alert("Błąd podczas wyświetlania diety!");
        //window.location.reload(false);
        window.location.href = '/Home';
      });
  };

  const toggleComponent = () => {
    if(d1.style.display === "none") {
        d1.style.display = "block";
        d2.style.display = "none";
        setX(0);
      }
    else {
        d1.style.display = "none";
        d2.style.display = "block";
        setX(1);
      }
  };

  const d1 = document.getElementById("d1");
  const d2 = document.getElementById("d2");

  return (
    <div>
      <h1>{error}</h1>
      <div className="BigBox">
        <br /><br />

        <Paper className="menu" elevation={3}>
          <Pie data={data} />
        </Paper>

        <Paper className="content" elevation={3}>
          <Button variant="outlined" style={{ float: "right" }} size="small" onClick={toggleComponent}>
            Dieta {x == 1 ? 1 : 7 } dniowa
          </Button>
          <div id="d1">
            {mealsList()}
          </div>
          <div id="d2" style={{ display: "none" }}>
            {mealsSevenList()}
          </div>
        </Paper>
      </div >
    </div >
  );
}
