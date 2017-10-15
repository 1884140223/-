<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<body>
	<div style="float:left;text-height:12px;font-size:30px;">
		<a href="teacher_login.jsp" style="text-decoration:none;color:black;">Teacher</a><br />
		<a href="student_login.jsp" style="text-decoration:none;color:black;">Student</a><br />
		<a href="classroom_login.jsp" style="text-decoration:none;color:black;">ClassRoom</a>
	</div>
	
	<form action="" method="post" style="text-align:center;;font-size:25px;">
		<lable>用户</lable> 
		<input type="text" id="code" /><br />
		<lable>密码</lable>
		<input type="password" id="password" /><br />
		<input type="button" value="提交" onclick="ajax()" /><br />
		<div id="message" style="color:red;height:20px"></div>
		<script type="text/javascript">
			function ajax(){
				var datas={"code":$("#code").val(),"password":$("#password").val()};
				$.ajax({
					url:'Servlet',
					type:'post',
					dateType:'json',
					data:datas,
					success:success_function,
					error:error_function
				});
			}
		
			function success_function(ajaxData){
				if("0"==ajaxData){
					location.href="success.jsp";
				}else{
					//location.reload();
					$("#message").html("用户名或密码错误！");
				}
			}
			function error_function(){
				alert("ajax错误");
				
			}
			
		</script>
	</form>
</body>
</html>