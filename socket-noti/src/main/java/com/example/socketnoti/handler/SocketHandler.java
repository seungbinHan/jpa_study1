package com.example.socketnoti.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.ArrayList;


@Component
public class SocketHandler extends TextWebSocketHandler {

    private final ArrayList<WebSocketSession> userSessions = new ArrayList<WebSocketSession>();

    /* Client가 접속 시 호출되는 메서드 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("연결 1");
        userSessions.add(session);
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(message.getPayload());
        TextMessage tm = new TextMessage("서버에서 주는 메시지!");

        for(var sess : userSessions){
            if(sess.getAttributes().get("admin") != null &&
                    sess.getAttributes().get("admin").equals("admin")){
                sess.sendMessage(tm);
            }
        }
    }


    /* Client가 접속 해제 시 호출되는 메서드드 */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        userSessions.remove(session);
    }
}
