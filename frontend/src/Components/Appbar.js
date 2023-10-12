import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { Link } from 'react-router-dom';
//slash
export default function Appbar() {
  const buttonStyle = { color: "white", border: "1px solid white", padding: "5px" }
  const tabStyle = { color: "white", padding: "5px", fontSize:"22px", borderRadius: "0",paddingLeft:'20px', paddingRight:'20px'};
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton size="large" edge="start" color="inherit" aria-label="menu" sx={{ mr: 2 }}>
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            EatFitNow
          </Typography>
          <nav>
            <Link to="/Create"><Button color="inherit" style={{ ...tabStyle, borderRight: '2px solid white' }}>BMI</Button></Link>
            <Link to="/Register"><Button color="inherit" style={{ ...tabStyle, borderRight: '2px solid white' }}>xxxx</Button></Link>
            <Link to="/Register"><Button color="inherit" style={tabStyle}>ccccc</Button></Link>
          </nav>
          <nav>
            <Link to="/Login"><Button color="inherit" style={buttonStyle}>Login</Button></Link>
            <Link to="/Register"><Button color="inherit" style={buttonStyle}>Register</Button></Link>
          </nav>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
