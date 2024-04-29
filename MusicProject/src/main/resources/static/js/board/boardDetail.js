/* 목록으로 */
const goListBtn = document.querySelector("#goListBtn");

goListBtn.addEventListener("click", () => {
    let url = location.pathname;
    url = url.substring(0, url.lastIndexOf("/"));

    location.href = url + location.search;
})


const boardLike = document.querySelector("#boardLike");
boardLike.addEventListener("click", e => {

    if(loginMemberNo == null){
        alert("로그인 후 좋아요를 눌러주세요");
        return;
    }

    const obj = {
        "memberNo" : loginMemberNo,
        "boardNo" : boardNo,
        "likeCheck" : likeCheck
    };

    fetch("/board/like", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    })
    .then(resp => resp.text())
    .then(count => {
        if(count == -1){
            console.log("좋아요 처리 실패");
            return;
        }

        likeCheck = likeCheck == 0 ? 1 : 0;

        e.target.classList.toggle("fa-regular");
        e.target.classList.toggle("fa-solid");

        e.target.nextElementSibling.innerText = count;
    })
});
