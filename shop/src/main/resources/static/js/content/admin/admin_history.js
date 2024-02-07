
const buy_detail_modal = new bootstrap.Modal('#buy-detail-modal');

function goModal(code){
    const buyCode = parseInt(code.children[1].textContent);
    
    // ------------------- 첫번째 방식 ---------------//
fetch('/admin/selectModal', { //요청경로
    method: 'POST',
    cache: 'no-cache',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
    },
    //컨트롤러로 전달할 데이터
    body: new URLSearchParams({
       // 데이터명 : 데이터값
       buyCode : buyCode
    })
})
.then((response) => {
    if(!response.ok){
        alert('fetch error!\n컨트롤러로 통신중에 오류가 발생했습니다.');
        return ;
    }

    // return response.text(); //컨트롤러에서 return하는 데이터가 없거나 int, String 일 때 사용
    return response.json(); //나머지 경우에 사용
})
//fetch 통신 후 실행 영역
.then((data) => {//data -> controller에서 리턴되는 데이터!
    const fild = document.querySelector('#fild-1');
    fild.innerHTML = '';
    let text = '';
    text += `<tr>`
    text += `<td>구매번호</td>`
    text += `<td>${data.buyCode}</td>`
    text += '<td>구매자ID</td>'
    text += `<td>${data.memberId}</td>`
    text += '</tr>'
    text += '<tr>'
    text += '<td>구매금액</td>'
    text += `<td>${data.buyPrice}</td>`
    text += '<td>구매일시</td>'
    text += `<td>${data.buyDate}</td>`
    text += '</tr>'
    
    fild.insertAdjacentHTML('afterbegin',text);
    


    buy_detail_modal.show();

})
//fetch 통신 실패 시 실행 영역
.catch(err=>{
    alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
    console.log(err);
});

}