//배열의 펼침 연산자 ...
let arr=[3,5,7];

let f1=(a,b)=>console.log(a,b);

//기존방법
function f2(a,b){
    console.log(a,b);
}

//호출
f1(arr[0],arr[1]);
f1(...arr);//펼침연산자를 이용해서 보내면 배열의 앞 두숫자가 전달된다

let arr1=[1,2];
let arr2=[11,33,55,66];
let arr3=[10,...arr1,8,...arr2];
console.log(arr3.length);
console.log(arr3);

