package in.jugchennai.urbantravellers.websocket;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * @author iArivu
 */
public class Gamedata {

    private JSONObject json;
    private Logger logger = Logger.getLogger(this.getClass());
   //  private String[] UserData = new String[50];

    public Gamedata() {
        
    }
    public Gamedata(JSONObject json) {
        this.json = json;
        logger.info("In GameData" + json);
        logger.info("GameData Length" + json.length());
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    @Override
    public String toString() {
        try {
            return json.toString(2);
        } catch (JSONException ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }
}
