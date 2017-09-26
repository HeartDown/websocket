/**
 * Created by zhangheng on 2017/9/20.
 */
$(function () {
    var vm = new Vue({
        el:"#app",
        data:{
            show:false,
            blogs:getAllBlog()
        }
    })
    setTimeout(() =>{
        vm.show = true;
    },500);
})
function getAllBlog() {
    var blog;
    $.ajaxSettings.async = false;
    $.ajax({
        url:"getAllBlog",
        method:"get",
        success:function (data) {
            blog=data;
        }
    })
    $.ajaxSettings.async = true;

    return blog;
}