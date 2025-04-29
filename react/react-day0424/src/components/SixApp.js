import { Alert } from '@mui/material';
import React, { useState } from 'react';
import SixShowState from './SixShowState';
import SixAverage from './SixAverage';

const SixApp = () => {
    const [number,setNumber]=useState(0);
    const [text,setText]=useState('');
    const increNumber=()=>{
        setNumber(number+1);
    }

    const decreNumber=()=>{
        setNumber(number-1);
    }

    const onChangeTextHandler=(e)=>{
        setText(e.target.value);
    }

    return (
        <div>
            <Alert severity='success'
                        style={{fontSize:'25px'}}>SixApp-useMemo(memorization:랜더링을 최적화하기 위한 기능)</Alert>
        
            <button onClick={increNumber}>+</button>
            &nbsp;&nbsp;
            <button onClick={decreNumber}>-</button>
            <br/>
            <input type='text' placeholder='Last name?'
            onChange={onChangeTextHandler}/>

            {/* 서브 컴포넌트 호출 */}
            <SixShowState number={number} text={text}/>
            <hr/>
            <SixAverage/>
        </div>
    );
};

export default SixApp;