import React, { useCallback, useState } from 'react';
import SevenLight from './SevenLight';

const SevenSmartHome = () => {
    const [masterOn,setMasterOn]=useState(false);
    const [kitchenOn,setKitchenOn]=useState(false);
    const [bathOn,setBathOn]=useState(false);

    //이렇게 호출하면 버튼 한개만 눌러도 3개의 서브 컴포넌트가 모두 호출
    // const toggleMaster=()=>setMasterOn(!masterOn);
    // const toggleKitchen=()=>setKitchenOn(!kitchenOn);
    // const toggleBath=()=>setBathOn(!bathOn);

    //useCallback 을 이용해서 최적화시켜보자
    const toggleMaster=useCallback(()=>{
        setMasterOn(!masterOn);
    },[masterOn]);

    const toggleKitchen=useCallback(()=>{
        setKitchenOn(!kitchenOn);
    },[kitchenOn]);

    const toggleBath=useCallback(()=>{
        setBathOn(!bathOn);
    },[bathOn]);
    
    return (
        <div>
            <SevenLight room={'침실'} on={masterOn} toggle={toggleMaster}/>
            <SevenLight room={'주방'} on={kitchenOn} toggle={toggleKitchen}/>
            <SevenLight room={'욕실'} on={bathOn} toggle={toggleBath}/>
        </div>
    );
};

export default SevenSmartHome;