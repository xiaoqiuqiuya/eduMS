
//Demo
layui.use('form', function(){
    var form = layui.form;
    //监听提交
});

layui.use('laydate', function() {
    var laydate = layui.laydate;
    //常规用法
    laydate.render({
        elem: '#contract_time',
        value: new Date()
    });
})


function addStudent() {
    var form = layui.form;
    var layer = layui.layer;
    var data = form.val("student-data");
    console.log("表单信息：");
    console.log(data);
    $.ajax({
        url: "/addStudent",
        data: JSON.stringify(data),
        dataType: "JSON",
        type: "POST",
        contentType: "application/json;charsetset=UTF-8",
        success: function (dataJson) {
            if (dataJson.status == 1) {
                layer.alert(dataJson.msg, {
                    icon: 1,
                    yes: function () {
                        //返回并且刷新页面
                        location = window.history.go(-1).reload();
                    },
                    closeBtn: 0
                });
            } else {
                layer.alert(dataJson.msg,{icon:2});
            }
        }
    })
}