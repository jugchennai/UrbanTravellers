/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.jugchennai.urbantravellers.websocket;

import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author prasannakumar
 */
@ServerEndpoint(value = "/GameBoardWS",
        encoders = {DataEncoder.class},
        decoders = {DataDecoder.class})
public class GameBoardSocket {
    
}
