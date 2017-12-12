/**
 * Created by zhangheng on 2017/9/20.
 */

var webSocket =null;
//连接到服务器
function connect() {
    if('WebSocket'in window){
        webSocket=new WebSocket("ws://localhost:8080/chat");
    }else {
        alert("no socket");
    }

    webSocket.onerror=function () {
        setMessageInnerHTML("error");
    }
    webSocket.onopen=function () {
        setMessageInnerHTML("打开连接");
    }
    webSocket.onmessage=function () {
        setMessageInnerHTML(event.data);
    }
    webSocket.onclose=function () {
        setMessageInnerHTML("关闭连接");
    }
    window.onbeforeunload=function () {
        webSocket.close();
    }
}
function setMessageInnerHTML(innerHtml) {
    document.getElementById('historyMsg').innerHTML+=innerHtml+'<br>';
}
function showChat() {
    $('#chatbtn').hide("fast",function(){
        connect();
        $('#chatdiv').show("slow");
    });
}
function closeWebSocket() {
    $('#chatdiv').hide("fast",function(){
        $('#chatbtn').show("slow");
    });
    webSocket.close();

}
function send() {
    webSocket.send($("#messageInput").val());
}

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