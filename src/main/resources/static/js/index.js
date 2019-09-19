/**
 * HTML5向Web API新引入了document.querySelector以及document.querySelectorAll两个方法用来更方便地从DOM选取元素
 */
function cambiar_login() {
	document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
	document.querySelector('.cont_form_login').style.display = "block";            
	setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);   
}

function login(){
	var name = $('#usrname').val();
	var passwd = $('#passwd').val();
	$.post("doLogin", { name: name, passwd: passwd },function(data){
		console.log(data)
		if(data.code === 200){
			window.location.href = "userInfo";
		}
	});
}

function cambiar_sign_up(at) {
	document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
	document.querySelector('.cont_form_login').style.opacity = "0";
  
	setTimeout(function(){   
		document.querySelector('.cont_form_login').style.display = "none";
	},400);  
}    



function ocultar_login_sign_up() {
	document.querySelector('.cont_forms').className = "cont_forms";                
	document.querySelector('.cont_form_login').style.opacity = "0"; 

	setTimeout(function(){
		document.querySelector('.cont_form_login').style.display = "none";
	},500);  
}