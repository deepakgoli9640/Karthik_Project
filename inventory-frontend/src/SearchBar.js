import { useState } from "react";
import SuggestionList from "./SuggestionList";
function SearchBar() {
  const [searchTerm, setSearchTerm] = useState("");
  const [results, setResults] = useState([]);
  function handleSearch()
  {
  return (
  setSearchTerm(event.target.value)
  );
  }

  return (
    <div>
      <input
        className="form-control me-3"
        type="search"
        placeholder="Search for products"
        aria-label="Search"
        style={{ width: "500px",
                height: "60px"
         }}

        onClick={handleSearch}  // Call handleSearch on every input change
      />
    <div>
        <SuggestionList results={results} />
    </div>
    </div>
  );
}

export default SearchBar;
