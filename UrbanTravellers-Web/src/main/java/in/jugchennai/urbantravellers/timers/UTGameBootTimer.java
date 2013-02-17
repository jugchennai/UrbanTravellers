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
package in.jugchennai.urbantravellers.timers;

import in.jugchennai.urbantravellers.websocket.GameBootSocketClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.websocket.ClientContainer;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author prasannakumar
 */
@Stateless
public class UTGameBootTimer {

    @Schedule(minute = "*/3", hour = "*", persistent = false)
    public void myTimer() {
        try {
            CountDownLatch messageLatch = new CountDownLatch(1);
            URI clientURI =
                    new URI("ws://localhost:8080/UrbanTravellers-Web/UTGameBootSocket");
            ClientContainer cliContainer = ContainerProvider.getClientContainer();
            cliContainer.connectToServer(new GameBootSocketClient(new JSONObject()), clientURI);
            messageLatch.await(1, TimeUnit.MINUTES);
        } catch (DeploymentException | URISyntaxException | InterruptedException ex) {
            Logger.getLogger(UTGameBootTimer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
