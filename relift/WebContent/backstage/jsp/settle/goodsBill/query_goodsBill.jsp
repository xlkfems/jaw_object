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
                <form class="layui-form" action="" id="goodsBillForm">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">客户编号</label>
                            <div class="layui-input-inline">
                                <input type="text" id="customerCode" name="customerCode" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">货运单编号</label>
                            <div class="layui-input-inline">
                                <input type="text" id="goodsBillCode" name="goodsBillCode" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">本单金额</label>
                            <div class="layui-input-inline">
                                <input type="text" id="billMoney" name="billMoney" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">应收金额</label>
                            <div class="layui-input-inline">
                                <input type="text" id="moneyReceivable" name="moneyReceivable" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">已收金额</label>
                            <div class="layui-input-inline">
                                <input type="text" id="receivedMoney" name="receivedMoney" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">预付金额</label>
                            <div class="layui-input-inline">
                                <input type="text" id="prepayMoney" name="prepayMoney" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">运费减款</label>
                            <div class="layui-input-inline">
                                <input type="text" id="carriageReduceFund" name="carriageReduceFund" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">余额</label>
                            <div class="layui-input-inline">
                                <input type="text" id="balance" name="balance" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">结算时间</label>
                            <div class="layui-input-inline">
                                <input type="text" id="balanceTime" name="balanceTime" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">保险费</label>
                            <div class="layui-input-inline">
                                <input type="text" id="insurance" name="insurance" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
             
                        <div class="layui-inline">
                            <label class="layui-form-label">送货费</label>
                            <div class="layui-input-inline">
                                <input type="text" id="carryGoodsFee" name="carryGoodsFee" disabled autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">结算类型</label>
                            <div class="layui-input-inline">
                                <input type="text" id="balanceType" name="balanceType" disabled autocomplete="off" class="layui-input">
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
    <script src="../../../js/clearControl/goodsBill/detail.js"></script>

</body>
</html>