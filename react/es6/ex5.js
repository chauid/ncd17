let obj1={"name":"lee","age":23,"addr":"seoul"};
console.log(obj1.name);
console.log(obj1.age);
console.log(obj1.addr);

//오브젝트 통으로 대입
let obj2=obj1;

//오브젝트에서 여러개의 변수값 한번에 얻기
let {name,age}=obj2;
console.log("name="+name);
console.log("age="+age);

//함수
let f1=({name='수지',age=20}={})=>console.log("이름"+name+",age="+age);

//호출
f1();//수지, 20
f1(obj2.name);//수지,20
f1(obj1);//lee,23


