import { Alert } from '@mui/material';
import React, { useRef } from 'react';
import cate from '../data/CateData.json';
import './mystyle.css';

const TwoApp = () => {
    const navData=cate.navData;
    const cateData=cate.categoryData;

    const mainPhotoRef=useRef(null);

    return (
        <div>
            <Alert severity='success'
               style={{fontSize:'25px'}}>TwoApp-json 데이타 출력</Alert>
            <div className='nav_container'>
              <ul className='nav_category'>
                {
                navData.map((item,i)=>
                    <li key={i}>
                        <div>
                            <img alt='' src={item.img} 
                            className='imgcategory'
                            onClick=
                            {(e)=>mainPhotoRef.current.src=e.target.src}/>
                        </div>
                        <div>{item.title}</div>
                    </li>)  
                }
                </ul>
            </div>

            <div className='nav_container'>
              <ul className='nav_category'>
                {
                cateData.map((item,i)=>
                    <li key={i}>
                        <div>
                            <img alt='' src={item.img} 
                            className='imgcategory'
                            onClick=
                            {(e)=>mainPhotoRef.current.src=e.target.src}/>
                        </div>
                        <div>{item.title}</div>
                    </li>)  
                }
                </ul>
            </div>

            {/* 아이콘 클릭시 작은 이미지를 가져와서 출력할 이미지 */}
            <div>
                <img alt=''  src=''
                  style={{width:'300px',height:'300px',
                  border:'5px inset gray',margin:'10px 300px'}}
                  ref={mainPhotoRef}/>
            </div>
        </div>
    );
};

export default TwoApp;