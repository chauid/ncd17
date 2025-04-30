import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const BoardList = () => {
    const [boardList,setBoardList]=useState([]);    
    const navi=useNavigate();

    //전체 데이타 가져오기
    const getAllDatas=()=>{
        axios.get("/board/list")
        .then(res=>{
            setBoardList(res.data);
        });
    }

    useEffect(()=>{
        getAllDatas();
    },[]);

    return (
        <div>
            <h3 className='alert alert-danger'>회원게시판
            {
                // 로그인을 하면 글쓰기 버튼이 보인다
                sessionStorage.token==null?"":
                <button type='button' className='btn btn-sm btn-success'
                style={{float:'right'}}
                onClick={()=>navi("/board/form")}>글쓰기</button>
            }
            </h3>
            <table className='table table-bordered'>
                <caption align="top"><b>
                    총 {boardList.length}개의 글이 있습니다</b></caption>
                <thead>
                    <tr  className='table-info'>
                        <th width="50">번호</th>
                        <th width="200">제목</th>
                        <th width="70">작성자</th>
                        <th width="120">작성일</th>
                        <th>조회</th>
                    </tr>
                </thead>
                <tbody>
                {
                    boardList &&
                    boardList.map((row,idx)=>
                        <tr key={idx} onClick={()=>{
                            if(sessionStorage.token==null){
                                alert("멤버만 확인가능한 페이지입니다");
                            }else{
                                navi(`/board/detail/${row.num}`);
                            }
                        }}>
                            <td align='center'>{boardList.length-idx}</td>
                            <td>
                                {row.subject}
                            </td>
                            <td align='center'>{row.username}</td>
                            <td align='center'>{row.writeday.substring(0,10)}</td>
                            <td align='center'>{row.readcount}</td>
                        </tr>)
                }
                </tbody>
            </table>
        </div>
    );
};

export default BoardList;