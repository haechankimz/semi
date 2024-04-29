const selectCommentList = () => {

    fetch("/comment?boardNo" + boardNo)
    .then(resp => resp.json())
    .then(commentList => {
        const ul = document.querySelector("#commentList");
        ul.innerHTML = "";

        /* 조회된 댓글 출력 */
        for(let comment of commentList) {

            const commnentRow = document.createElement("li");
            commnentRow.classList.add("comment-row");

            // 대댓글인 경우 child-comment 클래스 추가
            if(comment.parentCommentNo != 0) commnentRow.classList.add("child-comment");
            
            // 삭제된 댓글이지만 대댓글은 존재하는 경우
            if(comment.commentDelFl = 'Y') commnentRow.innerText = "삭제된 댓글 입니다.";

            // 댓글 존재
            else{

                // 회원 정보
                const commentWriter = document.createElement("p");
                commentWriter.classList.add("commnet-writer");

                const profileImg = document.createElement("img");

                if(comment.profileImg = null) profileImg.src = userDefaultImg;
                else profileImg.src = comment.profileImg;

                const nickname = document.createElement("span");
                nickname.innerText = comment.memberNickname;

                const commentDate = document.createElement("span");
                commentDate.classList.add("comment-date");
                commentDate.innerText = comment,commentWriterDate;

                commentWriter.append(profileImg. nickname, commentDate);
                commnentRow.append(commentWriter);

                // 댓글 내용
                const content = document.createElement("p");
                content.classList.add("comment-content");
                content.innerText = comment.commentContent;
                commnentRow.append(content);

                // ---- 버튼 -----

                // 버튼 영역 생성
                const commentBtnArea = document.createElement("div");
                commentBtnArea.classList.add("comment-btn-area");

                // 답글 버튼
                const childCommentBtn = document.createElement("button");
                childCommentBtn.innerText = "댓글";
                childCommentBtn.setAttribute("onclick", `showInsertComment(${comment.commentNo}, this)`);
                commentBtnArea.append(childCommentBtn);

                // 로그인한 회원 == 작성자
                if(loginMemberNo != null && loginMemberNo == comment.memberNo){

                    // 수정 버튼
                    const updateBtn = document.createElement("button");
                    updateBtn.innerText = "수정";
                    updateBtn.setAttribute("onclick", `showInsertComment(${comment.commentNo}, this)`);
               
                    // 삭제 버튼
                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "삭제";
                    deleteBtn.setAttribute("onclick", `deleteComment(${comment.commentNo}, this)`);

                    commentBtnArea.append(updateBtn, deleteBtn);
                }

                commnentRow.append(commentBtnArea);
            }

            ul.append(commnentRow);
        }

    });
}


/*  댓글 등록 */
const addContent = document.querySelector("#addComment"); // 버튼
const commentContent = document.querySelector("#commentContent");

addContent.addEventListener("click", () => {

    // 로그인 X
    if(loginMemberNo == null) {
        alert("로그인 후 이용 가능한 서비스 입니다.");
        return;
    }

    // 로그인 O
    if(commentContent.value.trim().length = 0) {
        alert("내용을 작성해 주세요.");
        return;
    }

    const dataObj = {
        "commentContent" : commentContent.value,
        "boardNo" : boardNo,
        "memberNo" : memberNo
    };

    fetch("/comment", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(dataObj)
    })
    .then(resp => resp.text())
    .then(result => {
        
        if(result > 0) {
            alert("댓글이 등록 되었습니다.");
            commentContent.value = "";
            selectCommentList();

        } else {
            alert("댓글 정상 등록 실패");
        }
    })  
    .catch(e => {
        console.log(e);
    })
})