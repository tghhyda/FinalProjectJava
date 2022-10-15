function seePasswordLogin(){
    const see_password = document.querySelector(".see_login_password");
    const hide_password = document.querySelector(".hide_login_password");
    if(document.getElementById("password").type === 'password'){
        document.getElementById("password").type = "text";
        see_password.style.display = "inline-block";
        hide_password.style.display = "none";
    }else{
        document.getElementById("password").type = "password";
        see_password.style.display = "none";
        hide_password.style.display = "inline-block";
    }
}