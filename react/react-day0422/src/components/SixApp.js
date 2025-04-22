import { Switch } from '@mui/material';
import React, { useEffect, useState } from 'react';

const SixApp = () => {
    //style 을 이용해서 이미지 보이기/숨기기
    const [visible,setVisible]=useState('visible');
    //const [visible,setVisible]=useState('hidden');

    const [count,setCount]=useState(1);
    const [number,setNumber]=useState(100);

    // useEffect(()=>{
    //     console.log("처음에도 호출되고 state 변수가 변경될때마다 호출된다")
    // });

    // useEffect(()=>{
    //     console.log("처음 로딩시 딱 한번만 호출된다")
    // },[]);

    // useEffect(()=>{
    //     console.log("count 가 변경될때 처리할 코드를 넣어주세요");
    // },[count]);

    // useEffect(()=>{
    //     console.log("number가 변경될때 처리할 코드를 넣어주세요");
    // },[number])

    useEffect(()=>{
        console.log("count 와 number가 변경될때 처리할 코드를 넣어주세요");
    },[count,number]);

    return (
        <div>
           <h3 className='alert alert-success'>
            SixApp-MUI Switch,require,useEffect</h3>  
        
            <br/>
            <Switch defaultChecked color="secondary"
            onChange={(e)=>setVisible(e.target.checked?'visible':'hidden')}/>
            <br/>
           <img alt='' src={require('../image2/12.jpg')}
           style={{width:'200px',visibility:visible}}/>
           <hr/>
           <h1>count:{count}</h1>
           <h1>number:{number}</h1>

           <button onClick={()=>setCount(count+1)}>count 1 증가</button>
           <br/>
           <button onClick={()=>setNumber(number+10)}>number 10 증가</button>
           <br/>
           <button onClick={()=>{
                setCount(count+2);
                setNumber(number+5)
           }}>count 와 number 모두 증가</button>
           
        </div>
    );
};

export default SixApp;