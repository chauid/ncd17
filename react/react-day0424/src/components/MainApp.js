import { Alert, FormControl, InputLabel, MenuItem, Select } from '@mui/material';
import React, { useState } from 'react';
import OneApp from './OneApp';
import TwoApp from './TwoApp';
import ThreeApp from './ThreeApp';
import FourApp from './FourApp';
import FiveApp from './FiveApp';
import SixApp from './SixApp';
import SevenApp from './SevenApp';
import EightApp from './EightApp';

const MainApp = () => {
    const [idx,setIdx]=useState(4);

    return (
        <div>
            <Alert severity='info' style={{fontSize:'25px'}}>2025-4-24 리액트 수업</Alert>
            <hr/>
            {/* <div style={{width:'300px'}} className='input-group'>
                <h5>App 선택 </h5>
                <select className='form-select' style={{margin:'10px'}}
                onChange={(e)=>setIdx(Number(e.target.value))}>
                    <option value={1} selected>OneApp</option>
                    <option value={2} >TwoApp</option>
                    <option value={3} >ThreeApp</option>
                    <option value={4} >FourApp</option>
                    <option value={5} >FiveApp</option>
                    <option value={6} >SixApp</option>
                    <option value={7} >SevenApp</option>
                    <option value={8} >EightApp</option>                    
                </select>
            </div> */}
            <FormControl fullWidth>
                <InputLabel>App</InputLabel>
                <Select style={{width:'300px'}}               
                value={idx}
                label="Age"
                onChange={(e)=>setIdx(e.target.value)}
                >
                    <MenuItem value={1}>OneApp</MenuItem>
                    <MenuItem value={2}>TwoApp</MenuItem>
                    <MenuItem value={3}>ThreeApp</MenuItem>
                    <MenuItem value={4}>FourApp</MenuItem>
                    <MenuItem value={5}>FiveApp</MenuItem>
                    <MenuItem value={6}>SixApp</MenuItem>
                    <MenuItem value={7}>SevenApp</MenuItem>
                    <MenuItem value={8}>EightApp</MenuItem>                    
                </Select>
            </FormControl>
            {
                idx===1?<OneApp/>:idx===2?<TwoApp/>:idx===3?<ThreeApp/>
                :idx===4?<FourApp/>:idx===5?<FiveApp/>:idx===6?<SixApp/>
                :idx===7?<SevenApp/>:<EightApp/>
            }
        </div>
    );
};

export default MainApp;