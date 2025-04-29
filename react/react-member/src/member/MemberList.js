import axios from 'axios';
import React, { useEffect, useState } from 'react';

const MemberList = () => {
    const [memberList,setMemberList]=useState([]);
    const [errorMsg,setErrorMsg]=useState(null);

    // const getMemberData=()=>{
    //     axios.get("/auth/member/list")
    //     .then(res=>{
    //         setMemberList(res.data);
    //     });
    // }

    const getMemberData=()=>{
        axios({
            method:'get',
            url:'/auth/member/list',
            headers:{Authorization:`Bearer ${sessionStorage.token}`}
        }).then(res=>{
            setMemberList(res.data);
        }).catch(error=>{
            //alert(error); 
            setErrorMsg("403");
        });
    }

    useEffect(()=>{
        getMemberData();
    },[]);
    
    //삭제 이벤트
    const deleteMember=(id)=>{
        let a=window.confirm("해당 멤버를 삭제할까요?");
        if(!a) return;

        axios.delete("/member/delete?id="+id)
        .then(res=>{
            getMemberData();
        });
    }

    return (        
        <div>
        {
            sessionStorage.token==null?
                <div>
                    <h1>먼저 로그인을 해주세요</h1>
                </div>
            :
            errorMsg==='403'?
            <div>
                <h1>관리자만 볼수 있는 페이지입니다</h1>
            </div>
            :
            <div>           
             <h3 className='alert alert-danger'>전체 회원 명단</h3>
             <table className='table table-bordered'>
                <thead>
                    <tr className='table-warning'>
                        <th width="50">번호</th>
                        <th width="100">아이디</th>
                        <th width="80">권한</th>                        
                        <th width="100">가입일</th>
                        <th width="50">번호</th>                        
                    </tr>
                </thead>
                <tbody>
                {
                    memberList &&
                    memberList.map((row,idx)=>
                    <>
                        <tr>
                            <td align="center" rowSpan={2}>{idx+1}</td>
                            <td>{row.username}</td>
                            <td align="center">{row.role==='ROLE_ADMIN'?"관리자":"일반멤버"}</td>
                            <td align="center">{row.gaipday}</td>
                            <td align="center">
                                <button type='button' 
                                className='btn btn-sm btn-outline-danger'
                                onClick={()=>deleteMember(row.id)}>삭제</button>
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={4} style={{backgroundColor:'#ffc'}}>
                                [주소]{row.address}</td>
                        </tr>
                    </>)
                }
                </tbody>
             </table>            
        </div>
        }    
        </div>
    );
};

export default MemberList;