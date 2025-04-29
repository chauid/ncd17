import React, { useReducer, useState } from 'react';
/*
  useReducer : state 관리가 용이하며 유지,보수가 편하다
  호출 : dispatch(type,action)
  구현 
     reducer(state,action)
  기능
  reducer : state 를 업데이트하는 역할(은행)
  dispatch-state 업데이트를 요구
  action - 요구의 내용
*/
//action type 을 미리 상수화해서 정해놓고자 할경우
const ACTION_TYPES={
    add:'addmoney',
    sub:'submoney'
}

const reducer=(state,action)=>{
    console.log("reducer 가 일을 합니다",state,action);
     switch(action.type){
        case ACTION_TYPES.add:
            return state+Number(action.payload);
        case ACTION_TYPES.sub:
            return state-action.payload;
        default:
            return state;
     }
}

const ReducerComp1 = () => {
    const [number,setNumber]=useState(0);
    //money  의 state 값 변경시 dispatch 로 호출
    const [money,dispatch]=useReducer(reducer,0);//money 가 0으로 초기값 지정

    return (
        <div>
            <h5>useReducer 예제 #1</h5>
            <h2 className='alert alert-success'>useReducer 은행에 오신것을 
                환영합니다
            </h2>
            <h3>잔고 : {money}원</h3>
            <input type='number' value={number}
            step={1000} onChange={(e)=>setNumber(e.target.value)}/>
            <br/><br/>
            <button type='button' 
            onClick={()=>dispatch({'type':ACTION_TYPES.add,payload:number})}>입금</button>
            &nbsp;&nbsp;
            <button type='button' 
            onClick={()=>dispatch({'type':ACTION_TYPES.sub,payload:number})}>출금</button>
           
        </div>
    );
};

export default ReducerComp1;