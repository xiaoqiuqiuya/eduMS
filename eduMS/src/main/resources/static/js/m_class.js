layui.use('table', function() {
    var table = layui.table;
    var tableIns = table.render({
        id: 'class-table',
        elem: '#class-table'
        , height: 'full-100'
        , url: '/myClass' //数据接口
        ,where:{all:'all'}
        , page: true//开启分页
        , limits: [5, 10, 15, 20]
        , limit: 5
        , cols: [[ //表头
            {field: 'id', title: '班级ID', align: 'center', width: 100, fixed: 'left'}
            ,{field: 'name', title: '班级名', align: 'center', width: 250, fixed: 'left'}
            , {field: 'opentime', align: 'center', title: '开班时间', width: 160}
            , {field: 'status', align: 'center', title: '状态', width: 140}
            , {field: 'stage', align: 'center', title: '阶段', width: 150}
            , {field: 'chargeteacher', align: 'center', title: '班主任', width: 140}
            , {field: 'teachteacher', align: 'center', title: '教师', width: 140}
            , {title: '操作', align: 'center', templet: "#classList", width: 300, fixed: 'right'}
        ]]
    })
    //列表操作
    table.on('tool(class-table)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        var cid =obj.data.id;
        console.log(cid)
        if (layEvent == 'edit') {
            layer.open({
                title: '编辑班级信息'
                ,type:2
                ,offset: '0px'
                ,area: ['500px','500px']
                ,content:'/updateClass?cid='+cid
                ,end:function () {display();}
            });
        }else if(layEvent == 'work'){
            layer.open({
                title: '作业信息'
                ,type:2
                ,area: ['800px', '600px']
                ,content:'/work.html?id='+cid
            });
        }else if(layEvent == 'student'){
            layer.open({
                //需要得到当前行的class_id
                // title: '班级学生'
                title:obj.name
                ,type:2
                ,area: ['800px', '600px']
                ,content:'/classStudent.html?id='+cid
            });
        }else if (layEvent == 'del') {
            var str = {delid:data};
            console.log(JSON.stringify(str));
            layer.open({
                content: '是否删除该班级？'
                , btn: ['确定']
                , yes: function (index, layero) {
                    $.ajax({
                        url: "/editClass?id="+cid,
                        dataType: "JSON",
                        type: "POST",
                        contentType: "application/json;charsetset=UTF-8",
                        success: function (dataJson) {
                            layer.msg(dataJson.msg)
                            display();
                        }
                    })
                }
            });
        }
    })
})

function display() {
    layui.use('table', function () {
        var table = layui.table;
        table.reload('class-table', {
            url: "/myClass",
            where: {all: "all"}
        })
    })
}

layui.use('element', function(){
    var element = layui.element;

});


layui.use('form', function(){
    var form = layui.form;
});

//发送请求
function select() {
    var content = document.getElementById("content").value;
    var status = document.getElementById("status").value;
    console.log("content:"+content+"status:"+status);
    layui.use('table', function() {
                var table = layui.table;
                table.reload('class-table',{
                    url:'/myClass',
                    where:{content:content,status:status,all:'all'}
                })
            })
}
function addClass(){
    layer.open({
        title: '添加班级'
        ,type:2
        ,area: ['500px', '600px']
        ,content:'/updateClass'
    });
}
