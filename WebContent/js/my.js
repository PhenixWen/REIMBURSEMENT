/**
 * Created by new on 2017/7/13.
 */
function check1(){
    //alert("hello");
   var no =  document.getElementById("no");//input标签---html页面的一个标签元素  object
   var novalue =  no.value;
   //alert(novalue);
    var req =/^\d{4}$/;//四位的数字
    //字母组成的正则表达式   /^[a-zA-Z]{6,20}$/
    if(novalue == ""){
        alert("员工编号不能为空！");
        return false;
    }
    else if(req.test(novalue) == false){
        alert("员工编号不是四位有效数字！");
        return false;
    }
    else{
        alert("员工编号合法！");
        return true;
    }
}

function check2(){
    var name =  document.getElementById("ename");//input标签---html页面的一个标签元素  object
    var namevalue =  name.value;
    //alert(novalue);
    var req2 =/^[a-zA-Z]{6,20}$/;//四位的数字
    //字母组成的正则表达式   /^[a-zA-Z]{6,20}$/
    if(namevalue == ""){
        alert("员工名字不能为空！");
        return false;
    }
    else if(req2.test(namevalue) == false){
        alert("员工名字不是格式错误！");
        return false;
    }
    else{
        alert("员工名字合法！");
        return true;
    }
}

function check(){
    if(check1() == true && check2() == true){
       return true;
    }
    else{
        return false;
    }
}