layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    //加载计划项数据表格
    var  tableIns = table.render({
        id : "cusDevPlanTable",
        //容器元素的ID属性值
        elem: '#cusDevPlanList',
        //容器的高度full-差值
        height : "full-125",
        //单元格最小的宽度
        cellMinWidth : 95,
        //访问数据的URL(后台的数据接口）
        url : ctx+'/cus_dev_plan/list?saleChanceId='+$("[name='id']").val(),
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
            {type: "checkbox", fixed:"center"},
            {field: "id", title:'编号',fixed:"true"},
            {field: 'planItem', title: '计划项',align:"center"},
            {field: 'planDate', title: '执行时间',align:"center"},
            {field: 'exeAffect', title: '执行效果',align:"center"},
            {field: 'createDate', title: '创建时间',align:"center"},
            {field: 'updateDate', title: '更新时间',align:"center"},
            {title: '操作',fixed:"right",align:"center", minWidth:150,templet:"#cusDevPlanListBar"}
        ]]
    });

    //头工具栏事件
    table.on('toolbar(cusDevPlans)', function (obj) {
       if (obj.event == "add") {
           openAddOrUpdateCusDevPlanDialog();
       } else if(obj.event == "success") {
           console.log("success");
       } else if (obj.event == "failed") {
           console.log("failed");
       }
    });

    function openAddOrUpdateCusDevPlanDialog(id) {
        var title = "计划项管理 - 添加计划项";
        var url = ctx + "/cus_dev_plan/toAddOrUpdateCusDevPlanPage?sId="+$("[name='id']").val();
        //判断计划项的ID是否为空―(如果为空，则表示添加;不为空则表示更新操作)
        if (id != null && id != "") {
            //更新计划项
            title = "计划项管理 - 更新计划项";
            url += "&id="+id;
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
            area: ['500px', '300px'],
            content: url
        });
    }

    //头工具栏事件
    // table.on('toolbar(cusDevPlans)', function(obj){
    //     switch(obj.event){
    //         case "add":
    //             openAddOrUpdateCusDevPlanDialog();
    //             break;
    //         case "success":
    //             updateSaleChanceDevResult($("input[name='id']").val(),2);
    //             break;
    //         case "failed":
    //             updateSaleChanceDevResult($("input[name='id']").val(),3);
    //             break;
    //     };
    // });



    /**
     * 行监听
     */
    table.on("tool(cusDevPlans)", function (obj) {
        if (obj.event == "edit") {
            // console.log("edit")
            openAddOrUpdateCusDevPlanDialog(obj.data.id);
        }else if (obj.event == "del") {
            console.log("del")
            //删除计划项
            deleteCusDevPlan(obj.data.id);

        }
    })

    function deleteCusDevPlan(id) {
        //弹出确认框，询问是否确认删除
        layer.confirm("确定删除该记录吗？", {icon:3, title:"开发项数据管理"}, function (index) {
            $.post(ctx+"/cus_dev_plan/delete", {id:id}, function (result){
                if (result.code == 200) {
                    //提示删除成功
                    layer.msg("删除成功", {icon:6});
                    //刷新数据表格
                    tableIns.reload();
                } else {
                    //提示失败原因
                    layer.msg(result.msg, {icon:5});
                }
            });
        });
    }

    // table.on("tool(cusDevPlans)", function(obj){
    //     var layEvent = obj.event;
    //     if(layEvent === "edit") {
    //         openAddOrUpdateCusDevPlanDialog(obj.data.id);
    //     }else if(layEvent === "del") {
    //         layer.confirm('确定删除当前数据？', {icon: 3, title: "开发计划管理"}, function (index) {
    //             $.post(ctx+"/cus_dev_plan/delete",{id:obj.data.id},function (data) {
    //                 if(data.code==200){
    //                     layer.msg("操作成功！");
    //                     tableIns.reload();
    //                 }else{
    //                     layer.msg(data.msg, {icon: 5});
    //                 }
    //             });
    //         })
    //     }
    //
    // });


    // 打开添加计划项数据页面
    // function openAddOrUpdateCusDevPlanDialog(id){
    //     var url  =  ctx+"/cus_dev_plan/addOrUpdateCusDevPlanPage?sid="+$("input[name='id']").val();
    //     var title="计划项管理-添加计划项";
    //     if(id){
    //         url = url+"&id="+id;
    //         title="计划项管理-更新计划项";
    //     }
    //     layui.layer.open({
    //         title : title,
    //         type : 2,
    //         area:["700px","400px"],
    //         maxmin:true,
    //         content : url
    //     });
    // }





    // function updateSaleChanceDevResult(sid,devResult) {
    //     layer.confirm('确定执行当前操作？', {icon: 3, title: "计划项维护"}, function (index) {
    //         $.post(ctx+"/sale_chance/updateSaleChanceDevResult",
    //             {
    //                 id:sid,
    //                 devResult:devResult
    //             },function (data) {
    //             if(data.code==200){
    //                 layer.msg("操作成功！");
    //                 layer.closeAll("iframe");
    //                 //刷新父页面
    //                 parent.location.reload();
    //             }else{
    //                 layer.msg(data.msg, {icon: 5});
    //             }
    //         });
    //     })
    // }




});
