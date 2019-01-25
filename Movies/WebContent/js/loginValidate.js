
function validatelogin(){
	var name=document.getElementById("username").value;
	var pass=document.getElementById("password").value;
	var repass=document.getElementById("repassword").value;
	var namelen=name.length;
	var passlen=pass.length;
	if(name=="" || pass=="" || repass=="" ){
	    alert("用户名与密码不能为空！");
	    return false;
	}else if(pass!=repass){
		alert("密码与重复密码必须一致！");
		 return false;
	}else if(namelen<5 || namelen>18){
		 alert("用户名长度必须在5-18之间！");
		 return false;
	}else if(passlen<6 || namelen>20){
		 alert("密码长度必须在6-20之间！");
		 return false;
	}
	  return true;
	
}
   function validateAge(){
	  var tt= form1.age.value				      
               if(isNaN(tt)){
	    alert("请输入有效数字！");
	     form1.age.focus();
	      form1.age.select();
	    }
 	 }
	 function validateEmail(){
	    str=document.getElementById("email").value;
	    var exp=/\w+([-+.']\w)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
	    var objEx=new RegExp(exp);
	    if(objEx.test(str)==false){
	     alert("请输入正确的邮箱！");
	     form1.email.focus();
	     form1.email.select();
	 }
	 }