// var flag = document.getElementById("yn").checked;
layui.use('table', function() {
    var table = layui.table;
    var tableIns = table.render({
        //elem  绑定页面的table的id属性
        id: 'class-table',
        elem: '#class-table'
        , height: 'full-100'
        , url: '/myClass' //数据接口
        , page: true//开启分页
        , limits: [5, 10, 15, 20]
        , limit: 5
        , cols: [[ //表头
            // {field: 'name', title: '班级名', align: 'center', width: 250, fixed: 'left'}
            // , {field: 'open_time', align: 'center', title: '开班时间', width: 160}
            // , {field: 'st', align: 'center', title: '状态', width: 160}
            // , {field: 'stage', align: 'center', title: '阶段', width: 160}
            // , {field: 'charge_teacher', align: 'center', title: '班主任', width: 160}
            // , {field: 'teach_teacher', align: 'center', title: '教师', width: 160}
            , {title: '操作', align: 'center', templet: "#classList", width: 200}
        ]]
    })
//列表操作
    table.on('tool(class-table)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        if (layEvent == 'edit') {
            layer.open({
                title: '编辑班级信息'
                ,type:2
                ,area: ['500px', '600px']
                ,content:'/updateClass.jsp?id='+data.id
                // ,content:'/updateClass.html?data='+jsonStr+"&id="+data.id
            });
        }else if(layEvent == 'task'){
            layer.open({
                title: '作业信息'
                ,type:2
                ,area: ['800px', '600px']
                ,content:'/task.html?id='+data.id
            });

        }else if(layEvent == 'stu'){
            console.log(obj.name)
            layer.open({
                //需要得到当前行的class_id
                // title: '班级学生'
                title:obj.name
                ,type:2
                ,area: ['800px', '600px']
                ,content:'/student.html?id='+data.id
            });

        }
    })
})

layui.use('form', function () {
        var form = layui.form;
        //监听提交
    });

    function display() {
        var flag = document.getElementById("yn").checked;
        layui.use('table', function () {
            var table = layui.table;
            var tableIns = table.render({
                //elem  绑定页面的table的id属性
                id: 'class-table',
                elem: '#class-table'
                , height: 'full-100'
                , url: '/myClass?flag=' + flag //数据接口
                , page: true//开启分页
                , limits: [5, 10, 15, 20]
                , limit: 5
                , cols: [[ //表头
                    // {field: 'name', title: '班级名', align: 'center', width: 250, fixed: 'left'}
                    // , {field: 'open_time', align: 'center', title: '开班时间', width: 160}
                    // , {field: 'st', align: 'center', title: '状态', width: 160}
                    // , {field: 'stage', align: 'center', title: '阶段', width: 160}
                    // , {field: 'charge_teacher', align: 'center', title: '班主任', width: 160}
                    // , {field: 'teach_teacher', align: 'center', title: '教师', width: 160}
                    , {title: '操作', align: 'center', templet: "#classList", width: 200}
                ]]
            })
        })
    }

