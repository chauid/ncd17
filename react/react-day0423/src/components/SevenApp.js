import { Alert } from '@mui/material';
import React, { useState } from 'react';

const SevenApp = () => {
    const [starArray,setStarArray]=useState([
        {
            starName:'김우빈',
            starAge:'22세',
            starPhoto:'2.jpg',
            starAddress:'서울시 강남구',
            starPhone:'010-2222-3333'
        },
        {
            starName:'설현',
            starAge:'25세',
            starPhoto:'15.jpg',
            starAddress:'서울시 영등포구',
            starPhone:'010-6767-8989'
        },
        {
            starName:'신민아',
            starAge:'31세',
            starPhoto:'17.jpg',
            starAddress:'제주도 애월읍',
            starPhone:'010-7777-9999'
        },
        {
            starName:'신세경',
            starAge:'29세',
            starPhoto:'18.jpg',
            starAddress:'부산시 해운대구',
            starPhone:'010-1234-1234'
        },
        {
            starName:'수지',
            starAge:'32세',
            starPhoto:'19.jpg',
            starAddress:'서울시 강동구',
            starPhone:'010-8765-9876'
        }
    ]);
    return (
        <div>
            <Alert severity='success'>SevenApp-배열 데이타 출력</Alert>
            <table className='table table-bordered' style={{width:'430px'}}>
                <tbody>
                {
                  starArray.map((row,idx)=>
                 <>
                    <tr>
                        <td rowSpan={4}>
                            <img alt="" 
                            src={require(`../star/${row.starPhoto}`)}
                            style={{width:'200px',height:'230px'}}/>
                        </td>
                        <td>이름 : {row.starName}</td>
                    </tr>
                    <tr>
                        <td>나이 : { row.starAge}세</td>
                    </tr>
                    <tr>
                        <td>핸드폰 : { row.starPhone}</td>
                    </tr>
                    <tr>
                        <td>주소 : { row.starAddress}</td>
                    </tr>
                 </>)  
                }
                </tbody>
            </table>
        </div>
    );
};

export default SevenApp;