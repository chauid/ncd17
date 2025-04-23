import { Alert } from '@mui/material';
import React, { useState } from 'react';
import "./mystyle.css";
/*
문제
1. mycarArray 를 해당 자동차 이미지가 나오도록 출력(class 는 mycar 적용)
2. input 에 숫자 1~15 를 입력후 엔터를 누르면 해당 자동차번호가 배열에 추가되고
   이미지 형태로 출력이 되도록 한다
   (단 1~15 가 아닐경우 "해당 자동차는 존재하지 않아요!" 출력)
3. 해당 자동차를 더블클릭하면 "해당 자동차를 삭제할까요?" 물어본후 확인을 클릭하면
   배열에서 삭제하기(filter 이용)
*/
const ThreeApp = () => {
    const [mycarArray,setMycarArray]=useState([1,5,10,3]);

    //자동차 번호 추가하는 이벤트
    const addCarNoEvent=(e)=>{
        if(e.key==='Enter'){
            let carNo=Number(e.target.value);
            if(carNo<1 || carNo>15){
                alert("해당 자동차는 존재하지 않아요!");
                e.target.value="";
                return;
            }

            setMycarArray(mycarArray.concat(carNo));
            e.target.value="";
        }
    }

    //삭제 메서드
    const deleteCar=(i)=>{
        let a=window.confirm("해당 자동차를 삭제할까요?");
        if(!a)
            return;

        //i번 삭제
        setMycarArray(mycarArray.filter((car,idx)=>i!==idx));
    }
    return (
        <div style={{width:'500px'}}>
            <Alert severity='success'>ThreeApp-배열 문제</Alert>

            <input type='text' className='form-control'
            placeholder='1-15 사이의 자동차 번호 입력'
            autoFocus onKeyUp={addCarNoEvent}/>
            <div style={{marginTop:'20px'}}>
            {
                mycarArray.map((car,idx)=>
                    <>
                        <img alt="" src={require(`../mycar/mycar${car}.png`)}
                        className='mycar'
                        onDoubleClick={()=>deleteCar(idx)}/>
                    </>)
            }
            </div>
        </div>
    );
};

export default ThreeApp;