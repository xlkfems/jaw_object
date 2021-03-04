<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>运输合同结算页面</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css">
    <link rel="stylesheet" href="../../../css/admin.css">
</head>
<body>
    <div class="layui-tab layui-tab-brief" lay-filter="demo">
        <div class="layui-tab-content" style="height: 100px; display: block">
            <div class="layui-tab-item layui-show">
                <div class="layui-form-item">
                <form class="layui-form" action="" id="transportForm">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">司机编号</label>
                            <div class="layui-input-inline">
                                <input type="text" id="driverCode" name="driverCode" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">结算类型</label>
                            <div class="layui-input-inline">
                                <input type="text" id="balanceType" name="balanceType" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">回执单编号</label>
                            <div class="layui-input-inline">
                                <input type="text" id="backBillCode" name="backBillCode" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">应付金额</label>
                            <div class="layui-input-inline">
                                <input type="text" id="needPayment" name="needPayment" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">承运费</label>
                            <div class="layui-input-inline">
                                <input type="text" id="carryFee" name="carryFee" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">预付金额</label>
                            <div class="layui-input-inline">
                                <input type="text" id="prepayMoney" name="prepayMoney" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">订装保证金</label>
                            <div class="layui-input-inline">
                                <input type="text" id="bindInsurance" name="bindInsurance" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">加运费</label>
                            <div class="layui-input-inline">
                                <input type="text" id="addCarriage" name="addCarriage" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">已付金额</label>
                            <div class="layui-input-inline">
                                <input type="text" id="payedMoney" name="payedMoney" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">余额</label>
                            <div class="layui-input-inline">
                                <input type="text" id="balance" name="balance" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">结算时间</label>
                            <div class="layui-input-inline">
                                <input type="text" id="balanceTime" name="balanceTime" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">配载服务费</label>
                            <div class="layui-input-inline">
                                <input type="text" id="dispatchServiceFee" name="dispatchServiceFee" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label wd-100">保险费</label>
                            <div class="layui-input-inline">
                                <input type="text" id="insurance" name="insurance" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                </form>
                </div>
            </div>
        </div>
    </div>
    <script src="../../../layui/layui.js"></script>
    <script src="../../../js/jquery/jquery-3.3.1.js"></script>

    <script src="../../../js/nginx.js"></script>
    <script src="../../../js/clearControl/transport/detail.js"></script>

</body>
</html>