package com.freeroom.websocket;

import org.eclipse.jetty.util.ConcurrentHashSet;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Set;

/**
 * Created by richard on 6/9/15.
 */
public class TalkSocket extends WebSocketAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static Set<Session> sessions = new ConcurrentHashSet();

    @Override
    public void onWebSocketConnect(Session session) {
        super.onWebSocketConnect(session);
        sessions.add(session);
        LOGGER.debug("Session from {} connected.", session.getRemoteAddress().getHostName());
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        sessions.remove(getSession());
        LOGGER.debug("Session from {} closed.", getSession().getRemoteAddress().getHostName());
        super.onWebSocketClose(statusCode, reason);
    }

    @Override
    public void onWebSocketError(Throwable cause) {
        super.onWebSocketError(cause);
    }

    @Override
    public void onWebSocketText(String message) {
        LOGGER.debug("Session from {} received message: {}.",
                getSession().getRemoteAddress().getHostName(), message);
    }
}
