import * as React from 'react';
import { useState } from 'react';
import { request, setAuthToken } from '../axios_helper.js';

export default function Users() {
  const [userList, setUserList] = useState('');
  const [error, setError] = useState('');

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
    <div className="home">
      {error}
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
  );
}
