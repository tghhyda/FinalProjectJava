const confirm_password_selector = document.querySelector(".confirm_password");
const password_selector = document.querySelector(".password");

function Validate() {
    if (password_selector.value != confirm_password_selector.value) {
        document.getElementById('message').innerHTML = ("Passwords do not match.");
        return false;
    }
    return true;
}

function seePassword(){
    const see_password = document.querySelector(".see_password");
    const hide_password = document.querySelector(".hide_password");
    if(password_selector.type === 'password'){
        password_selector.type = "text";
        see_password.style.display = "inline-block";
        hide_password.style.display = "none";
    }else{
        password_selector.type = "password";
        see_password.style.display = "none";
        hide_password.style.display = "inline-block";
    }
}

function seeConfirmPassword(){
    const see_password = document.querySelector(".see_confirm_password");
    const hide_password = document.querySelector(".hide_confirm_password");
    if(confirm_password_selector.type === 'password'){
        confirm_password_selector.type = "text";
        see_password.style.display = "inline-block";
        hide_password.style.display = "none";
    }else{
        confirm_password_selector.type = "password";
        see_password.style.display = "none";
        hide_password.style.display = "inline-block";
    }
}