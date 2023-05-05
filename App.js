import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ListEmployeeComponent from './Components/ListEmployeeComponent';
import { employeeServices } from './services/employeeservices';

import HeaderComponent from './Components/HeaderComponent';
import FooterComponent from './Components/FooterComponent';
import CreateEmployeeComponent from './Components/CreateEmployeeComponent';
import EditEmployeeComponent from './Components/EditEmployeeComponent';

function App() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    fetchEmployees();
  }, []);

  const fetchEmployees = () => {
    employeeServices.getEmployees()
      .then((res) => {
        setEmployees(res.data);
      })
      .catch((error) => {
        console.log('Error:', error);
      });
  };

  return (
    <Router>
      <div className="container">
        <HeaderComponent />
        <Routes>
          <Route
            exact
            path="/"
            element={<ListEmployeeComponent employees={employees} />}
          />
          <Route
            path="/employees"
            element={<ListEmployeeComponent employees={employees} />}
          />
          <Route
            path="/add-employee"
            element={<CreateEmployeeComponent />}
          />
          <Route
            path="/edit-employee/:id"
            element={<EditEmployeeComponent employees={employees} />}
          />
        </Routes>
        <FooterComponent />
      </div>
    </Router>
  );
}

export default App;
