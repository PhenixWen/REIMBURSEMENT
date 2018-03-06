<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="/REIMBURSEMENT/page/assets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/REIMBURSEMENT/page/assets/css/theme.css">
    <link rel="stylesheet" href="/REIMBURSEMENT/page/assets/css/font-awesome.css">
    <link rel="stylesheet" href="/assets/css/base.css" />
    <link rel="stylesheet" href="/assets/css/info-mgt.css" />
    <script src="/REIMBURSEMENT/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script type="text/javascript" src="/REIMBURSEMENT/js/jQuery.print.js"></script>
    <style type="text/css">
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }

        .brand {
            font-family: georgia, serif;
        }

        .brand .first {
            color: #ccc;
            font-style: italic;
        }

        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <style type="text/css">
        * {
            margin: 0;
        }

        /* body {
            margin-top: 30px;
            margin-left: 30px;
            width: 650px;
            height: 798px;
        } */
        .bill {
            margin-left: 0px;
            width: 99%;
            height: auto;
            text-align: center;
        }

        #bill-box {
            width: 100.5%;
            height: 798px;
        }

        #bill-header {
            margin-top: 8px;
            font-size: x-large;
        }

        #bill-nav {
            margin-top: 10px;
        }

        #bill-number {
            margin-left: 2%;
            margin-bottom: 8px;
            float: left;
        }

        #bill-date {
            margin-right: 2%;
            margin-bottom: 8px;
            float: right;
        }

        table {
            width: 100.5%;
        }

        table input {
            border: transparent;
            height: 18px;
            width: 240px;
            text-align: center;
            font-size: medium;
        }

        table tr td {
            width: 100px;
            height: 30px;
            border: 1px solid black;
        }

        #bill-prescription {
            width: 100%;
            height: auto;
            text-align: left;
            border: 1px solid black;
        }

        #count-detail, #pay-standard, #pay-self-item, #second-class-item,
        #pay-self, #pay-expense {
            margin-top: 8px;
            margin-left: 1%;
        }

        #footer {
            margin-top: 80px;
            width: 100%;
            height: 80px;
        }

        #money {
            width: 15%;
            height: 100%;
            float: left;
            border-top: 1px solid black;
            border-right: 1px solid black;
        }

        #money div {
            line-height: 80px;
            text-align: center;
        }

        #num-box {
            width: 84.8%;
            height: 100%;
            float: left;
            margin-left: 0px;
            /*border-top: 1px solid black;*/
        }

        #capital-num-box, #normal-num-box {
            clear: both;
            width: 100%;
            height: 40px;
        }

        #capital-num-box {
            border-top: 1px solid black;
            border-bottom: 1px solid black;
        }

        #capital-num-box label, #normal-num-box label {
            line-height: 40px;
            margin-left: 4%;
        }
    </style>
</head>

<body class="">
<div class="container-fluid">
    <div class="row-fluid">
        <div class="well">
            <div class="bill">
                <div id="bill-box">
                    <div id="bill-header">
                        <h3 align="center">哈尔滨工程大学医疗保险报销费用结算清单</h3>
                    </div>
                    <div id="bill-nav">
                        <div id="bill-number">流水单号：<span>201708041001</span></div>
                        <div id="bill-date">结算日期：2017年8月4日</div>
                    </div>
                    <table cellspacing="0" cellpadding="4">
                        <tr>
                            <td align="center">姓名</td>
                            <td><input type="text" id="id1" value="${requestScope.solve.personName}"
                                       readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                            <td align="center">身份证号</td>
                            <td><input type="text" name="" id="s" value="${requestScope.solve.certifiId}"
                                       readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                        </tr>
                        <tr>
                            <td align="center">个人编号</td>
                            <td><input type="text" name="" id="mscid"
                                       value="${requestScope.solve.personId}" readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                            <td align="center">住院号</td>
                            <td><input type="text" name="" id=""
                                       value="${requestScope.solve.solveId}"
                                       readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                        </tr>
                        <tr>
                            <td align="center">单位名称</td>
                            <td><input type="text" name="" id="idcp" value="${requestScope.solve.insName}"
                                       readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                            <td align="center">人员类别</td>
                            <td><input type="text" name="" id="" value="${requestScope.solve.patientKind}"
                                       readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                        </tr>
                        <tr>
                            <td align="center">医疗机构</td>
                            <td><input type="text" name="" id=""
                                       value="${requestScope.solve.compName}"
                                       readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
							<td align="center">医疗类别</td>
                            <td><input type="text" name="" id=""
                                       value="${requestScope.solve.cureKind}"
                                       readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                        </tr>
                        <tr>
                            <td align="center">医院等级</td>
                            <td><input type="text" name="" id=""
                                       value="${requestScope.solve.hosRank}"
                                       readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                            <td align="center">病种名称</td>
                            <td><input type="text" name="" id=""
                                       value="${requestScope.solve.diseName}"
                                       readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                        </tr>
                        <tr>
                            <td align="center">入院日期</td>
                            <td><input type="text" name="" id=""
                                       value="${requestScope.solve.inDate}" readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                            <td align="center">报销标志</td>
                            <td><input type="text" name="" id=""
                                       value="${requestScope.solve.diseM}" readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                        </tr>
                        <tr>
                            <td align="center">出院日期</td>
                            <td><input type="text" name="" id=""
                                       value="${requestScope.solve.outDate}" readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                            <td align="center">出院原因</td>
                            <td><input type="text" name="" id=""
                                       value="${requestScope.solve.outReason}" readonly="readonly"
                                       style="border: 0; background-color: transparent;" /></td>
                        </tr>
                    </table>
                    <div id="bill-prescription">
                        <div id="count-detail"><h3>结算明细单</h3></div>
                        <div id="pay-standard">起付标准：
                        <input type="text" name="" id="" value="${requestScope.solve.qf}" readonly="readonly" style="border: 0; background-color: transparent;" />
                        </div>
                        <div id="pay-self-item">自费项目：                           
                                <input type="text" name="" id="" value="${requestScope.solve.zflis}"
                                       readonly="readonly"
                                       style="width:800px; border: 0; background-color: transparent;" />
                                <br />
                        </div>
                        <div id="second-class-item">乙类项目：
                                <input type="text" name="" id="" value="${requestScope.solve.yllis}"
                                       readonly="readonly"
                                       style="width:800px; border: 0; background-color: transparent;" />
                                <br />
                        </div>
                        <br />
                        <hr />
                        <div id="pay-self">费用总额：<input type="text" name="" id=""
                                        value="${requestScope.solve.sum}" readonly="readonly"
                                        style="border: 0; background-color: transparent;" />
                        </div>
                        <div id="pay-expense">报销金额：<input type="text" name="" id=""
                                        value="${requestScope.solve.bx}" readonly="readonly"
                                        style="border: 0; background-color: transparent;" />
                        </div>
                        <div id="pay-expense">自费金额：<input type="text" name="" id=""
                                        value="${requestScope.solve.zf}" readonly="readonly"
                                        style="border: 0; background-color: transparent;" />
                        </div>
                        <div id="footer">
                            <div id="money">
                                <div id="">自费金额</div>
                            </div>
                            <div id="num-box">
                                <div id="capital-num-box">
                                    <label style="float: left;">小写： </label><input type="text"
                                                                                   id="small" value="${requestScope.solve.zf}"
                                                                                   style="float: left; margin-top: 4px; border: 0; background-color: transparent;"
                                                                                   readonly="readonly"></input>

                                </div>
                                <div id="normal-num-box">
                                    <label style="float: left;">大写：</label><input type="text"
                                                                                  id="big"
                                                                                  style="float: left; margin-top: 4px; border: 0; background-color: transparent;"
                                                                                  readonly="readonly"></input>
                                </div>
                                <script type="text/javascript">
                                    var num=document.getElementById("small").value;
                                    var fraction = ['角', '分'];
                                    var digit = [
                                        '零', '壹', '贰', '叁', '肆',
                                        '伍', '陆', '柒', '捌', '玖'
                                    ];
                                    var unit = [
                                        ['元', '万', '亿'],
                                        ['', '拾', '佰', '仟']
                                    ];
                                    var head = num < 0 ? '欠' : '';
                                    var n = Math.abs(num);
                                    var s = '';
                                    for(var i = 0; i < fraction.length; i++) {
                                        s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i]).replace(/零./, '');
                                    }
                                    s = s || '整';
                                    n = Math.floor(n);
                                    for(var i = 0; i < unit[0].length && n > 0; i++) {
                                        var p = '';
                                        for(var j = 0; j < unit[1].length && n > 0; j++) {
                                            p = digit[n % 10] + unit[1][j] + p;
                                            n = Math.floor(n / 10);
                                        }
                                        s = p.replace(/(零.)*零$/, '').replace(/^$/, '零') + unit[0][i] + s;
                                    }
                                    var str = head + s.replace(/(零.)*零元/, '元')
                                            .replace(/(零.)+/g, '零')
                                            .replace(/^整$/, '零元整');
                                    document.getElementById("big").value = str;
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="margin-top:130px;">
                    <button style="margin-left:-180px;margin-top: 30px; border-radius: 4px;"
                            class="btn btn-primary" onclick="jQuery('#bill-box').print()">打印</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/REIMBURSEMENT/js/bootstrap.js"></script>

</body></html>                                                   











































































































































































































































































































































































































































































































































































