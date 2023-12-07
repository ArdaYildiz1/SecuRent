import React, {Component} from 'react';
import {Route, Routes} from 'react-router-dom';
import AppRoutes from './AppRoutes';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-datepicker/dist/react-datepicker.css';

import './custom.css';
import Login from './pages/Login';
import SelectAgent from './pages/SelectAgent';
import TenantProfile from './pages/TenantProfile';
export default class App extends Component {
  static displayName = App.name;

  render() {
      return (
          <div className='bg-rain'>
              <Routes>
                  {AppRoutes.map((route, index) => {
                      const {element, ...rest} = route;
                      return <Route key={index} {...rest} element={element}/>;
                  })}
              </Routes>
          </div>

      );
  }
}
