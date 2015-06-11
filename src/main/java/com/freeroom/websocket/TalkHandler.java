package com.freeroom.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.lang.invoke.MethodHandles;

/**
 * Created by richard on 6/10/15.
 */
public class TalkHandler extends TextWebSocketHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.debug("Session {} is established.", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOGGER.debug("Session {} is closed.", session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        LOGGER.debug("Received message {} from session {}.", message.getPayload(), session.getId());
    }
}
