package in.jugchennai.urbantravellers.websocket;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * 
 * @author prasannakumar
 */
public class UTGameDataDecoder implements Decoder.Text<UTGamedata> {

    Logger logger = Logger.getLogger(UTGameDataDecoder.class);

    @Override
    public UTGamedata decode(String string) throws DecodeException {
        logger.info("In Data Decode");
        try {
            JSONObject jsonObject = new JSONObject(string);
            return new UTGamedata(jsonObject);
        } catch (JSONException ex) {
            throw new DecodeException("Error parsing JSON", ex.getMessage(), ex.fillInStackTrace());
        }
    }

    @Override
    public boolean willDecode(String string) {
        logger.info("Check Decoding Data: " + string);
        try {
            JSONObject jsonObject = new JSONObject(string);
            return true;
        } catch (JSONException ex) {
            return false;
        }
    }
}
