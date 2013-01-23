/*
 * Copyright 2012 JUGChennai.
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
 * @author prasannakumar
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

    /**
     *
     * @return
     */
    public int getSignalPos() {
        return signalPos;
    }

    /**
     *
     * @return
     */
    public SignalColor getSignalColor() {
        return signalColor;
    }

    /**
     *
     * @param signalColor
     */
    public void setSignalColor(SignalColor signalColor) {
        this.signalColor = signalColor;
    }

    /**
     *
     * @param position
     * @return
     */
    public boolean isPositionInSignal(int position) {
        return (this.signalColor == SignalColor.RED)
                && (position <= this.signalPos)
                && this.signalPos - position <= 6;
    }

    /**
     *
     * @param position
     * @param diceValue
     * @return
     */
    public int getValueToPassThrough(int position, int diceValue) {
        int asumedVal = position + diceValue;
        int edv = 0;
        if (this.signalPos == position || this.signalPos - asumedVal == 0) {
            edv = 1;
        } else if (this.signalPos - asumedVal < 0) {
            edv = -(this.signalPos - asumedVal);
        } else if (this.signalPos - asumedVal > 0) {
            edv = this.signalPos - asumedVal;
        } 
        return (isPositionInSignal(position)) ? edv : position + diceValue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.signalPos;
        hash = 89 * hash + (this.signalColor != null ? this.signalColor.hashCode() : 0);
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
