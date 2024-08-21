import React, { useState } from 'react';
import '@fortawesome/fontawesome-free/css/all.min.css';
import './Header.css';
import { NavLink, Link, useNavigate } from 'react-router-dom';

const Header: React.FC = () => {
  const [isCartOpen, setIsCartOpen] = useState(false);
  const navigate = useNavigate();

  const toggleCart = () => {
    setIsCartOpen(!isCartOpen);
  };

  const goToCart = () => {
    navigate("./cart");
  };

  return (
    <header id="header">
      <h1>Little Ones</h1>
      <div>
        <ul id="collection">
          <li>
            <NavLink 
              to="/" 
              className={({ isActive }) => (isActive ? 'active' : '')}
            >
              Home
            </NavLink>
          </li>
          <li>
            <NavLink 
              to="/shop" 
              className={({ isActive }) => (isActive ? 'active' : '')}
              id="shop-link"
            >
              Shop
            </NavLink>
          </li>
          <li>
            <NavLink 
              to="/blog" 
              className={({ isActive }) => (isActive ? 'active' : '')}
            >
              Blog
            </NavLink>
          </li>
          <li>
          <NavLink 
              to="/login" 
              className={({ isActive }) => (isActive ? 'active' : '')}
            >
              <i className="fas fa-user"> </i>
            </NavLink>
          </li>
          <li id="user">
            <Link to="#" id="cart-icon" onClick={toggleCart}>
              <i className="fas fa-shopping-cart addedToCart"></i>
              <div id="badge">0</div>
            </Link>
           
          </li>
        </ul>
      </div>

      {/* Conditionally render the cart slider */}
      {isCartOpen && (
        <div className={`cart-slider ${isCartOpen ? 'open' : ''}`}>
          <button className="close-btn" onClick={toggleCart}>×</button>
          {/* Include your cart contents here */}
          <div className="cart-slider-content">
            <h2>Your Cart</h2>
            {/* Add cart items here */}
            <div className="checkout-container">
            <button className="checkout-btn" onClick={goToCart}>Checkout</button>
            </div>
          </div>
        </div>
      )}
    </header>
  );
};

export default Header;
