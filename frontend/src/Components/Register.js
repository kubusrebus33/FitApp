import FormInput from "./FormInput.jsx";
import { useState } from "react";
import "./Register.css"
import { request, setAuthToken, setUsername } from '../axios_helper.js';

const Register = () => {
    const [values, setValues] = useState({
        email: "",
        password: "",
        confirmPassword: ""
    });

    const [errorMessage, setErrorMessage] = useState('');

    const inputs = [
        {
            id: 1,
            name: "email",
            type: "email",
            placeholder: "email",
            errorMessage: "Wpisz poprawny adres email!",
            label: "Email ",
            required: true
        },
        {
            id: 2,
            name: "password",
            type: "password",
            placeholder: "hasło",
            errorMessage: "Hasło powinno mieć od 8 do 20 znaków, hasło musi zawierać conajmniej 1 małą literę, 1 wielką literę, 1 liczbę, i jeden znak specjalny!",
            label: "Hasło ",
            pattern: "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$",
            required: true
        },
        {
            id: 3,
            name: "confirmPassword",
            type: "password",
            placeholder: "powtórz hasło",
            errorMessage: "Hasła muszą być identyczne!",
            label: "Powtórz hasło",
            pattern: values.password,
            required: true
        }
    ]

    const handleSubmit = (e) => {
        e.preventDefault();
        const userData = { username: values.email, password: values.password }

        request(
            "POST",
            "http://localhost:8080/register",
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
            // Reroute or handle the error in a way that suits your application
          });
      };
      

    const onChange = (e) => {
        setValues({ ...values, [e.target.name]: e.target.value })
    }

    return (
        <div className="registerForm">
            <form onSubmit={handleSubmit}>
                <h1> Register </h1>
                {inputs.map((input) => (
                    <FormInput key={input.id}{...input} value={values[input.name]} onChange={onChange} />
                ))}
                {errorMessage && (
                    <p className="error"> {errorMessage} </p>
                )}
                <button>Submit</button>
            </form>
        </div>
    )
}

export default Register; 