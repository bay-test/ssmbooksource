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

            //自动查询账务账号
            function searchAccounts(txtObj) {
                //document.getElementById("a1").innerHTML = txtObj.value;
            }
            
            //查询账务账号
            function find_account() {
            	$("#login_name").val("");
            	$("#accountId").val("");
            				
            	var idcard_no = $("#idcard_no").val();
            	if(idcard_no == "") {
            		$("#idcard_no_msg").text("身份证不能为空.").addClass("error_msg");
            		return;
            	}

            	/* var reg = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
            	if(!reg.test(idcard_no)) {
            		$("#idcard_no_msg").text("请输入正确格式的身份证.").addClass("error_msg");
            		return;
            	} */
            	
            	$.post(
            		"findAccount.do",
            		{"idcardNo":idcard_no},
            		function(data) {
            			if(data == "") {
            				$("#idcard_no_msg").text("此身份证没有对应的账务账号.").addClass("error_msg");
            			} else {
            				$("#idcard_no_msg").text("有效的身份证.").removeClass("error_msg");
            				$("#login_name").val(data.loginUserName);
            				
            				$("#accountId").val(data.accountId);
            			}
            		}
            	);
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
            <div id="save_result_info" class="save_fail" id="operate_msg">保存失败！192.168.0.23服务器上已经开通过 OS 账号 “mary”。</div>
            <form action="addService.do" method="post" id="form1" class="main_form">
                <!--内容项-->
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" class="width180" id="idcard_no"/>
                  <!--   <input type="button" value="查询账务账号" class="btn_search_large" onclick="find_account();"/> -->
                    <span class="required">*</span>
                    <div class="validate_msg_short" id="idcard_no_msg"></div>
                </div>
                <div class="text_info clearfix"><span>账务账号：</span></div>
                <div class="input_info">
                	<select name="accountId">
                        <c:forEach items="${accounts }" var="a">
                        	<option value="${a.accountId }">${a.loginUserName }</option>
                        </c:forEach>
                    </select>   
                    <div class="validate_msg_long"></div>
                </div>
                <div class="text_info clearfix"><span>资费类型：</span></div>
                <div class="input_info">
                    <select name="costId">
                        <c:forEach items="${costs }" var="cost">
                        	<option value="${cost.costId }">${cost.name }</option>
                        </c:forEach>
                    </select>                        
                </div> 
                <div class="text_info clearfix"><span>服务器 IP：</span></div>
                <div class="input_info">
                    <input type="text" name="hostIp"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">15 长度，符合IP的地址规范</div>
                </div>                   
                <div class="text_info clearfix"><span>登录服务器账号：</span></div>
                <div class="input_info">
                    <input type="text" name="serverUserName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">8长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" name="password"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password"  />
                    <span class="required">*</span>
                    <div class="validate_msg_long">两次密码必须相同</div>
                </div>     
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save" />
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