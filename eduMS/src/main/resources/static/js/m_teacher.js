layui.use('table', function () {
    var table = layui.table;
    var tableIns = table.render({
        //elem  绑定页面的table的id属性
        id: 'teacher-table',
        elem: '#teacher-table'
        , height: 'full-120'
        , url: '/mTeacher' //数据接口
        , page: true//开启分页
        , limits: [5, 10, 15, 20]
        , limit: 5
        , cols: [[ //表头
            {field: 'name', title: '姓名', align: 'center', width: 100}
            , {field: 'typeToString', align: 'center', title: '类型', width: 80}
            , {field: 'phone', align: 'center', title: '电话', width: 160}
            , {field: 'wechat', align: 'center', title: '微信', width: 160}
            , {field: 'email', align: 'center', title: '邮件', width: 240}
            , {field: 'qq', align: 'center', title: 'QQ', width: 160}
            , {field: 'sex', align: 'center', title: '性别', width: 50}

            , {
                align: 'center',
                title: '状态',
                templet: "#status",
                width: 100
            }
            , {
                title: '操作',
                align: 'center',
                templet: "#teacherList",
                width: 160
            }
        ]]
    })
    //列表操作
    table.on('tool(teacher-table)', function (obj) {
        var layEvent = obj.event,
            data = obj.data;
        var id = data.id
        if (layEvent == 'edit') {
            var cont = "/getTeacher?option=editTeacher&id=" + id;
            console.log(data.id);
            layer.open({
                title: '修改教师信息'
                , type: 2
                , area: ['500px', '500px']
                , content: cont
                , end: function () {
                    doSelect();
                }
            });
        } else if (layEvent == 'changeStatus') {
            console.log(id);
            var flag = document.getElementById("yn").checked;
            $.ajax({
                url: "updateTeacherStatus",
                data: {flag: flag, id: id},
                type: "POST",
                dataType: "JSON"
            })
        } else if (layEvent == 'del') {
            console.log(id);
            $.ajax({
                url: "updateTeacherStatus",
                data: {del: true, id: id},
                type: "POST",
                dataType: "JSON",
                success: function (dataJson) {
                    if (dataJson.status == 1) {
                        layer.alert(dataJson.msg, {
                            icon: 1,
                        })
                    } else {
                        layer.alert(dataJson.msg, {icon: 2})
                    }
                }

            })
        }
    })


})


function addTeacher() {
    layer.open({
        title: '添加教师'
        , type: 2
        , area: ['500px', '550px']
        , content: '/getTeacher?option=addTeacher'
        , end: function () {
            doSelect();
        }
    });
}

function doSelect() {
    //获取 content type flag
    var content = document.getElementById("content").value;
    var type = document.getElementById("type").value;
    console.log("content:" + content + "    type:" + type);
    layui.use('table', function () {
        var table = layui.table;
        table.reload("teacher-table", {
            url: '/mTeacher' //数据接口
            , where: {content: content, type: type}
        })
    })
}


//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function () {
    var element = layui.element;

    //…
});


layui.use('form', function () {
    var form = layui.form;

    //各种基于事件的操作，下面会有进一步介绍
});