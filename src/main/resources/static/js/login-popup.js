const show_login_selector = document.querySelector("#show-login");
const popup_selector = document.querySelector(".popup");
const close_button_selector = document.querySelector(".popup .close-btn");

show_login_selector.addEventListener("click", function () {
    popup_selector.classList.add("active");
});

close_button_selector.addEventListener("click", function () {
   popup_selector.classList.remove("active");
});

