import logo from './logo.svg';
import React, { Component } from 'react';
import { Route, Routes } from 'react-router-dom';
import AppRoutes from './AppRoutes';
import './App.css';


import HomePage from './HomePage.js';
function App() {
  return (
<<<<<<< Updated upstream
    <div className="App">
      <HomePage/>
=======
    <div className='icon-grid'>
      <Routes>
        {AppRoutes.map((route, index) => {
          const { element, ...rest } = route;
          return <Route key={index} {...rest} element={element} />;
        })}
      </Routes>
>>>>>>> Stashed changes
    </div>
  );
}

export default App;
