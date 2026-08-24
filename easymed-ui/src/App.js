import React, { useState } from 'react';
import axios from 'axios';

const BASE_URL = 'http://localhost:8090/consumer';

function App(){
  // object to store initial values
  const initialFormState={
    customerName: '',
    customerContact:'', 
    medicineName:'',
    quantity:''
  };

  // states
  const [formData, setFormData] = useState(initialFormState);
  const [searchName, setSearchName] = useState('');
  const [searchContact, setSearchContact] = useState('');
  const [ordersList, setOrdersList] = useState([]);
  const [statusMessage, setStatusMessage] = useState('');

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  // order save api
  const handleSaveOrder = async(e)=>{
    e.preventDefault();
    try{
      const response=await axios.post(`${BASE_URL}/save`, formData);
      setStatusMessage(`Order Saved Successfully with Id: ${response.data}`);
      setFormData(initialFormState);
    }catch(error){
      setStatusMessage(`Error Saving Order: ${error}`)
    }
  };

  // get all orders api
const handleGetAll = async () => {
    try {
      const response = await axios.get(`${BASE_URL}/getAll`);
      setOrdersList(response.data);
      setStatusMessage(`Loaded ${response.data.length} order(s).`);
    } catch (error) {
      setStatusMessage('Error fetching all orders.');
    }
  };

  //Get Orders By Medicine Name
  const handleGetByName = async (e) => {
    e.preventDefault();
    if (!searchName.trim()) return;
    try {
      const response = await axios.get(`${BASE_URL}/getAllByName/${searchName}`);
      setOrdersList(response.data);
      setStatusMessage(`Found ${response.data.length} order for medicine "${searchName}".`);
    } catch (error) {
      setStatusMessage('Error fetching orders by name.');
    }
  };

  // Get Orders By Customer Contact
  const handleGetByContact = async (e) => {
    e.preventDefault();
    if (!searchContact.trim()) return;
    try {
      const response = await axios.get(`${BASE_URL}/getAllByContact/${searchContact}`);
      setOrdersList(response.data);
      setStatusMessage(`Found ${response.data.length} order for contact "${searchContact}".`);
    } catch (error) {
      setStatusMessage('Error fetching orders by contact.');
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <h2>EasyMed</h2>
      <hr />

      
      {statusMessage && (
        <p style={{ fontWeight: 'bold', color: 'blue' }}>{statusMessage}</p>
      )}

      {/* order save form */}
      <fieldset style={{ marginBottom: '20px' }}>
        <legend>Add New Medicine Order</legend>
        <form onSubmit={handleSaveOrder}>
          <div>
            <label>Customer Name: </label>
            <input
              type="text"
              name="customerName"
              value={formData.customerName}
              onChange={handleInputChange}
              required
            />
          </div>
          <br />
          <div>
            <label>Customer Contact: </label>
            <input
              type="text"
              name="customerContact"
              value={formData.customerContact}
              onChange={handleInputChange}
              required
            />
          </div>
          <br />
          <div>
            <label>Medicine Name: </label>
            <input
              type="text"
              name="medicineName"
              value={formData.medicineName}
              onChange={handleInputChange}
              required
            />
          </div>
          <br />
          <div>
            <label>Quantity: </label>
            <input
              type="number"
              name="quantity"
              value={formData.quantity}
              onChange={handleInputChange}
              required
            />
          </div>
          <br />
          <button type="submit">Submit Order</button>
        </form>
      </fieldset>

      {/* order search */}
      <fieldset style={{ marginBottom: '20px' }}>
        <legend>Fetch & Search Orders</legend>

        {/* Fetch All orders */}
        <div>
          <button onClick={handleGetAll}>Fetch All Orders</button>
        </div>
        <br />

        {/* Search By Medicine Name */}
        <form onSubmit={handleGetByName}>
          <label>Search by Medicine Name: </label>
          <input
            type="text"
            value={searchName}
            onChange={(e) => setSearchName(e.target.value)}
          />
          <button type="submit">Search Name</button>
        </form>
        <br />

        {/* Search By Contact */}
        <form onSubmit={handleGetByContact}>
          <label>Search by Customer Contact: </label>
          <input
            type="text"
            value={searchContact}
            onChange={(e) => setSearchContact(e.target.value)}
          />
          <button type="submit">Search Contact</button>
        </form>
      </fieldset>

      {/* SECTION 3: DISPLAY RESULTS */}
      <fieldset>
        <legend>Order Results</legend>
        {ordersList.length === 0 ? (
          <p>No orders to display.</p>
        ) : (
          <table border="1" cellPadding="8" cellSpacing="0">
            <thead>
              <tr>
                <th>ID</th>
                <th>Customer Name</th>
                <th>Contact</th>
                <th>Medicine Name</th>
                <th>Quantity</th>
              </tr>
            </thead>
            <tbody>
              {ordersList.map((order) => (
                <tr key={order.id}>
                  <td>{order.id}</td>
                  <td>{order.customerName}</td>
                  <td>{order.customerContact}</td>
                  <td>{order.medicineName}</td>
                  <td>{order.quantity}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </fieldset>
    </div>
  );
}

export default App;