<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>CSCBMS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
		<script language="javascript" type="text/javascript" src="../js/jquery-1.11.1.js"></script>
        <script language="javascript" type="text/javascript">
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //重置密码
            function resetPwd() {
            	var checkObjs = $(":checkbox[name='check_admin']:checked");
            	if(checkObjs.length == 0) {
            		alert("请至少选择一个管理员.");
            		return;
            	}
            	
            	var ids = new Array();
            	for(var i=0;i<checkObjs.length;i++){
            		var trObj = checkObjs.eq(i).parent().parent();
            		var tdObj = trObj.children().eq(1);
            		ids.push(tdObj.text());
            	}
            	
            	$.post(
            		"resetPassword.do",
            		{"ids":ids.toString()},
            		function(data) {
            			// 提示信息
            			$("#operate_msg").text(data.message);
            			$("#operate_result_info").show();
            			// 等待2S，关闭提示信息
            			setTimeout(function(){
            				$("#operate_result_info").hide();
            			}, 2000);
            		}
            	);
            }
            //删除
            function deleteAdmin(id) {
                var r = window.confirm("确定要删除此管理员吗？");
                if(r) {
                	window.location.href = "deleteAdmin.do?adminId="+id;
                }
            }
            //全选
            function selectAdmins(inputObj) {
                var inputArray = document.getElementById("datalist").getElementsByTagName("input");
                for (var i = 1; i < inputArray.length; i++) {
                    if (inputArray[i].type == "checkbox") {
                        inputArray[i].checked = inputObj.checked;
                    }
                }
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
            <form action="findAdmin.do" method="post">
            	<input type="hidden" name="currentPage" value="1" />
            	
                <!--查询-->
                <div class="search_add">
                    <div>
                        	模块：
                        <select name="moduleId" id="selModules" class="select_search">
                            <option value="">全部</option>
                            <c:forEach items="${modules }" var="module">
                            	<option value="${module.moduleId }"  <c:if test="${module.moduleId==adminPage.moduleId }">selected</c:if>>${module.name }</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>角色：<input type="text" name="roleName" value="${adminPage.roleName }" class="text_search width200" /></div>
                    <div><input type="submit" value="搜索" class="btn_search" /></div>
                    <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();" />
                    <input type="button" value="增加" class="btn_add" onclick="location.href='toAddAdmin.do';" />
                </div>
                <!--删除和密码重置的操作提示-->
                <div id="operate_result_info" class="operate_fail">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span id="operate_msg">删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->
                </div>
                <!--数据区域：用表格展示数据-->
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="th_select_all">
                                <input type="checkbox" onclick="selectAdmins(this);" />
                                <span>全选</span>
                            </th>
                            <th>管理员ID</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th class="width100">拥有角色</th>
                            <th></th>
                        </tr>                      
                        <c:forEach items="${admins }" var="admin">
	                        <tr>
	                            <td><input type="checkbox" name="check_admin"/></td>
	                            <td>${admin.adminId }</td>
	                            <td>${admin.name }</td>
	                            <td>${admin.adminCode }</td>
	                            <td>${admin.telephone }</td>
	                            <td>${admin.email }</td>
	                            <td><fmt:formatDate value="${admin.enrollDate }" pattern="yyyy-MM-dd"/></td>
	                            <td>
	                                <a class="summary" onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">
	                                	<c:forEach items="${admin.roles }" var="role" varStatus="status">
	                                    	<c:choose>
	                                    		<c:when test="${status.first }">
	                                    			${role.name }
	                                    		</c:when>
	                                    		<c:when test="${status.index==1 }">
	                                    			...
	                                    		</c:when>
	                                    	</c:choose>
	                                    </c:forEach>
	                                </a>
	                                <!--浮动的详细信息-->
	                                <div class="detail_info">
	                                    <c:forEach items="${admin.roles }" var="role" varStatus="status">
	                                    	<c:choose>
	                                    		<c:when test="${status.last }">
	                                    			${role.name }
	                                    		</c:when>
	                                    		<c:otherwise>
	                                    			${role.name }、
	                                    		</c:otherwise>
	                                    	</c:choose>
	                                    </c:forEach>
	                                </div>
	                            </td>
	                            <td class="td_modi">
	                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateAdmin.do?id=${admin.adminId }';" />
	                                <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin(${admin.adminId });" />
	                            </td>
	                        </tr>
                       </c:forEach>
                    </table>
                </div>
                <!--分页-->
                <div id="pages">
                	<c:choose>
                		<c:when test="${adminPage.currentPage==1 }">
                			<a href="#">上一页</a>
                		</c:when>
                		<c:otherwise>
                			<a href="findAdmin.do?currentPage=${adminPage.currentPage-1 }">上一页</a>
                		</c:otherwise>
                	</c:choose>
        	        
        	        <c:forEach begin="1" end="${adminPage.totalPage }" var="p">
        	        	<c:choose>
        	        		<c:when test="${p==adminPage.currentPage }">
        	        			<a href="findAdmin.do?currentPage=${p }" class="current_page">${p }</a>
        	        		</c:when>
        	        		<c:otherwise>
        	        			<a href="findAdmin.do?currentPage=${p }">${p }</a>
        	        		</c:otherwise>
        	        	</c:choose>
                    </c:forEach>
                    
                    <c:choose>
                		<c:when test="${adminPage.currentPage==adminPage.totalPage }">
                			<a href="#">下一页</a>
                		</c:when>
                		<c:otherwise>
                			<a href="findAdmin.do?currentPage=${adminPage.currentPage+1 }">下一页</a>
                		</c:otherwise>
                	</c:choose>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[简单不先于复杂，而是在复杂之后]</p>
            <p>版权所有(C)brother</p>
        </div>
    </body>
</html>