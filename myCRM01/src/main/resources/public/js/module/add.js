layui.use(['form', 'layer'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    /**
     * 表单提交
     */
    form.on('submit(addModule)',function (data) {
        // console.log(data)
        // console.log(data.field)
        var index = layer.msg("数据提交中，请稍后...", {
            icon: 16,    //图标
            time: false, //不关闭，等拿到数据再关闭
            shade: 0.8   //设置遮罩的透明度
        });
        //发送ajax请求
        $.post(ctx+"/module/add", data.field, function (res) {
            if(res.code==200){
                top.layer.msg("操作成功", {icon: 6});
                top.layer.close(index);
                layer.closeAll("iframe");
                // 刷新父页面
                parent.location.reload();
            }else{
                //失败提示
                layer.msg(res.msg, {icon: 5});
            }
        });
        //阻止表单提交
        return false;
    });

    //关闭添加弹出框
    $("#closeBtn").click(function () {
        //当你在iframe页面关闭自身时
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    })

});