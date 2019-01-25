// JavaScript Document
pics=new Array("images/a737a7a68689f89baf4162914d.jpg","images/2taozi.jpg","images/3yingtao.jpg");
	pos=0;
	function left(){
		pic=document.images[0];
		if(pos==pics.length-1){
			pos=0;
		}else{
			pos++;
		}	
			pic.src=pics[pos];
	}
	function right(){
		pic=document.images[0];
		if(pos==0){
			pos=pics.length-1;
		}else{
			pos--;
		}	
			pic.src=pics[pos];
		
	}
	function autochange(){
		left();
		x=setTimeout("autochange()",3000)
	}
	function stopchange(){
		clearTimeout(x);
	}
	function setPos(i){
		stopchange();
		pic.src=pics[i];
	}