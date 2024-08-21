// src/services/api.ts

import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // Update this to your backend URL
  headers: {
    'Content-Type': 'application/json',
  },
});

export const registerUser = (user: { username: string; password: string; email: string }) =>
  api.post('/users/signup', user);

export const loginUser = (credentials: { username: string; password: string }) =>
  api.post('/users/login', credentials);

// Add more API calls as needed

export default api;
