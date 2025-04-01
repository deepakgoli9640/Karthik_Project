import react from 'react';
import reactdom from 'react-dom/client';
import SearchBar from './SearchBar';
export default function SuggestionList({ results }) {
    return (
        <div>
        <ul>
           {results.map((item, index) => (
             <li key={index}  color="white">{item.name}</li>  // Change `item.name` based on your API response
           ))}
         </ul>
        </div>
    );
}
