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
 * Utility class for converting data sizes between different units.
 * Useful for IoT telemetry data transmission monitoring and display.
 */
public class DataSizeConverter {

    private static final long BYTES_PER_KB = 1024L;
    private static final long BYTES_PER_MB = 1024L * 1024L;
    private static final long BYTES_PER_GB = 1024L * 1024L * 1024L;

    /**
     * Converts bytes to kilobytes.
     * @param bytes the number of bytes
     * @return size in kilobytes
     */
    public static double bytesToKilobytes(long bytes) {
        return (double) bytes / BYTES_PER_KB;
    }

    /**
     * Converts bytes to megabytes.
     * @param bytes the number of bytes
     * @return size in megabytes
     */
    public static double bytesToMegabytes(long bytes) {
        return (double) bytes / BYTES_PER_MB;
    }

    /**
     * Converts bytes to gigabytes.
     * @param bytes the number of bytes
     * @return size in gigabytes
     */
    public static double bytesToGigabytes(long bytes) {
        return (double) bytes / BYTES_PER_GB;
    }

    /**
     * Converts kilobytes to bytes.
     * @param kilobytes the number of kilobytes
     * @return size in bytes
     */
    public static long kilobytesToBytes(double kilobytes) {
        return (long) (kilobytes * BYTES_PER_KB);
    }

    /**
     * Converts megabytes to bytes.
     * @param megabytes the number of megabytes
     * @return size in bytes
     */
    public static long megabytesToBytes(double megabytes) {
        return (long) (megabytes * BYTES_PER_MB);
    }

    /**
     * Formats bytes to a human-readable string.
     * @param bytes the number of bytes
     * @return formatted string (e.g., "1.5 MB")
     */
    public static String formatBytes(long bytes) {
        if (bytes >= BYTES_PER_GB) {
            return String.format("%.2f GB", bytesToGigabytes(bytes));
        } else if (bytes >= BYTES_PER_MB) {
            return String.format("%.2f MB", bytesToMegabytes(bytes));
        } else if (bytes >= BYTES_PER_KB) {
            return String.format("%.2f KB", bytesToKilobytes(bytes));
        } else {
            return bytes + " bytes";
        }
    }
}
