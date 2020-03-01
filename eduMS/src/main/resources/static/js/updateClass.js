//Demo
layui.use('form', function () {
    var form = layui.form;
    //监听提交
    form.on('submit(formDemo)', function (data) {
    });
});

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
