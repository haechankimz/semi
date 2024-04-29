/* 목록으로 */
const goListBtn = document.querySelector("#goListBtn");

goListBtn.addEventListener("click", () => {
    let url = location.pathname;
    url = url.substring(0, url.lastIndexOf("/"));

    location.href = url + location.search;
})


/* 카테고리 버튼에 따라 리스트 뜨게 하기 */
// const categoryBtn = document.querySelectorAll(".category-btn");

// categoryBtn.forEach(categoryList => {
//     categoryList.addEventListener("click", () => {
//         const categoryNo = categoryList.dataset.categoryNo;
//         const boardCode = categoryList.dataset.boardCode;
//         const url = `/board/${boardCode}?categoryNo=${categoryNo}`;
//         window.location.href = url;
//     });
// });
