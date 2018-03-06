<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html><head>
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
    <script>
  		function CompName() {
    		$.ajax({
				url:"/REIMBURSEMENT/add_jz_compName_ajax",
				type:"GET",
				dataType:"json",
				success:function(data){
					var str="";
					$(data).each(function(i,jg){
						str= str+ "<option value="+ jg.compId+">"+jg.compName+"</option>";
					});
					$("#compName").html(str);
				},
				error:function(){}
			});
    	};
		function CompId() {
			$('#compName').change(function() {
				var compId = $('#compName').val();
				$("#compId").val(compId);
			})
		};
		function hosRank() {
			$('#compName').change(function() {
				var compId = $('#compName').val();
				$.ajax({
					url : "/REIMBURSEMENT/add_jz_hosRank_ajax?compId=" + compId,
					type : "GET",
					dataType : "text",
					success : function(data) {$("#hosRank").val(data);},
					error : function() {}
				});
			})
		};
		function solveId() {
			$('#solveId').bind('input propertychange',function() {
				var solveId = $('#solveId').val();
				$.ajax({
					url : "/REIMBURSEMENT/add_jz_solveId_ajax?solveId=" + solveId,
					type : "GET",
					dataType : "text",
					success : function(data) {
						if(data == 'yes'){
							$("#divIns").attr("class","am-form-group am-form-error am-form-icon am-form-feedback");
							$("#spanIns").attr("class","am-icon-times");
							$("#spanIns").html("该住院号已存在");							
						}else {
							$("#divIns").attr("class","am-form-group am-form-success am-form-icon am-form-feedback");
							$("#spanIns").attr("class","am-icon-check");
							$("#spanIns").html("住院号合法");
						}
						
					},
					error : function() {}
				});
			})
		};
  		function diseName() {
    		$.ajax({
				url:"/REIMBURSEMENT/add_jz_diseName_ajax",
				type:"GET",
				dataType:"json",
				success:function(data){
					var str="";
					$(data).each(function(i,bz){
						str= str+ "<option value="+ bz.diseId+">"+bz.diseName+"</option>";
					});
					$("#diseName").html(str);
				},
				error:function(){}
			});
    	};
		function diseId() {
			$('#diseName').change(function() {
				var diseId = $('#diseName').val();
				$("#diseId").val(diseId);
			})
		};
    	function init(){
    		$("#personId").val(getQueryString("personId"));
    		$("#personName").val(getQueryString("personName"));
    	}
    	function go(){
    		var url = "/REIMBURSEMENT/msg_jz?personId="+getQueryString("personId");
    		window.location.href = url;
    	}
    	function getQueryString(name) {
    		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    		var r = window.location.search.substr(1).match(reg);
    		if (r != null) {
    			return decodeURI(r[2]);
    		} else {
    			return null;
    		}
    	}
    </script>
</head>

<body onload = "init();CompName();CompId();solveId();CompName();hosRank();diseName();diseId();" data-type="generalComponents">


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
            <li><a href= "javascript:void(0);" onclick ="go()">就诊资料信息</a></li>
            <li class="am-active">录入就诊资料信息</li>
        </ol>


        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span>录入就诊资料信息
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">

                        </div>
                    </div>
                </div>
            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">
                    <div class="am-u-sm-12 am-u-md-9">
                    	<div class="am-text-center" style="color: red">带黄色圆圈项为必填项</div>
                        <form action="/REIMBURSEMENT/add_jz" method="post" class="am-form am-form-horizontal">
                        	<div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label" for = "personId">人员编号</label>
                                <div class="am-u-sm-9">
                                    <input type="text" name = "personId" id="personId" readonly="readonly">
                                </div>
                            </div>
                        	<div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">人员姓名</label>
                                <div class="am-u-sm-9">
                                    <input type="text" name = "personName" id="personName" readonly="readonly">
                                </div>
                            </div>
                            <div class="am-form-group am-form-warning am-form-icon am-form-feedback" id="divIns">
                                <label for="user-name" class="am-u-sm-3 am-form-label">住院号</label>
                                <div class="am-u-sm-9">
                                    <input type="text" name = "solveId" id="solveId" placeholder="输入住院号">
                                </div>
                                <span id="spanIns" class="am-icon-circle-o"></span>
                            </div>
                            <div class="am-form-group">
                                <label for="user-email" class="am-u-sm-3 am-form-label">医疗机构名称</label>
                                <div class="am-u-sm-9">
<select id="compName" data-am-selected="{searchBox: 1, maxHeight: 100}" style="display: none;" name="compId"></select>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-email" class="am-u-sm-3 am-form-label">医疗机构编码</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="compId" placeholder="输入医疗机构编码" readonly="readonly">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-phone" class="am-u-sm-3 am-form-label">医院等级</label>
                                <div class="am-u-sm-9">
                                    <input type="text" name = "hosRank" id="hosRank" placeholder="输入医疗等级" readonly="readonly">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-email" class="am-u-sm-3 am-form-label">病种名称</label>
                                <div class="am-u-sm-9">
<select id="diseName" data-am-selected="{searchBox: 1, maxHeight: 100}" style="display: none;" name="diseId"></select>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-email" class="am-u-sm-3 am-form-label">病种编码</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="diseId" placeholder="输入病种名称" readonly="readonly">
                                </div>
                            </div>
							<div class="am-form-group">
                                <label for="user-phone" class="am-u-sm-3 am-form-label">医疗类别</label>
                                <div class="am-u-sm-9">
                                    <select name = "cureId" data-am-selected="{searchBox: 1}" style="display: none;">
                                        <option value="1">一类</option>
                                        <option value="2">二类</option>
                                        <option value="3">三类</option>
                                        <option value="4">四类</option>
                                    </select>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-weibo" class="am-u-sm-3 am-form-label">入院日期</label>
                                <div class="am-u-sm-9">
                                    <input name = "inDate" type="date" id="user-weibo">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-weibo" class="am-u-sm-3 am-form-label">出院日期</label>
                                <div class="am-u-sm-9">
                                    <input name = "outDate" type="date" id="user-weibo" >
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="user-weibo" class="am-u-sm-3 am-form-label">出院原因</label>
                                <div class="am-u-sm-9">
                                    <input name = "outReason" type="text" id="user-weibo" placeholder="输入出院原因">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="submit" class="am-btn am-btn-primary">添加</button>
                                   <!-- <a href="/REIMBURSEMENT/page/msg_jz.jsp">
                                        　　<input type="button" class="am-btn am-btn-default"  onclick="window.location.href('/REIMBURSEMENT/page/msg_jz.jsp')"  value="返回">
                                    </a> -->
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">
</script>
<script src="/REIMBURSEMENT/page/assets/js/jquery.min.js"></script>
<script src="/REIMBURSEMENT/page/assets/js/amazeui.min.js"></script>
<script src="/REIMBURSEMENT/page/assets/js/app.js"></script>
</body></html>                                                   











































































































































































































































































































































































































































































































































































