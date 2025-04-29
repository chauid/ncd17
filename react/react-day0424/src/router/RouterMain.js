import React from 'react';
import Menu from './Menu';
import { Route, Routes } from 'react-router-dom';
import Home from '../components/Home';
import { EightApp, FiveApp, FourApp, OneApp, SevenApp, SixApp, ThreeApp, TwoApp } from '../components';

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <br style={{clear:'both'}}/><br/>
            <div style={{margin:'10px'}}>
                <Routes>
                    <Route path='/' element={<Home/>}/>
                    <Route path='/one' element={<OneApp/>}/>
                    <Route path='/two' element={<TwoApp/>}/>
                    <Route path='/three' element={<ThreeApp/>}/>
                    <Route path='/four' element={<FourApp/>}/>
                    <Route path='/five/*' element={<FiveApp/>}/>
                    <Route path='/six' element={<SixApp/>}/>
                    <Route path='/seven' element={<SevenApp/>}/>
                    <Route path='/eight/*' element={<EightApp/>}/>                    
                </Routes>
            </div>
        </div>
    );
};

export default RouterMain;