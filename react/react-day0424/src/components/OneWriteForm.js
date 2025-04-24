import { Button } from '@mui/material';
import React, { useState } from 'react';

const OneWriteForm = ({onSave}) => {
    const [irum,setIrum]=useState('');
    const [photo,setPhoto]=useState('13.jpg');
    const [blood,setBlood]=useState('O');

    //추가 버튼 이벤트
    const addEvent=()=>{
        onSave({irum,photo,blood});
        setIrum("");
    }

    return (
        <div className='input-group'>          
            <input type='text' className='form-control' value={irum}
            placeholder='이름' onChange={(e)=>setIrum(e.target.value)}/>

            <select className='form-select'
            onChange={(e)=>setPhoto(e.target.value)}>
            {
                [...new Array(10)].map((_,idx)=>
                    <option key={idx}>{idx+13}.jpg</option>)
            }
            </select>
            <select className='form-select'
            onChange={(e)=>setBlood(e.target.value)}>
                <option>O</option>
                <option>A</option>
                <option>B</option>
                <option>AB</option>                
            </select>
            <Button color='success' variant='contained' onClick={addEvent}>
                추가</Button>

        </div>
    );
};

export default OneWriteForm;