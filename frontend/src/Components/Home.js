import * as React from 'react';
import Paper from '@mui/material/Paper';
import "./paperStyles.css";
import { useState, useEffect } from "react";
import { request, getAuthToken } from '../axios_helper.js';
import './pieChart.js';
import { Pie } from 'react-chartjs-2';
import TableContainer from '@mui/material/TableContainer';
import Table from '@mui/material/Table';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import TableCell from '@mui/material/TableCell';
import TableBody from '@mui/material/TableBody';

export default function Home() {

  const [error, setError] = useState('');
  const [showDiv, setShowDiv] = useState(true);
  const [jsonData, setJsonData] = useState([]);
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
    console.log(countMakros(jsonData));
  }, [jsonData]);

  useEffect(() => async () => {
    const AuthToken = getAuthToken();

    if (AuthToken === null || AuthToken === "null" || AuthToken === "undefined") {
      setError("You are not logged in! Returning to login page.");
      setShowDiv(false);
      const delay = ms => new Promise(res => setTimeout(res, ms));
      await delay(3000);

      window.location.href = '/login';
    } else {
      getDiet();
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

  const countCalories = (list) => {
    let l = 0;
    for (const o of list) {
      l += o.calories;
    }
    return l;
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


  return (
    <div>
      <h1>{error}</h1>
      <div className="BigBox">

        <br /><br />
        <Paper className="menu" elevation={3}>
        <Pie data={data} />
        </Paper>

        <Paper className="content" elevation={3}>
          {mealsList()}
          <div style={{ width: '500px', height: '500px' }}>

            
          </div>
        </Paper>
      </div >
    </div >
  );
}
