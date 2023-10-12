import * as React from 'react';
import { useState } from "react";
import FormInput from "./FormInput.jsx";

export default function Login() {

  const [values, setValues] = useState({
    login: "",
    password: ""
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    const userData = { email: values.login, password: values.password }

    fetch("http://localhost:8080/user/authenticate", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(userData)
    }).then(() => {
      
    })
    console.log(userData);
  }

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