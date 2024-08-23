// import React from 'react';
import { Link } from 'react-router-dom';
import './CSS/Homepage.css'; ;

function Homepage() {
  return (
    <div>
      <section className="hero-section">
        <h1>LilyClothing</h1>
        <button className="get-started-btn">
          <Link to="/signin">Get Started</Link>
        </button>
      </section>

      <section className="image-placeholder">
        <img src="placeholder.png" alt="Placeholder Image" />
      </section>
    </div>
  );
}

export default Homepage;
