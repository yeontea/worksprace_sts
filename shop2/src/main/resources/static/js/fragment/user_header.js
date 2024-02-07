 //serach 버튼 클릭 시 주소록 검색 팝업 창 띄우기 
 function searchAddress(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            document.querySelector('#postCode').value= data.zonecode;
            document.querySelector('#address').value = data.roadAddress;
            document.querySelector('#address2').value= data.jibunAddress;
        }
    }).open();
  }

  function join(){

    const idInput = document.querySelector('#memberId');
    if(idInput.value == ''){
      alert('id는 필수입력 사항입니다.');
      return;

    }
    if(idInput.value.length > 20){
      alert('id는 20글자 내로 작성하세요.')
      return;

    }

    const pwInputs = document.querySelectorAll('input[type="password"]');
    
    if(pwInputs[0].value != pwInputs[1].value){
      alert('비밀번호가 일치하지 않습니다.\n 비밀번호를 다시 입력해주세요.');
      return;

    }
    // 문자+숫자+특수 문자가 포함된 4~12자리의 글자
    const regExp = /^.*(?=^.{4,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
    // test 함수의 매개변수로 들어온 문자가 정규식 조건에 부합하면 return true
    const espResult = regExp.test(pwInputs[0].value);
    if(!espResult){
      alert('비밀번호 형식에 일치하지 않습니다');
      return;
    }

    const ck = document.querySelector('#check');
     
    // if(ck.value == on){
    //   alert('개인정보 이용약관에 동의해주세요.')
    //   return;
    // }



    document.querySelector('#join-form').submit();
  }

  // 클릭 시 로그인 페이지로 이동
  function goLoginForm(){
    location.href = '/member/loginForm'; 
  }

  // 회원가입 모델창이 닫힐 때 실행되는 이벤트
  // 1. 모델창을 선택한다.
  const joinModal = document.querySelector('#exampleModal');
  // 2.선택한 태그에 이벤트 달아주기
  // hidden.bs.modal : 모델창이 닫힐 때 실행
  joinModal.addEventListener('hidden.bs.modal', function(event){
    document.querySelector('#join-form').reset();
  });

function logout(){
  const result = confirm('로그아웃 하시겠습니까?');

  if(result){
    location.href='/member/logout';

  }

}
  

  


