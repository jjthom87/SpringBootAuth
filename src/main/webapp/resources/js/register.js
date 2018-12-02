var registerForm = document.getElementById("register-form");
var userNameInput = document.getElementById("username-input");
var passwordInput = document.getElementById("password-input");

registerForm.addEventListener("submit", function(evt) {
    evt.preventDefault();
    //getValues();
	document.getElementsByTagName("img")[0].style.display="";
	document.getElementsByTagName("img")[0].style.position="absolute";
    setTimeout(function(){
	    var inputs = {
	    		"username": userNameInput.value,
	    		"password": passwordInput.value
	    };
	    
	    var xmlhttp = new XMLHttpRequest();
	    xmlhttp.onreadystatechange = function() {
//	    		document.getElementsByTagName("img")[0].style.display="";
//	    		document.getElementsByTagName("img")[0].style.position="absolute";
	        if (this.readyState == 4 && this.status == 200) {
	          window.location.href = '/login';
	        }
	    };
	    xmlhttp.open("POST", "/v1/register");
	    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	    xmlhttp.send(JSON.stringify(inputs));
    }, 3000);
});

function getValues() {
    console.log("username "+ userNameInput.value);
    console.log("password " + passwordInput.value);
}