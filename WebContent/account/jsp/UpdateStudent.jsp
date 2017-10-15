<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生修改</title>
<script type="text/javascript" src="<%=path %>/js/jquery-1.12.4.js"></script>
</head>
<body>
<center>
		<form>
			<div>
				<label>name</label>
				<input type="text" id="name" value=${account.name} />
			</div>
			<div>
				<label>password</label>
				<input type="password" id="password" value=${account.password} />
			</div>
			<div>
				<label>sex</label>
				<input type="text" id="sex" value=${account.sex} />
			</div>
			<div>
				<label>age</label>
				<input type="text" id="age" value=${account.age} />
			</div>
			<input type="button" value="保存" onclick="updateSave(${account.id});" />
		</form>
	</center>
	<script type="text/javascript">
	function updateSave(id){
		var datas = {"flag":"3", "id":id, 
				"name":$('#name').val(), 
				"password":$('#password').val(), "sex":$('#sex').val(), "age":$('#age').val()};
		$.ajax({
			url:'<%= path%>/StudentServlet',
			type:'post',
			dataType:'json',
			data:datas,
			success:success_function,
			error:error_function
		});
		function success_function(datas){
			if("0" == datas){
				var datas ={"flag":"0"};
				$.ajax({
					url:'<%= path%>/StudentServlet',
					type:'post',
					dataType:'json', 
					data:datas,
					success:success_function,
					error:error_function
				});
				function success_function(datas){
					if("0" == datas){
						location.href="<%= path%>/student.jsp";
						alert("修改成功！");
					}else{
						alert("修改失败！");
					}
				}	
				function error_function(){
					alert("修改错误！");
				}
			}else{
				alert("修改失败！");
			}
		}
		function error_function(){
			alert("修改错误！");
		}
		return;
	}
		
	</script>
</body>
</html>