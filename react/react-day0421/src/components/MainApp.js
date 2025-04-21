import React from "react";
import { OneApp } from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
const MainApp=()=>{
    return (
        <div>
            <h3 className="alert alert-danger">MainApp</h3>
            <OneApp/>
            <hr/>
            <TwoApp/>
            <hr/>
            <ThreeApp/>
        </div>
    )
}
export default MainApp;