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

  deleteImage.addEventListener("click", () => {
    profileImage.src="/images/user.png";
    imageInput.value = "";
  });













}
