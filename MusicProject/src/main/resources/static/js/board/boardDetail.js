const goListBtn = document.querySelector("#goListBtn");

goListBtn.addEventListener("click", () => {
    let url = location.pathname;
    url = url.substring(0, url.lastIndexOf("/"));

    location.href = url + location.search;
})