function checkUserName() {
	var span_username = document.getElementById("usernameCheck");
	span_username.innerHTML = "<p><mark>请输入用户名，长度大于6</mark></p>";
}

function onblurUsername(){
	var span_username = document.getElementById("usernameCheck");
	var username = document.getElementById("InputUserName").value;
	if(username.length > 6){
		span_username.innerHTML = "<p><mark>输入成功</mark></p>";
		return ;
	}else{
		span_username.innerHTML = "<p><mark>输入失败</mark>,请重新输入</p>";
	}	
}

function checkPassword() {
	var span_username = document.getElementById("passwordCheck");
	span_username.innerHTML = "<p><mark>请输入用密码，长度大于6</mark></p>";
}

function onblurPassword(){
	var span_username = document.getElementById("passwordCheck");
	var password = document.getElementById("InputPassword").value;
	if(password.length>=6){
		span_username.innerHTML = "<p><mark>输入成功</mark></p>";
		return;
	}else{
		span_username.innerHTML = "<p><mark>输入失败</mark>,请重新输入</p>";
	}
	
}

function reCheckassword() {
	var span_username = document.getElementById("passwordReCheck");
	span_username.innerHTML = "<p><mark>请再次输入密码，和上一次一致</mark></p>";
}

function onblurReCheckPassword(){
	var span_username = document.getElementById("passwordReCheck");
	var password = document.getElementById("InputPassword").value;
	var passwordCheck = document.getElementById("InputCheck").value;
	if(password == passwordCheck){
		span_username.innerHTML = "<p><mark>输入成功</mark></p>";
		return;
	}else{
		span_username.innerHTML = "<p><mark>输入失败</mark>,请重新输入</p>";
	}
	
}