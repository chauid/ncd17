import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';

const Food = () => {
    const {food1,food2}=useParams();
    console.log(food1,food2);

    return (
        <div>
            <Alert severity='success'
             style={{fontSize:'20px'}}>Food 컴포넌트</Alert> 
             {
                food1==null && food2==null?
                  <div>
                    <h3>저는 다이어트를 하겠습니다</h3>
                    <img alt='' src={require(`../image/1.jpg`)} style={{width:'100px'}}/>
                  </div>
                :
                food1!=null && food2==null?
                <div>
                    <h3>나의 점심 메뉴</h3>
                    <img alt='' src={require(`../image/${food1}.jpg`)} style={{width:'150px'}}/>
                    <h3>오늘은 후식이 없습니다</h3>
                </div> 
                :
                <div>
                    <h3>나의 점심 메뉴</h3>
                    <img alt='' src={require(`../image/${food1}.jpg`)} style={{width:'150px'}}/>
                    <h3>오늘의 후식</h3>
                    <img alt='' src={require(`../image/${food2}.jpg`)} style={{width:'150px'}}/>
                </div> 
             }
        </div>
    );
};

export default Food;