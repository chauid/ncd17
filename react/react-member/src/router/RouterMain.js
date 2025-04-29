import React from 'react';
import Menu from '../components/Menu';
import { Route, Routes } from 'react-router-dom';
import errorimg from '../image/error.png';
import { JoinForm, LoginForm, MemberList } from '../member';
import { Home } from '../components';
import { BoardList } from '../board';

const RouterMain = () => {
    return (
        <div>
           <Menu/>
           <br style={{clear:'both'}}/><br/>
           <div style={{margin:'10px 30px',width:'500px'}}>
                <Routes>
                    <Route path='/' element={<Home/>}/>

                    <Route path='/member'>
                        <Route path='list' element={<MemberList/>}/>
                        <Route path='join' element={<JoinForm/>}/>
                        <Route path='login' element={<LoginForm/>}/>
                    </Route>  

                    <Route path='/board'>
                        <Route path='list' element={<BoardList/>}/>
                    </Route>            

                    {/* 그 이외의 모든 매핑주소일경우 호출 */}
                    <Route path='*' element={
                        <div>
                            <h1>잘못된 URL 입니다</h1>
                            <img alt='' src={errorimg}/>
                        </div>
                    }/>
                    
                </Routes>
            </div>
        </div>
    );
};

export default RouterMain;