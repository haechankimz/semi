/* banner swipe */
var swiper = new Swiper(".swiper-container", {
    slidesPerView: 1,
    direction: 'horizontal',
    autoplay: {
        delay: 2000,
    },
    loop: true,
    spaceBetween: 30,
    centeredSlides: true,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
});

document.addEventListener("DOMContentLoaded", function() {
    document.body.style.overflow="hidden";
});

const popupClose = document.querySelector("#popupClose");
const popupLayer = document.querySelector("#popupLayer");
const loginForm = document.querySelector("#loginForm");
const background = document.querySelector("#modalBackground");

if(loginForm != null) {
    popupClose.addEventListener("click", () => {
        popupLayer.classList.add("popup-hidden");
    });
}

const loginIcon = document.querySelector("#loginIcon")
if(loginIcon != null) {
    loginIcon.addEventListener("click", ()=>{
        popupLayer.classList.remove("popup-hidden");
    });
}

/* 로그인 */
const getCookie = key => {
    const cookie = document.cookie;

    const cookieList = cookie.split(";").map( temp => temp.split("="));

    const obj = {};

    for(let i = 0; i < cookieList.length; i++){
        const k = cookieList[i][0];
        const v = cookieList[i][1];
        obj[k]=v;
    }

    return obj[key];
}

const loginEmail = document.querySelector("#loginForm input[name='memberEmail']");

if(loginEmail != null){
    const saveId = getCookie("saveId");

    if(saveId != undefined) {
        loginEmail.value=saveId;
        document.querySelector("input[name='saveId']").checked=true;
    }
}

/* 이메일, 비밀번호 미작성 시 로그인 막기 */
const loginPw = document.querySelector("#loginForm input[name='memberPw']");

// 로그인 상태 아닐때
if (loginForm != null) {

    // 제출 이벤트 발생 시
    loginForm.addEventListener("submit", e => {

        // 이메일 미작성
        if(loginEmail.value.trim().length === 0) {
            alert("이메일을 작성해 주세요!");
            e.preventDefault(); 
            loginEmail.focus(); 
            return;
        }

        // 비밀번호 미작성
        if (loginPw.value.trim().length === 0) {
            alert("비밀번호를 작성 해주세요!");
            e.preventDefault(); 
            loginPw.focus(); 
            return;
        }

    });
}


//  빠른 로그인
const quickLoginBtn = document.querySelector(".quick-login");

// quickLoginBtns 요소를 하나씩 꺼내서 이벤트 리스너 추가
quickLoginBtn.addEventListener("click", () => {
    const email = quickLoginBtn.innerText; // 버튼에 작성된 이메일 얻어오기
    location.href = "/member/quickLogin?memberEmail=" + email;

});



// 위젯 
// const domain = document.querySelector("#domain");
// const international = document.getElementById("international");
// const free = document.getElementById("free");
// const notice = document.getElementById("notice");

// domain.addEventListener("click", () => {
//    location.href="/board/1"; 
// });