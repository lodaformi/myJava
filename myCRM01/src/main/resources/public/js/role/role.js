layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    //用户展示
    //加载用户数据表格
    var  tableIns = table.render({
        //数据表格的id，用于头工具栏获取，达到多选条目的目的
        id : "roleTable",
        //容器元素的ID属性值
        elem: '#roleList',
        //容器的高度full-差值
        height: 'full-125',
        //单元格最小的宽度
        cellMinWidth : 95,
        //访问数据的URL(后台的数据接口)
        url : ctx+'/role/list',
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
            {field: 'roleName', title: '角色名称',align:"center"},
            {field: 'roleRemark', title: '角色备注',  align:'center'},
            {field: 'createDate', title: '创建时间', align:'center'},
            {field: 'updateDate', title: '修改时间', align:'center'},
            {title: '操作', templet:'#roleListBar',fixed:"right",align:"center", minWidth:150}
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
                roleName: $("input[name='roleName']").val(),  //角色名
            }
        })
    });

    //监听头部工具栏
    table.on('toolbar(roles)', function (obj) {
        // console.log("role js")
        // console.log(obj)
        switch (obj.event) {
            case "add":
                openAddOrUpdateUserDialog();
                break;
            case "grant":
                // console.log("grant")
                // console.log(obj)
                var checkStatus = table.checkStatus(obj.config.id)
                // console.log(checkStatus)
                // console.log(checkStatus.data)
                openAddGrantDialog(checkStatus.data);
                break;
        }
    })

    /**
     * 打开授权页面
     * @param data
     */
    function openAddGrantDialog(data) {
        if (data.length == 0) {
            layer.msg("请选择要授权的角色！", {icon: 5 });
            return;
        }
        if (data.length > 1) {
            layer.msg("暂不支持批量授权！", {icon: 5 });
            return;
        }
        var url = ctx + "/module/toAddGrantPage?roleId=" + data[0].id;
        var title = "<h3>角色管理 - 角色授权</h3>"
        //在iframe中打开，留出侧边菜单，而不是占据整个页面
        layui.layer.open({
            //类型： iframe 层
            type: 2,
            //标题
            title: title,
            //开启最大化最小化按钮
            maxmin: true,
            //大小（宽高）
            area: ['600px', '500px'],
            content: url
        });
    }

    //监听行工具栏
    table.on('tool(roles)', function (obj) {
        if (obj.event == "edit") {
            // console.log("edit")
            // console.log(obj)
            openAddOrUpdateUserDialog(obj.data.id)
        } else if(obj.event == "del") {
            console.log("del")
            deleteRole(obj.data.id);
        }
    })

    function deleteRole(roleId) {
        //弹出确认框，询问用户是否确认删除
        layer.confirm("确定删除选定的条目吗？",{icon:3, title:"角色管理"}, function (index) {
            //关闭确认框
            layer.close(index);
            $.ajax({
                type: "post",
                url: ctx+"/role/delete",
                data:{
                    roleId: roleId
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


    function openAddOrUpdateUserDialog(roleId) {
        var title = "<h3>角色管理 - 添加角色</h3>"
        var url = ctx + "/role/toAddOrUpdateRolePage";

        // 判断roleId是否为空;如果为空，则为添加操作，否则是修改操作
        if (roleId != null && roleId != "") {
            title = "<h3>角色管理 - 更新角色</h3>";
            url += "?roleId=" + roleId; //传递主键，查询数据
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
            area: ['450px', '300px'],
            content: url
        });
    }

});
