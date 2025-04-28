import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const ShopDetail = () => {
   const [selectData,setSelectData]=useState('');

   const {num}=useParams();

   //num 에 해당하는 데이타 가져오기
   const getSelectData=()=>{
      let geturl=process.env.REACT_APP_API_URL + "/react/detail?num="+num;
      axios.get(geturl)
      .then(res=>setSelectData(res.data));
   }

   //처음 로딩시 함수 호출
   useEffect(()=>getSelectData(),[]);

     return (
        <div>
           <Alert severity='info'>상품 상세보기</Alert> 
           {
              selectData &&
               <h2><b>{selectData.sangpum}</b></h2>
            }
        </div>
    );
};

export default ShopDetail;