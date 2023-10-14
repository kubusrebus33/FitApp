import './App.css';
import Appbar from './Components/Appbar';
import Create from './Components/addBmi';
import Login from './Components/Login';
import Register from './Components/Register';
import Home from './Components/Home';
import Users from './Components/Users';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

function App() {
  return (
    <Router>
      <div className="App">
        <Appbar />
        <div style={{ display:'flex', justifyContent: 'center', alignItems: 'center', height: '80vh'}}>
          <Routes>
            <Route path="/Login" element={<Login />} />
            <Route path="/Register" element={<Register />} />
            <Route path="/addBmi" element={<Create />} />
            <Route path="/Home" element={<Home />} />
            <Route path="/Users" element={<Users />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;