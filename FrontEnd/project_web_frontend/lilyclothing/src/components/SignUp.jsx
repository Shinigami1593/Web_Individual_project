import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './CSS/style.css'; // Import your CSS file for styling

const SignUp = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Add validation to check if password and confirmPassword match
    if (password !== confirmPassword) {
      alert("Passwords don't match");
      return;
    }

    try {
      const response = await fetch('http://localhost:8080/app_users/save', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          name,
          username: email,
          password,
        }),
      });

      if (response.ok) {
        console.log('User signed up successfully');
        navigate('/dashboard'); // Redirect to the dashboard after successful sign-up
      } else {
        console.log('Sign-up failed');
        // Handle sign-up failure (e.g., show an error message)
      }
    } catch (error) {
      console.error('Error during sign-up:', error);
    }
  };

  return (
    <section className="auth-form">
      <div className="form-container">
        <h1>Sign Up</h1>
        <form onSubmit={handleSubmit}>
          <label htmlFor="name">Full Name</label>
          <input
            type="text"
            id="name"
            name="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />

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

          <label htmlFor="confirm-password">Confirm Password</label>
          <input
            type="password"
            id="confirm-password"
            name="confirm-password"
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            required
          />

          <button type="submit" className="auth-btn">Sign Up</button>
        </form>
        <p>Already have an account? <a href="/signin">Sign in here</a></p>
      </div>
    </section>
  );
};

export default SignUp;
