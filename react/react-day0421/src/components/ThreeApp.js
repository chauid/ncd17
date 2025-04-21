import React, { useState } from 'react';
import "./mystyle.css";

const ThreeApp = () => {
    //값을 변경하기 위해서는 useState 를 이용해서 선언해야한다
    //[변수명,setter함수명]=useState(초기값)
    const [number,setNumber]=useState(0);//0은 초기값
    //통장번호를 저장할 변수
    const [accountNumber,setAccountNumber]=useState('111-111-1111');

    //5씩 감소하는 버튼 이벤트
    const decre5=()=>{
        if(number>0)
            setNumber(number-5);
    }

    //5씩 증가하는 버튼 이벤트
    const incre5=()=>{
        if(number<100)
            setNumber(number+5);
    }
    return (
        <div>
            <h3>ThreeApp 컴포넌트-숫자 증가/감소 이벤트</h3>

            <button type='button' className='btnstyle'
            onClick={()=>{
                if(number>0)
                    setNumber(number-1);
            }}>감소</button>
            <button type='button' className='btnstyle'
            onClick={()=>{
                if(number<10)
                  setNumber(number+1)
            }}>증가</button>
            <br/>
            <button type='button' className='btnstyle'
            onClick={decre5}>5씩감소</button>
            <button type='button' className='btnstyle'
            onClick={incre5}>5씩증가</button>
            <br/>
            <b className='numstyle'>{number}</b>
            <hr/>
            {/* 통장번호를 입력하면 바로 바뀐 번호로 출력되도록 이벤트를 추가하시오 */}
            <input type='text' className='form-control'
            placeholder='통장번호를 입력하세요'
            value={accountNumber}
            onChange={(e)=>setAccountNumber(e.target.value)}/>
            <br/>
            <h3 style={{color:'red'}}>{accountNumber}</h3>
        </div>
    );
};

export default ThreeApp;