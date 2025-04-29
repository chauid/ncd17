import { Alert, Button } from '@mui/material';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import noimage from '../image/noimage.png';
import axios from 'axios';

const ShopForm = () => {
    const [sangpum,setSangpum]=useState('');
    const [color,setColor]=useState('#ccffcc');
    const [price,setPrice]=useState(0);
    const [sangguip,setSangguip]=useState('2025-01-01');

    //업로드한 사진을 저장하기 위한 변수
    const [photo,setPhoto]=useState(null);
    const navi=useNavigate();
    //사진출력할 url
    const photourl=process.env.REACT_APP_PHOTO_URL;

     //파일 업로드 이벤트
     const photoUploadEvent=(e)=>{
        const imageFile=new FormData();
        const uploadFile=e.target.files[0];
        imageFile.append("upload",uploadFile);

        axios({
            method:'post',
            url:"/react/upload",
            data:imageFile
        }).then(res=>setPhoto(res.data));
    }

    //추가버튼 이벤트
    const addShopEvent=()=>{
       axios.post("/react/addshop",{sangpum,price,color,sangguip})
       .then(res=>{
         navi("/five/list");
          //초기화
            setSangguip('2025-01-01');
            setSangpum('');
            setPrice(0);
            setPhoto('');
       });       
    }
    return (
        <div>
            <Alert severity='info' style={{width:'500px'}}>상품 등록</Alert>
            <table className='table table-bordered' style={{width:'500px'}}>
                <tbody>
                    <tr>
                        <td rowSpan={5} width={200} align='center'>
                        <img alt='' src={photo?photourl+photo:noimage}
                        style={{width:'180px'}}/>
                        </td>
                        <td width="100" d>사진</td>
                        <td>
                            <input type='file' onChange={photoUploadEvent}
                            style={{width:'200px'}}/> 
                        </td>
                    </tr>
                    <tr>
                        <td>상품명</td>
                        <td>
                        <input type='text' 
                             value={sangpum} className='form-control'
                             onChange={(e)=>setSangpum(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td>가격</td>
                        <td>
                        <input type='text' 
                             value={price} className='form-control'
                             onChange={(e)=>setPrice(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td>색상</td>
                        <td>
                        <input type='color' 
                             value={color} className='form-control'
                             onChange={(e)=>setColor(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td>구입일</td>
                        <td>
                            <input type='date' 
                                value={sangguip} className='form-control'
                                onChange={(e)=>setSangguip(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3} align='center'>
                        <Button color='success' variant='contained'
                          style={{margin:'10px 160px',width:'100px'}} 
                          onClick={addShopEvent}>추가</Button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default ShopForm;