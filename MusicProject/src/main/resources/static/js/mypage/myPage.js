const updateProfile = document.querySelector("#updateProfile");

if(updateProfile != null){

  updateProfile.addEventListener("submit", e => {
    
    const memberNickname = document.querySelector("#memberNickname");
    const memberTel = document.querySelector("#memberTel");
    const memberAddress = document.querySelectorAll("[name='memberAddress']");


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
      return;
    } 

    let flag = true;

    if(loginMemberProfileImg == null && statusCheck == 1) flag = false;
    if(loginMemberProfileImg != null && statusCheck == 0) flag = false;
    if(loginMemberProfileImg != null && statusCheck == 1) flag = false;

    if(flag){ 
      e.preventDefault();
      alert("이미지 변경 후 클릭하세요");
    }
    e.preventDefault();
  });

  const profileImage = document.querySelector("#profileImage");
  const imageInput = document.querySelector("#imageInput");
  const deleteImage = document.querySelector("#deleteImage");

  let statusCheck = -1;
  let backupInput;


  const changeImageFn = e => {

    const maxSize =  1024 * 1024 * 5;
    const file = e.target.files[0];

    if(file == undefined){
      console.log("파일 선택 후 취소됨");
      const temp = backupInput.cloneNode(true);

      
      imageInput.after(backupInput);
      imageInput.remove();
      imageInput = backupInput;

      imageInput.addEventListener("change", changeImageFn);

      backupInput = temp;

      return;
    }

    if(file.size > maxSize){
      alert("5MB 이하의 이미지 파일을 선택해 주세요");

      if(statusCheck == -1){
        imageInput.value = '';
      }else{ 

        const temp = backupInput.cloneNode(true);

        imageInput.after(backupInput);
        imageInput.remove();
        imageInput = backupInput;
        imageInput.addEventListener("change", changeImageFn);

        backupInput = temp;
      }
      
      return;
    }

    const reader = new FileReader();
    reader.readAsDataURL(file); 

    reader.addEventListener("load", e => {
      
      let url = e.target.result;
      profileImage.setAttribute("src", url);
      statusCheck = 1;

      backupInput = imageInput.cloneNode(true);
    });

  }
  imageInput.addEventListener("change", changeImageFn);

  deleteImage.addEventListener("click", () => {

    profileImage.src = "/images/user.png";
    imageInput.value = '';

    backupInput = undefined;

    statusCheck = 0; 

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
      str = "현재 비밀번호를 입력해주세요.";
    }else if(newPw.value.trim().length == 0){
      str = "새 비밀번호를 입력해주세요.";
    }else if(newPwConfirm.value.trim().length == 0){
      str = "새 비밀번호 확인을 입력 해주세요.";
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

    if(memberPw.value.trim().length == 0){
      alert("비밀번호를 입력해 주세요");
      e.preventDefault();
      return;
    }

    if(!agree.checked){ // 체크 안됐을때
      alert("약관에 동의해주세요.");
      e.preventDefault();
      return;
    }
    if( !confirm("정말 탈퇴 하시겠습니까?")){ // 취소 선택시
      alert("취소 되었습니다.");
      e.preventDefault();
      return;
    }

  });
}


const myBoard = document.querySelector("#myBoard");
const myComment = document.querySelector("#myComment");
const writeList = document.querySelector("#writeList");
const listMain = document.querySelector("#listMain");

myBoard.addEventListener("click", () => {

  const obj = { "memberNo" : loginMemberNo };

  fetch("/myPage/selectBoard", {
    method : "POST",
    headers : {"Content-Type" : "application/json"},
    body : JSON.stringify(obj)
  })
  .then( response => response.json())
  .then( list => {
    console.log(list);

    if(list != null){

      for(let board of list){
        const tr = document.createElement("tr");
        const arr = ['boardNo', 'boardTitle', 'readCount', 'boardWriteDate'];
  
        for(let key of arr){
          const td = document.createElement("td");
          td.innerText = board[key];
          tr.append(td);
        }
        writeList.append(tr);
      }
    } else{
      const h3 = document.createElement("h3")
      h3.innerText = "작성한 글이 존재하지 않습니다.";
      listMain.append(h3);
    }


  });
})




