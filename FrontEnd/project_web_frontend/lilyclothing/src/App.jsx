// import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Link } from 'react-router-dom';
import Homepage from './components/Homepage';
import Products from './components/Products';
import ProductsDetails from './components/ProductsDetail';
import Cart from './components/Cart';
import SignIn from './components/SignIn';
import SignUp from './components/SignUp';

function App() {
  return (
    <Router>
      <header>
        <nav className="navbar">
          <div className="logo">
            <img src="images/lilyclothing.png" alt="Lily Clothing Logo" />
          </div>
          <ul className="nav-links">
            <li><Link to="/">Home</Link></li>
            <li><Link to="/products">Products</Link></li>
            <li><Link to="/cart">Cart</Link></li>
            <li><Link to="/signin" className="signin-btn">Sign in</Link></li>
            <li><Link to="/signup" className="register-btn">Register</Link></li>
          </ul>
        </nav>
      </header>
      <Routes>
        {/* Define the routes for each page */}
        <Route path="/" element={<Homepage />} />
        <Route path="/products" element={<Products />} />
        <Route path="/products/productId" element={<ProductsDetails />}/>
        <Route path="/cart" element={<Cart />} />
        <Route path="/signin" element={<SignIn />} />
        <Route path="/signup" element={<SignUp />} />
      </Routes>
      <footer>
        <div className="footer-content">
          <div className="footer-logo">
            <img src="logo.png" alt="Lily Clothing Logo" />
          </div>
          <ul className="footer-links">
            <li><Link to="/">Home</Link></li>
            <li><Link to="/products">Products</Link></li>
          </ul>
        </div>
      </footer>
    </Router>
  );
}

export default App;
