import * as React from 'react';
import { useState, useEffect } from "react";
import { request, setAuthToken, getAuthToken } from '../axios_helper.js';
import Paper from '@mui/material/Paper';

export default function Diet() {
  const [error, setError] = useState('');
  const [showDiv, setShowDiv] = useState(true);
  const [jsonData, setJsonData] = useState([]);

  useEffect(() => async () => {
    const AuthToken = getAuthToken();

    if (AuthToken === null || AuthToken === "null" || AuthToken === "undefined") {
      setError("You are not logged in! Returning to login page.");
      setShowDiv(false);
      const delay = ms => new Promise(res => setTimeout(res, ms));
      await delay(3000);

      window.location.href = '/login';
    } else {

    }
  }, []);

  const countCalories = (list) => {
    let l= 0;

    for (const o of list) {
        l += o.calories;
    }

    return l;
};

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
        window.alert("Najpierw stwórz swój profil użytkownika!");
        //window.location.reload(false);
        window.location.href = '/addBmi';
      });
  };

  const mealsList = () => (
    <div>
      <p>{countCalories(jsonData)}</p>
      <table>
        <thead>
          <tr>
            <th>Meal Name</th>
            <th>Cals</th>
            <th>Prots</th>
            <th>Carbs</th>
            <th>Fats</th>
            <th>Recipe</th>
            <th>Składniki</th>
          </tr>
        </thead>
        <tbody>
          {jsonData.map((meal, index) => (
            <tr key={index}>
              <td>{meal.mealName}</td>
              <td>{meal.calories}</td>
              <td>{meal.proteins}</td>
              <td>{meal.carbohydrates}</td>
              <td>{meal.fats}</td>
              <td>{meal.recipe}</td>
              <td>
                <ul>
                  {meal.ingredientAssoc.map((ingredient, i) => (
                    <li key={i}>{ingredient}</li>
                  ))}
                </ul>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
  

  return (
    <div>
      <h1>{error}</h1>
      <div className="BigBox">

        <br /><br />
        <Paper className="menu" elevation={3}>
          <h3 onClick={getDiet} className="clickable-text">Get your diet</h3>
        </Paper>
          
        <Paper className="content" elevation={3}>
          {mealsList()}
        </Paper>
      </div >
    </div >
  );

}