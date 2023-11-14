import * as React from 'react';
import Paper from '@mui/material/Paper';
import "./paperStyles.css";
import { useState, useEffect } from "react";
import { request, setAuthToken, getAuthToken } from '../axios_helper.js';

export default function Home() {

  const [error, setError] = useState('');
  const [showDiv, setShowDiv] = useState(true);


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

  return (
    <div>
    <h1>{error}</h1>
    <div className="BigBox">

      <br /><br />
      <Paper className="menu" elevation={3}>
      </Paper>
        
      <Paper className="content" elevation={3}>
      </Paper>
    </div >
  </div >
  );
}
