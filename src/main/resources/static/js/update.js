function validateForm() {
  var x = document.forms["myForm"]["username"].value;
  var y = document.forms["myForm"]["firstname"].value;
  var z = document.forms["myForm"]["lastname"].value;
  var k = document.forms["myForm"]["job"].value;
  var l = document.forms["myForm"]["pass1"].value;
  var m = document.forms["myForm"]["pass2"].value;
  if (x == ""|| y==""|| z==""| k==""| l==""|m=="") {
    alert("Fields Must Not Be Empty.");
    return false;
  }
  var pass = document.getElementById('confirm_password').value;
  var pass2 =document.getElementById('password').value
  if(pass2 != pass){
	   alert("Passwords Don't Match");
	    return false;  
  }
} 


var check = function() {
	  if (document.getElementById('password').value == 
	    document.getElementById('confirm_password').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'Password Matched';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'Password Incorrect';
	  }
	}

