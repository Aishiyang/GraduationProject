// JavaScript Document
swfobject.registerObject("FlashID");
	function changecolor(x,y){
		y.bgColor=x;
	}
	function showtime(){
		t=document.getElementsByName("mytime");
		d=new Date();
		t[0].value=d.toLocaleString();
		setTimeout("showtime()",1000);
	}