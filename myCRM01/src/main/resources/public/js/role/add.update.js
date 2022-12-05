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
     * 监听表单submit事件
     * form.on("submit(表单按钮元素的lay-filter属性值)", function (data) {...}
     */
    //添加角色
    form.on("submit(addOrUpdateRole)", function (data) {
        //加载层
        var index = layer.msg("数据提交中，请稍后...", {
            icon: 16,    //图标
            time: false, //不关闭，等拿到数据再关闭
            shade: 0.8   //设置遮罩的透明度
        });
        //请求的地址
        var url = ctx + "/role/add";

        //判断用户ID是否为空，如果不为空则为更新操作
        if ($("[name='id']").val()){
            //更新操作
            url = ctx + "/role/update"
        }

        //发送ajax请求
        $.post(url, data.field, function (result) {
            if (result.code == 200) {
                //成功提示
                layer.msg("操作成功！", {icon: 6});
                //关闭加载层
                layer.close(index);
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


});