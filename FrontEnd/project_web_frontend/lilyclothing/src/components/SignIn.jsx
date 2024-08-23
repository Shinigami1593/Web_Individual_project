import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './CSS/style.css'; // Import your CSS file for styling

const SignIn = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/app_users/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username: email, password }),
      });

      if (response.ok) {
        const userId = await response.json();
        // Save the user ID or handle it as needed
        console.log('Logged in successfully, User ID:', userId);
        navigate('/dashboard');
      } else {
        console.log('Login failed');
        // Handle login failure (e.g., show an error message)
      }
    } catch (error) {
      console.error('Error during login:', error);
    }
  };

  return (
    <section className="auth-form">
      <div className="form-container">
        <h1>Sign In</h1>
        <form onSubmit={handleSubmit}>
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <button type="submit" className="auth-btn">Sign In</button>
        </form>
        <p>Don't have an account? <a href="/signup">Register here</a></p>
      </div>
    </section>
  );
};

export default SignIn;

