// MainNav.tsx
import React from 'react';
import { Outlet } from 'react-router-dom';
import Navbar from './Header'; // Adjust the import path as necessary
import Footer from './Footer'; // Adjust the import path as necessary
import './MainNav.css'; // Optional CSS file for styling MainNav

const MainNav: React.FC = () => {
  return (
    <div className="main-nav-container">
      <Navbar />
      <main className="main-content">
        <Outlet />
      </main>
      <Footer />
    </div>
  );
};

export default MainNav;
