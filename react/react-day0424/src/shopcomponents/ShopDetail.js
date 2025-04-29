import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import noimage from '../image/noimage.png';

const ShopDetail = () => {
   const navi=useNavigate();

   const [selectData,setSelectData]=useState('');

   const {num}=useParams();

   //사진출력할 url
   const photourl=process.env.REACT_APP_PHOTO_URL;

   //num 에 해당하는 데이타 가져오기
   const getSelectData=()=>{
      let geturl="/react/detail?num="+num;
      axios.get(geturl)
      .then(res=>setSelectData(res.data));
   }

   //처음 로딩시 함수 호출
   useEffect(()=>getSelectData(),[]);

   //상품 삭제 이벤트
   const deleteEvent=()=>{
      let a=window.confirm("해당 상품을 삭제할까요?");
      if(!a) return;

      let deleteurl="/react/shopdelete?num="+num;
      axios.delete(deleteurl)
      .then(res=>navi("/five/list"));
   }
     return (
        <div>
           <Alert severity='info'>상품 상세보기</Alert> 
           {
              selectData &&
              <div>
                  <h2><b>{selectData.sangpum}</b></h2>
                  <table>
                     <tbody>
                        <tr>
                           <td align='center' width="370">
                              <img alt='' src={selectData.photo?photourl+selectData.photo:noimage}
                           style={{width:'300px',border:'5px solid tomato',marginRight:'10px'}}/>
                           </td>
                           <td valign='middle'>
                              <h3>상품명 : {selectData.sangpum}</h3>
                              <h3>색상 : 
                                 <div style={{backgroundColor:selectData.color,width:'100px',
                                    display:'inline-block',height:'25px',border:'1px solid black'}}></div>
                              </h3>
                              <h3>가 격 : {selectData.price}원</h3>
                              <h3>구입일 : {selectData.sangguip}</h3>
                              <h4>등록일 : {selectData.writeday}</h4>
                              <br/><br/>
                              <button type='button' className='btn btn-sm btn-secondary'
                              onClick={()=>navi('/five/form')}>상품추가</button>
                              &nbsp;
                              <button type='button' className='btn btn-sm btn-secondary'
                              onClick={()=>navi('/five/list')}>상품목록</button>
                              &nbsp;
                              <button type='button' className='btn btn-sm btn-secondary'
                              onClick={()=>navi(`/five/updateform/${num}`)}
                              >상품수정</button>
                              &nbsp;
                              <button type='button' className='btn btn-sm btn-secondary'
                              onClick={deleteEvent}>상품삭제</button>
                              &nbsp;

                           </td>
                        </tr>
                     </tbody>
                     
                  </table>
               </div>
            }
        </div>
    );
};

export default ShopDetail;