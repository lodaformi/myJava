layui.use(['form','jquery','jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);
    // 进行登录操作
    //表单提交
    form.on('submit(login)', function (data) {
        data = data.field;
        if ( data.username =="undefined" || data.username =="" || data.username.trim()=="") {
            layer.msg('用户名不能为空');
            return false;
        }
        if ( data.password =="undefined" || data.password =="" || data.password.trim()=="")  {
            layer.msg('密码不能为空');
            return false;
        }
        $.ajax({
            type:"post",
            url:ctx+"/user/login",
            data:{
                userName:data.username,
                userPwd:data.password
            },
            dataType:"json",
            success:function (data) {
                if(data.code==200){
                    layer.msg('登录成功', function () {
                        var result =data.result;

                        // 如果点击记住我 设置cookie 过期时间7天
                        if($("#rememberMe").prop('checked')){
                            // if($("input[type='checkbox']").is(':checked')){
                            // 写入cookie 7天
                            // $.cookie("userId",result.id, { expires: 7 });
                            $.cookie("userIdStr",result.idStr, { expires: 7 });
                            $.cookie("userName",result.userName, { expires: 7 });
                            $.cookie("trueName",result.trueName, { expires: 7 });
                        } else {
                            // $.cookie("userId",result.id);
                            $.cookie("userIdStr", result.idStr)
                            $.cookie("userName",result.userName);
                            $.cookie("trueName",result.trueName);
                        }
                        //登录成功后，跳转到首页
                        window.location.href=ctx+"/main";
                    });
                }else{//登陆失败
                    layer.msg(data.msg);
                }
            }
        });
        //阻止表单提交
        return false;
    });
});