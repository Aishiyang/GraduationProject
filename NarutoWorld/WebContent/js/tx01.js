// JavaScript Document
function testText()
{
	//方法1：//var str=document.getElementById("userID").value;//获得文本框对象 通过对象调用值
	//方法2：//var str=document.getElementsByName("注册用户名")[0].value;
    var str=document.注册信息表.注册用户名.value;//方法
	if(str=="")
	{
		alert("用户名不能为空");//警告
	}
}
function clearText()
{
	document.getElementById("userID").value="";
}
function _clearText()
{
	document.getElementById("_userID").value="";
}
