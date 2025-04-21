//초창기 컴포넌트는 모두 클래스 형태였다
//Hooks 문법이 리액트 v16.8에서 새로 도입되면서 일반 함수형태로 변경
//초기 함수형태는 상태저장을 하는 state 기능이 없었는데
//Hooks 문법이 추가된 이후부터 일반 함수에서도 상태유지를 위한 state 기능이 추가되었다
//클래스에서는 라이프 사이클이 엄청 복잡했었는데 Hooks 문법이후 라이프 사이클도 엄청 단순해졌다

import { Component } from "react";
import car11 from "../mycar11.png";

//리턴 안에있는 구문들은 html 태그가 아니라 JSX 태그이다
//html 과 jsx 의 차이점
//1. 모든 요소는 짝이 맞아야 한다(예:br,img 등등도 짝이 맞아야 한다)
//2. 특성 이름이 html 언어 사양이 아닌 dom api 에 기반을 둔다

//첫예제는 클래스로 만들어보자

class OneApp extends Component
{
    constructor(props){
        super(props);
        //생성자는 클래스명과 상관없이 무조건 constructor
    }
    render(){
        return (
            // 부모태그는 무조건 한개만 가능하다
            //태그안에서 직접 스타일을 추가하는 방법
            <div style={{backgroundColor:'orange',width:'200px',height:'200px'}}>
                <h2 style={{color:'blue',backgroundColor:'yellow'}}>OneApp 컴포넌트</h2>
                <br/>
                {/* <br/> 단독태그인경우 /> 로 닫는다 */}
                {/* public 의 이미지 나타내는방법-경로로 가능-권장안함-
                나중에 라우터에서 문제가 생길수도 있음 */}
                <img alt="" src="mycar13.png" style={{width:'100px'}}/> 

                {/*src의 이미지는 import 후 가져오거나 require 명령어를 이용한다   */}
                <img alt="" src={car11} style={{width:'100px'}}/>
            
            </div>
        )
    }
}

export {OneApp} //여러번 사용 가능,import 할때 {OneApp} 으로만 import 가 가능
//export default OneApp; //default 는 단 한번만 사용이 가능,이 경우는 import 시에 내 마음대로 이름을 정해도 된다
