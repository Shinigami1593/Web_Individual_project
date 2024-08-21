// src/App.tsx
import React from 'react';
import { RouterProvider, createBrowserRouter, Navigate } from 'react-router-dom';
import Home from './components/Home';
// import ExploreProducts from './components/ExploreProducts';
// import Checkout from './pages/Checkout';
// import Product from './pages/Product';
import Login from './components/Login';
import Signup from './components/Signup';
import Navbar from './components/Navbar';

const App: React.FC = () => {
  return (
    <Router>
      <Navbar />
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/explore" component={ExploreProducts} />
        <Route path="/checkout" component={Checkout} />
        <Route path="/product/:id" component={Product} />
        <Route path="/login" component={Login} />
        <Route path="/signup" component={Signup} />
      </Switch>
    </Router>
  );
};

export default App;
