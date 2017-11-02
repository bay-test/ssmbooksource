<%@page pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style >
.index{
 color: #fff;
   float:right;
   font-size:29px;
   display:block;
   text-decoration: none;
}
</style>
  <head>
    <base href="<%=basePath%>">
    <title>云服务器租赁资费后台管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" /> 
    
    <script  type="text/javascript">  
            
              window.self.location ="login/toLogin.do"
</script> 
  </head>
 
 
  <body class="index" >
 
	
  </body>
</html>
