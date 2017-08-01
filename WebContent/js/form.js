window.onload=function(){
	var login=document.getElementById('log-btn');
	var submit=document.getElementById('Submit');
	
	//TODO =======================开始添加、更改===========================================
	var logout=document.getElementById('logout');
	$("#divBtn li:first-child img").click(function(){
		$(".userInfo").css("visibility", "visible");
	});
	$("body").children().not('#header').click(function(){
		$(".userInfo").css("visibility", "hidden");
	});
	
	logout.onclick=function(){
		$("#divBtn ul li:first-child").css("visibility", "hidden").siblings().css("visibility", "visible");
	}
	
	//login.onclick=function(){
	//	if(checkuser() && checkpass()){
			// 
			// 此处将数据提交给后台服务器进行后台验证处理
			// 
			// 
			// 
			if(document.getElementById('land_text').value !=""){
				$("#divBtn ul li:not(:first-child)").css("visibility", "hidden").siblings().css("visibility", "visible");
			}else{
				//$("#divBtn ul li:not(:first-child)").css("visibility", "hidden").siblings().css("visibility", "visible");

			}
			//alert("登录成功！");
		//}
	//}
	//TODO ============================结束============================================
	
	submit.onclick=function(){
		if(identify1() && identify2() && identify3() && identify4() && identify5()){
			//
			//提交数据到后台，并存入数据库
			//
			//
			alert("注册成功！");
		}
	}
}
/*登录部分*/
function checkuser(){                          
	var user=document.getElementById('username');
	var usertxt=user.value.trim();

	var hintuser=document.getElementById('hintuser');
	var reg1=/^[^0-9_-]([\u4E00-\u9FFF0-9a-zA-Z_-]){5,20}$/;
	var reg2=/^\w+@\w+(\.[a-z]{2,8}){1,2}$/;
	var reg3=/^1[3-8][0-9]{9}$/;
	if(!reg1.test(usertxt) && !reg2.test(usertxt) && !reg3.test(usertxt) ){
		hintuser.innerHTML="请输入正确的或合法的格式";	
		user.value="";
		user.focus();
		return false;
	}else{
		hintuser.innerHTML="";
		return true;
	}	
}
function checkpass(){
	var pass=document.getElementById('password');
	var passtxt=pass.value.trim();

	var hintpass=document.getElementById('hintpass');
	var reg=/^[^_-]([0-9a-zA-Z_-]){5,20}$/;

	if(!reg.test(passtxt)){
		hintpass.innerHTML="请输入正确的格式";
		pass.value="";
		pass.focus();
		return false;
	}else{
		hintpass.innerHTML="";
		return true;
	}	
}
/*注册部分*/

/*姓名*/
function identify1(){                           //离开焦健
	var va=document.getElementById('usern');
	var val=va.value.trim();
	var txt=document.getElementById('ide-user');
	var reg=/^[^0-9_-]([\u4E00-\u9FFF0-9a-zA-Z_-]){5,20}$/;
	
	if(!reg.test(val)){
		txt.innerHTML="请输入正确的或合法的格式";
		va.value="";
		va.focus();	
		return false;
	}else{
		txt.innerHTML="";
		check();
		return true;
	}
}
function check() {
	//alert("开始检查用户名是否存在.....!");
	var url = "Judeg_User_Servlet?userName="
			+ document.getElementById("usern").value;
	if (window.XMLHttpRequest)
		req = new XMLHttpRequest();
	else if (window.ActiveXObject)
		req = new ActiveXObject("Microsoft.XMLHTTP");
	if (req) {
		req.open("get", url, true);
		//get方式可不加如下语句
		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		req.onreadystatechange = complete;
		req.send(null);
		//document.getElementById("flag").innerText = "请稍后，正在检查用户名!";
	}
}
/*分析返回的XML文档*/
function complete() {
	if (req.readyState == 4) {
		if (req.status == 200) {
			var result = req.responseText;
			var infoStr;
			if (result == "true"){
				 infoStr = "改用户名已经存在，请换用户名！";
				var va=document.getElementById('usern');
				//document.getElementById("image").src="images/false.jpg";
				va.focus();	
				va.value="";
			}else{
				 infoStr = "该用户名没有注册，请你继续注册！";
				//document.getElementById("image").src="images/true.jpg";
			}
			document.getElementById("flag").innerText = infoStr;
			//flag.style.display = 'block';
		
		}
	}
}
/*密码*/
function identify2(){
	var va=document.getElementById('passw');
	var val=va.value.trim();
	var txt=document.getElementById('ide-pass');
	var reg=/^[^_-]([0-9a-zA-Z_-]){5,20}$/;

	if(!reg.test(val)){
		txt.innerHTML="请输入正确的格式";
		va.value="";
		va.focus();	
		return false;
	}else{
		txt.innerHTML="";
		return true;
	}
}
/*确认密码*/
function identify3(){
	var va=document.getElementById('confirm-passw');
	var val=va.value.trim();
	var txt=document.getElementById('ide-cpass');

	if(identify2()){
		var passtxt=document.getElementById('passw');
		var passval=passtxt.value.trim();
		if(val!=passval){
			txt.innerHTML="两次密码不一样,请重新输入";
			va.value="";
			return false;
		}else{
			txt.innerHTML="";
			return true;
		}
	}
}
/*电话*/
function identify4(){
	var va=document.getElementById('phone');
	var val=va.value.trim();
	var txt=document.getElementById('ide-phone');
	var reg=/^1[3-8][0-9]{9}$/;

	if(!reg.test(val)){
		txt.innerHTML="请输入11位合格的手机号码";
		va.value="";
		va.focus();	
		return false;
	}else{
		txt.innerHTML="";
		return true;
	}
}
/*邮箱*/
function identify5(){
	var va=document.getElementById('email');
	var val=va.value.trim();
	var txt=document.getElementById('ide-email');
	var reg=/^\w+@\w+(\.[a-z]{2,8}){1,2}$/;

	if(!reg.test(val)){
		txt.innerHTML="请输入正确的邮箱格式";
		va.value="";
		va.focus();	
		return false;
	}else{
		txt.innerHTML="";
		return true;
	}
}

