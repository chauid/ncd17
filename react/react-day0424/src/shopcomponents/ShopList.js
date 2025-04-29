import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import noimage from '../image/noimage.png';
import { useNavigate } from 'react-router-dom';

const ShopList = () => {
    const [shoplist,setShopList]=useState([]);
    const navi=useNavigate();
    //사진출력할 url
    const photourl=process.env.REACT_APP_PHOTO_URL;

    //출력함수
    const list=()=>{
        axios.get("/react/shoplist")
        .then(res=>setShopList(res.data));
    }
    //처음 로딩시 list 함수 호출
    useEffect(()=>{
        list();
    },[]);

    return (
        <div>
            <Alert severity='info'>총 {shoplist.length} 개의 상품이 등록되었습니다</Alert>
            <table className='table table-bordered' style={{width:'400px'}}>
                <thead>
                    <tr className='table-danger'>
                        <th width="50">번호</th>
                        <th width="150">상품명</th>
                        <th width="100">가격</th>
                        <th>상세보기</th>                        
                    </tr>
                </thead>
                <tbody>
                {
                    shoplist
                    &&
                    shoplist.map((row,idx)=>
                    <tr key={idx}>
                        <td align='center'>{idx+1}</td>
                        <td>
                            <img alt='' src={row.photo?photourl+row.photo:noimage}
                            style={{width:'30px',height:'30px',border:'1px solid black'}}
                            />
                            &nbsp;
                            {row.sangpum}
                        </td>
                        <td align='right'>{row.price}원</td>
                        <td align='center'>
                            <button type='button' 
                            className='btn btn-sm btn-outline-secondary'
                            onClick={()=>navi(`/five/detail/${row.num}`)}
                            >Detail</button>
                        </td>
                    </tr>)
                }
                </tbody>
            </table>
        
        </div>
    );
};

export default ShopList;