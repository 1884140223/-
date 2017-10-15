<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级页面</title>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
</head>
<body>
	${code1}你好，你已经登录成功！你的密码是：${password1}<br />
	<a href="#" onclick="odata('1', 'add')">新增</a>
	<a href="login.jsp">退出</a>
	<table border="1" width="1200" height="200">
			<tr>
				<td>年级</td>
				<td>文理科</td>
				<td>人数</td>
				<td>班主任</td>
			</tr>
			<c:forEach var="account" items="${list }" >
				<tr>
					<td>${account.code }</td>
					<td>${account.lei }</td>
					<td>${account.number }</td>
					<td>${account.teacher }</td>
					<td>
						<a href="#" onclick="odata('2',${account.id});">删除</a>
						<a href="#" onclick="odata('0',${account.id});">修改</a>
					</td>
				</tr>
			</c:forEach>
	</table>
	<script type="text/javascript">
		var flag;
		var id;
		function odata(flag,id){
			if("1" == flag){
				location.href="account/jsp/AddClass.jsp";
				return;
			}
			if("2" == flag){
				var idatas = {"flag":flag,"id":id};
				$.ajax({
					url:'<%= path%>/ClassRoomServlet',
					type:'post',
					dataType:'json',
					data:idatas,
					success:success_function,
					error:error_function
				});
				function success_function(odatas){
					if("0"==odatas){
						var datas ={"flag":"0"};
						$.ajax({
							url:'<%= path%>/ClassRoomServlet',
							type:'post',
							dataType:'json', 
							data:datas,
							success:success_function,
							error:error_function
						});
						function success_function(datas){
							if("0" == datas){
								location.href="<%= path%>/classroom.jsp";
								alert("删除成功！");
							}else{
								alert("删除失败！");
							}
						}	
						function error_function(){
							alert("删除错误！");
						}
					}else{
						//location.reload();
						alert("删除失败！");
					}
				}
				function error_function(){
					alert("删除错误");	
				}
				return;
			}
			if("0" == flag){
				var idatas = {"flag":flag,"id":id};
				$.ajax({
					url:'<%= path%>/ClassRoomServlet',
					type:'post',
					dataType:'json',
					data:idatas,
					success:success_function,
					error:error_function
				});
				function success_function(odatas){
					if("0" == odatas){
						location.href="account/jsp/UpdateClass.jsp";
					}else{
						
					}
				}
				function error_function(){
					alert("修改错误!");
				}
				return;
			}
		}
	</script>
</body>
</html>