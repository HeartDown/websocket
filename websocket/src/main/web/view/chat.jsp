<%--
  Created by IntelliJ IDEA.
  User: zhangheng
  Date: 2017/8/1
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <script src="js/jquery-1.7.2.js"></script>
    <title>$Title$</title>
</head>
<body>
<script type="text/javascript">
    var webSocket =null;
    if('WebSocket'in window){
        webSocket=new WebSocket("ws://localhost:8080/chat");
    }else {
        alert("no socket");
    }
    webSocket.onerror=function () {
        setMessageInnerHTML("error");
    }
    webSocket.onopen=function () {
        setMessageInnerHTML("open");
    }
    webSocket.onmessage=function () {
        setMessageInnerHTML(event.data);
    }
    webSocket.onclose=function () {
        setMessageInnerHTML("close");
    }
    window.onbeforeunload=function () {
        webSocket.close();
    }
    function setMessageInnerHTML(innerHtml) {
        document.getElementById('message').innerHTML+=innerHtml+'<br>';
    }
    function closeWebSocket() {
        webSocket.close();
    }
    function send() {
        alert($("#content").val());
        webSocket.send($("#content").val());
    }
</script>
welcome<br>
<input type="text" id="content"><button onclick="send()" >Send</button>
<button onclick="closeWebSocket()">close</button>
<div id="message"></div>
</body>
</html>
