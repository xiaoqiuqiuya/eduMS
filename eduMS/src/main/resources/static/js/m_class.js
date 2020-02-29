layui.use('table', function() {
    var table = layui.table;
    var tableIns = table.render({
        id: 'class-table',
        elem: '#class-table'
        , height: 'full-100'
        , url: '/mClass' //数据接口
        // ,where:{content:content,status:status}
        , page: true//开启分页
        , limits: [5, 10, 15, 20]
        , limit: 5
        , cols: [[ //表头
            {field: 'name', title: '班级名', align: 'center', width: 250, fixed: 'left'}
            , {field: 'open_time', align: 'center', title: '开班时间', width: 160}
            , {field: 'st', align: 'center', title: '状态', width: 140}
            , {field: 'stage', align: 'center', title: '阶段', width: 150}
            , {field: 'charge_teacher', align: 'center', title: '班主任', width: 140}
            , {field: 'teach_teacher', align: 'center', title: '教师', width: 140}
            , {title: '操作', align: 'center', templet: "#classList", width: 300, fixed: 'right'}
        ]]
    })
    table.on('tool(class-table)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        if (layEvent == 'work') {
            layer.open({
                title: '作业信息'
                ,type:2
                ,area: ['800px', '600px']
                ,content:'/task.html?id='+data.id
            });

        }else if(layEvent=='student'){
            console.log(obj.name)
            layer.open({
                //需要得到当前行的class_id
                // title: '班级学生'
                title:obj.name
                ,type:2
                ,area: ['800px', '600px']
                ,content:'/student.html?id='+data.id
            });

        }else if(layEvent=='edit'){
            layer.open({
                title: '编辑班级信息'
                ,type:2
                ,area: ['500px', '600px']
                ,content:'/updateClass.jsp?id='+data.id
                // ,content:'/updateClass.html?data='+jsonStr+"&id="+data.id
            });

        }
        // else if(layEvent=='log'){
        //
        // }
        else if(layEvent=='del'){
            layer.open({
                content: '是否删除该次班次？'
                ,btn: ['确定']
                ,yes: function(index, layero){
                    $.ajax({
                        url:'/delClass',
                        data:{cid:data.id},
                        type:"POST",
                        dataType:"JSON",
                        success:function (dataJson) {
                            layer.msg(dataJson.msg)
                            location = location;
                            return;
                        }
                    })
                }
            });

        }
    })

})


layui.use('element', function(){
    var element = layui.element;

});


layui.use('form', function(){
    var form = layui.form;
});

function select() {
    var content = document.getElementById("content").value;
    var status = document.getElementById("status").value;
    console.log("2.content:"+content+"status:"+status);
    layui.use('table', function() {
                var table = layui.table;
                var tableIns = table.render({
                    id: 'class-table',
                    elem: '#class-table'
                    , height: 'full-100'
                    , url: '/mClass'
                    ,where:{content:content,status:status}
                    , page: true//开启分页
                    , limits: [5, 10, 15, 20]
                    , limit: 5
                    , cols: [[ //表头
                        {field: 'name', title: '班级名', align: 'center', width: 250, fixed: 'left'}
                        , {field: 'open_time', align: 'center', title: '开班时间', width: 160}
                        , {field: 'st', align: 'center', title: '状态', width: 160}
                        , {field: 'stage', align: 'center', title: '阶段', width: 150}
                        , {field: 'charge_teacher', align: 'center', title: '班主任', width: 160}
                        , {field: 'teach_teacher', align: 'center', title: '教师', width: 160}
                        , {title: '操作', align: 'center', templet: "#classList", width: 300, fixed: 'right'}
                    ]]
                })
            })
}

function addClass(){
    layer.open({
        title: '添加班级'
        ,type:2
        ,area: ['500px', '600px']
        ,content:'/addClass.html'
    });
}
