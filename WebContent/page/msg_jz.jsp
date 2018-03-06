<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>医疗报销系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="/REIMBURSEMENT/page/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/REIMBURSEMENT/page/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/admin.css">
    <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/app.css">
    <script type="text/javascript">
    function del(solveId, personId)
    {
    	var r=confirm("确定删除此次就诊记录？")
    	if (r==true)
      	{
    		window.location.href='/REIMBURSEMENT/del_jz?solveId='+solveId+'&personId='+personId;
	    }
    }
    </script>
</head>


<body data-type="generalComponents">


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

            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
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
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display: none;">
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
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display: block;">
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
        <div class="tpl-content-page-title">医疗中心报销</div>
        <ol class="am-breadcrumb">
            <li><a href="/REIMBURSEMENT/page/index.jsp" class="am-icon-home">首页</a></li>
            <li><a href="/REIMBURSEMENT/page/zxbx_index.jsp">中心报销</a></li>
            <li class="am-active">就诊资料信息</li>
        </ol>

        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> ${requestScope.personName} 的就诊资料信息
                </div>
            </div>
            <button type="button" class="am-btn am-btn-primary am-btn-success" onclick="window.open('/REIMBURSEMENT/page/add_jz.jsp?personId=${requestScope.personId}&personName=${requestScope.personName}')" >
                <span class="am-icon-plus"></span><span>新增</span>
            </button>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table style="padding-left:.1rem;padding-right:.1rem;" class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th style="padding-left:.1rem;padding-right:.1rem;" class="table-title">住院号</th>
                                    <th style="padding-left:.1rem;padding-right:.1rem;" class="table-title">医疗机构</th>
                                    <th style="padding-left:.1rem;padding-right:.1rem;" class="table-title">医院等级</th>
                                    <th style="padding-left:.1rem;padding-right:.1rem;" class="table-title">病种名称</th>
                                    <th style="padding-left:.1rem;padding-right:.1rem;" class="table-title">报销标志</th>
                                    <th style="padding-left:.1rem;padding-right:.1rem;" class="table-title">入院日期</th>
                                    <th style="padding-left:.1rem;padding-right:.1rem;" class="table-title">出院日期</th>
                                    <th style="padding-left:.1rem;padding-right:.1rem;" class="table-title">出院原因</th>
                                    <th style="padding-left:.1rem;padding-right:.1rem;" class="table-title">是否结算</th>
                                    <th style="padding-left:12rem;padding-right:11rem;" class="table-title">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.jiuzhens}" var="j">
                                <tr>
                                    <td>${j.solveId}</td>
                                    <td>${j.compName}</td>
                                    <td>${j.hosRank}</td>
                                    <td>${j.diseName}</td>
                                    <td>${j.diseM}</td>
                                    <td>${j.inDate}</td>
                                    <td>${j.outDate}</td>
                                    <td>${j.outReason}</td>
                                    <td>${j.settlement}</td>
                                    <td>                                     
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                            	<c:if test="${j.settlement == '未结算'}">
                                            	<button type="button" style="padding-left:.6rem;padding-right:.6rem;"class="am-btn am-btn-default am-btn-xs am-text-success" onclick="window.open('/REIMBURSEMENT/pre_solve?solveId=${j.solveId}&personId=${requestScope.personId}')"><span class="am-icon-rmb"></span>预结算</button>                                       
                                                <button type="button" style="padding-left:.6rem;padding-right:.6rem;"class="am-btn am-btn-default am-btn-xs am-text-primary" onclick="window.open('/REIMBURSEMENT/msg_cf?solveId=${j.solveId}&personId=${requestScope.personId}')"><span class="am-icon-medkit"></span>处方</button>
                                                <button type="button" style="padding-left:.6rem;padding-right:.6rem;"class="am-btn am-btn-default am-btn-xs am-text-primary" onclick="window.open('/REIMBURSEMENT/msg_zlxm?solveId=${j.solveId}&personId=${requestScope.personId}')"><span class="am-icon-stethoscope"></span>诊疗</button>
                                                <button type="button" style="padding-left:.6rem;padding-right:.6rem;"class="am-btn am-btn-default am-btn-xs am-text-primary" onclick="window.open('/REIMBURSEMENT/msg_fwss?solveId=${j.solveId}&personId=${requestScope.personId}')"><span class="am-icon-wheelchair"></span>服务</button>
                                                <button type="button" style="padding-left:.6rem;padding-right:.6rem;"class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="window.open('/REIMBURSEMENT/edi_jz1?personName=${requestScope.personName}&solveId=${j.solveId}&personId=${requestScope.personId}')"><span class="am-icon-pencil-square-o"></span>更新</button>
                                                <button type="button" style="padding-left:.6rem;padding-right:.6rem;"class="am-btn am-btn-default am-btn-xs am-text-danger" onclick="del(${j.solveId},${requestScope.personId})" ><span class="am-icon-trash-o"></span>删除</button>
												</c:if>
                                                <c:if test="${j.settlement == '已结算'}">
                                                <button style="margin-left:35px;" type="button" class="am-btn am-btn-default am-btn-xs am-text-success" onclick="window.open('/REIMBURSEMENT/pre_solve2?solveId=${j.solveId}&personId=${requestScope.personId}')"><span class="am-icon-rmb"></span>结算单</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-primary" onclick="window.open('/REIMBURSEMENT/msg_cf?solveId=${j.solveId}&personId=${requestScope.personId}&settlement=1')"><span class="am-icon-medkit"></span>处方</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-primary" onclick="window.open('/REIMBURSEMENT/msg_zlxm?solveId=${j.solveId}&personId=${requestScope.personId}&settlement=1')"><span class="am-icon-stethoscope"></span>诊疗</button>
                                                <button type="button" class="am-btn am-btn-default am-btn-xs am-text-primary" onclick="window.open('/REIMBURSEMENT/msg_fwss?solveId=${j.solveId}&personId=${requestScope.personId}&settlement=1')"><span class="am-icon-wheelchair"></span>服务</button>
                                                </c:if>       
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                   <c:forEach begin="1" step="1" end="${requestScope.pages}" var="i">
                                    
									    <c:if test="${i eq requestScope.pagenow}">
									    	<li class="am-active">
									    	<a href="/REIMBURSEMENT/msg_jz?page=${i}&personId=${requestScope.personId}">${i}</a>
									    	</li>
									    </c:if>
									    
									    <c:if test="${i ne requestScope.pagenow}">
									    	<li>
									    	<a href="/REIMBURSEMENT/msg_jz?page=${i}&personId=${requestScope.personId}">${i}</a>
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
        </div>
    </div>
</div>


<script src="/REIMBURSEMENT/page/assets/js/jquery.min.js"></script>
<script src="/REIMBURSEMENT/page/assets/js/amazeui.min.js"></script>
<script src="/REIMBURSEMENT/page/assets/js/app.js"></script>
</body></html>  