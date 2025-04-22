import React, { useEffect, useState } from 'react';
import img1 from '../image2/19.jpg';
import { Button } from '@mui/material';

const SevenApp = () => {
    const [count,setCount]=useState(1);
    const [show,setShow]=useState(true);

    useEffect(()=>{
        count%3===0?setShow(false):setShow(true); 
    },[count]);//count 가 변경이 되어야만 호출된다

    return (
        <div>
            <h3 className='alert alert-success'>SevenApp-useEffect</h3>  
            <h5>count 가 3의 배수일때마다 사진 숨기기</h5>

            <Button variant='contained' color="success"
            onClick={()=>{
                setCount(count+1);
                //비동기 특성상 순서대로 진행되지 않는다
                //count%3===0?setShow(false):setShow(true);
            }}>count증가</Button>
            <br/>
            <b style={{fontSize:'4em',color:'red'}}>{count}</b>
            <br/><br/>
            {
                show &&
                <img alt='' src={img1} style={{width:'300px'}}/>
            }
        </div>
    );
};

export default SevenApp;