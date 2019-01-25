// JavaScript Document
var imglist=new Array(4)
imglist[0]="images/a.jpg";  
imglist[1]="images/aa.jpg";
imglist[2]="images/aaa.jpg";

var i=0;
	function go(){
		if(i==imglist.length)
 		{
 		 i=0;
		 }
 		document.getElementById("tp").src=imglist[i];
		 ++i;
		}
	function autochange(){
		go();
		o=setTimeout("autochange()",1000);
	}
	function stopchange(){
		clearTimeout(o);
	}
