<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>医疗报销系统</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="/REIMBURSEMENT/page/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/REIMBURSEMENT/page/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/amazeui.min.css" />
  <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/admin.css">
  <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/app.css">
  <script src="/REIMBURSEMENT/page/assets/js/jquery.min.js"></script>
  <script>
  
  
  
  $(function(){
		$("#name").blur(function(){
			var value = $("#name").val();
			$.ajax({
				url:"/REIMBURSEMENT/AjaxCheckPersonID?name="+value,
				type:"GET",
				dataType:"text",
				success:function(data){
					if(data == "yes" && value != ''){
						$("#divName").attr("class", "am-form-group am-form-success am-form-icon am-form-feedback");
						
						$("#spanName").attr("class", "am-icon-check");
						$("#spanName").html("用户名可用");
					}
					else {
						$("#divName").attr("class", "am-form-group am-form-error am-form-icon am-form-feedback");
						$("#spanName").attr("class", "am-icon-times");
						$("#spanName").html("用户名已存在或用户名非法");
						
					}
					
				},
				error:function(){
					alert("error");
				}
			});
		});
	});
  
  function check() {
		
		if ($("#name").val() == '') {
			alert("存在必填项为空");
			return false;
		}
		else{
			if($("#psw1").val() != $("#psw2").val()){
				alert("两次密码不同");
				return false;
			}
			else{
				if($("#divName").hasClass("am-form-success")){
					return true;
				}
				alert("用户名非法");
				return false;
			}
			
		}

	}
  </script>
</head>

<body data-type="login">

  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				医疗报销系统<span> 注册</span> <i class="am-icon-skyatlas"></i>
			</div>
		</div>
		<div class="login-font">
			<!-- <i>用户注册</i> -->
			<!-- or <span> Sign Up</span> -->
		</div>
		<div class="am-u-sm-10 login-am-center">
			<form class="am-form" onsubmit="return check()"
			method="post" action="/REIMBURSEMENT/RegisterServlet">
				<fieldset>
				
					<div class="am-form-group" id="divName">
						<input type="text" class="am-form-field" name="name" id="name" placeholder="输入用户名">
						<span id="spanName" class=""></span>
					</div>
					
					
					
					<div class="am-form-group">
						<input type="password" name="psw1" class="" id="psw1" placeholder="输入密码">
					</div>
					
					
					
					<div>
						<input type="password" name="psw2" class="" id="psw2" placeholder="再次输入密码">
					</div>
					
					
					<p><button type="submit" class="am-btn am-btn-default">注册</button></p>
				</fieldset>
			</form>
		</div>
	</div>
</div>
	  <script src="/REIMBURSEMENT/page/assets/js/jquery.min.js"></script>
	  <script src="/REIMBURSEMENT/page/assets/js/amazeui.min.js"></script>
	  <script src="/REIMBURSEMENT/page/assets/js/app.js"></script>
</body></html>                                                   











































































































































































































































































































































































































































































































































































