import React from 'react';
import noimage from "../image/noimage.png";
import { DeleteForever, DeleteForeverSharp} from '@mui/icons-material';

const FourRowItem = ({row,onDelete}) => {
    const shoppath=process.env.REACT_APP_PHOTO_URL;

    //삭제 함수
    const shopDeleteEvent=(num)=>{
        let a=window.confirm("해당 상품을 삭제할까요?");
        if(!a) return;

        onDelete(num);
    }
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
                        style={{float:'right',cursor:'pointer'}}
                        onClick={()=>shopDeleteEvent(row.num)}/>
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