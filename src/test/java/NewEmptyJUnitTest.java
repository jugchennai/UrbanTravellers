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
import in.jugchennai.urbantravellers.game.Player;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author prasannakumar
 */
public class NewEmptyJUnitTest {
    protected Map<String, Player> playerMap = new LinkedHashMap<>();
    
    @Before
    public void init() {
        playerMap.put("raj", new Player("raj"));
        playerMap.put("shiv", new Player("shiv"));
        playerMap.put("arivu", new Player("arivu"));
    }
    
    @Test
    public void testNextPlayer() {
        String currPlayer = "arivu";
        String players[] = playerMap.keySet().toArray(new String[]{});
        int index = 0;
        int tofind = 0;
        while(index < players.length) {
            if( players[index].equals(currPlayer)) {
                tofind = index +1;
                System.out.println("to find " + tofind);
                if(index+1 == players.length) {
                    tofind = 0;
                }
                break;
            }
            index ++;
        }
        System.out.println("next player " + players[tofind]);
    }
}