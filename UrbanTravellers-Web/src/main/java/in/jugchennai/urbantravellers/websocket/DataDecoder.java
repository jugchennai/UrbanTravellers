/*
 * Copyright 2013 JUGChennai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package in.jugchennai.urbantravellers.websocket;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/*
 * 
 */
public class DataDecoder implements Decoder.Text<Gamedata> {

    Logger logger = Logger.getLogger(DataDecoder.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public Gamedata decode(String string) throws DecodeException {
        logger.info("In Data Decode");
        try {
            JSONObject jsonObject = new JSONObject(string);
            return new Gamedata(jsonObject);
        } catch (JSONException ex) {
            throw new DecodeException("Error parsing JSON", ex.getMessage(),
                    ex.fillInStackTrace());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean willDecode(String string) {
        logger.info("Check Decoding Data: " + string);
        try {
            new JSONObject(string);
            return true;
        } catch (JSONException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
