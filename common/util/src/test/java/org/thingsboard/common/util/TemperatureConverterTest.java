/**
 * Copyright © 2016-2026 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    private static final double DELTA = 0.01;

    @Test
    public void testCelsiusToFahrenheit_freezingPoint() {
        Assertions.assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), DELTA);
    }

    @Test
    public void testCelsiusToFahrenheit_boilingPoint() {
        Assertions.assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), DELTA);
    }

    @Test
    public void testCelsiusToFahrenheit_roomTemperature() {
        Assertions.assertEquals(77.0, TemperatureConverter.celsiusToFahrenheit(25), DELTA);
    }

    @Test
    public void testFahrenheitToCelsius_freezingPoint() {
        Assertions.assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), DELTA);
    }

    @Test
    public void testFahrenheitToCelsius_boilingPoint() {
        Assertions.assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), DELTA);
    }

    @Test
    public void testCelsiusToKelvin_absoluteZero() {
        Assertions.assertEquals(0.0, TemperatureConverter.celsiusToKelvin(-273.15), DELTA);
    }

    @Test
    public void testCelsiusToKelvin_roomTemperature() {
        Assertions.assertEquals(298.15, TemperatureConverter.celsiusToKelvin(25), DELTA);
    }

    // @Test
    // public void testKelvinToCelsius_absoluteZero() {
    //     Assertions.assertEquals(-273.15, TemperatureConverter.kelvinToCelsius(0), DELTA);
    // }

}
