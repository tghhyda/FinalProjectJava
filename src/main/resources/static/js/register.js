function validatePassword(confirm, password){
    if(confirm.value === password.value){
        return true;
    }else
        return false;
}

const confirm_password_selector = document.querySelector(".confirm_password");
const password_selector = document.querySelector(".password");
const button_register_selector = document.querySelector(".button-submit-register");
const register_form_selector = document.querySelector(".register_form");

// const register_form_selector = document.querySelector(".register_form");
// register_form_selector.addEventListener("submit", function (){
//     if(validatePassword(confirm_password_selector, password_selector)){
//         console.log("submit success");
//         return;
//     }else{
//         console.log("submit fail");
//         return;
//     }
// });


// button_register_selector.addEventListener("click", function (){
//     if(validatePassword(confirm_password_selector, password_selector)){
//         console.log("submit success");
//         return;
//     }else{
//         console.log("submit fail");
//         return;
//     }
// });

button_register_selector.addEventListener("click", function (){
    if(validatePassword(confirm_password_selector, password_selector)){
        console.log("submit success");
        register_form_selector.setAttribute("th:action","@{process_register}")
    }else{
        console.log("submit fail");
        return;
    }
});