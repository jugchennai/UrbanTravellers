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
public class SignalPoint {

    private int signalPos;
    private SignalColor signalColor;

    /**
     *
     * @param position
     */
    public SignalPoint(int position) {
        this.signalPos = position;
        this.signalColor = SignalColor.RED;
    }

    public int getSignalPos() {
        return signalPos;
    }

    public SignalColor getSignalColor() {
        return signalColor;
    }

    public void setSignalColor(SignalColor signalColor) {
        this.signalColor = signalColor;
    }

    /**
     * if the given position is nearby signal 
     * to honor the dice or not
     * @param position
     * @return
     */
    public boolean isPositionInSignal(int position) {
        return (this.signalColor == SignalColor.RED)
                && (position <= this.signalPos)
                && this.signalPos - position <= 6;
    }

    /**
     * check whether to honor the dice 
     * or not. 
     * @param position
     * @param diceValue
     * @return 
     */
    public boolean allowedToGo(int position, int diceValue) {
        int asumedVal = position + diceValue;
        boolean go = false;
        if (asumedVal <= this.signalPos && this.signalColor == SignalColor.RED) {
            go = true;
        } else if (position == this.signalPos 
                && this.signalColor == SignalColor.RED) {
            go = false;
        } 
        return go;
    }

    @Override
    public String toString() {
        return "" + this.signalPos + " in " + this.signalColor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.signalPos;
        hash = 89 * hash + 
                (this.signalColor != null ? this.signalColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SignalPoint other = (SignalPoint) obj;
        if (this.signalPos != other.signalPos) {
            return false;
        }
        if (this.signalColor != other.signalColor) {
            return false;
        }
        return true;
    }
}
