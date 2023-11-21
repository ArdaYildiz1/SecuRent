import './custom.css';
import React, {Component} from 'react';
import {Route, Routes} from 'react-router-dom';
import AppRoutes from './AppRoutes';
import 'bootstrap/dist/css/bootstrap.min.css';

export default class App extends Component {
  static displayName = App.name;

  render() {
      return (
          <div className='icon-grid'>
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
