$(function () {

    var editor=null;
    var vm = new Vue({
        el: '#app',
        name:'editor',
        insertOrUpdate:true,//默认为新增
        data: {
            curUser:getuser(),
            file:null,
            loadingStatus:false,
            blog:{
                title:'请输入标题',
                content:'',
                slug:'',
                social:[],
                type:[],
                coverUrl:''
            },
            collapse1:1,
            suibinumber:2,
            textnumber:0,
            caogaonumber:4,
            visible: false,
            theme1: 'light',
            value1: 25,
            value2: [20, 50],
            value3: [20, 50]
        },
        computed:{

        },
        methods: {
            addNew:function () {
                window.location.href=getUrl()+"seeBlog";
            },
            show: function () {
                this.visible = true;
            },unloadblog:function () {
                layer.msg('确定提交？', {
                    time: 0//不自动关闭
                    ,icon: 6
                    ,btn: ['必须啊', '不，再想想']
                    ,yes: function(index){
                        vm.blog.content=editor.txt.html();
                        vm.blog.coverUrl='images/'+vm.file.name;
                        var date = new Date();
                        var dateformmater = date.getFullYear()+"-"+((date.getMonth()+1)<10?'0'+(date.getMonth()+1):(date.getMonth()+1))+"-"+
                            ((date.getDate()+1)<10?'0'+(date.getDate()+1):(date.getDate()+1));
                        if(vm.insertOrUpdate){
                            vm.blog.created=dateformmater;
                        }else {
                            vm.blog.modified=dateformmater;
                        }
                        axios({
                            method:'post',
                            url:'http://localhost:8080/insert',
                            params:{
                                content:JSON.stringify(vm.blog)
                            },headers:{
                                'Content-Type': 'application/x-www-form-urlencoded'
                            }
                        }).then(function (response) {
                            if(response.data){
                                //上传图片
                                vm.uploads();
                                alert(JSON.stringify(response.data.message));
                                window.location.href=getUrl()+"/seeBlog";
                            }
                        })
                    }
                });
            },handleSuccess(response, file, fileList){
                layer.msg(response.message);
            },handleUpload:function(file){
                vm.file = file;
                return this.loadingStatus;
            },
            uploads(){
                this.loadingStatus = true;
                this.$refs.upload.upload(this.file);
                // this.$emit('before-upload',this.loadingStatus );
                setTimeout(() =>{
                    this.$Message.success("上传成功");
                },500);
            }
        }
        ,mounted(){
            // 获取元素
            var div = document.getElementById('div1');
            editor = new wangEditor(div);
            editor.customConfig.jsFilter = false;
            // 上传图片（举例）
            editor.customConfig.uploadImgUrl = '/upload';

            // 配置自定义参数（举例）
            editor.customConfig.uploadParams = {
                token: 'abcdefg',
                user: 'wangfupeng1988'
            };

            // 设置 headers（举例）
            editor.customConfig.uploadHeaders = {
                'Accept' : 'text/x-json'
            };

            // 隐藏掉插入网络图片功能。该配置，只有在你正确配置了图片上传功能之后才可用。
            editor.customConfig.hideLinkImg = true;
            // 生成编辑器
            editor.create();
        }

    })
})
function getuser() {
    var curUser;
    $.ajaxSettings.async = false;
    $.ajax({
        url: "getUser",
        method: "get"
        ,success : function(data) {
            if (data) {
                curUser= data;
            }
        }});
    $.ajaxSettings.async = true;
    return curUser;
}