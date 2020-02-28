function login() {
    var username = document.getElementById("account").value;
    var password = document.getElementById("password").value;
    console.log("send request");
    // var data = {account:username,password:password};
    console.log(username,password);
    $.ajax({
        url:"/login",
        data:{account:username,password:password},
        dataType:"JSON",
        type:"POST",
        success:function(dataJson){
            console.log(dataJson.status)
            if(dataJson.status==1){
                console.log("登录成功");
                location.href="/index";
            }else{
                console.log(dataJson.msg);
                layui.use('layer', function(){
                    var layer = layui.layer;
                    layer.msg(dataJson.msg);
                });
            }
        }
    })
}
