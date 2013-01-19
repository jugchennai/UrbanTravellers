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

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author prasannakumar
 */
public class SignalPointTest {

    SignalPoint point = new SignalPoint(4);

    @Test
    public void testGivenPosInSignal() {
        point.setSignalColor(SignalColor.RED);
        assertEquals(true, point.isPositionInSignal(2));
    }

    @Test
    public void testToIgnoreOnGreenSignal() {
        point.setSignalColor(SignalColor.GREEN);
        assertEquals(false, point.isPositionInSignal(2));
    }

    @Test
    public void testToVerifyFarSignal() {
        point = new SignalPoint(11);
        point.setSignalColor(SignalColor.RED);
        assertEquals(false, point.isPositionInSignal(3));
    }

    @Test
    public void testShouldGetPassThroughValueOnRedSignal() {
        point = new SignalPoint(4);
        point.setSignalColor(SignalColor.RED);
        assertEquals(4, point.getValueToPassThrough(2, 6));
        assertEquals(1, point.getValueToPassThrough(4, 3));
        assertEquals(1, point.getValueToPassThrough(2, 2));
    }
}
