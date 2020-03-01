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
            // 关闭所有
                layer.msg(dataJson.msg);
                layer.closeAll();
            } else {

            }


        }
    })

}
