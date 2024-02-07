
// 자바 스크립트의 객체 (다수의 데이터를 저장하는 변수)
const stu = {
    'name' : '홍길동',
    'age' : 20
};

console.log(stu);
console.log(`name = ${stu.name}`);
console.log(`age = ${stu.age}`);

const arr = [];
arr[0] = 20;
arr[1] = 30;
arr[2] = 'java';

const arr1 = [20, 30, 'java'];
arr1.push(50); // 배열 크기 다음 요소에 추가.
arr1.push('홍');

// 객체 배열
const arr2 = [
    {
        'name' : '홍',
        'age' : 20
    },
    {
        'name' : '김',
        'age' : 30

    },
    {
        'name' : '이',
        'age' : 40

    }
];

console.log(arr2);
console.log(arr2[1].name);







function addRow(){
    const fild = document.querySelector('.stu-list').querySelector('tbody');

    let stu ='';
    
    stu += '<tr>';
    stu += '<td><input type="text" class="stu"></td>';
    stu += '<td><input type="text" class="score"></td>';
    stu += '</tr>';

    fild.insertAdjacentHTML("afterbegin",stu);
}

function setData(){
    const scores = document.querySelectorAll('.score');
    const stus = document.querySelectorAll('.stu');
    const first = document.querySelector('#firstName');
    const bo = document.querySelector('#names');
    const total = document.querySelector('#totalScore');
    const trs = document.querySelectorAll('.stu-list > tbody > tr');


    let sum = 0;
    for(const score of scores){
        sum = sum + parseInt(score.value);

    }
    total.value = sum;

// ---------------------------------------------------------
    let s = 0;
    for(let i = 0; i < stus.length; i++){

        if(s<parseInt(scores[i].value)){

            s = parseInt(scores[i].value);


            first.value = stus[i].value;

        }
    }
    // ------------------------------------------------------
    //  const stuList = [];
    // for(const trtag of trs){
    //     const student = {
    //         'name' : trtag.querySelector('input')[0].value,
    //         'score' : parseInt(trtag.querySelector('input')[1].value)
    //     };


    //     stuList.push(student);
    // }

    // const maxStu = stuList[0];

    // for(const stu of stuList){
    //     if(maxStu.score < stu.score){
    //         maxStu = stu;

    //     }

    // }
    // first.value = maxStu.name;


    let final = '';
    for(let i = 0; i < stus.length; i++){
        if(parseInt(scores[i].value)<60){

            final += stus[i].value;
            final +=' ';

        }
        
    }
    bo.value = final;
    
    
    

}