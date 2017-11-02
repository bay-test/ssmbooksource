<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>CSCBMS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存成功的提示信息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
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
                <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
                <li><a href="../account/account_list.html" class="account_off"></a></li>
                <li><a href="../service/service_list.html" class="service_on"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul> -->
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <!--保存操作的提示信息-->
            <div id="save_result_info" class="save_fail">资费修改失败！数据并发错误。</div>
            <form action="updateService.do" method="post" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>业务账号ID：</span></div>
                <div class="input_info">
                    <input type="text" name="serviceId" value="${service.serviceId }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>云服务器账号：</span></div>
                <div class="input_info">
                    <input type="text" name="serverUserName" value="${service.serverUserName }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" name="hostIp" value="${service.hostIp }" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <select class="width150" name="costId">
                        <c:forEach items="${costs }" var="cost">
                        	<option value="${cost.costId }" <c:if test="${cost.costId==service.costId }">selected</c:if>>${cost.name }</option>
                        </c:forEach>
                    </select>
                    <div class="validate_msg_long">请修改资费类型，或者取消修改操作。</div>                      
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" onclick="history.back();"/>
                </div>

                
                <p>业务说明：<br />
                1、修改资费后，点击保存，并未真正修改数据库中的数据；<br />
                2、提交操作到消息队列；<br />
                3、每月月底由程序自动完成业务所关联的资费；</p>
                
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