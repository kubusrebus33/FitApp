import * as React from 'react';
import { useState } from "react";
import FormInput from "./FormInput.jsx";
import { request, setAuthToken, setUsername } from '../axios_helper.js';

export default function Login() {

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
        console.error("An error occurred:", error);
        setAuthToken(null);
      });
  };

  const inputs = [
    {
      id: 1,
      name: "login",
      type: "text",
      placeholder: "login",
      label: "Login: ",
      required: true
    },
    {
      id: 2,
      name: "password",
      type: "password",
      placeholder: "hasło",
      label: "Hasło ",
      required: true
    }]

  const onChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value })
  }

  return (
    <div className="loginForm">
      <form onSubmit={handleSubmit}>
        <h1> Login </h1>
        {inputs.map((input) => (
          <FormInput key={input.id}{...input} value={values[input.name]} onChange={onChange} />
        ))}
        <button>Submit</button>
      </form>
    </div>
  );
}