layui.use(['table','layer',"form"],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    //用户展示
    //加载用户数据表格
    var  tableIns = table.render({
        //数据表格的id，用于头工具栏获取，达到多选条目的目的
        id : "userTable",
        //容器元素的ID属性值
        elem: '#userList',
        //容器的高度full-差值
        height: 'full-125',
        //单元格最小的宽度
        cellMinWidth : 95,
        //访问数据的URL(后台的数据接口)
        url : ctx+'/user/list',
        //开启分页
        page : true,
        //默认每页显示的数量
        limit : 10,
        //每页页数的可选项
        limits : [10,15,20,25],
        //开启头部工具栏
        toolbar: "#toolbarDemo",

        //表头
        cols : [[
            //field：要求field属性值与返回的数据中对应字段的属性值保持一致
            //title：设置列的标题
            //sort：是否允许排序（默认false）
            //fixed: 固定列
            {type: "checkbox", fixed:"center"}, //复选框
            {field: "id", title:'编号',fixed:"true"},
            {field: 'userName', title: '用户名称',align:"center"},
            {field: 'trueName', title: '真实姓名',  align:'center'},
            {field: 'email', title: '用户邮箱', align:'center'},
            {field: 'phone', title: '用户号码', align:'center'},
            {field: 'createDate', title: '创建时间', align:'center'},
            {field: 'updateDate', title: '修改时间', align:'center'},
            {title: '操作', templet:'#userListBar',fixed:"right",align:"center", minWidth:150}
        ]]
    });

    // 多条件搜索
    //点击搜索按钮时，数据表格重载，将文本框中的值，传递给后台的url
    $(".search_btn").on("click",function(){
        //表格重载，多条件查询
        tableIns.reload({
            page: {
                curr: 1 //重新从第 1 页开始
            },
            //表单文本框值的获取方法，元素的val()方法
            where: {
                //属性选择器
                userName: $("input[name='userName']").val(),  //用户名
                email: $("input[name='email']").val(),  //邮箱
                phone: $("input[name='phone']").val()  //手机号码
            }
        })
    });

    //监听头部工具栏
    table.on('toolbar(users)', function (obj) {
        switch (obj.event) {
            case "add":
                openAddOrUpdateUserDialog();
                break;
            case "del":
                // console.log("del")
                // console.log(obj)
                var checkStatus = table.checkStatus(obj.config.id);
                // console.log(checkStatus)
                // console.log(checkStatus.data)
                deleteUsers(checkStatus.data)
                break;
        }
    })

    function deleteUsers(userData) {
        if (userData.length < 1) {
            layer.msg("请选择要删除的条目！", {icon:5});
            return;
        }
        //询问是否确认删除
        layer.confirm("确定要删除选中的记录吗？", {icon:3, title:"用户管理"}, function (index) {
            //关闭确认框
            layer.close(index);
            //传递参数，体现在地址栏上就是多个一样的参数名，不一样的参数值
            var ids = "";
            //循环拼接选中条目的id，拼接结果为ids=32&ids=97&ids=98&ids=125
            for (var i = 0; i < userData.length; i++) {
                if (i == userData.length-1) {
                    ids += "ids=" + userData[i].id;
                } else {
                    ids += "ids=" + userData[i].id + "&";
                }
            }
            // console.log(ids)
            $.ajax({
                url: ctx+"/user/delete",
                method: "post",
                data: ids,  //传递的参数是数组ids=32&ids=97&ids=98&ids=125
                success: function (res) {
                    //判断结果
                    if (res.code == 200) {
                        layer.msg("删除成功！", {icon:6})
                        //刷新表格
                        tableIns.reload();
                    }else {
                        layer.msg(res.msg, {icon:5})
                    }
                }
            });
        })
    }

    //监听行工具栏
    table.on('tool(users)', function (obj) {
        if (obj.event == "edit") {
            // console.log("edit")
            openAddOrUpdateUserDialog(obj.data.id)
        } else if(obj.event == "del") {
            console.log("del")
            deleteUser(obj.data.id);
        }
    })

    function deleteUser(id) {
        //弹出确认框，询问用户是否确认删除
        layer.confirm("确定删除选定的条目吗？",{icon:3, title:"用户管理"}, function (index) {
            //关闭确认框
            layer.close(index);
            $.ajax({
                type: "post",
                url: ctx+"/user/delete",
                data:{
                    ids: id
                },
                success: function (res) {
                    //判断结果
                    if (res.code == 200) {
                        layer.msg("删除成功！", {icon:6})
                        //刷新表格
                        tableIns.reload();
                    }else {
                        layer.msg(res.msg, {icon:5})
                    }
                }
            })
        })
    }
    /**
     * 打开添加/修改用户的对话框
     */
    function openAddOrUpdateUserDialog(id) {
        var title = "<h3>用户管理 - 添加用户</h3>"
        var url = ctx + "/user/toAddOrUpdateUserPage";
        //判断id是否为空;如果为空，则为添加操作，否则是修改操作
        if (id != null && id != "") {
            title = "<h3>用户管理 - 更新用户</h3>";
            url += "?id=" + id; //传递主键，查询数据
        }
        //在iframe中打开，留出侧边菜单，而不是占据整个页面
        layui.layer.open({
            //类型： iframe 层
            type: 2,
            //标题
            title: title,
            //开启最大化最小化按钮
            maxmin: true,
            //大小（宽高）
            area: ['650px', '400px'],
            content: url
        });
    }
});
