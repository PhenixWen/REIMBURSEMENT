<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html class="js cssanimations"><head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>医疗报销系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp">
    <link rel="icon" type="image/png" href="/REIMBURSEMENT/page/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/REIMBURSEMENT/page/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI">
    <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/amazeui.min.css">
    <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/admin.css">
    <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/app.css">
    <script src="/REIMBURSEMENT/page/assets/js/echarts.min.js"></script>
    <script>
    	function check(id){
    		var p = confirm("确认删除此记录？");
    		if(p == true)
    		$.ajax({
    			url:"/REIMBURSEMENT/BingZhongDeleteServlet?diseId="+id,
    			type:"GET",
    			dataType:"text",
    			success:function(data){
    				if(data == "no"){
    					alert("无法删除该病种信息");
    					
    				}else{
    					alert("删除成功");
    					location.href="/REIMBURSEMENT/page/bingzhongquery.jsp"; 
    				}
    			},
    			error:function(){
    				alert("error");
    			}
    		});
    	}
    </script>
</head>

<body data-type="index">


<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <a href="javascript:;" class="tpl-logo">
            <img src="/REIMBURSEMENT/page/assets/img/logo.png" alt="">
        </a>
    </div>
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown="" data-am-dropdown-toggle="">

                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-success">5</span> 条提醒</h3><a href="###">全部</a></li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span>
                        【预览模块】移动端 查看时 手机、电脑框隐藏。</a>
                        <span class="tpl-dropdown-list-fr">3小时前</span>
                    </li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span>
                        移动端，导航条下边距处理</a>
                        <span class="tpl-dropdown-list-fr">15分钟前</span>
                    </li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span>
                        追加统计代码</a>
                        <span class="tpl-dropdown-list-fr">2天前</span>
                    </li>
                </ul>
            </li>
            <li class="am-dropdown" data-am-dropdown="" data-am-dropdown-toggle="">

                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-danger">9</span> 条新消息</h3><a href="###">全部</a></li>
                    <li>
                        <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="/REIMBURSEMENT/page/assets/img/user02.png" alt=""> </span>
                            <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> ${sessionScope.user }            </span>
                                <span class="tpl-dropdown-content-time">10分钟前 </span>
                                </span>
                            <span class="tpl-dropdown-content-font"> Amaze UI 的诞生，依托于 GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>
                        </a>
                        <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="/REIMBURSEMENT/page/assets/img/user03.png" alt=""> </span>
                            <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> Steam </span>
                                <span class="tpl-dropdown-content-time">18分钟前</span>
                                </span>
                            <span class="tpl-dropdown-content-font"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。 </span>
                        </a>
                    </li>

                </ul>
            </li>
            <li class="am-dropdown" data-am-dropdown="" data-am-dropdown-toggle="">

                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-primary">4</span> 个任务进度</h3><a href="###">全部</a></li>
                    <li>
                        <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">Amaze UI 用户中心 v1.2 </span>
                                <span class="percent">45%</span>
                                </span>
                            <span class="progress">
                        <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-success" style="width:45%"></div></div>
                    </span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">新闻内容页 </span>
                                <span class="percent">30%</span>
                                </span>
                            <span class="progress">
                       <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-secondary" style="width:30%"></div></div>
                    </span>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">管理中心 </span>
                                <span class="percent">60%</span>
                                </span>
                            <span class="progress">
                        <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-warning" style="width:60%"></div></div>
                    </span>
                        </a>
                    </li>

                </ul>
            </li>
            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

            <li class="am-dropdown" data-am-dropdown="" data-am-dropdown-toggle="">
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">${sessionScope.user }           </span><span class="tpl-header-list-user-ico"> <img src="/REIMBURSEMENT/page/assets/img/user01.png"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="/REIMBURSEMENT/page/login.jsp" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
        </ul>
    </div>
</header>


<div class="tpl-page-container tpl-page-header-fixed">


    <div class="tpl-left-nav tpl-left-nav-hover" style="display: block;">
        <div class="tpl-left-nav-title">业务信息列表</div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="/REIMBURSEMENT/page/index.jsp" class="nav-link active">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                    </a>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>医疗基本信息</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display: block;">
                        <li>
                            <a href="/REIMBURSEMENT/page/yaopinquery.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>药品信息</span>
                                <i></i>
                            </a>

                            <a href="/REIMBURSEMENT/page/zhenliaoquery.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>诊疗项目信息</span>


                            </a><a href="/REIMBURSEMENT/page/bingzhongquery.jsp">
                            <i class="am-icon-angle-right"></i>
                            <span>病种信息</span>


                        </a><a href="/REIMBURSEMENT/page/fuwuquery.jsp">
                            <i class="am-icon-angle-right"></i>
                            <span>服务设施项目信息</span>


                        </a><a href="/REIMBURSEMENT/page/jigouquery.jsp">
                            <i class="am-icon-angle-right"></i>
                            <span>定点医疗信息</span>

                        </a>
                        </li>
                    </ul>
                </li>


                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>医疗待遇计算参数维护</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display: none;">
                        <li>
                            <a href="/REIMBURSEMENT/page/fengdingquery.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>封顶线</span>
                                <i></i>
                            </a>

                            <a href="/REIMBURSEMENT/page/qifuquery.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>起付标准</span>


                            </a><a href="/REIMBURSEMENT/page/fenduanquery.jsp">
                            <i class="am-icon-angle-right"></i>
                            <span>个人分段自费比例</span>


                        </a>
                        </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>医疗待遇审批</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display: none;">
                        <li>
                            
            <a href="/REIMBURSEMENT/page/jigousp.jsp">
                <i class="am-icon-angle-right"></i>
                <span>人员就诊机构审批</span>
                <i></i>
            </a>







                            
            <a href="/REIMBURSEMENT/page/yaopinsp.jsp">
                <i class="am-icon-angle-right"></i>
                <span>特检特治审批</span>
            </a>










                        </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>医疗中心报销</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display: none;">
                        <li>
                            <a href="/REIMBURSEMENT/page/zxbx_index.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>中心报销</span>
                                <i></i>
                            </a>

                            <a href="/REIMBURSEMENT/page/cancel.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>取消报销</span>

                            </a>
                        </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>综合查询</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display: none;">
                        <li>
                            <a href="/REIMBURSEMENT/page/annual_baoxiao.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>医疗人员费用信息</span>
                                <i></i>
                            </a>


                        </li>
                    </ul>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>公共业务</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display: none;">
                        <li>
                            <a href="/REIMBURSEMENT/page/basical_institutions.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>单位基本信息</span>
                                <i></i>
                            </a>

                            <a href="/REIMBURSEMENT/page/basical_people.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>个人基本信息</span>

                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>


    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">医疗基本信息</div>
        <ol class="am-breadcrumb">
            <li><a href="/REIMBURSEMENT/page/index.jsp" class="am-icon-home">首页</a></li>
            <li><a href="/REIMBURSEMENT/page/bingzhongquery.jsp">病种信息</a></li>
        </ol>
        <div class="tpl-content-scope">

        </div>


        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span>病种信息
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">

                        </div>
                    </div>
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <form class="am-form  am-form-inline" method = "post" action = "/REIMBURSEMENT/BingZhongQueryServlet">
                        <label for="doc-ipt-pwd-1">病种编号：</label>
                        <div class="am-form-group">

                            <input type="text" id="doc-ipt-pwd-1" placeholder="编号" name = "diseId">
                        </div>

                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <label for="doc-ipt-pwd-1">病种名称：</label>
                        <div class="am-form-group">
                            <input type="text" class="" id="doc-ipt-pwd-1" placeholder="名称" name = "diseName">
                        </div>

                        <br><br>
						<input hidden = "hidden" name = "mark" value = "0">
                         <label for="user-phone" class="am-form-label">病种种类：</label>
	                    <div class="am-form-group">
	                        <select data-am-selected="{searchBox: 1, maxHeight: 100}" style="display: none;" name = "diseKind">
	                            <option value=""></option>
	                            <option value="传染病">传染病</option>
                                <option value="心理病">心理病</option>
                                <option value="肿瘤">肿瘤</option>
                                <option value="心血管疾病">心血管疾病</option>
                                <option value="空调病">空调病</option>
                                <option value="精神病">精神病</option>
                                <option value="消化系统疾病">消化系统疾病</option>
                                <option value="泌尿生殖系统疾病">泌尿生殖系统疾病</option>
	                        </select>
	                    </div>
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <button type="submit" class="am-btn am-btn-primary">查询</button>
                        <button type="button" class="am-btn am-btn-primary am-btn-success" onclick="window.open('/REIMBURSEMENT/page/bingzhongadd.jsp')">
                            <span class="am-icon-plus"></span><span>新增</span>
                        </button>


                    </form>





                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-type">病种编号</th>
                                    <th class="table-type">病种名称</th>
                                    <th class="table-type">病种种类</th>
                                    <th class="table-type">病种报销标志</th>
                                    <th class="table-type">备注</th>
                                    <th class="table-set">操作</th>
                                </tr>
                                </thead>
                                <tbody>
<!--                                 <tr> -->
<%--                                      <c:forEach items = "${requestScope.bingzhonglist }" var = "b"> --%>
<!--                                      	<tr> -->
<%--                                      		<td>${b.diseId }</td> --%>
<%-- 	                                    	<td>${b.diseName }</td> --%>
<%-- 	                                    	<td>${b.diseKind }</td> --%>
<%-- 	                                    	<td>${b.diseM }</td> --%>
<%-- 	                                    	<td>${b.remarks }</td> --%>
<!-- 	                                    	<td> -->
<!-- 		                                        <div class="am-btn-toolbar"> -->
<!-- 		                                            <div class="am-btn-group am-btn-group-xs"> -->
<%-- 		                                                <button type = "button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="window.location.href='/REIMBURSEMENT/BingZhongUpdate1Servlet?diseId=${b.diseId }'"><span --%>
<!-- 		                                                        class="am-icon-pencil-square-o"></span>编辑 -->
<!-- 		                                                </button> -->
<%-- 		                                                <button type = "button" class="am-btn am-btn-default am-btn-xs am-hide-sm-only" onclick="window.location.href='/REIMBURSEMENT/BingZhongDetailServlet?diseId=${b.diseId }'"><span --%>
<!-- 		                                                        class="am-icon-copy"></span>详情 -->
<!-- 		                                                </button> -->
<%-- 		                                                <button type = "button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="window.location.href='/REIMBURSEMENT/BingZhongDeleteServlet?diseId=${b.diseId }'"> --%>
<!-- 		                                                    <span class="am-icon-trash-o"></span>删除 -->
<!-- 		                                                </button> -->
<!-- 		                                            </div> -->
<!-- 		                                        </div> -->
<!-- 		                                    </td> -->
<!--                                      	</tr> -->
<%--                                      </c:forEach> --%>
<!--                                 </tr> -->
									<c:forEach items="${requestScope.bingzhonglist}" var="b">
								    <tr>
								        <td>${b.diseId }</td>
								        <td>${b.diseName}</td>
								        <td>${b.diseKind }</td>
								        <td>${b.diseM }</td>
								        <td>${b.remarks }</td>
								        <td>
	                                         <div class="am-btn-toolbar">
		                                            <div class="am-btn-group am-btn-group-xs">
		                                                <button type = "button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="window.location.href='/REIMBURSEMENT/BingZhongUpdate1Servlet?diseId=${b.diseId }'"><span
		                                                        class="am-icon-pencil-square-o"></span>编辑
		                                                </button>
		                                                <button type = "button" class="am-btn am-btn-default am-btn-xs am-hide-sm-only" onclick="window.location.href='/REIMBURSEMENT/BingZhongDetailServlet?diseId=${b.diseId }'"><span
		                                                        class="am-icon-copy"></span>详情
		                                                </button>
		                                                <button type = "button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="check(${b.diseId })">
		                                                    <span class="am-icon-trash-o"></span>删除
		                                                </button>
		                                            </div>
		                                        </div>
	                                    </td>
								    </tr>
								    </c:forEach>
                                </tbody>
                            </table>
                            <div class="am-cf">
                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination am-pagination-centered">
                                   
									
                                    <c:forEach begin="1" step="1" end="${requestScope.pages}" var="i">
                                    
									    <c:if test="${i eq requestScope.curpage }">
									    	<li class="am-active">
									    	<a href="/REIMBURSEMENT/BingZhongQueryServlet?page=${i }&diseId=${requestScope.diseId}&diseName=${requestScope.diseName}&diseKind=${requestScope.diseKind}&mark=1">${i }</a>
									    	</li>
									    </c:if>
									    
									    <c:if test="${i ne requestScope.curpage }">
									    	<li>
									    	<a href="/REIMBURSEMENT/BingZhongQueryServlet?page=${i }&diseId=${requestScope.diseId}&diseName=${requestScope.diseName}&diseKind=${requestScope.diseKind}&mark=1">${i }</a>
									    	</li>
									    </c:if>
									    
                                    </c:forEach>
                                    
                                        
                                    </ul>
                                </div>
                            </div>
                            <hr>

                        </form>
                    </div>

                </div>
            </div>
            <div class="tpl-alert"></div>
        </div>


    </div>

</div>



<script src="/REIMBURSEMENT/page/assets/js/jquery.min.js"></script>
<script src="/REIMBURSEMENT/page/assets/js/amazeui.min.js"></script>
<script src="/REIMBURSEMENT/page/assets/js/iscroll.js"></script>
<script src="/REIMBURSEMENT/page/assets/js/app.js"></script>


</body></html>                                                   











































































































































































































































































































































































































































































































































































