import React from 'react';
import { NavLink } from 'react-router-dom';
import "./mystyle.css";

const Menu = () => {
    return (
        <div>
          <ul className='menu'>
            <li>
                <NavLink to={"/"}>Home</NavLink>
            </li> 
            <li>
                <NavLink to={"/login/hello"}>Login</NavLink>
            </li>            
            <li>
                <NavLink to={"/about"}>About</NavLink>
            </li>
            <li>
                <NavLink to={"/about/Samsung"}>About #2</NavLink>
            </li>
            <li>
                <NavLink to={"/about/Google"}>About #3</NavLink>
            </li>
            <li>
                <NavLink to={"/food"}>Food</NavLink>
            </li> 
            <li>
                <NavLink to={"/food/8"}>Food #2</NavLink>
            </li>
            <li>
                <NavLink to={"/food/7/11"}>Food #3</NavLink>
            </li>           
          </ul>  
        </div>
    );
};

export default Menu;