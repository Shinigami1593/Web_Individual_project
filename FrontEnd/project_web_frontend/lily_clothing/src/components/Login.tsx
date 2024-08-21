import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';
import './login.css';

const Login: React.FC = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/user/login', { email, password });
            // Assuming the API returns a success status on successful login
            if (response.status === 200) {
                navigate('/dashboard');
            }
        } catch (err) {
            setError('Invalid email or password');
        }
    };

    return (
        <div className="loginWrapper">
            <div className="loginContainer">
                <h2>Login</h2>
                {error && <p className="error">{error}</p>}
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

                    <input type="submit" value="Login" />
                </form>
                <div className="forgotPassword">
                    <a href="#">Forgot your password?</a>
                </div>
                <div className="register">
                    <p>Don't have an account?  <Link to="/register">Register</Link></p>
                </div>
            </div>
        </div>
    );
};

export default Login;
