
package in.jugchennai.urbantravellers.websocket;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;

public class UTGameDataEncoder implements Encoder.Text<UTGamedata> {
    
    /**
     * 
     * @param gd
     * @return
     * @throws EncodeException 
     */
    @Override
    public String encode(UTGamedata gd) throws EncodeException {
        return gd.getJson().toString();
    }
}
