//es6 라이브러리 Number
let a=12;
let b=23.0;
let c=12.6;

console.log(a+" 는 정수인가?"+Number.isInteger(a));
console.log(b+" 는 정수인가?"+Number.isInteger(b));
console.log(c+" 는 정수인가?"+Number.isInteger(c));

//NaN
console.log(12/'a'); //NaN :수식이 잘못되었을때 NaN 이 출력
let a1="NaN";
let b1=NaN;
let c1="안녕";
let d1=12;

console.log("es5 의 isNaN -숫자일경우 false,아닐경우 true");
console.log("a1="+isNaN(a1));//true
console.log("b1="+isNaN(b1));//true
console.log("c1="+isNaN(c1));//true
console.log("d1="+isNaN(d1));//false

console.log("es6 의 Number.isNaN 은 정말 NaN인경우만 true");
console.log("a1="+Number.isNaN(a1));//false
console.log("b1="+Number.isNaN(b1));//true
console.log("c1="+Number.isNaN(c1));//false
console.log("d1="+Number.isNaN(d1));//false


