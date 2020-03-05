//模糊查询
function doSelectStudent() {
    var content = document.getElementById("content").value;
    var status = document.getElementById("status").value;
        layui.use('table', function() {
            var table = layui.table;
            table.reload('student-table',{
                //elem  绑定页面的table的id属性
                elem: '#student-table'
                ,where:{content:content,status:status}
                , url: '/getStudent'
            })
        })
}
//初始化表格
layui.use('table', function() {
    var table = layui.table;
    var tableIns = table.render({
        //elem  绑定页面的table的id属性
        id: 'student-table',
        elem: '#student-table'
        , height: 'full-120'
        , url: '/getStudent' //数据接口
        , page: true//开启分页
        , limits: [15, 30,45, 60 ]
        , limit: 20
        , cols: [[ //表头
            {field: 'name', title: '名字', align: 'center', width: 100, fixed: 'left'}
            , {field: 'idcard', align: 'center', title: '身份证', width: 200}
            , {field: 'sex', align: 'center', title: '性别', width: 60}
            , {field: 'university', align: 'center', title: '学校', width: 160}
            , {field: 'className', align: 'center', title: '班级名字', width: 160}
            , {field: 'qq', align: 'center', title: 'QQ', width: 160}
            , {field: 'phone', align: 'center', title: '手机', width: 160}
            , {field: 'education', align: 'center', title: '学历', width: 80}
            , {field: 'email', align: 'center', title: '邮箱', width: 200}
            , {field: 'information', align: 'center', title: '信息', width: 160}
            , {field: 'major', align: 'center', title: '专业', width: 100}
            , {field: 'remark', align: 'center', title: '备注', width: 160}
            , {field: 'wechat', align: 'center', title: '微信', width: 160}
            , {field: 'channel', align: 'center', title: '途径', width: 80}
            , {field: 'contractteacher', align: 'center', title: '签约教师', width: 160}
        ]]
    })
    //列表操作
    table.on('tool(class-table)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        if (layEvent == '') {
        }
    })

})
//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});
// layui.use('form', function(){
//     var form = layui.form;
//     //各种基于事件的操作，下面会有进一步介绍
//     form.on('select(test)', function(data){
//         var status = data.value;
//         console.log(status); //得到被选中的值
//         // $.ajax({
//         //     url:'/selectStudent?class_status='+status,
//         //     dataType:"JSON",
//         //     type:"POST",
//         //     success:function (dataJson) {
//         layui.use('table', function() {
//             var table = layui.table;
//             var tableIns = table.render({
//                 //elem  绑定页面的table的id属性
//                 id: 'student-table',
//                 elem: '#student-table'
//                 , height: 'full-200'
//                 // , url: '/getStudents' //数据接口
//                 , url: '/selectStudent?class_status='+status
//                 , page: true//开启分页
//                 , limits: [20, 40,60, 80 ]
//                 , limit: 20
//                 , cols: [[ //表头
//                     {field: 'name', title: '名字', align: 'center', width: 100, fixed: 'left'}
//                     , {field: 'IDcard', align: 'center', title: '身份证', width: 200}
//                     , {field: 'sex', align: 'center', title: '性别', width: 60}
//                     , {field: 'university', align: 'center', title: '学校', width: 160}
//                     , {field: 'class_name', align: 'center', title: '班级名字', width: 160}
//                     , {field: 'qq', align: 'center', title: 'QQ', width: 160}
//                     , {field: 'phone', align: 'center', title: '手机', width: 160}
//                     , {field: 'education', align: 'center', title: '学历', width: 80}
//                     , {field: 'email', align: 'center', title: '邮箱', width: 200}
//                     , {field: 'information', align: 'center', title: '信息', width: 160}
//                     , {field: 'major', align: 'center', title: '专业', width: 100}
//                     , {field: 'remark', align: 'center', title: '备注', width: 160}
//                     , {field: 'wechat', align: 'center', title: '微信', width: 160}
//                     , {field: 'channel', align: 'center', title: '途径', width: 80}
//                     , {field: 'contract_teacher', align: 'center', title: '签约教师', width: 160}
//                 ]]
//             })
//         })
//     })
//     // })
//     // });
// });
