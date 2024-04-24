const updateProfile = document.querySelector("#updateProfile");

if(updateProfile != null){

  updateProfile.addEventListener("submit", e => {
    
    const memberNickname = document.querySelector("#memberNickname");
    const memberTel = document.querySelector("#memberTel");
    const memberAddress = document.querySelectorAll("[name='memberAddress']");
    const profileImage = document.querySelector("#profileImage");
    const imageInput = document.querySelector("#imageInput");
    const deleteImage = document.querySelector("#deleteImage");


    if(memberNickname.value.trim().length == 0){
      alert("닉네임을 입력해주세요.");
      e.preventDefault();
      memberNickname.focus();
      return;
    }

    if(memberTel.value.trim().length == 0){
      alert("전화번호를 입력해주세요.");
      e.preventDefault();
      memberTel.focus();
      return;
    }

    const add0 = memberAddress[0].value.trim().length == 0;
    const add1 = memberAddress[1].value.trim().length == 0;
    const add2 = memberAddress[2].value.trim().length == 0;

    const result1 = add0 && add1 && add2;
    const result2 = !(add0||add1||add2);

    if( !(result1 || result2) ){
      alert("주소를 모두 작성 또는 미작성 해주세요.")
      e.preventDefault();
      add0.focus();
    } 
  
  });

}

/* **********************비밀번호 변경*********************** */
const changePw = document.querySelector("#changePw");

if(changePw != null){
  
  // 제출 되었을 때
  changePw.addEventListener("submit", e => {
    
    const currentPw = document.querySelector("#currentPw");
    const newPw = document.querySelector("#newPw");
    const newPwConfirm = document.querySelector("#newPwConfirm");

    // 값을 대입 했는가?

    let str; // undefined 상태

    if( currentPw.value.trim().length == 0){
      str = "현재 비밀번호를 입력해주세요";
    }else if(newPw.value.trim().length == 0){
      str = "새 비밀번호를 입력해주세요";
    }else if(newPwConfirm.value.trim().length == 0){
      str = "새 비밀번호 확인을 입력 해주세요";
    }

    if(str != undefined){ // str에 값이 대입됨 == if문 중 하나 실행됨
      alert(str);
      e.preventDefault();
      return;
    }

    // 새 비밀번호 정규식 검사
    const regExp = /^[a-zA-Z0-9!@#_-]{6,20}$/;

    if( !regExp.test(newPw.value)) { // 새 비밀번호 정규식 통과 X
      alert("새 비밀번호가 유효하지 않습니다");
      e.preventDefault();
      return;
    }

    // 새 비밀번호 == 새 비밀번호 확인
    if(newPw.value != newPwConfirm.value){
      alert("새 비밀번호가 일치하지 않습니다.");
      e.preventDefault();
      return;
    }
  });
}


/* ********************** 회원 탈퇴 *********************** */
const secession = document.querySelector("#secession");

if(secession != null){

  secession.addEventListener("submit", e => {

    const memberPw = document.querySelector("#memberPw");
    const agree = document.querySelector("#agree");

    // 비밀번호 입력 되었는지 확인
    if(memberPw.value.trim().length == 0){
      alert("비밀번호를 입력해 주세요");
      e.preventDefault();
      return;
    }

    // 약관 동의 체크 확인

    // checkbox 또는 radio   checked 속성
    // checked -> 체크 시 true, 미체크시 false 반환
    // - checked = true -> 체크하기
    // - checked = false -> 체크 해제 하기

    if(!agree.checked){ // 체크 안됐을때
      alert("약관에 동의해주세요.");
      e.preventDefault();
      return;
    }
    // 정말 탈퇴? 물어보기
    if( !confirm("정말 탈퇴 하시겠습니까?")){ // 취소 선택시
      alert("취소 되었습니다.");
      e.preventDefault();
      return;
    }

  });
}
