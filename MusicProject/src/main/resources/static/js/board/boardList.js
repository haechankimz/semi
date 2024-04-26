/* 특정카테고리의 게시글 가져오기 */
const categoryBtn = document.querySelectorAll(".category-btn");

categoryBtn.forEach(categoryBtn => {
    categoryBtn.addEventListener("click", () => {
        const boardCode = categoryBtn.getAttribute("boardCode");
        const categoryNo = categoryBtn.getAttribute("categoryNo")
        location.href = `/board/${boardCode}/category/${categoryNo}`;
    });
});







/* 글쓰기 버튼 / 검색 요소 */