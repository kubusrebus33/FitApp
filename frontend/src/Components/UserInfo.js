import * as React from 'react';
import { useState, useEffect } from "react";
import { request, setAuthToken, getAuthToken } from '../axios_helper.js';

export default function Users() {
  const [error, setError] = useState('');
  const [showDiv, setShowDiv] = useState(true); // Initially, show the div

  useEffect(() => async () => {
    const AuthToken = getAuthToken();

    if (AuthToken === null || AuthToken === "null" || AuthToken === "undefined") {
      setError("You are not logged in! Returning to login page.");
      setShowDiv(false);
      const delay = ms => new Promise(res => setTimeout(res, ms));
      await delay(5000);

      window.location.href = '/login';
    } else {
      
    }
  }, []);

  const [userList, setUserList] = useState('');

  const handleFetchUsers = () => {
    request("GET",
      "http://localhost:8080/getAll",
      null
    )
      .then((response) => {
        setUserList(response.data); // Store the list of users in state
        setError(null); // Clear any previous errors
      })
      .catch((error) => {
        setError("An error occurred while fetching users.");
        console.error("An error occurred:", error);
        setAuthToken(null);
      });
  };

  return (
    <div className="BigBox">
      <h1>{error}</h1>
      {showDiv && (
        <div className="home">

          <h1>It is the list of users:</h1>

          <button onClick={handleFetchUsers}>Fetch Users</button>
          {userList.length > 0 && (
            <ul>
              {userList.map((user) => (
                <li key={user.userId}>
                  User ID: {user.userId}, Username: {user.username}
                </li>
              ))}
            </ul>
          )}
        </div>
      )}
    </div>
  );
}
