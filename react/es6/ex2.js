//함수 파라미터 기본값
let f1=(x,y=100,z=200)=>{
    console.log("x="+x);
    console.log("y="+y);
    console.log("z="+z);   
    console.log("------------") 
}

//호출
f1(5);
f1(5,20);
f1(10,20,30);
f1();