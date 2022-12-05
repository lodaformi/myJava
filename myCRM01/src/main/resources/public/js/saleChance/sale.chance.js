layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;
    //用户列表展示
    //加载数据表格
    var  tableIns = table.render({
        //数据表格的id，用于头工具栏获取，达到多选条目的目的；或多条件查询时使用表格重载，
        id : "saleChanceTable",
        //容器元素的ID属性值
        elem: '#saleChanceList',
        //容器的高度full-差值
        height: 'full-125',
        //单元格最小的宽度
        cellMinWidth : 95,
        //访问数据的URL(后台的数据接口)
        url : ctx+'/sale_chance/list',
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
            {field: 'chanceSource', title: '机会来源',align:"center"},
            {field: 'customerName', title: '客户名称',  align:'center'},
            {field: 'cgjl', title: '成功几率', align:'center'},
            {field: 'overview', title: '概要', align:'center'},
            {field: 'linkMan', title: '联系人',  align:'center'},
            {field: 'linkPhone', title: '联系电话', align:'center'},
            {field: 'description', title: '描述', align:'center'},
            {field: 'createMan', title: '创建人', align:'center'},
            {field: 'assignTime', title: '分配时间', align:'center'},
            // 页面显示结果是数字的话，不人性化，所以需要联表查询用户表，将指派人姓名显示到数据表格中
            // 对应的实体类中也要加上uname字段
            // {field: 'assignMan', title: '指派人', align:'center'},
            {field: 'uname', title: '指派人', align:'center'},
            {field: 'createDate', title: '创建时间', align:'center'},
            {field: 'updateDate', title: '修改时间', align:'center'},
            {field: 'state', title: '分配状态', align:'center',templet:function(d){
                    return formatterState(d.state);
                }},
            {field: 'devResult', title: '开发状态', align:'center',templet:function (d) {
                    return formatterDevResult(d.devResult);
                }},
            //行工具栏
            {title: '操作', templet:'#saleChanceListBar',fixed:"right",align:"center", minWidth:150}
        ]]
    });

    function formatterState(state){
        if(state==0){
            return "<div style='color:darkorange '>未分配</div>";
        }else if(state==1){
            return "<div style='color: green'>已分配</div>";
        }else{
            return "<div style='color: red'>未知</div>";
        }
    }

    function formatterDevResult(value){
        /**
         * 0-未开发
         * 1-开发中
         * 2-开发成功
         * 3-开发失败
         */
        if(value==0){
            return "<div style='color: #B6D76F'>未开发</div>";
        }else if(value==1){
            return "<div style='color: #00FF00;'>开发中</div>";
        }else if(value==2){
            return "<div style='color: #00B83F'>开发成功</div>";
        }else if(value==3){
            return "<div style='color: red'>开发失败</div>";
        }else {
            return "<div style='color: #af0000'>未知</div>"
        }
    }

    // 多条件搜索
    //点击搜索按钮时，数据表格重载，将文本框中的值，传递给后台的url
    $(".search_btn").on("click",function(){
        table.reload("saleChanceTable",{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            //表单文本框值的获取方法，元素的val()方法
            where: {
                //属性选择器
                customerName: $("input[name='customerName']").val(),  //客户名
                createMan: $("input[name='createMan']").val(),  //创建人
                //id选择器
                state: $("#state").val()  //状态
            }
        })
    });

    //头工具栏事件
    //toolbar(table的lay-filter="saleChances"值)
    table.on('toolbar(saleChances)', function(obj){
        console.log(obj)

        switch (obj.event) {
            case "add":
                openSalChanceDialog();
                break;
            case "del":
                console.log("delSaleChance")
                delSaleChances()
                break;
        }
        // var checkStatus = table.checkStatus(obj.config.id);
        // switch(obj.event){
        //     case "add":
        //         openAddOrUpdateSaleChanceDialog();
        //         break;
        //     case "del":
        //         delSaleChance(checkStatus.data);
        //         break;
        // };
    });

    /**
     * 删除多条记录
     */
    function delSaleChances() {
        var checkStatus = table.checkStatus('saleChanceTable'); //saleChanceTable 即为数据表格 id 对应的值

        console.log(checkStatus)
        // console.log(checkStatus.data) //获取选中行的数据
        // console.log(checkStatus.data.length) //获取选中行数量，可作为是否有选中行的条件
        // console.log(checkStatus.isAll ) //表格是否全选
        //获取选中要删除的条目
        var delData = checkStatus.data;
        if (delData.length < 1) {
            layer.msg("请选择要删除的条目！", {icon:5});
            return;
        }
        //询问是否确认删除
        layer.confirm("确定要删除选中的记录吗？", {icon:3, title:"营销机会管理"}, function (index) {
            //关闭确认框
            layer.close(index);
            //传递参数，体现在地址栏上就是多个一样的参数名，不一样的参数值
            var ids = "";
            //循环拼接选中条目的id，拼接结果为ids=32&ids=97&ids=98&ids=125
            for (var i = 0; i < delData.length; i++) {
                if (i == delData.length-1) {
                    ids += "ids=" + delData[i].id;
                } else {
                    ids += "ids=" + delData[i].id + "&";
                }
            }
            // console.log(ids)
            $.ajax({
               url: ctx+"/sale_chance/delete",
               type: "post",
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


    // 打开添加/修改机会数据页面
    //如果营销机会id为空，则为添加操作
    //如果营销机会id不为空，则为更新操作
    function openSalChanceDialog(saleChanceId) {
        var title = "<h3>营销机会管理 - 添加营销机会</h3>";
        var url = ctx + "/sale_chance/toSaleChancePage";    //跳转到添加营销机会视图

        if (saleChanceId != null && saleChanceId != "") {
            var title = "<h3>营销机会管理 - 更新营销机会</h3>";
            url += "?saleChanceId="+saleChanceId;
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
            area: ['500px', '620px'],
            content: url
        });
    }

    /**
     * 行工具栏
     */
    //工具条事件
    //注：tool 是工具条事件名，参数 是 table 原始容器的属性 lay-filter="对应的值"
    table.on('tool(saleChances)', function(obj){
        console.log(obj);
        var id = obj.data.id;
        if (obj.event == "edit"){
            // console.log(id)
            openSalChanceDialog(id);
        }else if (obj.event == "del") {
             console.log("del")
            //弹出确认框，询问用户是否确认删除
            layer.confirm("确定删除选定的条目吗？",{icon:3, title:"营销机会管理"}, function (index) {
                //关闭确认框
                layer.close(index);
                $.ajax({
                    type: "post",
                    url: ctx+"/sale_chance/delete",
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
    })




    /**
     * 行监听
     */
    // table.on("tool(saleChances)", function(obj){
    //     var layEvent = obj.event;
    //     if(layEvent === "edit") {
    //         openAddOrUpdateSaleChanceDialog(obj.data.id);
    //     }else if(layEvent === "del") {
    //         layer.confirm('确定删除当前数据？', {icon: 3, title: "机会数据管理"}, function (index) {
    //             $.post(ctx+"/sale_chance/delete",{ids:obj.data.id},function (data) {
    //                 if(data.code==200){
    //                     layer.msg("操作成功！");
    //                     tableIns.reload();
    //                 }else{
    //                     layer.msg(data.msg, {icon: 5});
    //                 }
    //             });
    //         })
    //     }
    // });


    // 打开添加机会数据页面
    function openAddOrUpdateSaleChanceDialog(sid){
        var url  =  ctx+"/sale_chance/addOrUpdateSaleChancePage";
        var title="营销机会管理-机会添加";
        if(sid){
            url = url+"?id="+sid;
            title="营销机会管理-机会更新";
        }
        layui.layer.open({
            title : title,
            type : 2,
            area:["700px","560px"],
            maxmin:true,
            content : url
        });
    }


    /**
     * 批量删除
     * @param datas
     */
    function delSaleChance222(datas) {
        if(datas.length==0){
            layer.msg("请选择删除记录!", {icon: 5});
            return;
        }
        layer.confirm('确定删除选中的机会数据？', {
            btn: ['确定','取消'] //按钮
        }, function(index){
            layer.close(index);
            var ids= "ids=";
            for(var i=0;i<datas.length;i++){
                if(i<datas.length-1){
                    ids=ids+datas[i].id+"&ids=";
                }else {
                    ids=ids+datas[i].id
                }
            }
            $.ajax({
                type:"post",
                url:ctx+"/sale_chance/delete",
                data:ids,
                dataType:"json",
                success:function (data) {
                    if(data.code==200){
                        tableIns.reload();
                    }else{
                        layer.msg(data.msg, {icon: 5});
                    }
                }
            })
        });
    }




});
