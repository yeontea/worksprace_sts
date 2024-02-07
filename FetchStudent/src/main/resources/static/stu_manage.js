function goSelect(){
           
    const tag1 = document.querySelector('#classSelecter').value;
    location.href=`/stu/first?classCode=${tag1}`;  
}
function insert(num){
    const result = confirm('입력한 정보로 점수를 등록할까요?')
    if(result){
    insertScore(num);
    }
    };

    function insertScore(num){
        const inputs = document.querySelectorAll('#gege');
        
    
        


        fetch('/stu/insertStu', { //요청경로
            method: 'POST',
            cache: 'no-cache',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
            },
            //컨트롤러로 전달할 데이터
            body: new URLSearchParams({
               // 데이터명 : 데이터값
               korScore : inputs[0].value,
               engScore : inputs[1].value,
               mathScore : inputs[2].value,
               stuNum : num
            })
        })
        .then((response) => {
            if(!response.ok){
                alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
                return ;
            }
        
            return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
            //return response.json(); //나머지 경우에 사용
        })
        //fetch 통신 후 실행 영역
        .then((data) => {//data -> controller에서 리턴되는 데이터!
           alert('점수 등록 완료')
            show(num);
        })
        //fetch 통신 실패 시 실행 영역
        .catch(err=>{
            alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
            console.log(err);
        });

    } 


function insertStu(stu){
    fetch('/stu/detail', { //요청경로
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        //컨트롤러로 전달할 데이터
        body: new URLSearchParams({
           // 데이터명 : 데이터값
           stuNum : stu
        })
    })
    .then((response) => {
        if(!response.ok){
            alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
            return ;
        }
    
        //return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
        return response.json(); //나머지 경우에 사용
    })
    //fetch 통신 후 실행 영역
    .then((data) => {//data -> controller에서 리턴되는 데이터!
        const div = document.querySelector('.stu-detail-div');
        div.innerHTML = ``;

        let str = `
        <div>
            <div><h3>학생 기본 정보</h3></div>
            <div><table id="stu_detail_table">
                <col width="33%">
                <col width="33%">
                <col width="33%">
                   <thead> 
                     <tr>
                         <td>학번</td>
                         <td>소속반</td>
                         <td>학생명</td>
                     </tr>
                   </thead>
                   <tbody>
                     <tr>
                         <td>${data.stuVO.stuNum}</td> 
                         <td>${data.stuVO.className}</td>
                         <td>${data.stuVO.stuName}</td>
                     </tr>
                   </tbody>
                </table>
             </div>
        </div>
        <div>
                <div><h3>학생 점수 정보</h3></div>
                <div><table id="stu_detail_table2">
                <thead>
                  <tr>
                    <td>국어점수</td>
                    <td>영어점수</td>
                    <td>수학점수</td>
                    <td>평균</td>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td><input id="gege" type="text" name="korScore"></td> 
                    <td><input id="gege" type="text" name="engScore"></td>
                    <td><input id="gege" type="text" name="mathScore"></td>
                    <td>${data.studentVO == null ? 0.0 : (data.studentVO.korScore+data.studentVO.engScore+data.studentVO.mathScore)/3.0}</td>
                  </tr>
                  </tbody>

                </table></div>
                <div class = "button-div"><input type="button" value="저장" onclick="insert(${data.stuVO.stuNum})"></div>
        </div> 
        
        `;
        div.insertAdjacentHTML('afterbegin',str);

    })
    //fetch 통신 실패 시 실행 영역
    .catch(err=>{
        alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
        console.log(err);
    });
    
}
function show(stu){
    alert(stu);
    console.log(stu);
    fetch('/stu/detail', { //요청경로
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        //컨트롤러로 전달할 데이터
        body: new URLSearchParams({
           // 데이터명 : 데이터값
           stuNum:stu
        })
    })
    .then((response) => {
        if(!response.ok){
            alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
            return ;
        }
    
        //return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
        return response.json(); //나머지 경우에 사용
    })
    //fetch 통신 후 실행 영역
    .then((data) => {//data -> controller에서 리턴되는 데이터!
        const div = document.querySelector('.stu-detail-div');
        div.innerHTML = ``;

        let str = `
        <div>
            <div><h3>학생 기본 정보</h3></div>
            <div><table id="stu_detail_table">
                <col width="33%">
                <col width="33%">
                <col width="33%">
                   <thead> 
                     <tr>
                         <td>학번</td>
                         <td>소속반</td>
                         <td>학생명</td>
                     </tr>
                   </thead>
                   <tbody> 
                     <tr>
                         <td>${data.stuVO.stuNum}</td>
                         <td>${data.stuVO.className}</td>
                         <td>${data.stuVO.stuName}</td>
                     </tr>
                   </tbody>
                </table>
             </div>
        </div>
        <div>
                <div><h3>학생 점수 정보</h3></div>
                <div><table id="stu_detail_table2">
                <thead>
                  <tr>
                    <td>국어점수</td>
                    <td>영어점수</td>
                    <td>수학점수</td>
                    <td>평균</td>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>${data.studentVO == null ? 0 : data.studentVO.korScore}</td> 
                    <td>${data.studentVO == null ? 0 : data.studentVO.engScore}</td>
                    <td>${data.studentVO == null ? 0 : data.studentVO.mathScore}</td>
                    <td>${data.studentVO == null ? 0.0 : (data.studentVO.korScore+data.studentVO.engScore+data.studentVO.mathScore)/3.0}</td>
                  </tr>
                  </tbody>

                </table></div>
                <div><input id="button-css" type="button" value="점수입력" onclick="insertStu(${data.stuVO.stuNum})"></div>
        </div>
        
        `;

        div.insertAdjacentHTML('afterbegin',str);
        

    })
    //fetch 통신 실패 시 실행 영역
    .catch(err=>{
        alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
        console.log(err);
    });

}

function fetchSelect(){
    const tag1 = document.querySelector('#classSelecter').value;
    fetch('/stu/fetchSelect', { //요청경로
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        //컨트롤러로 전달할 데이터
        body: new URLSearchParams({
           // 데이터명 : 데이터값
           classCode : tag1
          
            
        })
    })
    .then((response) => {
        if(!response.ok){
            alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
            return ;
            
        }
    
        //return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
        return response.json(); //나머지 경우에 사용
    })
    //fetch 통신 후 실행 영역
    .then((data) => {//data -> controller에서 리턴되는 데이터!
        console.log(data);
        // 기존 테이블 내용 삭제 
        const tbodyTag = document.querySelector('#stu-list-table>tbody');
        //tbody 태그 안의 모든 내용을 삭제 
        tbodyTag.innerHTML = '';
        //새로 조회한 데이터로 tbody 안의 내용을 채워줌
        let str = ``;
        
        
        data.forEach(function(stu,i){
           
                str += `
                <tr>
                   <td>${data.length-i}</td>
                   <td>${stu.className}</td>
                   <td>${stu.stuNum}</td>
                   <td><span id="name-span" onclick="show(${stu.stuNum})">${stu.stuName}</span></td>
                </tr>`;
    });
        tbodyTag.insertAdjacentHTML('afterbegin',str);
        

    })


    //fetch 통신 실패 시 실행 영역
    .catch(err=>{
        alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
        console.log(err);
    });
}