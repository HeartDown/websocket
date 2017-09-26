<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>iview example</title>
    <link rel="stylesheet" href="/static/css/loginstyles.css">
    <script type="text/javascript" src="/static/js/vue.min.js" ></script>
    <script type="text/javascript" src="/static/js/axios.js" ></script>
    <script type="text/javascript" src="/static/js/globle.js" ></script>
</head>
<body>
<div class="htmleaf-container" id="app">
    <div class="wrapper">
        <div class="container">
            <h1>Welcome</h1>
            <form class="form">
                <input type="text" v-model="formItem.username" placeholder="Username">
                <input type="password" v-model="formItem.password" placeholder="Password">
                <input type="textarea" v-model="formItem.personinfo" placeholder="introduce">
                <button type="button" @click="handleSubmit('formItem')">Login</button>
            </form>
        </div>
        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
</div>
<script>
    new Vue({
        el: '#app',
        data(){
            return{
                formItem:{
                    username:'aaa',
                    password:'1234',
                    personinfo:"无名而立",
                }
            }
        },
        methods: {
            handleSubmit (name) {
//                this.$refs[name].validate((valid) => {
//                    if (valid) {
                        this.$Message.success('提交成功!');
                        axios({
                            method: 'post',
                            url: 'http://localhost:8080/login',
                            params: {
                                formitem: this.formItem
                            },headers:{
                                'Content-Type': 'application/x-www-form-urlencoded'
                            }
                        }).then(function (response) {
                            if(response.data){
                                if(response.data.status=="success"){
                                    alert(JSON.stringify(response.data.msg));
                                    location.href="seeBlog";
                                }
                                else {
                                    alert(JSON.stringify(response.data.msg));
                                }
                            }
                        }).catch(function (error) {
                            alert(error);
                        });
//                    } else {
//                        this.$Modal.info({
//                        title: 'fail',
//                        content: '表单验证失败!'
//                    });
//            }
//            })
            },handleReset(name){
                this.$refs[name].resetFields();
            }
        }
    })
</script>
</body>
</html>