import { Alert } from '@mui/material';
import React, { useState } from 'react';
import OneRowItem from './OneRowItem';
import OneWriteForm from './OneWriteForm';

const OneApp = () => {
    const [dataArray,setDataArray]=useState(
        [
            {
                irum:"이효리",
                blood:'AB',
                photo:"30.jpg",
                today:new Date()
            },
            {
                irum:"강하나",
                blood:'A',
                photo:"7.jpg",
                today:new Date()
            },
            {
                irum:"남보라",
                blood:'O',
                photo:"29.jpg",
                today:new Date()
            }
        ]
    );

    //배열에 추가하는 함수
    const dataAddEvent=(data)=>{
        setDataArray(dataArray.concat({
            ...data,/*펼침연산자*/
            today:new Date()
        }));
    }

    //삭제하는 함수
    const deleteData=(idx)=>{
        setDataArray(dataArray.filter((d,i)=>idx!==i));
    }
    return (
        <div style={{width:'500px'}}>
            <Alert severity='success'
            style={{fontSize:'25px'}}>OneApp-자식컴포넌트와의 통신</Alert>
            {/* 데이타 입력 */}
            <OneWriteForm onSave={dataAddEvent}/>
            <hr/>
            {/* 데이타 출력 */}
            <table className='table table-bordered'>
                <thead>
                    <tr className='table-danger'>
                        <th width="50">번호</th>
                        <th width="150">이름</th>
                        <th width="60">혈액형</th>
                        <th width="120">등록일</th>
                        <th>삭제</th>                        
                    </tr>
                </thead>
                <tbody>
                {
                    dataArray.map((row,idx)=>
                        <OneRowItem key={idx} row={row} idx={idx}
                        onDelete={deleteData}/>)
                } 
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;