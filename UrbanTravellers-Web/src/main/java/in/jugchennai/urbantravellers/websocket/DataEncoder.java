
package in.jugchennai.urbantravellers.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;

/**
 * @author Arun Gupta
 */
public class DataEncoder implements Encoder.Text<Gamedata> {
    @Override
    public String encode(Gamedata gd) throws EncodeException {
        return gd.getJson().toString();
    }
}
