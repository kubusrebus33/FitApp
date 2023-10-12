import { useState } from "react";
import FormInput from "./FormInput.jsx";
import "./Register.css"

const Create = () => {
    const [sex, setSex] = useState('');
    const [goal, setGoal] = useState('');
    const [activityLevel, setActivity] = useState('');
    const [workActivityLevel, setWorkActivity] = useState('');

    const [values, setValues] = useState({
        age:"",
        weight:"",
        height:"",
    });

    function activityFactor(p1, p2) {
        let values = [[1.4, 1.5, 1.6, 1.7, 1.9], [1.5, 1.6, 1.7, 1.8, 2.0], [1.6, 1.7, 1.8, 1.9, 2.2], [1.7, 1.8, 1.9, 2.1, 2.3]];

        return values[p1-1][p2-1];
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const age = values.age;
        const weight = values.weight;
        const height = values.height;
        const userProfile = {age, sex, goal, activityLevel, workActivityLevel, weight, height}
        const Bmi = weight / ((height / 100) * (height / 100));

        let caloricDemand;
        if(sex === "m")
            caloricDemand = (10 * weight) + (6.25 * height) - (5*age) +5;  // wzór mifflina
        else 
            caloricDemand = (10 * weight) + (6.25 * height) - (5*age) -161;  // wzór mifflina

        console.log("Caloric demand: " + caloricDemand*activityFactor(workActivityLevel, activityLevel));
        console.log("BMI: " + Bmi);
        console.log(userProfile);

         fetch("http://localhost:8080/userProfile/add", {
        method:"POST",
        headers:{"Content-Type": "application/json"},
        body:JSON.stringify(userProfile)
        }).then(()=>{
            console.log("New userProfile added")
        })
    }

    const inputs = [
        {
            id:1,
            name:"age",
            type:"number",
            placeholder:"wiek",
            errorMessage:"Podaj poprawny wiek!",
            label:"Wiek",
            min: 15,
            max: 85,
            required: true
        },
        {
            id:2,
            name:"weight",
            type:"number",
            placeholder:"waga",
            errorMessage:"Podaj poprawną wagę!",
            label:"Podaj wagę w kg: ",
            min: 35,
            max: 250,
            required: true
        },
        {
            id:3,
            name:"height",
            type:"number",
            placeholder:"wzrost",
            errorMessage:"Podaj poprawny wzrost!",
            label:"Podaj wzrost w cm: ",
            min: 150,
            max: 211,
            required: true
        }
    ]

    const onChange = (e) =>{
        setValues({...values, [e.target.name]: e.target.value})
    }
    
    return (
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

                {inputs.map((input) =>(
                        <FormInput key={input.id}{...input} value={values[input.name]} onChange={onChange} />
                    ))}

                <button>Submit</button>
            </form>
        </div>
    );
}

export default Create;
