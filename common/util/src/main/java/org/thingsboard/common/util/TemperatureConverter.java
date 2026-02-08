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

/**
 * Utility class for converting temperature values between different units.
 * Useful for IoT sensor data normalization.
 */
public class TemperatureConverter {

    /**
     * Converts Celsius to Fahrenheit.
     * @param celsius temperature in Celsius
     * @return temperature in Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Converts Fahrenheit to Celsius.
     * @param fahrenheit temperature in Fahrenheit
     * @return temperature in Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    /**
     * Converts Celsius to Kelvin.
     * @param celsius temperature in Celsius
     * @return temperature in Kelvin
     */
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    /**
     * Converts Kelvin to Celsius.
     * @param kelvin temperature in Kelvin
     * @return temperature in Celsius
     */
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}
