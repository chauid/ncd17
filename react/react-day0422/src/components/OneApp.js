import React, { useState } from 'react';
import './mystyle.css';
import photo1 from '../image/31.jpg';

const OneApp = () => {
    const [irum,setIrum]=useState('이해성');
    const [nai,setNai]=useState(20);

    const style1={
        color:'deeppink',
        backgroundColor:'#fcfc00',
        width:'400px',
        border:'5px groove tomato',
        textAlign:'center'
    }
    return (
        <div>
            <h3 className='alert alert-success'>OneApp-복습,간단한 데이타 입력 이벤트</h3>
            <h5 style={style1}>스타일 적용방법 #1-변수로 지정하는 방법</h5>
            <h5 style={{color:'red',fontFamily:'Single Day',
                border:'3px inset gold'
            }}>스타일 적용방법 #2-직접 지정하는 방법</h5>
            <h5 className='myfont'>스타일 적용방법 #2-클래스적용</h5>
            <img alt='' src={photo1} style={{width:'150px'}}/>
            <h6>이름과 나이 입력하기</h6>
            <h2 style={{backgroundColor:'orange'}}>
                이 름 : {irum}<br/>
                나 이 : {nai}세
            </h2>
            <input type='text' placeholder='irum 입력' value={irum}
            onChange={(e)=>setIrum(e.target.value)}/>
            <input type='text' placeholder='nai 입력' value={nai}
            onChange={(e)=>setNai(e.target.value)}/>
        </div>
    );
};

export default OneApp;