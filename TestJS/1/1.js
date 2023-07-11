/**
 * usernameTextBox script
 * 1.0 by aurora
 */

var usernameEle = document.getElementById("username")
var usernameError = document.getElementById("usernameError")
usernameEle.onblur = function(){
    var username = usernameEle.value
    username = username.trim();
    var re = /^\w{4,8}$/g
    if(re.test(username)){
        usernameError.innerText = ""
    }
    else {
        usernameError.innerText = "用户名必须为4-8位字符"
        
    }
}

/**
 * pwdTextBox
 */
var pwd1 = document.getElementById("pwd1")
var pwd2 = document.getElementById("pwd2")
var pwdError1 = document.getElementById("pwdError1")
var pwdError2 = document.getElementById("pwdError2")
pwd1.onblur = function() {
    var re = /^.{6,11}$/g
    if(re.test(pwd1.value) === false){
        pwdError1.innerText = "密码必须大于6位小于11"
    }
    else{
        pwdError1.innerText = ""
    }
}
pwd2.onblur = function(){
    if(pwd1.value != pwd2.value){
        pwdError2.innerText = "两次密码不一致"
    }
    else{
        pwdError2.innerText = ""
    }
}
/**
 * email TextBox
 */

var email = document.getElementById("email")
var emailError = document.getElementById("emailError")
email.onblur = function(){
    var re = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/g
    if (re.test(email.value)){
        emailError.innerText = ""
    }
    else{
        emailError.innerText = "邮箱不合法"
    }
}

/**
 * submmit
 */
var userFrom = document.getElementById("userForm")
document.getElementById("submmitBtn").onclick = function (){
    usernameEle.focus();
    usernameEle.blur();

    pwd1.focus();
    pwd1.blur();
    pwd2.focus();
    pwd2.blur();

    email.focus();
    email.blur();
    if (usernameError.innerText === "" && 
        pwdError1.innerText === "" &&
        pwd2.innerText === "" &&
        emailError.innerText === ""){
            userFrom.submit();
    }
}