<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>CSCBMS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script language="javascript" type="text/javascript" src="../js/jquery-1.11.1.js"></script>
        <script language="javascript" type="text/javascript">
            //保存成功的提示消息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(true);", 50000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
            function check_oldPassword(){
            	var reg = /^[0-9a-zA-Z_]{1,}$/;
            	var pwd = $("#oldPassword").val();
            	if(!reg.test(pwd)){
            		$("#old_password_msg").text("30长度以内的字母、数字和下划线的组合").addClass("error_msg");
            	}else{
            		$("#old_password_msg").text("").removeClass("error_msg");
            	}
            }
            function check_newPassword(){
            	var reg = /^[0-9a-zA-Z_]{1,}$/;
            	var newpwd = $("#newPassword").val();
            	if(!reg.test(newpwd)){
            		$("#new_password_msg").text("30长度以内的字母、数字和下划线的组合").addClass("error_msg");
            	} else{
            		$("#new_password_msg").text("").removeClass("error_msg");
            	}
            }
            function check_regPassword(){
            	var reg = /^[0-9a-zA-Z_]{1,}$/;
            	var newpwd = $("#newPassword").val();
            	var regpwd = $("#regPassword").val();
            	if(!reg.test(newpwd)){
            		$("#reg_password_msg").text("30长度以内的字母、数字和下划线的组合").addClass("error_msg");
            	}else{
            		$("#reg_password_msg").text("").removeClass("error_msg");
            	}
            	console
            	if(newpwd!=regpwd){
            		$("#reg_password_msg").text("两次密码必须相同").addClass("error_msg");
            	} else{
            		$("#reg_password_msg").text("").removeClass("error_msg");
            	}
            }
            function modifyPwd(){
            	$.post("ModifyPwd.do",$(".main_form").serialize(),function(data){
            		if(data){
            			showResult()
            		}else{
            			alert("修改失败")
            		}
            	})
            	return false;
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.jpg" alt="logo" class="left"/>
             <a href="<%=request.getContextPath() %>/login/toLogin.do">[退出]</a>              
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
        	<jsp:include page="/WEB-INF/main/menu.jsp" />
            <!-- <ul id="menu">
                <li><a href="../index.html" class="index_off"></a></li>
                <li><a href="../role/role_list.html" class="role_off"></a></li>
                <li><a href="../admin/admin_list.html" class="admin_on"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
                <li><a href="../account/account_list.html" class="account_off"></a></li>
                <li><a href="../service/service_list.html" class="service_off"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul> -->
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">修改成功！</div>
            <form action="ModifyPwd.do" method="post" class="main_form">
            		<div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info"><input type="text" readonly="readonly" class="readonly" name="adminCode" value="${admin.adminCode }"  /></div>
                    <div class="text_info clearfix"><span>原密码：</span></div>
                    <div class="input_info">
                        <input type="password" id="oldPassword" name="oldPassword" onblur="check_oldPassword();"/>
                        <span class="required">*</span>
                        <div id="old_password_msg" class="validate_msg_long"></div>
                    </div>
                    <div class="text_info clearfix"><span>新密码：</span></div>
                    <div class="input_info">
                        <input type="password" id="newPassword" name="newPassword" onblur="check_newPassword();"/>
                        <span class="required">*</span>
                        <div id="new_password_msg" class="validate_msg_long"></div>
                    </div>
                    <div class="text_info clearfix"><span>重复新密码：</span></div>
                    <div class="input_info">
                        <input type="password" id="regPassword" onblur="check_regPassword();" />
                        <span class="required">*</span>
                        <div id="reg_password_msg" class="validate_msg_long"></div>
                    </div>      
                    <div class="button_info clearfix">
                        <input type="submit" value="修改" class="btn_save" />
                        <input type="button" value="取消" class="btn_save" onclick="history.back();"/>
                    </div>
                </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[简单不先于复杂，而是在复杂之后]</span>
            <br />
            <span>版权所有(C)brother </span>
        </div>
    </body>
</html>