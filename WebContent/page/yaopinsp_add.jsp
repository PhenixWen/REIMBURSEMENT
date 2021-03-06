<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html class="js cssanimations">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>医疗报销系统</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp">
<link rel="icon" type="image/png"
	href="/REIMBURSEMENT/page/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="/REIMBURSEMENT/page/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI">
<link rel="stylesheet"
	href="/REIMBURSEMENT/page/assets/css/amazeui.min.css">
<link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/admin.css">
<link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/app.css">
<script src="/REIMBURSEMENT/page/assets/js/echarts.min.js"></script>
<script src="/REIMBURSEMENT/page/assets/js/jquery.min.js"></script>
<script>

	$(function(){
		$('#Id').blur(function() {
			var Id = $('#Id').val();
			$.ajax({
				url : "/REIMBURSEMENT/AjaxCheckRealPersonID?no=" + Id,
				type : "GET",
				dataType : "text",
				success : function(data) {
					if (data == "no"){
						$("#divId").attr("class", "am-form-group am-form-error am-form-icon am-form-feedback");
						$("#spanId").attr("class", "am-icon-times");
						$("#spanId").html("个人编号不存在");
						$("#Name").val("");
					}
					else {
						$("#divId").attr("class", "am-form-group am-form-success am-form-icon am-form-feedback");
						$("#spanId").attr("class", "am-icon-check");
						
						$("#spanId").html("");
						$("#Name").val(data);
					}
				},
				error : function() {}
			});
		})
	});
	

	$(function() {
		$.ajax({
			url : "/REIMBURSEMENT/add_cf_ajax",
			type : "GET",
			dataType : "json",
			success : function(data) {
				var str = "";
				$(data).each(
						function(i, p) {
							str = str + "<option value=" + p.mediName + ">"
									+ p.mediName + "</option>";
						});
				$("#medi").html(str);
			},
			error : function() {
				alert("error");
			}
		});
	});
	

	
	function check() {
		if ($("#divId").hasClass("am-form-success")) {
			if($("#stdate").val() == '' || $("#eddate").val() == ''){
				alert("日期为空");
				return false;
			}
			return true;
		} else {
			alert("个人编号填写错误");
			return false;
		}
	}
</script>
</head>

<body data-type="index">


	<header class="am-topbar am-topbar-inverse admin-header">
		<div class="am-topbar-brand">
			<a href="javascript:;" class="tpl-logo"> <img
				src="/REIMBURSEMENT/page/assets/img/logo.png" alt="">
			</a>
		</div>
		<div
			class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

		</div>

		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

			<ul
				class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
				<li class="am-dropdown" data-am-dropdown=""
					data-am-dropdown-toggle="">

					<ul class="am-dropdown-content tpl-dropdown-content">
						<li class="tpl-dropdown-content-external">
							<h3>
								你有 <span class="tpl-color-success">5</span> 条提醒
							</h3>
							<a href="###">全部</a>
						</li>
						<li class="tpl-dropdown-list-bdbc"><a href="#"
							class="tpl-dropdown-list-fl"><span
								class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span>
								【预览模块】移动端 查看时 手机、电脑框隐藏。</a> <span class="tpl-dropdown-list-fr">3小时前</span>
						</li>
						<li class="tpl-dropdown-list-bdbc"><a href="#"
							class="tpl-dropdown-list-fl"><span
								class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span>
								移动端，导航条下边距处理</a> <span class="tpl-dropdown-list-fr">15分钟前</span></li>
						<li class="tpl-dropdown-list-bdbc"><a href="#"
							class="tpl-dropdown-list-fl"><span
								class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span>
								追加统计代码</a> <span class="tpl-dropdown-list-fr">2天前</span></li>
					</ul>
				</li>
				<li class="am-dropdown" data-am-dropdown=""
					data-am-dropdown-toggle="">

					<ul class="am-dropdown-content tpl-dropdown-content">
						<li class="tpl-dropdown-content-external">
							<h3>
								你有 <span class="tpl-color-danger">9</span> 条新消息
							</h3>
							<a href="###">全部</a>
						</li>
						<li><a href="#" class="tpl-dropdown-content-message"> <span
								class="tpl-dropdown-content-photo"> <img
									src="/REIMBURSEMENT/page/assets/img/user02.png" alt="">
							</span> <span class="tpl-dropdown-content-subject"> <span
									class="tpl-dropdown-content-from"> ${sessionScope.user }            </span> <span
									class="tpl-dropdown-content-time">10分钟前 </span>
							</span> <span class="tpl-dropdown-content-font"> Amaze UI 的诞生，依托于
									GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>
						</a> <a href="#" class="tpl-dropdown-content-message"> <span
								class="tpl-dropdown-content-photo"> <img
									src="/REIMBURSEMENT/page/assets/img/user03.png" alt="">
							</span> <span class="tpl-dropdown-content-subject"> <span
									class="tpl-dropdown-content-from"> Steam </span> <span
									class="tpl-dropdown-content-time">18分钟前</span>
							</span> <span class="tpl-dropdown-content-font"> 为了能最准确的传达所描述的问题，
									建议你在反馈时附上演示，方便我们理解。 </span>
						</a>
					</ul>
				</li>
				<li class="am-dropdown" data-am-dropdown=""
					data-am-dropdown-toggle="">

					<ul class="am-dropdown-content tpl-dropdown-content">
						<li class="tpl-dropdown-content-external">
							<h3>
								你有 <span class="tpl-color-primary">4</span> 个任务进度
							</h3>
							<a href="###">全部</a>
						</li>
						<li><a href="javascript:;"
							class="tpl-dropdown-content-progress"> <span class="task">
									<span class="desc">Amaze UI 用户中心 v1.2 </span> <span
									class="percent">45%</span>
							</span> <span class="progress">
									<div class="am-progress tpl-progress am-progress-striped">
										<div class="am-progress-bar am-progress-bar-success"
											style="width: 45%"></div>
									</div>
							</span>
						</a></li>
						<li><a href="javascript:;"
							class="tpl-dropdown-content-progress"> <span class="task">
									<span class="desc">新闻内容页 </span> <span class="percent">30%</span>
							</span> <span class="progress">
									<div class="am-progress tpl-progress am-progress-striped">
										<div class="am-progress-bar am-progress-bar-secondary"
											style="width: 30%"></div>
									</div>
							</span>
						</a></li>
						<li><a href="javascript:;"
							class="tpl-dropdown-content-progress"> <span class="task">
									<span class="desc">管理中心 </span> <span class="percent">60%</span>
							</span> <span class="progress">
									<div class="am-progress tpl-progress am-progress-striped">
										<div class="am-progress-bar am-progress-bar-warning"
											style="width: 60%"></div>
									</div>
							</span>
						</a></li>

					</ul>
				</li>
				<li class="am-hide-sm-only"><a href="javascript:;"
					id="admin-fullscreen" class="tpl-header-list-link"><span
						class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

				<li class="am-dropdown" data-am-dropdown=""
					data-am-dropdown-toggle=""><a
					class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
						<span class="tpl-header-list-user-nick">${sessionScope.user }           </span><span
						class="tpl-header-list-user-ico"> <img
							src="/REIMBURSEMENT/page/assets/img/user01.png"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
						<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
						<li><a href="#"><span class="am-icon-power-off"></span>
								退出</a></li>
					</ul></li>
				<li><a href="/REIMBURSEMENT/page/login.jsp" class="tpl-header-list-link"><span
						class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
			</ul>
		</div>
	</header>


	<div class="tpl-page-container tpl-page-header-fixed">


		<div class="tpl-left-nav tpl-left-nav-hover">
			<div class="tpl-left-nav-title">业务信息列表</div>
			<div class="tpl-left-nav-list">
				<ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><a
						href="/REIMBURSEMENT/page/index.jsp" class="nav-link active">
							<i class="am-icon-home"></i> <span>首页</span>
					</a></li>
					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-table"></i> <span>医疗基本信息</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" style="display: none;">
							<li><a href="/REIMBURSEMENT/page/yaopinquery.jsp"> <i
									class="am-icon-angle-right"></i> <span>药品信息</span> <i></i>
							</a> <a href="/REIMBURSEMENT/page/zhenliaoquery.jsp"> <i
									class="am-icon-angle-right"></i> <span>诊疗项目信息</span>


							</a><a href="/REIMBURSEMENT/page/bingzhongquery.jsp"> <i
									class="am-icon-angle-right"></i> <span>病种信息</span>



							</a><a href="/REIMBURSEMENT/page/fuwuquery.jsp"> <i
									class="am-icon-angle-right"></i> <span>服务设施项目信息</span>



							</a><a href="/REIMBURSEMENT/page/jigouquery.jsp"> <i
									class="am-icon-angle-right"></i> <span>定点医疗信息</span>
							</a></li>
						</ul></li>


					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-table"></i> <span>医疗待遇计算参数维护</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" style="display: none;">
							<li><a href="/REIMBURSEMENT/page/fengdingquery.jsp"> <i
									class="am-icon-angle-right"></i> <span>封顶线</span> <i></i>
							</a> <a href="/REIMBURSEMENT/page/qifuquery.jsp"> <i
									class="am-icon-angle-right"></i> <span>起付标准</span>


							</a><a href="/REIMBURSEMENT/page/fenduanquery.jsp"> <i
									class="am-icon-angle-right"></i> <span>个人分段自费比例</span>



							</a></li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-table"></i> <span>医疗待遇审批</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" style="display: block;">
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
						</ul></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-table"></i> <span>医疗中心报销</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" style="display: none;">
							<li><a href="/REIMBURSEMENT/page/zxbx_index.jsp"> <i
									class="am-icon-angle-right"></i> <span>中心报销</span> <i></i>
							</a> <a href="/REIMBURSEMENT/page/cancel.jsp"> <i
									class="am-icon-angle-right"></i> <span>取消报销</span>

							</a></li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-table"></i> <span>综合查询</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" style="display: none;">
							<li><a href="/REIMBURSEMENT/page/annual_baoxiao.jsp"> <i
									class="am-icon-angle-right"></i> <span>医疗人员费用信息</span> <i></i>
							</a></li>
						</ul></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-table"></i> <span>公共业务</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu" style="display: none;">
							<li><a href="/REIMBURSEMENT/page/basical_institutions.jsp">
									<i class="am-icon-angle-right"></i> <span>单位基本信息</span> <i></i>
							</a> <a href="/REIMBURSEMENT/page/basical_people.jsp"> <i
									class="am-icon-angle-right"></i> <span>个人基本信息</span>
							</a></li>
						</ul></li>


				</ul>
			</div>
		</div>

		<div class="tpl-content-wrapper">
			<div class="tpl-content-page-title">医疗待遇审批</div>
			<ol class="am-breadcrumb">
				<li><a href="/REIMBURSEMENT/page/index.jsp" class="am-icon-home">首页</a></li>
				<li><a href="/REIMBURSEMENT/page/index.jsp">医疗待遇审批</a></li>
				<li class="am-active">特检特治审批批</li>
			</ol>
			<div class="tpl-content-scope"></div>

			<div class="tpl-portlet-components">
				<div class="portlet-title">
					<div class="caption font-green bold">
						<span class="am-icon-code"></span>添加特检特治审批
					</div>
					<div class="tpl-portlet-input tpl-fz-ml">
						<div class="portlet-input input-small input-inline">
							<div class="input-icon right"></div>
						</div>
					</div>


				</div>
				<div class="tpl-block ">

					<div class="am-g tpl-amazeui-form">
						<div class="am-u-sm-12 am-u-md-9">
							<div class="am-text-center" style="color: red">带黄色圈项为必填项</div>
							<br>
							<form class="am-form am-form-horizontal"
								onsubmit="return check()"
								action="/REIMBURSEMENT/YaoPinSpInsertServlet" method="post">


									<div
										class="am-form-group am-form-warning am-form-icon am-form-feedback"
										id="divId">
										<label for="user-weibo" class="am-u-sm-3 am-form-label">申请人编号</label>
										<div class="am-u-sm-9">
											<input id="Id" class="" placeholder="输入申请人编号" type="text"
												name="Id">
										</div>
										<span id="spanId" class="am-icon-circle-o"></span>
									</div>
									
									
									<div class="am-form-group">
		                                <label for="user-name" class="am-u-sm-3 am-form-label">申请人姓名</label>
		                                <div class="am-u-sm-9">
		                                    <input type="text" id="Name" name="Name" readonly="readonly">
		                                </div>
		                            </div>
									
									
							
									
									<div class="am-form-group">
										<label for="user-phone" class="am-u-sm-3 am-form-label">药品名称</label>
										
										<div class="am-u-sm-9">
											<select id="medi" name="medi"
												data-am-selected="{searchBox: 1, maxHeight: 100}"
												style="display: none;">

											</select>
										</div>
									</div>
									
									<div class="am-form-group">
										<label for="user-weibo" class="am-u-sm-3 am-form-label">申请日期</label>
										<div class="am-u-sm-9">
											<input class="am-form-field" data-am-datepicker="" id="stdate"
												readonly="" required="" placeholder="点击选择日期" type="text"
												name="stdate">
										</div>
									</div>
									
									<div class="am-form-group">
										<label for="user-weibo" class="am-u-sm-3 am-form-label">结束日期</label>
										<div class="am-u-sm-9">
											<input class="am-form-field" data-am-datepicker="" id="eddate"
												readonly="" required="" placeholder="点击选择日期" type="text"
												name="eddate">
										</div>
									</div>

									<div class="am-form-group">
										<div class="am-u-sm-9 am-u-sm-push-3">
											<button type="submit" class="am-btn am-btn-primary">添加</button>
										</div>
									</div>

									<br>
							</form>
						</div>

					</div>
				</div>

			</div>


		</div>

	</div>



	<script src="/REIMBURSEMENT/page/assets/js/jquery.min.js"></script>
	<script src="/REIMBURSEMENT/page/assets/js/amazeui.min.js"></script>
	<script src="/REIMBURSEMENT/page/assets/js/iscroll.js"></script>
	<script src="/REIMBURSEMENT/page/assets/js/app.js"></script>





















</body></html>                                                   













































































































































































































































































































































































































































































































































































