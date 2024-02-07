
//수량이 변경 될때마다 총 가격을 세팅
function setTotalPrice(inputTag, itemPrice){
    //단가

    //수량
    const cnt = inputTag.value;

    if(cnt == ''){
        inputTag.value = 1;
        cnt = 1;
    }

    const totalPrice = parseInt(itemPrice) * parseInt(cnt);

    document.querySelector('.total-price-span').textContent = '￦' + totalPrice.toLocaleString();
    
}

//장바구니 버튼 클릭 시 시행
function insertCart(loginInfo, itemCode){
    if(loginInfo == null){
        alert('로그인 하세요!');
        return ;
    }

    fetch('/cart/insertCart', { //요청경로
        method: 'POST',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        //컨트롤러로 전달할 데이터
        body: new URLSearchParams({
           // 데이터명 : 데이터값
           'itemCode' : itemCode,
           'cartCnt' : document.querySelector('input[type="number"]').value
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
        const result = confirm('장바구니에 상품을 담았습니다.\n장바구니 페이지로 이동할까요?');

        if(result){
            location.href = '/cart/list';
        }

    })
    //fetch 통신 실패 시 실행 영역
    .catch(err=>{
        alert('fetch error!\nthen 구문에서 오류가 발생했습니다.\n콘솔창을 확인하세요!');
        console.log(err);
    });
    

}

//바로 구매 버튼 클릭 시 실행
function insertBuy(){
    //총 가격 정보를 input value로 세팅
    const totalPriceStr = document.querySelector('.total-price-span').textContent;

    const regex = /[^0-9]/g;
    const totalPrice = totalPriceStr.replace(regex, '');

    document.querySelector('input[name="totalPrice"]').value = totalPrice;

    //submit
    document.querySelector('#insert-buy-form').submit();
}










