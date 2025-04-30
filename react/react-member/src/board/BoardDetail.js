import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const BoardDetail = () => {
    const [selectData,setSelectData]=useState('');
    const [error,setError]=useState('');

    const {num}=useParams();
    const navi=useNavigate();
    const PHOTO_URL=process.env.REACT_APP_PHOTO_URL;

    const getSelectData=()=>{
        axios({
            method:'get',
            url:'/auth/board/detail?num='+num,
            headers:{Authorization:`Bearer ${sessionStorage.token}`}
        }).then(res=>{
            setSelectData(res.data);
        }).catch(err=>setError("403"));
    }

    useEffect(()=>{
        getSelectData();
    },[]);

    return (
        <div>
            {
                sessionStorage.token==null?
                <div>
                    <h3 className='alert alert-danger'>먼저 로그인을 해주세요</h3>
                </div>
                :error==='403'?
                <div>
                    <h1>접근 권한이 없습니다</h1>
                </div>
                :
                <div>
                    <h3 className='alert alert-danger'>게시판 상세보기</h3>
                    {
                        selectData &&
                        <div>
                            <h2><b>{selectData.subject}</b></h2>
                            <span style={{color:'gray'}}>
                                작성자 : {selectData.username}
                            </span>
                            <span style={{color:'gray',marginLeft:'20px'}}>
                                {selectData.writeday}
                            </span>
                            <br/><br/>
                            <img alt='' src={PHOTO_URL+selectData.photo}
                            style={{maxWidth:'250px',border:'2px solid gray'}}/>
                            <br/><br/>
                            <pre style={{fontSize:'20px'}}>{selectData.content}</pre>
                        
                            <br/><br/>
                            <button type='button' className='btn btn-sm btn-outline-secondary'
                            style={{width:'100px'}}
                            onClick={()=>navi('/board/form')}>글쓰기</button>
                            &nbsp;
                            <button type='button' className='btn btn-sm btn-outline-secondary'
                            style={{width:'100px'}}
                            onClick={()=>navi('/board/list')}>글목록</button>
                            {
                                selectData.username===sessionStorage.username?
                                <>
                                    &nbsp;
                                    <button type='button' className='btn btn-sm btn-outline-secondary'
                                    style={{width:'100px'}}
                                    onClick={()=>navi(`/board/updateform/${num}`)}>글수정</button>
                                    &nbsp;
                                    <button type='button' className='btn btn-sm btn-outline-secondary'
                                    style={{width:'100px'}}
                                    >글삭제</button>
                                </>:<></>
                            }
                           
                           
                        </div>
                    }
                   
                </div>
            }
        </div>
    );
};

export default BoardDetail;