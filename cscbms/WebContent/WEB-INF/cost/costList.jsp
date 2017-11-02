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
        	//自动加载
        	$(function(){
        		var baseDurationSort = $("#baseDurationSort").val();
        		var baseCostSort = $("#baseCostSort").val();
        		if(baseDurationSort != "") {
	        		$("#baseDuration").attr("class","sort_"+baseDurationSort);
        		}
        		if(baseCostSort != "") {
	        		$("#baseCost").attr("class","sort_"+baseCostSort);
        		}
        	});
            //排序按钮的点击事件
            function sort(btnObj) {
                if (btnObj.className == "sort_desc") {
                    //btnObj.className = "sort_asc";
                	$("#"+btnObj.id+"Sort").val("asc");
                } else {
                    //btnObj.className = "sort_desc";
                	$("#"+btnObj.id+"Sort").val("desc");
                }
                $("#costForm").submit();
            }

            //启用
            function startFee(id) {
                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
                if(r) {
               		window.location.href = "startFee.do?id="+id;
               	}
            }
            //删除
            function deleteFee(id) {
                var r = window.confirm("确定要删除此资费吗？");
               	if(r) {
               		window.location.href = "deleteCost.do?id="+id;
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
                <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_on"></a></li>
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
            <form action="findCost.do" method="post" id="costForm">
                <!--排序-->
                <div class="search_add">
                    <div>
                    	<input type="hidden" name="currentPage" value="1"/>
                    	<input type="hidden" name="baseDurationSort" id="baseDurationSort" value="${costPage.baseDurationSort}"/>
                    	<input type="hidden" name="baseCostSort" id="baseCostSort" value="${costPage.baseCostSort}"/>
                    
                        <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                        <input type="button" value="基费" id="baseDuration" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="时长" id="baseCost" class="sort_asc" onclick="sort(this);" />
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='toAddCost.do';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>                     
                        <c:forEach items="${costs }" var="cost">
	                        <tr>
	                            <td>${cost.costId }</td>
	                            <td>${cost.name }</a></td>
	                            <td>${cost.baseDuration }</td>
	                            <td>${cost.baseCost }</td>
	                            <td>${cost.unitCost }</td>
	                            <td><fmt:formatDate value="${cost.creatTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                            <td><fmt:formatDate value="${cost.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                            <td>
	                            	<c:choose>
	                            		<c:when test="${cost.status==1 }">开通</c:when>
	                            		<c:otherwise>暂停</c:otherwise>
	                            	</c:choose>
	                            </td>
	                            <td>
	                            	<c:choose>
	                            		<c:when test="${cost.status==1 }"></c:when>
	                            		<c:otherwise>
		                            		<input type="button" value="启用" class="btn_start" onclick="startFee(${cost.costId});" />
			                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateCost.do?id=${cost.costId}';" />
			                                <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${cost.costId});" />
			                             </c:otherwise>
	                            	</c:choose>                                
	                                
	                            </td>
	                        </tr>
                        </c:forEach>
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div id="pages">
                	<c:choose>
                		<c:when test="${costPage.currentPage==1 }">
                			<a href="#">上一页</a>
                		</c:when>
                		<c:otherwise>
                			<a href="findCost.do?currentPage=${costPage.currentPage-1 }">上一页</a>
                		</c:otherwise>
                	</c:choose>
        	        
        	        <c:forEach begin="1" end="${costPage.totalPage }" var="p">
        	        	<c:choose>
        	        		<c:when test="${p==costPage.currentPage }">
        	        			<a href="findCost.do?currentPage=${p }" class="current_page">${p }</a>
        	        		</c:when>
        	        		<c:otherwise>
        	        			<a href="findCost.do?currentPage=${p }">${p }</a>
        	        		</c:otherwise>
        	        	</c:choose>
                    </c:forEach>
                    
                    <c:choose>
                		<c:when test="${costPage.currentPage==costPage.totalPage }">
                			<a href="#">下一页</a>
                		</c:when>
                		<c:otherwise>
                			<a href="findCost.do?currentPage=${costPage.currentPage+1 }">下一页</a>
                		</c:otherwise>
                	</c:choose>
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