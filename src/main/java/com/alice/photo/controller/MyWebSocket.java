//package com.alice.photo.controller;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArraySet;
//
///**
// * @author ghj
// * @Description websocket服务器端
// * @date 2020/1/10 10:52
// */
//@ServerEndpoint("/websocket")
//public class MyWebSocket {
//    private int onlineCount = 0;
//    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
//    // 若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标
////    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();
//    private static Map<Long, MyWebSocket> webSocketMap = new ConcurrentHashMap<Long, MyWebSocket>();
//    private Session session;
//
//    @OnOpen
//    public void onOpen(Session session) {
//        this.session = session;
//        webSocketMap.put(System.currentTimeMillis(), this);     //加入set中
//        addOnlineCount();           //在线数加1
//        System.out.println("有新连接加入！当前在线人数为" + webSocketMap.size());
//    }
//
//    @OnClose
//    public void onClose() {
//        webSocketMap.remove(session.getId());
//        subOnlineCount();
//        System.out.println("有一连接关闭！当前在线人数为" + webSocketMap.size());
//    }
//
//    /**
//     * 发送信息
//     *
//     * @param content
//     * @param session
//     */
//    @OnMessage
//    public void onMessage(String content, Session session) {
//        System.out.println("来自客户端的消息:" + content);
//        webSocketMap.forEach((key, myWebSocket) -> {
//            try {
//                myWebSocket.sendMsg(content, key);
//            } catch (IOException e) {
//                e.printStackTrace();
//
//            }
//        });
////        for (MyWebSocket webSocket : webSocketMap) {
////            try {
////                webSocket.sendMsg(content, webSocket);
////            } catch (Exception e) {
////                e.printStackTrace();
////                continue;
////            }
////        }
//    }
//
//    /**
//     * 发生错误时调用
//     *
//     * @param session
//     * @param error
//     */
//    @OnError
//    public void onError(Session session, Throwable error) throws IOException {
//        System.out.println("发生错误");
//        session.close();
//        error.printStackTrace();
//    }
//
//    private void sendMsg(String content, Long info) throws IOException {
//        this.session.getBasicRemote().sendText(content);
//    }
//
//    private void subOnlineCount() {
//        onlineCount--;
//    }
//
//    private int getOnlineCount() {
//        return this.onlineCount;
//    }
//
//    private void addOnlineCount() {
//        onlineCount++;
//    }
//}
