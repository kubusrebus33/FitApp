import FormInput from "./FormInput.jsx";
import {useState} from "react";
import "./Register.css"

const Register = () => {
    const [values, setValues] = useState({
        email:"",
        password:"",
        confirmPassword:""
    });

    const inputs = [
        {
            id:1,
            name:"email",
            type:"email",
            placeholder:"email",
            errorMessage:"Wpisz poprawny adres email!",
            label:"Email ",
            required: true
        },
        {
            id:2,
            name:"password",
            type:"password",
            placeholder:"hasło",
            errorMessage:"Hasło powinno mieć od 8 do 20 znaków, hasło musi zawierać conajmniej 1 małą literę, 1 wielką literę, 1 liczbę, i jeden znak specjalny!",
            label:"Hasło ",
            pattern:"^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$",
            required: true
        },
        {
            id:3,
            name:"confirmPassword",
            type:"password",
            placeholder:"powtórz hasło",
            errorMessage:"Hasła muszą być identyczne!",
            label:"Powtórz hasło",
            pattern: values.password,
            required: true
        }
    ]

    const handleSubmit = (e) =>{
        e.preventDefault();
        const userData = { email: values.email, password: values.password }

        fetch("http://localhost:8080/user/add", {
        method:"POST",
        headers:{"Content-Type": "application/json"},
        body:JSON.stringify(userData)
        }).then(()=>{
            console.log("New user added")
        })
    }

    const onChange = (e) =>{
        setValues({...values, [e.target.name]: e.target.value})
    }

        return (
            <div className="registerForm">
                <form onSubmit={handleSubmit}>
                    <h1> Register </h1>
                    {inputs.map((input) =>(
                        <FormInput key={input.id}{...input} value={values[input.name]} onChange={onChange} />
                    ))}
                <button>Submit</button>
                </form>
            </div>
        )
}

export default Register; 