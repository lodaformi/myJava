layui.use(['form', 'layer'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    //关闭添加弹出框
    $("#closeBtn").click(function () {
        //当你在iframe页面关闭自身时
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    })

    /**
     * 表单submit监听
     * submit(?)存放的是按钮的lay-filter值
     */
    form.on('submit(addOrUpdateCusDevPlan)', function (data) {
        console.log(data)

        //加载层
        var index = top.layer.msg("数据提交中，请稍后...", {
            icon: 16,    //图标
            time: false, //不关闭，等拿到数据再关闭
            shade: 0.8   //设置遮罩的透明度
        });

        var url = ctx + "/cus_dev_plan/add"
        //判断计划项ID是否为空，不为空，表示更新
        var id = $("[name='id']").val();
        if (id != null && id != "") {
            url = ctx + "/cus_dev_plan/update"
        }
        //发送ajax请求
        $.post(url, data.field, function (result) {
            if (result.code == 200) {
                //成功提示
                top.layer.msg("操作成功！", {icon: 6});
                //关闭加载层
                top.layer.close(index);
                //关闭弹出层
                layer.closeAll("iframe");
                //刷新父窗口，重新加载数据
                parent.location.reload();
            }else {
                //失败提示
                layer.msg("操作失败！", {icon: 5});
            }
        })

        //阻止表单提交
        return false;
    });


    // form.on("submit(addOrUpdateCusDevPlan)", function (data) {
    //     var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
    //     //弹出loading
    //     var url=ctx + "/cus_dev_plan/save";
    //     if($("input[name='id']").val()){
    //         url=ctx + "/cus_dev_plan/update";
    //     }
    //     $.post(url, data.field, function (res) {
    //         if (res.code == 200) {
    //             setTimeout(function () {
    //                 top.layer.close(index);
    //                 top.layer.msg("操作成功！");
    //                 layer.closeAll("iframe");
    //                 //刷新父页面
    //                 parent.location.reload();
    //             }, 500);
    //         } else {
    //             layer.msg(
    //                     res.msg, {
    //                         icon: 5
    //                     }
    //                 );
    //         }
    //     });
    //     return false;
    // });
});