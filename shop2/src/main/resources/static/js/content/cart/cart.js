const chkMain = document.querySelector("#checkAll");

function gogo(a,tag) {
        // ------------------- 첫번째 방식 ---------------//
    fetch('/cart/updateCartCnt', { //요청경로
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        //컨트롤러로 전달할 데이터
        body: new URLSearchParams({
        // 데이터명 : 데이터값
        cartCode : a,
        cartCnt : tag.parentElement.previousElementSibling.querySelector('input').value
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
        const tags = document.querySelectorAll("#su");
        const filds = document.querySelectorAll('#fild');
        const prices = document.querySelectorAll('#price');
        for (let i = 0; i < tags.length; i++) {
            filds[i].innerHTML = `${parseInt(tags[i].value) * parseInt(prices[i].textContent)}`;
        }


        
    })
    //fetch 통신 실패 시 실행 영역
    .catch(err=>{
        alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
        console.log(err);
    });
}
    



chkMain.addEventListener('click', function () {
    const chks = document.querySelectorAll('.chk');
    if (chkMain.checked) {

        for (let i = 0; i < chks.length; i++) {

            chks[i].checked = true;

        }

    }
    else {
        for (let i = 0; i < chks.length; i++) {

            chks[i].checked = false;

        }
    }
    

       
            
            const filds = document.querySelectorAll('#fild');
            const totalPrice = document.querySelector('.totalPrice');
            let sum = 0;
            for (let i = 0; i < chks.length; i++) {
    
            if (chks[i].checked) {
                sum = sum + parseInt(filds[i].textContent);
    
            }
        }
        totalPrice.textContent = sum.toLocaleString();    
        
    
    
   


});

const chks = document.querySelectorAll('.chk');
for (let i = 0; i < chks.length; i++) {

    chks[i].addEventListener('change', function () {
        
        const filds = document.querySelectorAll('#fild');
        const totalPrice = document.querySelector('.totalPrice');
        let sum = 0;
        for (let i = 0; i < chks.length; i++) {

        if (chks[i].checked) {
            sum = sum + parseInt(filds[i].textContent);

        }
    }
        totalPrice.textContent = sum.toLocaleString();
    })


}

function goDelete(c){
    if(confirm('선택한 상품을 장바구니에서 삭제할까요?')){
        location.href=`/cart/delete?cartCode=${c}`

    }
}



