import { DeleteForeverSharp } from '@mui/icons-material';
import { Alert, Button } from '@mui/material';
import React, { useState } from 'react';

const SixApp = () => {
    const [inputArray,setInputArray]=useState([]);
    const [inputs,setInputs]=useState({
        name:'',
        nickname:'',
        hp:'',
        addr:''
    });

    //각 데이타 입력시 inputs 의 각 멤버값에 넣어주기
    const changeData=(e)=>{
        //e.target.name, e.target.value
        let {name,value}=e.target;

        setInputs(
            {
                ...inputs, //기존의 inputs 객체를 펼쳐서 넣음
                [name]:value  //입력하는 태그의 name 과 value 를 넣어준다
            }
        )

    }
    return (
        <div>
            <Alert severity='success'>SixApp-입력값들을 하나의 객체에 넣기</Alert>
            <table className='table table-bordered' style={{width:'300px'}}>
                <tbody>
                    <tr>
                        <th className='table-success' width="100">이름</th>
                        <td>
                            <input type='text' className='form-control'
                            name="name" value={inputs.name}
                            onChange={changeData}/>
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' width="100">닉네임</th>
                        <td>
                            <input type='text' className='form-control'
                            name="nickname" value={inputs.nickname}
                            onChange={changeData}/>
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' width="100">핸드폰</th>
                        <td>
                            <input type='text' className='form-control'
                            name="hp" value={inputs.hp} onChange={changeData}/>
                        </td>
                    </tr>
                    <tr>
                        <th className='table-success' width="100">주소</th>
                        <td>
                            <input type='text' className='form-control'
                            name="addr" value={inputs.addr}
                            onChange={changeData}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align='center'>
                            <Button variant='outlined' color="warning"
                            onClick={()=>setInputArray(inputArray.concat(inputs))}>
                                배열에 추가</Button>
                            <Button variant='outlined' color="warning"
                            onClick={()=>setInputs({
                                name:'',
                                nickname:'',
                                hp:'',
                                addr:''
                            })}>
                            입력값 초기화</Button>
                        </td>
                    </tr>
                    <tr style={{height:'100px'}} className='table-info'>
                        <td colSpan={2}>
                            <h5>
                                이름 : {inputs.name}<br/>
                                닉네임 : {inputs.nickname}<br/>
                                핸드폰 : {inputs.hp}<br/>
                                주소 : {inputs.addr}
                            </h5>
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr/>
            <table className='table table-bordered' style={{width:'500px'}}>
                <caption align="top">총 {inputArray.length} 명</caption>
                <thead>
                    <tr className='table-success'>
                        <th width="50">번호</th>
                        <th width="80">이름</th>
                        <th width="80">닉네임</th>
                        <th width="100">핸드폰</th>
                        <th width="120">주소</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                {
                    inputArray.map((row,idx)=>
                    <tr key={idx}>
                        <td align="center">{idx+1}</td>
                        <td>{row.name}</td>
                        <td>{row.nickname}</td>
                        <td>{row.hp}</td>
                        <td>{row.addr}</td>
                        <td align="center">
                            <DeleteForeverSharp style={{color:'red',cursor:'pointer'}}
                            onClick={()=>{
                                setInputArray(inputArray.filter((d,i)=>i!==idx));
                            }}/>
                        </td>
                    </tr>)
                }
                </tbody>
            </table>
        </div>
    );
};

export default SixApp;