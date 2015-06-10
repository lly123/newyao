package com.freeroom.websocket;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * Created by richard on 6/9/15.
 */
public class TalkServlet extends WebSocketServlet {
    @Override
    public void configure(final WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.register(TalkSocket.class);
    }
}
