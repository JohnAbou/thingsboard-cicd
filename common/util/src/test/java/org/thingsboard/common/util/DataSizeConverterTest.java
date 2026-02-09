package org.thingsboard.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataSizeConverterTest {

    private static final double DELTA = 0.01;

    @Test
    public void testBytesToKilobytes() {
        Assertions.assertEquals(1.0, DataSizeConverter.bytesToKilobytes(1024), DELTA);
        Assertions.assertEquals(2.5, DataSizeConverter.bytesToKilobytes(2560), DELTA);
    }

    @Test
    public void testBytesToMegabytes() {
        Assertions.assertEquals(1.0, DataSizeConverter.bytesToMegabytes(1024 * 1024), DELTA);
        Assertions.assertEquals(0.5, DataSizeConverter.bytesToMegabytes(512 * 1024), DELTA);
    }

    @Test
    public void testBytesToGigabytes() {
        Assertions.assertEquals(1.0, DataSizeConverter.bytesToGigabytes(1024L * 1024 * 1024), DELTA);
    }

    @Test
    public void testKilobytesToBytes() {
        Assertions.assertEquals(1024, DataSizeConverter.kilobytesToBytes(1.0));
        Assertions.assertEquals(2560, DataSizeConverter.kilobytesToBytes(2.5));
    }

    @Test
    public void testMegabytesToBytes() {
        Assertions.assertEquals(1024 * 1024, DataSizeConverter.megabytesToBytes(1.0));
    }

    @Test
    public void testFormatBytes_bytes() {
        Assertions.assertEquals("500 bytes", DataSizeConverter.formatBytes(500));
    }

    @Test
    public void testFormatBytes_kilobytes() {
        Assertions.assertEquals("1.50 KB", DataSizeConverter.formatBytes(1536));
    }

    @Test
    public void testFormatBytes_megabytes() {
        Assertions.assertEquals("1.00 MB", DataSizeConverter.formatBytes(1024 * 1024));
    }

    @Test
    public void testFormatBytes_gigabytes() {
        Assertions.assertEquals("1.00 GB", DataSizeConverter.formatBytes(1024L * 1024 * 1024));
    }

    
}
