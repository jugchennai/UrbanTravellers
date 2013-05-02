/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jugchennai.urbantravellers.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/SignalChange", encoders = {DataEncoder.class}, decoders = {DataDecoder.class})
public class SignalChangeSocket {

    protected static Set<Session> peers = Collections.synchronizedSet(new HashSet());

    @OnOpen
    public void onOpen(Session peer) throws Exception {
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
        peers.remove(peer);
    }

    @OnMessage
    public void broadCaseSignalChange(GameData gd, Session session) throws IOException, EncodeException {
        System.out.println("a signal change msg has been arrived " + gd.getJson().toString());
        for (Session peer : peers) {
            peer.getBasicRemote().sendObject(gd);
        }
    }
}
