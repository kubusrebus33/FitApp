import * as React from 'react';
import { useState } from "react";
import FormInput from "./FormInput.jsx";
import { request, setAuthToken, setUsername } from '../axios_helper.js';
import { Link } from 'react-router-dom';
import Paper from '@mui/material/Paper';
import './paperStyles.css';

export default function Login() {
  const [errorMessage, setErrorMessage] = useState('');

  const [values, setValues] = useState({
    login: "",
    password: ""
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    const userData = { username: values.login, password: values.password }

    request(
      "POST",
      "http://localhost:8080/login",
      JSON.stringify(userData)
    )
      .then((response) => {
        console.log("Success:", response.data);
        setAuthToken(response.data.token);
        setUsername(response.data.username);
        window.location.href = '/Home';
      })
      .catch((error) => {
        window.location.href='/login';
        setAuthToken(null);
        window.alert("Błędne dane logowania!");
      });
  };

  const inputs = [
    {
      id: 1,
      name: "login",
      type: "email",
      placeholder: "email",
      errorMessage: "Wpisz poprawny adres email!",
      label: "Email: ",
      required: true
    },
    {
      id: 2,
      name: "password",
      type: "password",
      errorMessage: "Hasło musi zawierać conajmniej 8 znaków!",
      pattern: "^.{8,}$",
      placeholder: "hasło",
      label: "Hasło ",
      required: true
    }]

  const onChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value })
  }

  return (
    <div className="loginForm">
      <Paper className="login" elevation={3}>
        <form onSubmit={handleSubmit}>
          <h1> Login </h1>
          {inputs.map((input) => (
            <FormInput key={input.id}{...input} value={values[input.name]} onChange={onChange} />
          ))}
          <h4>Nie masz konta?
            <nav>
              <Link to="/Register">Zarejestruj się</Link>
            </nav>
          </h4>

          <button>Submit</button>
        </form>
      </Paper>
    </div>
  );
}