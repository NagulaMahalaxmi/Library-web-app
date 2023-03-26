import React from "react";
import { useState } from "react";
import Booksdisplay from "./Booksdisplay";

import "./Categorylist.css";

function Categorylist({ categories,onSelectCategory}) {
  const [selectedcategory, setSelectedcategory] = useState(null);

  const handleClick = async (event) => {
    const categoryid = event.target.value;
    setSelectedcategory(categoryid);
    onSelectCategory(categoryid);
  };
  
  return (
    <div className="category-list-container">
      <label for="categoryselect">Categories :</label>
      <select
        id="categoryselect"
        value={selectedcategory}
        onChange={handleClick}
      >        <option value="">select a category</option>

        {categories.map(category => (
          <option key={category.category_id} value={category.category_id}>
            {category.category_name}
          </option>
        ))}
        
      </select>
      
    </div>
  );
}

export default Categorylist;
