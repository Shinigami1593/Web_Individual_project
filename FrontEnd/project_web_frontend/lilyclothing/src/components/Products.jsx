import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import Modal from 'react-modal';
import axios from 'axios';
import './CSS/Products.css'; // Import your CSS file for styling

// Define Modal root element for accessibility
Modal.setAppElement('#root');

const API_URL = 'http://localhost:8080/products'; // Base API URL

const ProductGrid = () => {
  const [products, setProducts] = useState([]);
  const [modalIsOpen, setModalIsOpen] = useState(false);
  const [newProduct, setNewProduct] = useState({
    name: '',
    description: '',
    price: '',
    stockQuantity: '',
  });

  useEffect(() => {
    // Fetch products from API on component mount
    const fetchProducts = async () => {
      try {
        const response = await axios.get(`${API_URL}/getAll`);
        console.log(response.data);
        setProducts(response.data); // Adjust to access the 'data' property
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    };

    fetchProducts();
  }, []);

  const openModal = () => setModalIsOpen(true);
  const closeModal = () => setModalIsOpen(false);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewProduct((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const addProduct = async () => {
    try {
      const response = await axios.post(`${API_URL}/save`, newProduct);
      setProducts((prev) => [...prev, response.data]);
      setNewProduct({
        name: '',
        description: '',
        price: '',
        stockQuantity: '',
      });
      closeModal();
    } catch (error) {
      console.error('Error adding product:', error);
    }
  };

  const editProduct = async (productId, updatedProduct) => {
    try {
      await axios.put(`${API_URL}/update/${productId}`, updatedProduct);
      setProducts((prev) =>
        prev.map((product) =>
          product.productId === productId ? { ...product, ...updatedProduct } : product
        )
      );
    } catch (error) {
      console.error('Error editing product:', error);
    }
  };

  const deleteProduct = async (productId) => {
    try {
      await axios.delete(`${API_URL}/delete/${productId}`);
      setProducts((prev) => prev.filter((product) => product.productId !== productId));
    } catch (error) {
      console.error('Error deleting product:', error);
    }
  };

  return (
    <section className="product-grid">
      <button onClick={openModal} className="add-product-btn">
        Add Product
      </button>
      {products.map((product) => (
        <div key={product.productId} className="product-card">
          <Link to={`/product/${product.productId}`}>
            <img src={product.image} alt={product.name} />
            <p>{product.name}</p>
            <p>${product.price}</p>
            <p>{product.description}</p>
            <p>Stock: {product.stockQuantity}</p>
          </Link>
          <button onClick={() => editProduct(product.productId, { name: 'Updated Product' })}>
            Edit
          </button>
          <button onClick={() => deleteProduct(product.productId)}>Delete</button>
        </div>
      ))}

      <Modal
        isOpen={modalIsOpen}
        onRequestClose={closeModal}
        contentLabel="Add Product Modal"
        className="modal"
        overlayClassName="overlay"
      >
        <h2>Add New Product</h2>
        <form onSubmit={(e) => { e.preventDefault(); addProduct(); }}>
          <label>
            Name:
            <input
              type="text"
              name="name"
              value={newProduct.name}
              onChange={handleInputChange}
              required
            />
          </label>
          <label>
            Description:
            <input
              type="text"
              name="description"
              value={newProduct.description}
              onChange={handleInputChange}
              required
            />
          </label>
          <label>
            Price:
            <input
              type="number"
              name="price"
              value={newProduct.price}
              onChange={handleInputChange}
              required
            />
          </label>
          <label>
            Stock Quantity:
            <input
              type="number"
              name="stockQuantity"
              value={newProduct.stockQuantity}
              onChange={handleInputChange}
              required
            />
          </label>
          <button type="submit">Add Product</button>
          <button type="button" onClick={closeModal}>Close</button>
        </form>
      </Modal>
    </section>
  );
};

export default ProductGrid;
