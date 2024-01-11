import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { Link } from 'react-router-dom';
import { getAuthToken, getUsername, setAuthToken, setUsername } from '../axios_helper.js';

export default function Appbar() {
  const handleLogout = (e) =>{
    e.preventDefault();

    setAuthToken(null);
    setUsername(null);
    
    window.location.reload(false);
    window.location.href = '/login';
  }

  function extractUsername(email) {
    const atIndex = email.indexOf('@');

    if (atIndex !== -1) {
        const username = email.substring(0, atIndex);
        return username;
    } else {
        return email;
    }
}

  const buttonStyle = { color: "white", border: "1px solid white", padding: "5px" }
  const tabStyle = { color: "white", padding: "5px", fontSize: "15px", borderRadius: "0", paddingLeft: '20px', paddingRight: '20px' };
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton size="large" edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }}>
            <nav>
              <Link to="/Home"><MenuIcon /></Link>
            </nav>
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            EatFitNow
          </Typography>
          {getAuthToken() !== null && getAuthToken() !== "null" && getAuthToken() !== "undefined" ? (
            <>
            <nav>
              <Link to="/Home"><Button color="inherit" style={{ ...tabStyle, borderRight: '2px solid white' }}>Strona główna</Button></Link>
              <Link to="/addBmi"><Button color="inherit" style={{ ...tabStyle, borderRight: '2px solid white' }}>Kalkulator kalorii</Button></Link>
              <Link to="/Diet"><Button color="inherit" style={tabStyle}>Moja dieta</Button></Link>
            </nav>
            <h2>{`Witaj ${extractUsername(getUsername())}`}</h2>
            <Button color="inherit" onClick={handleLogout}> 
              Logout
            </Button>
          </>
          ) : (
            <nav>
              <Link to="/Login">
                <Button color="inherit" style={buttonStyle}>
                  Login
                </Button>
              </Link>
              <Link to="/Register">
                <Button color="inherit" style={buttonStyle}>
                  Register
                </Button>
              </Link>
            </nav>
          )}
        </Toolbar>
      </AppBar>
    </Box>
  );
}
