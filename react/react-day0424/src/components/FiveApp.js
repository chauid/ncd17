import { Alert } from '@mui/material';
import React from 'react';
import { Route, Routes, useNavigate } from 'react-router-dom';
import { ShopDetail, ShopForm, ShopList } from '../shopcomponents';

const FiveApp = () => {
    const navi=useNavigate();
    return (
        <div>            
            <Alert severity='success'
                        style={{fontSize:'25px'}}>FiveApp-shop 라우터설정</Alert>
            <div style={{margin:'20px'}}>
                {/* <NavLink to={"/five/list"}>Shop목록</NavLink>
                &nbsp;&nbsp;
                <NavLink to={"/five/form"}>Shop추가</NavLink> */}
                <button type='button' className='btn btn-sm btn-outline-secondary'
                onClick={()=>navi("/five/list")}>Shop목록</button>
                 &nbsp;&nbsp;
                 <button type='button' className='btn btn-sm btn-outline-secondary'
                onClick={()=>navi("/five/form")}>Shop 추가</button>
                <br/><br/>
                <Routes>
                    <Route path='/' element={<ShopList/>}/>
                    <Route path='list' element={<ShopList/>}/>
                    <Route path='form' element={<ShopForm/>}/>
                    <Route path='detail/:num' element={<ShopDetail/>}/>
                </Routes>
            </div>
        </div>
    );
};

export default FiveApp;