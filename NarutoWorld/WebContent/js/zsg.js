var row = 0 ; //定义全局行数用于修改
var reg_email = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/; //用于判断邮箱格式
var reg_name = /^((\w*\d\w*[a-z]\w*)|(\w*[a-z]\w*\d\w*))$/i; //用于判断用户名格式
var reg_chinese = /^[\u0391-\uFFE5]+$/ ; //用于判断姓名格式
var reg_pass = /^((\w*\d\w*[a-z]\w*)|(\w*[a-z]\w*\d\w*))$/i;//用于判断密码格式
//----获取行号-----
function getRow(r){
 var i=r.parentNode.parentNode.rowIndex; 
 return i ;
}
//----获取行号-----

//----删除某一行-----
function delRow(r){ 
 document.getElementById('table').deleteRow(getRow(r));
}
//----删除某一行-----

//----清除添加信息框的内容-----
function cleanAddInput(){
 document.getElementById('number').value='';
 document.getElementById('name').value=''; 
 document.getElementById('text').value='';
}
//----清除添加信息框的内容-----

//----显示添加信息框-----
function showAddInput(){
 document.getElementById('addinfo').style="display:block-inline" ;
 document.getElementById('btn_add').style="display:block-inline" ;
 document.getElementById('btn_update').style="display:none" ;
 cleanAddInput(); 
}
//----显示添加信息框-----

//----隐藏添加信息框-----
function hideAddInput(){
 document.getElementById('addinfo').style="display:none" ;

}
//----隐藏添加信息框-----

//----判断输入框的信息是否符合要求-----
function judge(){
 //根据id获取表单信息
 var number = document.getElementById('number').value;
 var name = document.getElementById('name').value;
 var text = document.getElementById('text').value;
 var judge = true ; //用于判断表单信息是否符合
 if(number==''){
  judge = false ;
  alert('请输入编号');
 }else if(name==''){
  judge = false ;
  alert('请输入姓名');
 }else if(text==''){
  judge = false ;
  alert('请输入人物简介');
 }else if(!reg_chinese.test(name)){
  judge = false ;
  alert('姓名格式不正确');
 }
 
 return judge ;
}
//----判断输入框的信息是否符合要求-----

//----新增信息的插入方法-----
function insertInfo(){
 //根据id获取表单信息
 var arr = new Array();
 arr[0] = document.getElementById('number').value;
 arr[1] = document.getElementById('name').value; 
 arr[2] = document.getElementById('text').value;
 arr[3] ="<a style='text-align:center;color:blue;cursor:pointer;' onclick='updateRow(this);'>修改</a> <a style='text-align:center;color:blue;cursor:pointer;' onclick='delRow(this);'>删除</a>";
 var x = document.getElementById('table').insertRow(1); //获取第一行对象
 
 for(var i=0;i<arr.length;i++){
  x.insertCell(i).innerHTML = arr[i] ; //用循环把每个数据插入第一行的每一列
 }
 
}
//----新增信息的插入方法-----

//----新增信息-----
function addInfo(){
 
 if(judge()==true){
  alert('添加成功');
  insertInfo(); //执行插入
  hideAddInput(); //隐藏添加信息框
  
 }else{
  alert('添加失败');
 }
}
//----新增信息-----


//----根据行号修改信息-----
function updateRow(r){
 row = getRow(r); //把该行号赋值给全局变量
 showAddInput(); //显示修改表单
 //提交按钮替换
 document.getElementById('btn_add').style="display:none" ;
 document.getElementById('btn_update').style="display:block-inline" ;
 insertInputFromQuery(queryInfoByRow(row));
 
}
//----根据行号修改信息-----


//----根据行号查信息----
function queryInfoByRow(r){
 
 var arr = new Array();
 for(var m=0 ; m<3;m++){
  arr[m] = document.getElementById('table').rows[row].cells[m].innerText;
 }
 return arr ; //返回该行数据
 
}
//----根据行号查信息----

//----把查询到的信息放入修改的表单里----
function insertInputFromQuery(arr){
 document.getElementById('number').value = arr[0];
 document.getElementById('name').value = arr[1];
 document.getElementById('text').value = arr[2];
 
}
//----把查询到的信息放入修改的表单里----


function updateInfo(){
 if(judge()==true){
  alert('修改成功');
  document.getElementById('table').deleteRow(row);//删除原来那行  
  insertInfo(); //插入修改后的值
  hideAddInput(); //隐藏添加模块
 }else{
  alert('修改失败');
  hideAddInput();
 }
}