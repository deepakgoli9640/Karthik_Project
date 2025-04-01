import React from 'react';
import Data from './Data.json';
import Items from './Items.jsx';
import './all.css';
import {useState,useEffect} from 'react';
export const Update=()=>{
    const [items, setItems] = useState([]);
            useEffect(() => {
                fetch("http://localhost:8080/product/all") // Fetching from backend
                    .then((response) => response.json())
                    .then((data) => setItems(data))
                    .catch((error) => console.error("Error fetching items:", error));
                }, []);
    return(
        <div className="product-list">
          {items.map((item,i)=>{
               return <Items key={i} id={item.id} price={item.price} name={item.name} image={item.imageUrl} action="Modify Price" category={item.category}/>
              })}
          </div>
)
}

export const All=()=>{

    const [items, setItems] = useState([]);
        useEffect(() => {
            fetch("http://localhost:8080/product/all") // Fetching from backend
                .then((response) => response.json())
                .then((data) => setItems(data))
                .catch((error) => console.error("Error fetching items:", error));
            }, []);
    return(
        <div className="product-list">
          {items.map((item,i)=>{
               return <Items key={i} id={item.id} price={item.price} name={item.name} image={item.imageUrl} category={item.Category} action="Add to Cart"/>
              })}
          </div>
)
}

 export const Add = () => {
  
     const[values,setValues]=useState({
         name:'',
         imageUrl:'',
         category:'',
         price:''
         })
     const handleChange=(e)=>{
         setValues({...values,
             [e.target.name]:e.target.value
             });
         };
       const handleSubmit = async (e) => {
         e.preventDefault();
         try {
           const response = await fetch("http://localhost:8080/product/add", {
             method: "POST",
             headers: { "Content-Type": "application/json" },
             body: JSON.stringify(values),
           });

           if (response.ok) {
             alert("Product added successfully!");
             setValues({ name: '', price: '', imageUrl: '', category: '' }); // Reset form
           } else {
             alert("Failed to add product.");

           }
         } catch (error) {
           console.error("Error:", error);
         }
       };


            return(
                <div className="form">
                    <form onSubmit={handleSubmit}>
                        <label htmlFor="name">Product Name</label>
                        <input type="text" placeholder="Enter Product Name" name="name" onChange={(e)=>handleChange(e)} required/>

                        <label htmlFor="imageUrl">Image Url</label>
                        <input type="text" placeholder="Enter image Url" name="imageUrl" onChange={(e)=>handleChange(e)} reqiured/>

                        <label htmlFor="category">category</label>
                        <select name="category" id="category" onChange={(e)=>handleChange(e)}>
                            <option value="price in grams">price in grams</option>
                            <option value="price per item">price per item</option>
                        </select>

                        <label htmlFor="price">Price</label>
                        <input type="number" placeholder="Enter price of product" name="price" onChange={(e)=>handleChange(e)} required/>
                      <div className="submit">
                      <button type="submit" className="button">
                        Submit
                      </button>
                      </div>


                    </form>
                </div>

                )
            };
export const Delete=()=>{
  
  const [items, setItems] = useState([]);
  useEffect(() => {
      fetch("http://localhost:8080/product/all") 
          .then((response) => response.json())
          .then((data) => setItems(data))
          .catch((error) => console.error("Error fetching items:", error));
      }, []);
return(
  <div className="product-list">
    {items.map((item,i)=>{
         return <Items key={i} id={item.id} price={item.price} name={item.name} image={item.imageUrl} action="Delete" setItems={setItems}/>
        })}
    </div>
)
}




