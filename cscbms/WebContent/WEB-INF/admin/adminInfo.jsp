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
            $(function(){
            	if($("#flag").val()){
            		showResultDiv($("#flag").val());
            		window.location.href = "/cscbms/userInfo/touserInfo.do"
            	}
            	
            })
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
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">    
        <input type="hidden" id="flag" name="flag" value="${flag }"/>        
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="update.do" method="post" class="main_form">
            		<input type="hidden" name="adminId" value="${admin.adminId }"/>
            		
            		
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" name="name" value="${admin.name }" />
                        <span class="required">*</span>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info"><input type="text" readonly="readonly" class="readonly" name="adminCode" value="${admin.adminCode }"  /></div>
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" name="telephone" value="${admin.telephone }"  />
                        <span class="required">*</span>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" name="email" value="${admin.email }"/>
                        <span class="required">*</span>
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