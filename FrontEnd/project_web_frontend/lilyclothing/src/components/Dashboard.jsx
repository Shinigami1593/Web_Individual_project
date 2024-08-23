import React from 'react';
import './CSS/Dashboard.css'; // Make sure to include your styles in a CSS file

const Dashboard = ({ userName }) => {
  return (
    <section className="dashboard">
      <div className="dashboard-container">
        <h1>Welcome, {userName}!</h1>
        <div className="dashboard-grid">
          <div className="dashboard-item">
            <h2>My Orders</h2>
            <p>View your order history and track current orders.</p>
            <button className="dashboard-btn">View Orders</button>
          </div>
          <div className="dashboard-item">
            <h2>Profile Settings</h2>
            <p>Update your personal information and password.</p>
            <button className="dashboard-btn">Edit Profile</button>
          </div>
          <div className="dashboard-item">
            <h2>Wishlist</h2>
            <p>See items you've saved for later.</p>
            <button className="dashboard-btn">View Wishlist</button>
          </div>
          <div className="dashboard-item">
            <h2>Support</h2>
            <p>Need help? Contact our support team.</p>
            <button className="dashboard-btn">Get Support</button>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Dashboard;
