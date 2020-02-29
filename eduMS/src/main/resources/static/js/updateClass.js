// window.onload = function (ev) {
//         //获取修改的教师id
//         var id = location.search.slice(1);
//         var ids = id.id;
//         console.log(location.search.slice(1))
//         console.log("ids:"+ids);
//         $.ajax({
//             url:"/updateClass?"+id,
//             type:"Post",
//             dataType:"json",
//             success:function(dataJson){
//                 var data = dataJson.data;
//                 console.log("className:"+dataJson.name);
//                 $("#className").val(dataJson.name);
//                 //状态 = 3
//                 console.log("status:"+dataJson.status);
//                 // var id = dataJson.status;
//                 $("#status").val(dataJson.status);
//                 // var name = dataJson.className;
//                 //阶段
//                 $("#stage").val(dataJson.stage);
//                 //开班时间
//                 $("#open_time").val(dataJson.oTime);
//                 //班主任   添加选项  选中目前班主任
//                 //需要获取教师 id  和  教师名
//                 //添加班主任可选项
//                 console.log("班主任:"+dataJson.cTeacher[1].name);
//                 //取到班主任列表
//                 var cts = dataJson.cTeacher;
//                 $.each(cts,function(index,n){
//                     var str = "<option value='"+cts[index].id+"'>"+cts[index].name+"</option>";
//                     $("#charge_teacher").append(str);
//                     console.log("班主任:"+cts[index].name);
//                 });
//                 //选中目前的班主任
//                 $("#charge_teacher").val(dataJson.cid);
//                 //取到讲师列表
//                 var tts = dataJson.tTeacher;
//                 $.each(tts,function(index,n){
//                     var str = "<option value='"+tts[index].id+"'>"+tts[index].name+"</option>";
//                     $("#teach_teacher").append(str);
//                     // console.log("讲师:"+tts[index].name);
//                 });
//                 //选中目前的班主任
//                 $("#teach_teacher").val(dataJson.tid);
//             }
//         });
//
//
//     }
//

    //Demo
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
        });
    });
function doUpdataClass(){
    //id 班级名 状态 阶段 开班时间 班主任 教师
    var id = location.search.slice(1);
    var name = document.getElementById("className").value;
    var status = document.getElementById("status").value;
    var stage = document.getElementById("stage").value;
    var open_time =document.getElementById("open_time").value;
    var cid = document.getElementById("charge_teacher").value;
    var tid = document.getElementById("teach_teacher").value;
    console.log("name:"+name+"  status:"+status+"  stage:"+stage+"  open_time:"+open_time+"  cid:"+cid+"  tid:"+tid);
    $.ajax({
        url:"/doUpdataClass",
        data:{"id":id,"name":name,"status":status,"stage":stage,"open_time":open_time,"cid":cid,"tid":tid},
        type:"POST",
        dataType:"JSON",
        success:function(dataJson){
            if(dataJson.status==1){
                console.log("修改成功");
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.msg("修改成功");
                })
            }else{
                console.log("修改失败");
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.msg("修改失败");
                })
            }
        }
    })
}
