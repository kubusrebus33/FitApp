import * as React from 'react';
import { useState, useEffect } from "react";
import { request, setAuthToken, getAuthToken } from '../axios_helper.js';
import Paper from '@mui/material/Paper';
import TableContainer from '@mui/material/TableContainer';
import Table from '@mui/material/Table';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import TableCell from '@mui/material/TableCell';
import TableBody from '@mui/material/TableBody';
import Button from '@mui/material/Button';

export default function Diet() {
  const [error, setError] = useState('');
  const [jsonData, setJsonData] = useState([]);

  useEffect(() => async () => {
    const AuthToken = getAuthToken();

    if (AuthToken === null || AuthToken === "null" || AuthToken === "undefined") {
      setError("You are not logged in! Returning to login page.");
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
      "http://localhost:8080/postUserDiet",
      null
    )
      .then((response) => {
        setJsonData(response.data);
      })
      .catch((error) => {
        console.log(error);
        window.alert("Nie można wygenerować diety!");
        window.location.href = '/addBmi';
      });
  };


  const deleteDiet = () => {
    request("GET",
      `http://localhost:8080/deleteDiet`,
      null
    )
      .then((response) => {
        postDiet();
      })
      .catch((error) => {
        console.log(error);
        window.alert("Najpierw dodaj dietę!");
      });
  };

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

  const mealsList2 = () => (
    <div>
      <p>Łącznie kalorii: {countCalories(jsonData)}</p>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
          <TableHead>
            <TableRow style={{ fontWeight: 'bold' }}>
              <TableCell><b>Nazwa posiłku</b></TableCell>
              <TableCell align="right"><b>Kilo kalorie</b></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {jsonData.map((meal, index) => (
              <TableRow key={index}>
                <TableCell>{meal.mealName}</TableCell>
                <TableCell align="right">{meal.calories}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  );

  return (
    <div>
      <h1>{error}</h1>
      <div className="BigBox">

        <br /><br />
        <Paper className="menu" elevation={3}>
          <h3 onClick={() => showDiv('option1')} className="clickable-text">Moja dieta</h3>
          <h3 onClick={() => showDiv('option2')} className="clickable-text">Edytuj  dietę</h3>
        </Paper>

        <Paper className="content" elevation={3}>
          <div className="dataDisplay" style={{ display: "block" }} id="option1">
            <Button variant="outlined" onClick={deleteDiet} size="large">Generuj nową dietę</Button>
            {mealsList()}

          </div>
          <div className="dataDisplay" style={{ display: "none" }} id="option2">
            {mealsList2()}
          </div>
        </Paper>
      </div >
    </div >
  );
}