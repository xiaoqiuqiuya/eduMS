function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

var cid = GetQueryString("id");
console.log("id:" + cid);


//添加作业
function addWork() {
    location = "/getWork?cid="+cid;
}

layui.use('table', function () {
    var table = layui.table;
    var tableIns = table.render({
        id: 'task-table',
        elem: '#task-table'
        , url: '/work' //数据接口
        , where: {
            id: cid
        }
        , page: true//开启分页
        , limits: [5, 10, 15, 20]
        , limit: 5
        , cols: [[ //表头
            {field: 'id', title: '作业id', align: 'center', width: 70}
            , {field: 'createtime', title: '时间', align: 'center', width: 200}
            , {field: 'point', align: 'center', title: '知识点', width: 150}
            , {field: 'content', align: 'center', title: '内容'}
            , {title: '操作', align: 'center', templet: "#taskList", width: 150}
        ]]
    })
    //列表操作
    table.on('tool(task-table)', function (obj) {
        var layEvent = obj.event;
        var wid = obj.data.id;
        if (layEvent == 'edit') {
            location = "/getWork?wid=" + wid;
        } else if (layEvent == 'del') {
            console.log("作业id:" + wid);
            var str = {delid:wid};
            console.log(JSON.stringify(str));
            layer.open({
                content: '是否删除该次作业？'
                , btn: ['确定']
                , yes: function (index, layero) {
                    $.ajax({
                        url: "/doEditWork?delid="+wid,
                        // data: JSON.stringify(str),
                        dataType: "JSON",
                        type: "POST",
                        contentType: "application/json;charsetset=UTF-8",
                        success: function (dataJson) {
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


// layui.use('table', function() {
//     var table = layui.table;
//
// })

//Demo
layui.use('form', function () {
    var form = layui.form;
    //监听提交
    form.on('submit(formDemo)', function (data) {
    });
});

