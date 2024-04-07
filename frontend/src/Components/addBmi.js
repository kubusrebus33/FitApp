import { useState, useEffect } from "react";
import FormInput from "./FormInput.jsx";
import "./Register.css"
import { request, getAuthToken } from '../axios_helper.js';
import Paper from '@mui/material/Paper';
import "./paperStyles.css";
import Box from '@mui/material/Box';
import Slider from '@mui/material/Slider';
import Button from '@mui/material/Button';

const Create = () => {
    const [error, setError] = useState('');
    const [jsonData, setJsonData] = useState({});

    function valueText(value) {
        return `${value}`;
    }

    function DiscreteSliderSteps() {
        const [sliderValue, setSliderValue] = useState(1);

        const handleSliderChange = (event, newValue) => {
            setSliderValue(newValue);
        };

        const x = (0.005 * jsonData.weight * 1000 * 7.35) / 7;
        const cals = sliderValue * 7700;
        const z = cals / x;
        const weeks = Math.floor(z / 7);
        const days = Math.floor(z % 7);

        return (

            <Box sx={{ width: 300 }}>
                <Slider
                    value={sliderValue}
                    onChange={handleSliderChange}
                    step={1}
                    marks
                    min={1}
                    max={20}
                />
                <p>Chcę schudnąć: {valueText(sliderValue)} kg</p>

                <p>Zajmie to około {weeks} tygodni, {days} dni</p>
            </Box>
        );
    }

    function showDiv(divId) {
        var divs = document.querySelectorAll('.content > div'); // Get all content divs
        for (var i = 0; i < divs.length; i++) {
            if (divs[i].id === divId) {
                divs[i].style.display = 'block'; // Show the selected div
            } else {
                divs[i].style.display = 'none'; // Hide other divs
            }
        }

        if (Object.keys(jsonData).length === 0) {
            document.querySelector(".dataDisplay").style.display = "none";
            document.querySelector(".slider").style.display = "none";
            if (divId === "option1" || divId === "option3") {
                document.querySelector(".errorDiv").style.display = "block";
            }
        } else {
            if (divId === "option3") document.querySelector(".slider").style.display = "block";

            document.querySelector(".BmiErr").style.display = "block";
            document.querySelector(".BmiForm").style.display = "none";
            document.querySelector(".errorDiv").style.display = "none";
        }

        if (divId !== "option2") {
            document.querySelector(".BmiErr").style.display = "none";
        }
    }

    useEffect(() => {
        const fetchData = async () => {
            const AuthToken = getAuthToken();

            if (AuthToken === null || AuthToken === "null" || AuthToken === "undefined") {
                document.querySelector(".BigBox").style.display = "none"; // Hide the selected element

                setError("Nie jesteś zalogowany! Powrót do strony logowania...");
                const delay = ms => new Promise(res => setTimeout(res, ms));
                await delay(3000);
                window.location.href = '/login';
            } else {
                request("GET", "http://localhost:8080/getUserProfile", null)
                    .then((response) => {
                        setJsonData(response.data);
                        document.querySelector(".errorDiv").style.display = "none";
                    })
                    .catch((error) => {
                        console.error("Error getting user profile", error);
                        document.querySelector(".dataDisplay").style.display = "none";
                        document.querySelector(".errorDiv").style.display = "block";
                    });
            }
        };

        fetchData(); // Invoke the fetchData function
    }, []);

    const [sex, setSex] = useState('');
    const [goal, setGoal] = useState('');
    const [dietInfo, setDietInfo] = useState(111);
    const [activityLevel, setActivity] = useState('');

    const [values, setValues] = useState({
        age: "",
        weight: "",
        height: "",
    });

    function CountActivityFactor(x) {
        let y;
        switch (x) {
            case '1':
                y = 1.2;
                break;
            case '2':
                y = 1.375;
                break;
            case '3':
                y = 1.55;
                break;
            case '4':
                y = 1.725;
                break;
            case '5':
                y = 1.9;
                break;
            default:
                y = 0;
        }
        return y;
    }

    function countBmi(weight, height) {
        return (weight / ((height / 100) * (height / 100))).toFixed(2);
    }

    function countCaloriesDemand(weight, height, age, sex) {
        if (sex === "m")
            return (10 * weight) + (6.25 * height) - (5 * age) + 5;  // Mifflin-St Jeor equation for males
        else
            return (10 * weight) + (6.25 * height) - (5 * age) - 161;  // Mifflin-St Jeor equation for females
    }

    function finalCaloriesDemand(weight, calories, goal) {
        // const x = (0.005 * values.weight * 1000 * 7.35);
        // setCal(x);

        switch (goal) {
            case '1':
                return calories - (0.005 * values.weight * 1000 * 7.35) / 7;
            case '2':
                return calories;
            case '3':
                return calories + (0.005 * values.weight * 1000 * 7.35) / 7;
            default:
                return 0;
        }
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        let bmi = countBmi(values.weight, values.height);
        //const bmi = values.weight / ((values.height / 100) * (values.height / 100));

        let caloricDemand = countCaloriesDemand(values.weight, values.height, values.age, sex);
        caloricDemand = caloricDemand * CountActivityFactor(activityLevel);

        caloricDemand = Math.round(caloricDemand);
        // 1 kg tłuszczu to 7000 - 7700 kcal

        caloricDemand = finalCaloriesDemand(values.weight, caloricDemand, goal);

        const userData = {
            age: values.age,
            sex,
            goal,
            activityLevel,
            weight: values.weight,
            height: values.height,
            dietInfo,
            caloricDemand: caloricDemand,
            bmi: bmi
        };
        console.log("Zapotrzebowanie: " + caloricDemand);
        console.log("dietInfo: " + dietInfo);
        request(
            "POST",
            "http://localhost:8080/addUserProfile",
            JSON.stringify(userData)
        )
            .then((response) => {
                console.log("Success:", response.data);
                window.alert("Pomyślnie dodano profil użytkownika!");
                window.location.href = '/addBmi';
            })
            .catch((error) => {
                window.alert("Wypełnij formularz poprawnymi danymi!");
                window.location.href = '/addBmi';
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
        <div>
            <h1>{error}</h1>
            <div className="BigBox">
                <br /><br />
                <Paper className="menu" elevation={3}>
                    <h3 onClick={() => showDiv('option1')} className="clickable-text">Profil użytkownika</h3>
                    <h3 onClick={() => showDiv('option2')} className="clickable-text">Dodaj profil użytkownika</h3>
                    <h3 onClick={() => showDiv('option3')} className="clickable-text">Czas transformacji ciała</h3>
                </Paper>

                <Paper className="content" elevation={3}>
                    <div className="errorDiv" style={{ display: "none" }}>
                        <h1> Najpierw dodaj swój profil użytkownika!</h1>
                    </div>
                    <div className="dataDisplay" style={{ display: "block" }} id="option1">
                        <h2>Informacje personalne:</h2>
                        <p>WIEK: {jsonData.age} </p>
                        <p>PŁEĆ: {jsonData.sex == 'm' ? "Mężczyzna" : "Kobieta"}</p>

                        <h2>Pomiary i cel:</h2>
                        <p>CEL: {
                            (() => {
                                switch (jsonData.goal) {
                                    case 1:
                                        return "Zrzucenie wagi";
                                    case 2:
                                        return "Utrzymanie wagi";
                                    default:
                                        return "Przybranie na wadze";
                                }
                            })()
                        }
                        </p>
                        <p>WAGA: {jsonData.weight} kg</p>
                        <p>WZROST: {jsonData.height} cm</p>

                        <h2>Bmi oraz kalorie:</h2>
                        <p>ZAPOTRZEBOWANIE KALORYCZNE: {jsonData.caloricDemand} kcal</p>
                        <p>BMI: {jsonData.bmi}</p>

                    </div>
                    <div className="BmiErr" style={{ display: "none" }}>
                        <h1> Dodałeś już swój profil użytkownika!</h1>
                    </div>
                    <div className="BmiForm" id="option2" style={{ display: "none" }}>
                        <form onSubmit={handleSubmit}>
                            <label> Płeć:</label><br />
                            <input type="radio" value="k" name="sex" required onChange={(e) => setSex(e.target.value)}></input>&nbsp;&nbsp;
                            <label>kobieta</label>&nbsp;&nbsp;
                            <input type="radio" value="m" name="sex" onChange={(e) => setSex(e.target.value)}></input>&nbsp;&nbsp;
                            <label>mężczyzna</label><br /><br />

                            <label> Chcę:</label><br />
                            <input type="radio" value="1" name="goal" required onChange={(e) => setGoal(e.target.value)}></input>&nbsp;&nbsp;
                            <label>schudnąć</label>&nbsp;&nbsp;
                            <input type="radio" value="2" name="goal" onChange={(e) => setGoal(e.target.value)}></input>&nbsp;&nbsp;
                            <label>utrzymać wagę</label>&nbsp;&nbsp;
                            <input type="radio" value="3" name="goal" onChange={(e) => setGoal(e.target.value)}></input>&nbsp;&nbsp;
                            <label>przytyć</label><br /><br />

                            <label>Preferencje żywieniowe:</label><br />
                            <input type="radio" value="111" name="dietInfo" onChange={(e) => setDietInfo(e.target.value)} defaultChecked></input>&nbsp;&nbsp;
                            <label>Brak</label>&nbsp;&nbsp;
                            <input type="radio" value="11" name="dietInfo" onChange={(e) => setDietInfo(e.target.value)}></input>&nbsp;&nbsp;
                            <label>Bez mięsa</label>&nbsp;&nbsp;
                            <input type="radio" value="101" name="dietInfo" onChange={(e) => setDietInfo(e.target.value)}></input>&nbsp;&nbsp;
                            <label>Bez glutenu</label>&nbsp;&nbsp;
                            <input type="radio" value="110" name="dietInfo" onChange={(e) => setDietInfo(e.target.value)}></input>&nbsp;&nbsp;
                            <label>Bez Laktozy</label><br /><br />

                            <label> Ilość aktywności fizycznej:</label><br />
                            <input type="radio" value="1" name="activityLevel" required onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                            <label>Siedzący tryb życia (niewielka lub brak aktywności fizycznej, praca przy biurku)</label><br />
                            <input type="radio" value="2" name="activityLevel" onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                            <label>Lekka aktywność (ćwiczenia 1-3 razy w tygodniu)</label><br />
                            <input type="radio" value="3" name="activityLevel" onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                            <label>Średnia aktywność  (ćwiczenia 3-5 razy w tygodniu)</label><br />
                            <input type="radio" value="4" name="activityLevel" onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                            <label>Bardzo aktywny (ćwiczenia 6-7 razy w tygodniu)</label><br />
                            <input type="radio" value="5" name="activityLevel" onChange={(e) => setActivity(e.target.value)}></input>&nbsp;&nbsp;
                            <label>Bardzo intensywna aktywność (ćwiczenia 2 razy dziennie)</label><br /><br />

                            {inputs.map((input) => (
                                <FormInput key={input.id}{...input} value={values[input.name]} onChange={onChange} />
                            ))}

                            <Button className="submitButton" size="large" variant="contained" onClick={handleSubmit}>Wyślij</Button>
                        </form>
                    </div>

                    <div className="slider" id="option3" style={{ display: "none" }}>
                        <br />
                        <DiscreteSliderSteps />
                        <br />

                    </div>
                </Paper>
            </div >
        </div >
    );

}

export default Create;