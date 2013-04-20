
package in.jugchennai.urbantravellers.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;

public class DataEncoder implements Encoder.Text<GameData> {
    @Override
    public String encode(GameData figure) throws EncodeException {
        return figure.getJson().toString();
    }
}
