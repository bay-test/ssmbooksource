<%@page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>CSRCBMS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" /> 
        <script type="text/javascript" language="javascript" src="../js/jquery-1.11.1.js"></script>
        <script type="text/javascript" language="javascript">
        	//登录校验
        	function check_login() {
        		var admin_code = $("#admin_code").val();
        		if(admin_code == "") {
        			$("#admin_code_msg").text("请输入账号.");
        			return;
        		}
        		
        		var password = $("#password").val();
        		if(password == "") {
        			$("#password_msg").text("请输入密码.");
        			return;
        		}
        		
        		var code = $("#code").val();
        		if(code == "") {
        			$("#code_msg").text("请输入验证码.");
        			return;
        		}
        		
        		$.post(
        			"login.do",
        			$("#myform").serialize(),
        			function(data) {
        				if(data.flag==1) {
        					//账号错误
        					$("#admin_code_msg").text("账号错误.");
        				} else if(data.flag==2) {
        					//密码错误
        					$("#password_msg").text("密码错误.");
        				} else if(data.flag==3) {
        					//验证码错误
        					$("#code_msg").text("验证码错误.");
        					change();
        				} else {
        					//成功
        					location.href = "toIndex.do";
        				}
        			}
        		);
        	}
        	//设置提示信息
        	function set_msg(id, msg) {
        		$("#"+id).text(msg);
        	}
        	//刷新验证码
        	function change() {
        		$("#code_image").attr("src", "createImage.do?date=" + new Date().getTime());
        	}
        </script>
    </head>
    <body class="login">
        <div class="login_box">
        	<form action="login.do" method="post" id="myform">
	            <table>
	             
	                
	                <tr>
	                    <td class="login_info">账号：</td>
	                    <td colspan="2">
	                    	<input type="text" value="admin" name="adminCode" id="admin_code" class="width150" onfocus="set_msg('admin_code_msg','30长度的字母、数字和下划线');"/>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="login_info">密码：</td>
	                    <td colspan="2">
	                    	<input type="password" value="admin" name="password" id="password" class="width150" onfocus="set_msg('password_msg','30长度的字母、数字和下划线');"/>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="login_info">验证码：</td>
	                    <td class="width70"><input name="code" type="text" class="width70" id="code" onfocus="set_msg('code_msg','');"/></td>
	                    <td><img src="createImage.do" alt="验证码" title="点击更换" id="code_image" onclick="change();"/></td>  
	                    <td><span class="required" id="code_msg"></span></td>
	                </tr>
	               
	                <tr>
	                    <td></td>
	                    <td class="login_button" colspan="2">
	                        <a href="javascript:check_login();"><img src="../images/login_btn.png" /></a>
	                    </td>    
	                    <td><span class="required"></span></td>                
	                </tr>
	            </table>
            </form>
        </div>
    </body>
</html>