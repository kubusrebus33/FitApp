import * as React from 'react';
import { useNavigate } from 'react-router-dom';
import "./paperStyles.css";
import image from "./frontpage.jpg";
import Button from '@mui/material/Button';

export default function Welcome() {
  const navigate = useNavigate(); // Initialize navigate function

  const divStyle = {
    backgroundImage: `url(${image})`,
    backgroundSize: 'cover', // or 'contain' based on your preference
    width: '100%',
    height: '93vh', // Adjust the height as needed
  };

  const navigateToRegister = () => {
    navigate('/Register'); // Use navigate to navigate
  };

  return (
    <div style={divStyle}>
      <div style={styles.paper}>
        <p1 style={{}}> Oblicz zapotrzebowanie kaloryczne i wygeneruj swoją dietę już dziś! </p1>
        <Button size="large" variant="contained" style={{marginTop:"50px"}} onClick={navigateToRegister} >DARMOWA REJESTRACJA</Button>
      </div>
    </div>
  );
}

const styles = {
  paper: {
    paddingLeft: 90,
    paddingTop: 250,
    width: 500,
    float: 'left',
    
    margin: 'auto',
    textAlign: 'center',
    fontSize: '3em', // Adjust the font size as needed
    color: 'black', // Adjust the text color as needed
    fontFamily: 'Arial, sans-serif', // Adjust the font family as needed
  },
};
