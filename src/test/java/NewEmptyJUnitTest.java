/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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