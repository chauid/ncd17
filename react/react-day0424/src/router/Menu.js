import React from 'react';
import "../components/mystyle.css";
import { NavLink } from 'react-router-dom';

const Menu = () => {
    return (
        <div>
            <ul className='menu'>                
                <li>
                    <NavLink to={"/"}>Home</NavLink>
                </li>
                <li>
                    <NavLink to={"/one"}>One</NavLink>
                </li>
                <li>
                    <NavLink to={"/two"}>Two</NavLink>
                </li>
                <li>
                    <NavLink to={"/three"}>Three</NavLink>
                </li>
                <li>
                    <NavLink to={"/four"}>Four</NavLink>
                </li>
                <li>
                    <NavLink to={"/five"}>Five</NavLink>
                </li>
                <li>
                    <NavLink to={"/six"}>Six</NavLink>
                </li>
                <li>
                    <NavLink to={"/seven"}>Seven</NavLink>
                </li>
                <li>
                    <NavLink to={"/eight"}>Eight</NavLink>
                </li>

            </ul>
        </div>
    );
};

export default Menu;