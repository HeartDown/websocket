package com.socket;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
/**
 * Created by zhangheng on 2017/8/1.
 */
@ServerEndpoint("/chat")
public class MyWebSocket {
    public static int online = 0;

    private static CopyOnWriteArraySet<MyWebSocket> webSockets =
            new CopyOnWriteArraySet<>();
    //用户对话
    private Session session;

    /**
     * 链接建立时调用
     * @param session1
     */
    @OnOpen
    public void onOpen(Session session1){
        this.session=session1;
        webSockets.add(this);
        addCount();
        System.out.println("当前连接的用户："+session1.getId());
    }
    @OnClose
    public void onClose(Session session){
        webSockets.remove(this);
        subCount();
        System.out.println(session.getId()+"用户退出了，当前在线人数为："+online);
    }
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println(session.getId()+"来自客户端消息："+message);

        for (MyWebSocket m :
                webSockets) {
            try {
                m.sendMessage(session.getId()+":"+message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public synchronized int getOnline(){
        return online;
    }
    public synchronized static void addCount() {
        MyWebSocket.online++;
    }
    public synchronized static void subCount() {
        MyWebSocket.online--;
    }
}
