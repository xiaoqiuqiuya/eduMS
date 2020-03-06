layui.use('form', function(){
    var form = layui.form;
    //监听提交
});

/**
 * 添加 没id
 * 修改 有id
 *
 */
function doUpdateTeacher() {
    var form = layui.form;
    var  date = form.val("teacher-data");
    console.log(date)
    //发送ajax执行修改教师
    $.ajax({
        url:"/editTeacher"
        ,data:JSON.stringify(date)
        ,type:"POST"
        ,dataType:"JSON"
        ,contentType:"application/json;charset=UTF-8"
        ,success:function (dataJson) {
            if (dataJson.status==1){
                layer.alert("操作成功",{
                    icon:1
                    ,yes: function () {
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                    },
                    closeBtn: 0
                })
            }else {
                layer.alert(dataJson.msg,{icon:2})
            }
        }
    })
}