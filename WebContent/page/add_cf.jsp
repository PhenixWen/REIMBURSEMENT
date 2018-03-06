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
    function returnFloat(value){
    	 var value=Math.round(parseFloat(value)*100)/100;
    	 var xsd=value.toString().split(".");
    	 if(xsd.length==1){
    	 value=value.toString()+".00";
    	 return value;
    	 }
    	 if(xsd.length>1){
    	 if(xsd[1].length<2){
    	 value=value.toString()+"0";
    	 }
    	 return value;
    	 }
    	}
		function fun1() {
			$("#price").keyup(function() {
				var p = $("#price").val();
				var c = $("#num").val();
				$("#sum").val(returnFloat(p * c));
			});
			$("#num").keyup(function() {
				var p = $("#price").val();
				var c = $("#num").val();
				$("#sum").val(returnFloat(p * c));
			});
		}
		function fun2(){
			$("#solveId").val(getQueryString("solveId"));
			$("#personId").val(getQueryString("personId"));
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
     	function go(){
    		var personId0 = $("#personId").val();
    		var personId = getQueryString("personId");
    		var url = "/REIMBURSEMENT/msg_jz?personId=";
    		if(personId !== null && personId !== undefined && personId !== '') url = url+personId;
    		else url = url+personId0;
    		window.location.href = url;
    	}
    	function golis(){
    		var personId0 = $("#personId").val();
    		var personId = getQueryString("personId");    		
    		var solveId0 = $("#solveId").val();
    		var solveId = getQueryString("solveId");
    		var url = "/REIMBURSEMENT/msg_cf?personId=";
    		if(personId !== null && personId !== undefined && personId !== '') url = url+personId;
    		else url = url+personId0;
    		url = url + "&solveid=";
    		if(solveId !== null && solveId !== undefined && solveId !== '') url = url+solveId;
    		else url = url+solveId0;
    		window.location.href = url;
    	} 
		function mediName() {
    		$.ajax({
				url:"/REIMBURSEMENT/add_cf_ajax",
				type:"GET",
				dataType:"json",
				success:function(data){
					var str="";
					$(data).each(function(i,yp){
						str= str+ "<option value="+yp.mediId+">"+yp.mediName+"</option>";
					});
					$("#mediName").html(str);
				},
				error:function(){}
			});
    	};
    	function price() {
    		$("#price").blur(function(){
    			var value = $("#price").val();
    			var req = /^\d+(\.\d+)?$/
    			if(req.test(value) && value <= 10000){
    				$("#divPrice")
    					.attr("class",
    							"am-form-group am-form-success am-form-icon am-form-feedback");
    				$("#spanPrice").attr("class",
    						"am-icon-check");
    				$("#spanPrice").html("单价合法");
    			}else{
    				$("#divPrice")
    					.attr("class",
    							"am-form-group am-form-error am-form-icon am-form-feedback");
    				$("#spanPrice").attr("class",
    						"am-icon-times");
    				$("#spanPrice").html(
    						"请输入10000以内正实数");
    			}
    		});
    	};
    	function num() {
    		$("#num").blur(function(){
    			var value = $("#num").val();
    			var req = /^\d+(\.\d+)?$/
    			if(req.test(value) && value <= 100){
    				$("#divNum")
    					.attr("class",
    							"am-form-group am-form-success am-form-icon am-form-feedback");
    				$("#spanNum").attr("class",
    						"am-icon-check");
    				$("#spanNum").html("数量合法");
    			}else{
    				$("#divNum")
    					.attr("class",
    							"am-form-group am-form-error am-form-icon am-form-feedback");
    				$("#spanNum").attr("class",
    						"am-icon-times");
    				$("#spanNum").html(
    						"请输入100以内正整数");
    			}
    		});
    	};
	</script>
</head>

<body onload = "fun1();fun2();mediName();price();num();" data-type="generalComponents">


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
            <li><a href="javascript:void(0);" onclick ="go()">就诊资料信息</a></li>
            <li><a href="javascript:void(0);" onclick ="golis()">处方明细信息</a></li>
            <li class="am-active">录入处方明细</li>
        </ol>


        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span>录入处方明细
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
                        <form style="padding-left:100px;" action="/REIMBURSEMENT/add_cf?" method="post" class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">住院号</label>
                                <div class="am-u-sm-9">
                                    <input  type="text" id="solveId" name="solveId" readonly="readonly">
                                </div>
                            </div>
                            <input style="display:none;" type="text" id="personId" name="personId">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">药品名称</label>
                                <div class="am-u-sm-9">
<select id="mediName" data-am-selected="{searchBox: 1, maxHeight: 100}" style="display: none;" name="mediId"></select>         
                                </div>
                            </div>
                            <div class="am-form-group am-form-warning am-form-icon am-form-feedback" id = "divPrice">
                                <label for="user-weibo" class="am-u-sm-3 am-form-label">单价</label>
                                <div class="am-u-sm-9">
                                    <input  type="text" name="price" id="price" placeholder="输入单价">
                                </div>
                                <span id="spanPrice" class="am-icon-circle-o"></span>
                            </div>
                            <div class="am-form-group am-form-warning am-form-icon am-form-feedback" id = "divNum">
                                <label for="user-weibo" class="am-u-sm-3 am-form-label">数量</label>
                                <div class="am-u-sm-9">
                                    <input  type="text" name="num" id="num" placeholder="输入数量">
                                </div>
                                <span id="spanNum" class="am-icon-circle-o"></span>
                            </div>
                            <div class="am-form-group">
                                <label for="user-weibo" class="am-u-sm-3 am-form-label">总价</label>
                                <div class="am-u-sm-9">
                                    <input  type="text" name="sum" id="sum" placeholder="0" readonly="readonly">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button type="submit" class="am-btn am-btn-primary">添加</button>
                                </div>
                            </div>
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











































































































































































































































































































































































































































































































































































