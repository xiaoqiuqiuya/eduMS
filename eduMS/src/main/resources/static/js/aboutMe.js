//获取地址栏的tid
function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}
var tid = GetQueryString("tid");
var url = "/aboutMe"
if (tid!=null){
    url = "/aboutMe?tid="+tid;
}
$.ajax({
    url:url,
    type:"Post",
    dataType:"json",
    success:function(dataJson){
        var data = dataJson.data;
        $("#name").val(data[0].name);
        $("#type").val(data[0].type);
        $("#qq").val(data[0].qq);
        $("#weChat").val(data[0].weChat);
        $("#phone").val(data[0].phone);
        $("#email").val(data[0].email);
        $("#sex").val(data[0].sex);
    }
});
layui.use('form', function(){
    var form = layui.form;
    //监听提交
    form.on('submit(formDemo)', function(data){
        layer.msg("已提交修改请求");
        // return false;
    });
});
function reflash(){
    location=location;
}
function doUpdateTeacher() {
    //发送ajax执行修改教师
    $.ajax({
        url:"updataTeacher?option=updataTeacher",
        data:{
            name:name.value,
            type:type.value,
            qq:qq.value,
            weChat:weChat.value,
            phone:phone.value,
            email:email.value,
            sex:sex.value
        },
        dataType:"JSON",
        type:"POST",
        success:function (dataJson) {
            if (dataJson.status==1){
                layer.msg(dataJson.msg);
            }else {
                layer.msg(dataJson.msg);

            }
        }
    })
}
