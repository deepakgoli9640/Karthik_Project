import React from 'react';
import karpuram from 'C:/Users/deepa/OneDrive/Desktop/karthik/frontend/src/Components/Assets/karpuram.png';
import './cart.css';
const Cart=()=>{
    return(
        <div>
          <div className="card" style={{ width: "18rem" }}>
            <img src={karpuram} className="card-img-top" alt="..." />
            <div className="card-body">
              <h3 className="card-title">Price : 235</h3>
              <p className="card-text">

              </p>
              <a href="#" className="btn btn-primary">
                Proceed to Bill
              </a>

            </div>
          </div>

        </div>
        )
    }

export default Cart;
