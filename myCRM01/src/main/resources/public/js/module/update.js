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

    //表单提交
    form.on("submit(updateModule)", function (data) {
        // console.log("update")
        // console.log(data);
        // console.log(data.field);
        var index = layer.msg("数据提交中，请稍后...", {
            icon: 16,    //图标
            time: false, //不关闭，等拿到数据再关闭
            shade: 0.8   //设置遮罩的透明度
        });
        //弹出loading
        $.post(ctx+"/module/update", data.field, function (res) {
            if (res.code == 200) {
                setTimeout(function () {
                    top.layer.close(index);
                    top.layer.msg("操作成功！");
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                }, 500);
            } else {
                //失败提示
                layer.msg(res.msg, {icon: 5});
            }
        });
        return false;
    });

});