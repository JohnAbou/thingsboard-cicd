package org.thingsboard.common.util;

public class DataSizeConverter {

    private static final long BYTES_PER_KB = 1024L;
    private static final long BYTES_PER_MB = 1024L * 1024L;
    private static final long BYTES_PER_GB = 1024L * 1024L * 1024L;


    public static double bytesToKilobytes(long bytes) {
        return (double) bytes / BYTES_PER_KB;
    }

    public static double bytesToMegabytes(long bytes) {
        return (double) bytes / BYTES_PER_MB;
    }

    public static double bytesToGigabytes(long bytes) {
        return (double) bytes / BYTES_PER_GB;
    }

    public static long kilobytesToBytes(double kilobytes) {
        return (long) (kilobytes * BYTES_PER_KB);
    }

    public static long megabytesToBytes(double megabytes) {
        return (long) (megabytes * BYTES_PER_MB);
    }

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
