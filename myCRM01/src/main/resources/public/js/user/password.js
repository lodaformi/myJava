layui.use(['form','jquery','jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);


    form.on('submit(saveBtn)',function (data) {
        data =data.field;
        console.log("data.field")
        console.log(data)
        $.ajax({
            type:"post",
            url:ctx+"/user/updatePassword",
            data:{
                oldPassword:data.old_password,
                newPassword:data.new_password,
                confirmPassword:data.again_password
            },
            dataType:"json",
            success:function (data) {
                if(data.code==200){
                    layer.msg("密码修改成功,系统将在3秒后自动退出...",function () {
                        $.removeCookie("userIdStr",{domain:"localhost",path:"/"});
                        $.removeCookie("userName",{domain:"localhost",path:"/"});
                        $.removeCookie("trueName",{domain:"localhost",path:"/"});
                        setTimeout(function () {
                            //window.parent.location父级窗口
                            //window.location本级窗口
                            //加不加parent的区别在页面的跳转上区别很大
                            window.parent.location.href=ctx+"/index";
                        },3000);
                    })
                }else{
                    layer.msg(data.msg);
                }
            }
        })

    })
    



});