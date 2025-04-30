import axios from 'axios';
import React, { useRef, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const BoardForm = () => {
    const [file,setFile]=useState('');
    const [preview,setPreview]=useState('');
    const [subject,setSubject]=useState('');
    const contentRef=useRef('');
    const navi=useNavigate();

    const onSaveSubmit=(e)=>{
        e.preventDefault();

        const uploadData=new FormData();
        uploadData.append("upload",file);
        uploadData.append("subject",subject);
        uploadData.append("content",contentRef.current.value);

        axios({
            method:'post',
            url:'/auth/board/insert',
            data:uploadData,
            headers:{'Content-Type':'multipart/form-data',Authorization:`Bearer ${sessionStorage.token}`}
        }).then(res=>{
            alert("추가되었습니다");
            navi("/board/list");
        })
        
    }

    //파일 선택시 미리보기 이미지 나타내기
    const onFileChange=(e)=>{
        const file=e.target.files[0];
        const fileReader=new FileReader();
        if(file)
            fileReader.readAsDataURL(file);

        fileReader.onload=()=>{
            setPreview(fileReader.result);
        }
    }

    return (
        <div>
            <h3 className='alert alert-danger'>회원 글쓰기</h3>
            <form onSubmit={onSaveSubmit}>
                <table className='table table-bordered'>
                    <tr>
                        <th width="100">사진</th>
                        <td width="200">
                            <input type='file' required
                                style={{width:'200px'}}
                                onChange={(e)=>{
                                setFile(e.target.files[0]);
                                onFileChange(e);
                            }}/>
                        </td>
                        <td rowSpan={3}>
                            <img alt='' src={preview}
                              style={{width:'150px'}}/>
                        </td>
                    </tr>
                    <tr>
                        <th width="100">제목</th>
                        <td width="200">
                            <input type='text' className='form-control'
                            required onChange={(e)=>setSubject(e.target.value)}/>
                        </td>
                    </tr>
                    <tr style={{height:'120px'}}>
                        <td colSpan={2}>
                            <textarea style={{width:'100%',height:'120px'}} ref={contentRef}></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3} align='center'>
                            <button type='submit'
                            className='btn btn-info'>글저장</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    );
};

export default BoardForm;