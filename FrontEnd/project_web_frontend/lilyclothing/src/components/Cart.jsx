import React from 'react';
import './CSS/Cart.css'; // Assume you have a CSS file for styling

const Cart = () => {
  const cartItems = [
    {
      id: 1,
      name: 'Product Name 1',
      price: 50,
      quantity: 1,
      image: 'product-image.png',
    },
    {
      id: 2,
      name: 'Product Name 2',
      price: 30,
      quantity: 1,
      image: 'product-image.png',
    },
  ];

  const handleQuantityChange = (id, value) => {
    // Handle quantity change logic here
  };

  const handleCheckout = () => {
    // Handle checkout logic here (e.g., sending data to server, etc.)
    alert("Proceeding to checkout!");
  };

  const subtotal = cartItems.reduce((acc, item) => acc + item.price * item.quantity, 0);

  return (
    <section className="cart">
      <div className="cart-container">
        <h1>Your Cart</h1>
        <table className="cart-table">
          <thead>
            <tr>
              <th>Product</th>
              <th>Price</th>
              <th>Quantity</th>
              <th>Total</th>
            </tr>
          </thead>
          <tbody>
            {cartItems.map((item) => (
              <tr key={item.id}>
                <td>
                  <div className="cart-product">
                    <img src={item.image} alt={item.name} />
                    <p>{item.name}</p>
                  </div>
                </td>
                <td>${item.price}</td>
                <td>
                  <input
                    type="number"
                    value={item.quantity}
                    min="1"
                    onChange={(e) => handleQuantityChange(item.id, e.target.value)}
                  />
                </td>
                <td>${item.price * item.quantity}</td>
              </tr>
            ))}
          </tbody>
        </table>

        <div className="cart-summary">
          <h2>Cart Summary</h2>
          <p>Subtotal: ${subtotal}</p>
          <p>Shipping: Free</p>
          <p><strong>Total: ${subtotal}</strong></p>
          <button className="checkout-btn" onClick={handleCheckout}>
            Proceed to Checkout
          </button>
        </div>
      </div>
    </section>
  );
};

export default Cart;
