function GetQueryString(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]);return null;
}
var cid = GetQueryString("id");
console.log("id:"+cid);

layui.use('table', function() {
    var table = layui.table;
    var tableIns = table.render({
        id: 'task-table',
        elem: '#task-table'
        , url: '/work' //数据接口
        ,where:{
            id:cid
        }
        , page: true//开启分页
        , limits: [5, 10, 15, 20]
        , limit: 5
        , cols: [[ //表头
            {field: 'id', title: '作业id', align: 'center', width: 200}
            ,{field: 'createtime', title: '时间', align: 'center', width: 200}
            , {field: 'point', align: 'center', title: '知识点', width: 150}
            , {field: 'content', align: 'center', title: '内容', width: 150}
            , {title: '操作', align: 'center', templet: "#taskList", width: 150}
        ]]
    })
    //列表操作
    table.on('tool(task-table)', function (obj) {
        var layEvent = obj.event;
         var wid = obj.data.id;
        // var content = data.content;
        // var point = data.point;
        // var wid = data.id;
        // document.cookie ="content="+content;
        // document.cookie ="point="+point;
        // document.cookie ="wid="+wid;
        //修改

        if (layEvent == 'edit') {
            // var content ="<div th:insert='~{navigation :: nav}'></div>"
            console.log("作业id:"+wid);
            // layer.open({
            //     title:'班级班级信息',
            //     type:2,
            //     content:'',
            // })
            // $.ajax({
            //     url:'/editWork',
            //     data:{wid:wid},
            //     type:"POST",
            //     dataType:"JSON",
            //     success:function (dataJson) {
            //     }
            // })
            location="/editWork?wid="+wid;
        }else if(layEvent == 'del'){
            layer.open({
                content: '是否删除该次作业？'
                ,btn: ['确定']
                ,yes: function(index, layero){
                    $.ajax({
                        url:'/delWork',
                        data:{wid:data.id},
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

//提交修改的作业信息
function doUpdataClass() {
    var form = layui.form;
    var layer = layui.layer;
    var data = form.val("class-data");
    console.log("表单信息：");
    console.log(data);
    $.ajax({
        url: "/editClass",
        data: JSON.stringify(data),
        dataType: "JSON",
        type: "POST",
        contentType: "application/json;charsetset=UTF-8",
        success: function (dataJson) {
            if (dataJson.status == 1) {
                layer.alert('修改成功', {
                    icon: 1,
                    yes: function () {
                        layer.msg(dataJson.msg);
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    },
                    closeBtn: 0
                });
            } else {

            }


        }
    })

}
