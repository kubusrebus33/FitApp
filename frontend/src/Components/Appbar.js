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
import AccountMenu from './AccountMenu.js';

export default function Appbar() {
  const handleLogout = (e) =>{
    e.preventDefault();

    setAuthToken();
    setUsername();
    
    window.location.reload(false);
    //window.location.href = '/login';
  }
  const buttonStyle = { color: "white", border: "1px solid white", padding: "5px" }
  const tabStyle = { color: "white", padding: "5px", fontSize: "22px", borderRadius: "0", paddingLeft: '20px', paddingRight: '20px' };
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
          {/* <AccountMenu /> */}
          <nav>
            <Link to="/addBmi"><Button color="inherit" style={{ ...tabStyle, borderRight: '2px solid white' }}>BMI</Button></Link>
            <Link to="/Home"><Button color="inherit" style={{ ...tabStyle, borderRight: '2px solid white' }}>Home</Button></Link>
            <Link to="/Users"><Button color="inherit" style={tabStyle}>ListOfUsers</Button></Link>
          </nav>
          {getAuthToken() !== null && getAuthToken() !== "null" && getAuthToken() !== "undefined" ? (
            <div>
              <h1>{`witaj ${getUsername()}`}</h1>
              <Button color="inherit" onClick={handleLogout}>
                Logout
              </Button>
            </div>
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
