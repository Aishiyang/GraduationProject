
function validatelogin(){
	var name=document.getElementById("username").value;
	var pass=document.getElementById("password").value;
	var repass=document.getElementById("repassword").value;
	var namelen=name.length;
	var passlen=pass.length;
	if(name=="" || pass=="" || repass=="" ){
	    alert("�û��������벻��Ϊ�գ�");
	    return false;
	}else if(pass!=repass){
		alert("�������ظ��������һ�£�");
		 return false;
	}else if(namelen<5 || namelen>18){
		 alert("�û������ȱ�����5-18֮�䣡");
		 return false;
	}else if(passlen<6 || namelen>20){
		 alert("���볤�ȱ�����6-20֮�䣡");
		 return false;
	}
	  return true;
	
}
   function validateAge(){
	  var tt= form1.age.value				      
               if(isNaN(tt)){
	    alert("��������Ч���֣�");
	     form1.age.focus();
	      form1.age.select();
	    }
 	 }
	 function validateEmail(){
	    str=document.getElementById("email").value;
	    var exp=/\w+([-+.']\w)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
	    var objEx=new RegExp(exp);
	    if(objEx.test(str)==false){
	     alert("��������ȷ�����䣡");
	     form1.email.focus();
	     form1.email.select();
	 }
	 }