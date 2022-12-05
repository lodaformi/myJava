layui.use(['table', 'treetable'], function () {
    var $ = layui.jquery,
        table = layui.table,
        treeTable = layui.treetable;
    // 渲染表格
    treeTable.render({
        treeColIndex: 1,
        treeSpid: -1,
        treeIdName: 'id',
        treePidName: 'parentId',
        elem: '#munu-table',
        url: ctx+'/module/list',
        toolbar: "#toolbarDemo",
        treeDefaultClose:true,
        page: true,
        cols: [[
            {type: 'numbers'},
            {field: 'moduleName', minWidth: 100, title: '菜单名称'},
            {field: 'optValue', title: '权限码'},
            {field: 'url', title: '菜单url'},
            {field: 'createDate', title: '创建时间'},
            {field: 'updateDate', title: '更新时间'},
            {
                field: 'grade', width: 80, align: 'center', templet: function (d) {
                    if (d.grade == 0) {
                        return '<span class="layui-badge layui-bg-blue">目录</span>';
                    }
                    if(d.grade==1){
                        return '<span class="layui-badge-rim">菜单</span>';
                    }
                    if (d.grade == 2) {
                        return '<span class="layui-badge layui-bg-gray">按钮</span>';
                    }
                }, title: '类型'
            },
            {templet: '#auth-state', width: 180, align: 'center', title: '操作'}
        ]],
        done: function () {
            layer.closeAll('loading');
        }
    });

    // 头工具栏事件
    table.on('toolbar(munu-table)',function (obj) {
        switch (obj.event) {
            case "add":
                //添加目录 层级=0 父菜单=-1
                openAddModuleDialog(0,-1);
                break;
            case "expand":
                treeTable.expandAll('#munu-table');
                break;
            case "fold":
                treeTable.foldAll('#munu-table');
                break;
        }
    });

    /**
     * 行工具栏
     */
    table.on('tool(munu-table)',function (obj) {
        var layEvent =obj.event;
        if (layEvent === "add") {
            // console.log("add")
            // console.log(obj)
            // console.log(obj.data)
            if(obj.data.grade == 2){
                layer.msg("暂不支持四级菜单添加操作!", {icon: 5});
                return;
            }
            //—级下添加二级菜单，二级菜单下添加三级菜单
            // grade=当前层级+1,parentId=当前资源的ID
            openAddModuleDialog(obj.data.grade+1, obj.data.id);
        } else if(layEvent === "edit") {
            // console.log("edit")
            // console.log(obj)
            // console.log(obj.data)
            openUpdateModuleDialog(obj.data.id);
        } else if(layEvent === "del") {
            deleteModule(obj.data.id);
        }
    });

    function deleteModule(id) {
        //询问是否确认删除
        layer.confirm("确认删除当前记录?",{icon: 3, title: "资源管理"},function (index) {
            //关闭确认框
            layer.close(index);
            //发送ajax请求
            $.post(ctx+"/module/delete",{mId: id},function (res) {
                //判断结果
                if (res.code == 200) {
                    layer.msg("删除成功！", {icon:6})
                    //刷新
                    window.location.reload();
                } else {
                    layer.msg(res.msg, {icon:5})
                }
            })
        })
    }

    /**
     * 打开添加资源对话框
     * @param grade 层级
     * @param parentId 父级模块Id
     */
    function openAddModuleDialog(grade,parentId) {
        var title = "<h3>资源管理-添加资源</h3>"
        var url = ctx + "/module/toAddModulePage?grade="+grade+"&parentId="+parentId;
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


    function openUpdateModuleDialog(id) {
        //在iframe中打开，留出侧边菜单，而不是占据整个页面
        layui.layer.open({
            //类型： iframe 层
            type: 2,
            //标题
            title: "菜单管理-菜单更新",
            //开启最大化最小化按钮
            maxmin: true,
            //大小（宽高）
            area: ['650px', '400px'],
            content: ctx+"/module/toUpdateModulePage?id="+id
        });
    }


});