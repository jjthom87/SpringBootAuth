var registerForm = document.getElementById("register-form");
var userNameInput = document.getElementById("username-input");
var passwordInput = document.getElementById("password-input");

registerForm.addEventListener("submit", function(evt) {
    evt.preventDefault();
    getValues();
    
    var inputs = {
    		"username": userNameInput.value,
    		"password": passwordInput.value
    };
    
//    fetch("/v1/register", {
//    	  method: "POST", 
//    	  body: JSON.stringify(inputs)
//    	}).then(res => {
//    	  console.log("Request complete! response:", res);
//    	});
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/v1/register");
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.send(JSON.stringify(inputs));
    
});

function getValues() {
    console.log("username "+ userNameInput.value);
    console.log("password " + passwordInput.value);
}