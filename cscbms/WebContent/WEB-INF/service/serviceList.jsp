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
			//开通
            function start_service(id) {
            	var r = window.confirm("确定要开通此业务账号吗？");
            	if(!r) return;
            	//采用异步的方式，开通业务账号
            	$.post(
            		"startService.do",
            		{"serviceId":id},
            		function(data) {
            			//设置提示信息
            			$("#operate_msg").text(data.message);
            			//显示出提示信息
            			$("#operate_result_info").show();
            			//延迟2s刷新
           				setTimeout(function(){
	            			//如果开通成功，刷新页面
	            			if(data.success) {
            					//刷新当前页
            					location.href = "findService.do";
	            			} else {
	            				$("#operate_result_info").hide();
	            			}
            			}, 1000);
            		}
            	);
            }            
            //暂停
            function pause_service(id) {
            	var r = window.confirm("确定要暂停此业务账号吗？");
            	if(!r) return;
            	//采用异步的方式，暂停业务账号
            	$.post(
            		"pauseService.do",
            		{"serviceId":id},
            		function(data) {
            			//设置提示信息
            			$("#operate_msg").text(data.message);
            			//显示出提示信息
            			$("#operate_result_info").show();
           				//延迟2s刷新
           				setTimeout(function(){
	            			//如果暂停成功，刷新页面
	            			if(data.success) {
            					//刷新当前页
            					location.href = "findService.do";
	            			} else {
	            				$("#operate_result_info").hide();
	            			}
            			}, 1000);
            		}
            	);
            }
            //删除
            function delete_service(id) {
            	var r = window.confirm("确定要删除此业务账号吗？");
            	if(!r) return;
            	//采用异步的方式，删除业务账号
            	$.post(
            		"deleteService.do",
            		{"serviceId":id},
            		function(data) {
            			//设置提示信息
            			$("#operate_msg").text(data.message);
            			//显示出提示信息
            			$("#operate_result_info").show();
           				//延迟2s刷新
           				setTimeout(function(){
	            			//如果删除成功，刷新页面
	            			if(data.success) {
            					//刷新当前页
            					location.href = "findService.do";
	            			} else {
	            				$("#operate_result_info").hide();
	            			}
            			}, 1000);
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
            <form action="findService.do" method="post">
            	<input type="hidden" name="currentPage" value="1"/>
                <!--查询-->
                <div class="search_add">                        
                    <div>姓名：<input type="text" name="serverUserName" value="${servicePage.serverUserName }" class="width100 text_search" /></div>                            
                    <div>服务器 IP：<input type="text" name="hostIp" value="${servicePage.hostIp }" class="width100 text_search" /></div>
                    <div>身份证：<input type="text" name="idcardNo" value="${servicePage.idcardNo }" class="text_search" /></div>
                    <div>状态：
                        <select class="select_search" name="status">
                            <option value="-1">全部</option>
                            <option value="0" <c:if test="${servicePage.status==0 }">selected</c:if>>开通</option>
                            <option value="1" <c:if test="${servicePage.status==1 }">selected</c:if>>暂停</option>
                            <option value="2" <c:if test="${servicePage.status==2 }">selected</c:if>>删除</option>
                        </select>
                    </div>
                    <div><input type="submit" value="搜索" class="btn_search" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='toAddService.do';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    <span id="operate_msg"></span>
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">业务ID</th>
                        <th class="width70">账务账号ID</th>
                        <th class="width150">身份证</th>
                        <th class="width70">姓名</th>
                        <th>云服务器账号</th>
                        <th class="width50">状态</th>
                        <th class="width100">服务器 IP</th>
                        <th class="width100">资费</th>                                                        
                        <th class="width200">操作</th>
                    </tr>
                    <c:forEach items="${services }" var="service">
	                    <tr>
	                        <td>${service.serviceId }</td>
	                        <td>${service.accountId }</td>
	                        <td>${service.idcardNo }</td>
	                        <td>${service.realName }</td>
	                        <td>${service.serverUserName }</td>
	                        <td>
	                        	<c:choose>
	                        		<c:when test="${service.status==0 }">
	                        			开通
	                        		</c:when>
	                        		<c:when test="${service.status==1 }">
	                        			暂停
	                        		</c:when>
	                        		<c:otherwise>
	                        			删除
	                        		</c:otherwise>
	                        	</c:choose>
	                        </td>
	                        <td>${service.hostIp }</td>
	                        <td>
	                            <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${service.costName }</a>
	                            <!--浮动的详细信息-->
	                            <div class="detail_info">
	                                ${service.descr }
	                            </div>
	                        </td>                            
	                        <td class="td_modi">
	                        	<c:choose>
	                        		<c:when test="${service.status==0 }">
	                        			<input type="button" value="暂停" class="btn_pause" onclick="pause_service(${service.serviceId });" />
			                            <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateService.do?id=${service.serviceId}';" />
			                            <input type="button" value="删除" class="btn_delete" onclick="delete_service(${service.serviceId });" />
	                        		</c:when>
	                        		<c:when test="${service.status==1 }">
	                        			<input type="button" value="开通" class="btn_start" onclick="start_service(${service.serviceId });" />
			                            <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateService.do?id=${service.serviceId}';" />
			                            <input type="button" value="删除" class="btn_delete" onclick="delete_service(${service.serviceId });" />
	                        		</c:when>
	                        		<c:otherwise>
	                        			
	                        		</c:otherwise>
	                        	</c:choose>
	                        </td>
	                    </tr>
                    </c:forEach>                                                              
                </table>                
                <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
                </div>                    
                <!--分页-->
                <div id="pages">
                    <a href="findService.do?currentPage=1">首页</a>
                	<c:choose>
                		<c:when test="${servicePage.currentPage==1 }">
                			<a href="#">上一页</a>
                		</c:when>
                		<c:otherwise>
                			<a href="findService.do?currentPage=${servicePage.currentPage-1 }">上一页</a>
                		</c:otherwise>
                	</c:choose>
        	        
        	        <c:forEach begin="1" end="${servicePage.totalPage }" var="p">
        	        	<c:choose>
        	        		<c:when test="${p==servicePage.currentPage }">
        	        			<a href="findService.do?currentPage=${p }" class="current_page">${p }</a>
        	        		</c:when>
        	        		<c:otherwise>
        	        			<a href="findService.do?currentPage=${p }">${p }</a>
        	        		</c:otherwise>
        	        	</c:choose>
                    </c:forEach>
                    
                    <c:choose>
                		<c:when test="${servicePage.currentPage==servicePage.totalPage }">
                			<a href="#">下一页</a>
                		</c:when>
                		<c:otherwise>
                			<a href="findService.do?currentPage=${servicePage.currentPage+1 }">下一页</a>
                		</c:otherwise>
                	</c:choose>
                    <a href="findService.do?currentPage=${servicePage.totalPage }">末页</a>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[简单不先于复杂，而是在复杂之后]</p>
            <p>版权所有(C)brother </p>
        </div>
    </body>
</html>