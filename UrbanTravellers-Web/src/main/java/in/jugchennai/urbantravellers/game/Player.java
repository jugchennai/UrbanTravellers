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
package in.jugchennai.urbantravellers.game;



/**
 *
 * @author Prasanna Kumar <prassee.sathian@gmail.com>
 */
public class Player {

    private String name;
    private int position,diceValue;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }

    @Override
    public boolean equals(Object obj) {
        Player player = (Player) obj;
        return (this.name.equals(player.getName())
                && this.diceValue == player.getDiceValue()
                && this.position == player.getPosition());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        
        return hash;
    }

    @Override
    public String toString() {
        return this.name + " is in position " 
                + this.position + " after rolling " 
                + this.diceValue + " on dice";
    }
}
