import FormInput from "./FormInput.jsx";
import { useState } from "react";
import "./Register.css"
import { request, setAuthToken, setUsername } from '../axios_helper.js';
import Paper from '@mui/material/Paper';
import './paperStyles.css';
import Button from '@mui/material/Button';

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
            label: "Email",
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
        if (values.email.trim() === "") {
            setErrorMessage("Email nie może być pusty!");
            return;
        }
        if (values.password.length < 8) {
            setErrorMessage("Hasło musi mieć minimum 8 znaków!");
            return;
        }
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
                setErrorMessage("Ten adres email jest zajęty!");
            });
    };


    const onChange = (e) => {
        setValues({ ...values, [e.target.name]: e.target.value })
    }

    return (
        <div className="registerForm" id="registerForm" sx ={{ 
            backgroundImage: 'url("1.png")',
           backgroundRepeat: 'repeat'}}>
            <Paper className="register" elevation={3}>
                <form onSubmit={handleSubmit}>
                    <h1> Rejestracja </h1>
                    {inputs.map((input) => (
                        <FormInput key={input.id}{...input} value={values[input.name]} onChange={onChange} />
                    ))}
                    {errorMessage && (
                        <h3 className="error" style={{ color: 'red' }}> {errorMessage} </h3>
                    )}<br />
                    <Button className="submitButton" size="large" variant="contained" onClick={handleSubmit}>Rejestruj</Button>
                </form>
            </Paper>
        </div>
    )
}

export default Register; 