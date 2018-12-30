/**
 * 
 */

function validate() {
	var pw1 = document.getElementById("pwd1").value;
	var pw2 = document.getElementById("pwd2").value;
	if((!pw1)&&(!pw2)){
		document.getElementById("tishi").innerHTML="<span></span>";
		document.getElementById("submit").disabled = false;
	}
	else{
		if(pw1 == pw2) {
			document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
			document.getElementById("submit").disabled = false;
		}
		else{
			document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
			document.getElementById("submit").disabled = true;
		}
	}
}

function resetpwd(){
	document.getElementById("tishi").innerHTML="<span></span>";
	document.getElementById("submit").disabled = false;
}