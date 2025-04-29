import React from 'react';
import mainimg from '../image/mainimage.png';

const Home = () => {
    return (
        <div>
            <h3 className='alert alert-danger'>홈페이지 방문을 환영합니다</h3>
            <img alt='' src={mainimg} style={{border:'10px solid gold',width:'100%'}}
            />
        </div>
    );
};

export default Home;