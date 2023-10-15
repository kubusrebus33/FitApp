import { useState, useEffect } from "react";
import FormInput from "./FormInput.jsx";
import "./Register.css"
import { request, setAuthToken, setUsername, getAuthToken } from '../axios_helper.js';

const Create = () => {
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

    const [sex, setSex] = useState('');
    const [goal, setGoal] = useState('');
    const [activityLevel, setActivity] = useState('');
    const [workActivityLevel, setWorkActivity] = useState('');

    const [values, setValues] = useState({
        age: "",
        weight: "",
        height: "",
    });

    function CountActivityFactor(p1, p2) {
        let values = [[1.4, 1.5, 1.6, 1.7, 1.9], [1.5, 1.6, 1.7, 1.8, 2.0], [1.6, 1.7, 1.8, 1.9, 2.2], [1.7, 1.8, 1.9, 2.1, 2.3]];

        return values[p1 - 1][p2 - 1];
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const userData = { age: values.age, sex, goal, activityLevel, workActivityLevel, weight: values.weight, height: values.height }
        const Bmi = userData.weight / ((userData.height / 100) * (userData.height / 100));

        let caloricDemand;
        if (sex === "m")
            caloricDemand = (10 * userData.weight) + (6.25 * userData.height) - (5 * userData.age) + 5;  // wzór mifflina
        else
            caloricDemand = (10 * userData.weight) + (6.25 * userData.height) - (5 * userData.age) - 161;  // wzór mifflina

        caloricDemand = caloricDemand * CountActivityFactor(workActivityLevel, activityLevel);

        userData.caloricDemand = caloricDemand;
        userData.bmi = Bmi;

        console.log(userData);
        request(
            "POST",
            "http://localhost:8080/addUserProfile",
            JSON.stringify(userData)
        )
            .then((response) => {
                console.log("Success:", response.data);
                window.location.href = '/Home';
            })
            .catch((error) => {
                console.error("An error occurred:", error);
                setAuthToken(null);
            });
    }

    const inputs = [
        {
            id: 1,
            name: "age",
            type: "number",
            placeholder: "wiek",
            errorMessage: "Podaj poprawny wiek!",
            label: "Wiek",
            min: 15,
            max: 85,
            required: true
        },
        {
            id: 2,
            name: "weight",
            type: "number",
            placeholder: "waga",
            errorMessage: "Podaj poprawną wagę!",
            label: "Podaj wagę w kg: ",
            min: 35,
            max: 250,
            required: true
        },
        {
            id: 3,
            name: "height",
            type: "number",
            placeholder: "wzrost",
            errorMessage: "Podaj poprawny wzrost!",
            label: "Podaj wzrost w cm: ",
            min: 150,
            max: 211,
            required: true
        }
    ]

    const onChange = (e) => {
        setValues({ ...values, [e.target.name]: e.target.value })
    }

    return (
        <div className="BigBox">
            <h1>{error}</h1>
            {showDiv && (
                <div className="userProfile">
                    <h1> Add BMI </h1>

                    <form onSubmit={handleSubmit}>
                        <input type="radio" value="k" name="sex" required onChange={(e) => setSex(e.target.value)}></input>&nbsp;&nbsp;
                        <label>kobieta</label>&nbsp;&nbsp;
                        <input type="radio" value="m" name="sex" onChange={(e) => setSex(e.target.value)}></input>&nbsp;&nbsp;
                        <label>mężczyzna</label><br />

                        <label> Typ pracy:</label><br />
                        <input type="radio" value="1" name="workActivityLevel" required onChange={(e) => setWorkActivity(e.target.value)}></input>&nbsp;&nbsp;
                        <label>1 - brak aktywności zawodowej</label>&nbsp;&nbsp;
                        <input type="radio" value="2" name="workActivityLevel" onChange={(e) => setWorkActivity(e.target.value)}></input>&nbsp;&nbsp;
                        <label>2 - praca niewymagająca wysiłku fizycznego</label>&nbsp;&nbsp;
                        <input type="radio" value="3" name="workActivityLevel" onChange={(e) => setWorkActivity(e.target.value)}></input>&nbsp;&nbsp;
                        <label>3 - praca wymagająca lekkiego wysiłku fizycznego</label>&nbsp;&nbsp;
                        <input type="radio" value="4" name="workActivityLevel" onChange={(e) => setWorkActivity(e.target.value)}></input>&nbsp;&nbsp;
                        <label>4  - ciężka praca fizyczna</label>&nbsp;&nbsp;<br />

                        <label> Chcę:</label><br />
                        <input type="radio" value="1" name="goal" required onChange={(e) => setGoal(e.target.value)}></input>&nbsp;&nbsp;
                        <label>schudnąć</label>&nbsp;&nbsp;
                        <input type="radio" value="2" name="goal" onChange={(e) => setGoal(e.target.value)}></input>&nbsp;&nbsp;
                        <label>utrzymać wagę</label>&nbsp;&nbsp;
                        <input type="radio" value="3" name="goal" onChange={(e) => setGoal(e.target.value)}></input>&nbsp;&nbsp;
                        <label>przytyć</label><br />

                        <label> Ilość aktywności fizycznej:</label><br />
                        <input type="radio" value="1" name="activityLevel" required onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                        <label>brak aktywności</label>&nbsp;&nbsp;
                        <input type="radio" value="2" name="activityLevel" onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                        <label>mało aktywny</label>&nbsp;&nbsp;
                        <input type="radio" value="3" name="activityLevel" onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                        <label>średnio aktywny</label>&nbsp;&nbsp;
                        <input type="radio" value="4" name="activityLevel" onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                        <label>aktywny</label>&nbsp;&nbsp;
                        <input type="radio" value="5" name="activityLevel" onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                        <label>bardzo aktywny</label><br />

                        {inputs.map((input) => (
                            <FormInput key={input.id}{...input} value={values[input.name]} onChange={onChange} />
                        ))}

                        <button>Submit</button>
                    </form>
                </div>
            )}
        </div>
    );
}

export default Create;
