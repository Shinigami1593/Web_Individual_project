import React, { useState } from 'react';
import './CSS/ProductsDetail.css'; ; // Import your CSS file for styling

const ProductDetail = () => {
  const [quantity, setQuantity] = useState(1);

  const handleAddToCart = () => {
    // Handle the add-to-cart logic here
    alert(`Added ${quantity} item(s) to the cart.`);
  };

  return (
    <section className="product-detail">
      <div className="product-image">
        <img src="placeholder.png" alt="Product Image" />
      </div>
      <div className="product-info">
        <h1>Text Heading</h1>
        <span className="product-tag">Tag</span>
        <p className="product-price">$50</p>
        <p className="product-description">Text</p>
        <label htmlFor="quantity">Quantity</label>
        <select
          id="quantity"
          name="quantity"
          value={quantity}
          onChange={(e) => setQuantity(e.target.value)}
        >
          {[...Array(10).keys()].map((num) => (
            <option key={num + 1} value={num + 1}>
              {num + 1}
            </option>
          ))}
        </select>
        <button className="add-to-cart-btn" onClick={handleAddToCart}>
          Add to cart
        </button>
      </div>
    </section>
  );
};

export default ProductDetail;
