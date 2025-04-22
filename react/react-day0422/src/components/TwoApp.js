import React, { useState } from 'react';
import photo1 from '../image/30.jpg';
import photo2 from '../image/31.jpg';
import photo3 from '../image/2.jpg';
import photo4 from '../image/3.jpg';

const TwoApp = () => {
    const [photo,setPhoto]=useState(photo2);
    const [borderWidth,setBorderWidth]=useState(10);
    const [borderColor,setBorderColor]=useState('tomato');
    const [show,setShow]=useState(true);

    //색상 라디오버튼 이벤트
    const changeColor=(e)=>setBorderColor(e.target.value);

    return (
        <div>
           <h3 className='alert alert-success'>TwoApp-이벤트 연습</h3> 
           {
            show && 
           <img alt='' src={photo} 
           style={{width:'200px',border:`${borderWidth}px solid ${borderColor}`}}/>
            }
           
           <br/><br/>
           <b>보이기/숨기기</b>&nbsp;
            <label>
                <input type='checkbox' defaultChecked 
                onClick={(e)=>setShow(e.target.checked)}/>
            </label>
           <br/>
           <b>사진 변경 : </b>
           <select style={{width:'150px'}}
             onChange={(e)=>setPhoto(e.target.value)} >
                <option value={photo1}>사진 1</option>
                <option value={photo2} selected>사진 2</option>
                <option value={photo3}>사진 3</option>
                <option value={photo4}>사진 4</option>
           </select>
           <br/>
           <b>테두리선 굵기 변경 : </b>
           <input type='number' min="1" max="20" value={borderWidth}
           onChange={(e)=>setBorderWidth(Number(e.target.value))}/>
           <br/>
           <b>테두리선 색상 변경</b><br/>
           <label>
                <input type='radio' name='bcolor' defaultValue={'#66cdaa'}
                onClick={changeColor}/>아쿠아마린
           </label>
           &nbsp;&nbsp;
           <label>
                <input type='radio' name='bcolor' defaultValue={'#ffc0cb'}
                onClick={changeColor}/>연핑크
           </label>
           &nbsp;&nbsp;
           <label>
                <input type='radio' name='bcolor' defaultValue={'tomato'}
                defaultChecked onClick={changeColor}/>토마토
           </label>
           &nbsp;&nbsp;
           <label>
                <input type='radio' name='bcolor' defaultValue={'#9acd32'}
                onClick={changeColor}/>옐로그린
           </label>
        </div>
    );
};

export default TwoApp;