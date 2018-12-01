
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("users-name").innerHTML = this.responseText
    }
  };
  xhttp.open("GET", "/v1/getUser", true);
  xhttp.send();