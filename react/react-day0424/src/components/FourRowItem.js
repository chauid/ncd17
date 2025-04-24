import React from 'react';
import noimage from "../image/noimage.png";
import { DeleteForeverSharp } from '@mui/icons-material';

const FourRowItem = ({row}) => {
    const shoppath="https://kr.object.ncloudstorage.com/bitcamp-bucket-springmvc3/jpashop/";

    return (
        <tr>
            <td width="160">
                <img alt="" src={row.photo?shoppath+row.photo:noimage}  
                style={{width:'140px',height:'180px',border:'3px solid gray'}}
                  onError={(e)=>e.target.src=noimage}/>   
            </td>
            <td style={{marginLeft:'10px'}} valign="middle">
                <h6>상품명 : {row.sangpum}
                    <DeleteForeverSharp 
                        style={{float:'right',cursor:'pointer'}}/>
                </h6>
                <h6 style={{backgroundColor:row.color}}>색 상 : {row.color}</h6>
                <h6>단 가 : {row.price}원</h6>
                <h6>구입일 : {row.sangguip}</h6>
                <h6>등록일 : {row.writeday}</h6>
            </td>
        </tr>
    );
};

export default FourRowItem;