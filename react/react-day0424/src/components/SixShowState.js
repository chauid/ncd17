import React, { useMemo } from 'react';

const getNumber=(number)=>{
    console.log("숫자가 변동되었습니다");
    return number;
}

const getText=(text)=>{
    console.log("글자가 변동되었습니다");
    return text;
}
const SixShowState = ({number,text}) => {
    //숫자가 바껴도 모든 함수가 호출되고
    //글자가 변경되도 모든 함수가 호출된다
    //이부분을 숫자가 바뀌면 숫자관련 함수만 호출되고
    //문자가 바뀌면 문자관련 함수만 호출되도록 변경해보자
    // const showNumber=getNumber(number);
    // const showText=getText(text);

    const showNumber=useMemo(()=>getNumber(number),[number]);
    const showText=useMemo(()=>getText(text),[text]);

    return (
        <div style={{fontSize:'2px',margin:'20px'}}>
            {showNumber}
            <br/><br/>
            {showText}
        </div>
    );
};

export default SixShowState;