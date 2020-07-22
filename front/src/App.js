import React from "react";
import { Route, Switch } from "react-router-dom";
import "./index.css";
import Header from "./component/common/Header";
import Main from "./component/admin/Main";
import Home from "./component/home/Home";

const App = () => {
  return (
    <div className="App">
      <Header />
      <Switch>
        <Route exact path="/">
          <Home />
        </Route>
        <Route path="/admin">
          <Main />
        </Route>
      </Switch>
    </div>
  );
};

export default App;
