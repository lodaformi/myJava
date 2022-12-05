layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    //加载数据表格
    var  tableIns = table.render({
        //数据表格的id，用于头工具栏获取，达到多选条目的目的
        id : "saleChanceTable",
        //容器元素的ID属性值
        elem: '#saleChanceList',
        //容器的高度full-差值
        height: 'full-125',
        //单元格最小的宽度
        cellMinWidth : 95,
        //访问数据的URL(后台的数据接口) 设置flag参数，表示查询的事客户开发计划数据
        url : ctx+'/sale_chance/list?flag=1',
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
            {field: 'createDate', title: '创建时间', align:'center'},
            {field: 'updateDate', title: '修改时间', align:'center'},
            {field: 'devResult', title: '开发状态', align:'center',templet:function (d) {
                    return formatterDevResult(d.devResult);
                }},
            //行工具栏
            {title: '操作', templet:'#op',fixed:"right",align:"center", minWidth:150}
        ]]
    });


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

    //用户列表展示
    // var  tableIns = table.render({
    //     elem: '#saleChanceList',
    //     url : ctx+'/sale_chance/list?state=1&flag=1',
    //     cellMinWidth : 95,
    //     page : true,
    //     height : "full-125",
    //     limits : [10,15,20,25],
    //     limit : 10,
    //     toolbar: "#toolbarDemo",
    //     id : "saleChanceListTable",
    //     cols : [[
    //         {type: "checkbox", fixed:"center"},
    //         {field: "id", title:'编号',fixed:"true"},
    //         {field: 'chanceSource', title: '机会来源',align:"center"},
    //         {field: 'customerName', title: '客户名称',  align:'center'},
    //         {field: 'cgjl', title: '成功几率', align:'center'},
    //         {field: 'overview', title: '概要', align:'center'},
    //         {field: 'linkMan', title: '联系人',  align:'center'},
    //         {field: 'linkPhone', title: '联系电话', align:'center'},
    //         {field: 'description', title: '描述', align:'center'},
    //         {field: 'createMan', title: '创建人', align:'center'},
    //         {field: 'createDate', title: '创建时间', align:'center'},
    //         {field: 'devResult', title: '开发状态', align:'center',templet:function (d) {
    //                 return formatterDevResult(d.devResult);
    //             }},
    //         {title: '操作',fixed:"right",align:"center", minWidth:150,templet:"#op"}
    //     ]]
    // });
    //
    // function formatterDevResult(value){
    //     /**
    //      * 0-未开发
    //      * 1-开发中
    //      * 2-开发成功
    //      * 3-开发失败
    //      */
    //     if(value==0){
    //         return "<div style='color: yellow'>未开发</div>";
    //     }else if(value==1){
    //         return "<div style='color: #00FF00;'>开发中</div>";
    //     }else if(value==2){
    //         return "<div style='color: #00B83F'>开发成功</div>";
    //     }else if(value==3){
    //         return "<div style='color: red'>开发失败</div>";
    //     }else {
    //         return "<div style='color: #af0000'>未知</div>"
    //     }
    // }


    // 多条件搜索
    $(".search_btn").click(function(){
        tableIns.reload({
            page: {
                curr: 1 //重新从第 1 页开始
            },
            //设置需要传递给后端的参数
            where: {    //设定异步数据接口的额外参数,任意设
                //通过文本框/下拉框的值，设置传递的参数
                customerName: $("input[name='customerName']").val(),  //客户名
                createMan: $("input[name='createMan']").val(), //创建人
                devResult:$("#devResult").val()  //开发状态
            }
        })
    });


    /**
     * 行监听
     */
    //工具条事件
    //注：tool是工具条事件名，saleChances 是 table 原始容器的属性 lay-filter="对应的值"
    table.on('tool(saleChances)', function(obj){
        var layEvent = obj.event;
        if (layEvent == "dev") {
            openCusDevPlanDialog("计划项数据维护", obj.data.id);
        } else if (layEvent == "info") {
            openCusDevPlanDialog("计划项数据详情", obj.data.id);
        }
    });

    /**
     * 打开计划项开发或详情页面
     * @param name
     * @param id
     */
    function openCusDevPlanDialog(title, id) {
        //在iframe中打开，留出侧边菜单，而不是占据整个页面
        layui.layer.open({
            //类型： iframe 层
            type: 2,
            //标题
            title: title,
            //开启最大化最小化按钮
            maxmin: true,
            //大小（宽高）
            area: ['750px', '550px'],
            content: ctx + "/cus_dev_plan/toCusDevPlanPage?id="+id
        });
    }
    // 打开开发计划对话框
    // function openCusDevPlanDialog(title,sid){
    //     layui.layer.open({
    //         title : title,
    //         type : 2,
    //         area:["750px","550px"],
    //         maxmin:true,
    //         content : ctx+"/cus_dev_plan/toCusDevPlanDataPage?sid="+sid
    //     });
    // }




});
