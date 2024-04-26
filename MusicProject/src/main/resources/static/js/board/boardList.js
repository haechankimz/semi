const insertBtn = document.querySelector("#insertBtn");


insertBtn.addEventListener("click", () => {

  location.href = `/editBoard/${boardCode}/insert`;

});
