/* banner swipe */
const swiper = new Swiper(".swiper-container", {
    slidesPerview: 1,
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