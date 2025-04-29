import { Alert } from '@mui/material';
import React from 'react';
import { Route, Routes, useNavigate } from 'react-router-dom';
import ReducerComp1 from '../reducer/ReducerComp1';
import ReducerComp2 from '../reducer/ReducerComp2';

const EightApp = () => {
    const navi=useNavigate();
    return (
        <div>
            <Alert severity='success'
                        style={{fontSize:'25px'}}>EightApp-useReducer</Alert>
            <br/>
            <button type='button' onClick={()=>navi("/eight/reducer1")}>Reducer 예제1</button>   
            &nbsp;  
            <button type='button' onClick={()=>navi("/eight/reducer2")}>Reducer 예제2</button>   

            <div style={{margin:'20px'}}>
                <Routes>
                    <Route path='reducer1' element={<ReducerComp1/>}/>
                    <Route path='reducer2' element={<ReducerComp2/>}/>
                </Routes>  
            </div>      
        </div>
    );
};

export default EightApp;