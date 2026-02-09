package org.thingsboard.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests d'intégration paramétrés pour DataSizeConverter.
 * 
 * Ces tests diffèrent des tests unitaires car:
 * - Ils utilisent des données externes (fichier CSV)
 * - Ils testent la précision bidirectionnelle des conversions
 * - Ils valident un grand volume de cas de test
 * 
 * Critère de qualité: Fonctionnalité / Exactitude
 * Objectif: Delta < 0.00001 pour toutes les conversions
 */
@DisplayName("Tests d'intégration - Exactitude des conversions de données")
public class DataSizeConverterIntegrationTest {

    private static final double PRECISION_DELTA = 0.00001;

    @ParameterizedTest(name = "Conversion bytes={0} vers KB={1}")
    @CsvFileSource(resources = "/conversion_test_data.csv", numLinesToSkip = 1)
    @DisplayName("Test conversion Bytes -> Kilobytes avec données CSV")
    void testBytesToKilobytes_FromCsv(long bytes, double expectedKB, double expectedMB, double expectedGB) {
        double actualKB = DataSizeConverter.bytesToKilobytes(bytes);
        assertEquals(expectedKB, actualKB, PRECISION_DELTA,
            String.format("Conversion %d bytes -> KB incorrecte. Attendu: %f, Obtenu: %f", 
                bytes, expectedKB, actualKB));
    }

    @ParameterizedTest(name = "Conversion bytes={0} vers MB={2}")
    @CsvFileSource(resources = "/conversion_test_data.csv", numLinesToSkip = 1)
    @DisplayName("Test conversion Bytes -> Megabytes avec données CSV")
    void testBytesToMegabytes_FromCsv(long bytes, double expectedKB, double expectedMB, double expectedGB) {
        double actualMB = DataSizeConverter.bytesToMegabytes(bytes);
        assertEquals(expectedMB, actualMB, PRECISION_DELTA,
            String.format("Conversion %d bytes -> MB incorrecte. Attendu: %f, Obtenu: %f", 
                bytes, expectedMB, actualMB));
    }

    @ParameterizedTest(name = "Conversion bytes={0} vers GB={3}")
    @CsvFileSource(resources = "/conversion_test_data.csv", numLinesToSkip = 1)
    @DisplayName("Test conversion Bytes -> Gigabytes avec données CSV")
    void testBytesToGigabytes_FromCsv(long bytes, double expectedKB, double expectedMB, double expectedGB) {
        double actualGB = DataSizeConverter.bytesToGigabytes(bytes);
        assertEquals(expectedGB, actualGB, PRECISION_DELTA,
            String.format("Conversion %d bytes -> GB incorrecte. Attendu: %f, Obtenu: %f", 
                bytes, expectedGB, actualGB));
    }

    @ParameterizedTest(name = "Conversion bidirectionnelle KB={1} -> bytes -> KB")
    @CsvFileSource(resources = "/conversion_test_data.csv", numLinesToSkip = 1)
    @DisplayName("Test conversion bidirectionnelle KB <-> Bytes")
    void testBidirectionalKilobytesConversion(long bytes, double expectedKB, double expectedMB, double expectedGB) {
        // Conversion KB -> Bytes -> KB (aller-retour)
        long convertedBytes = DataSizeConverter.kilobytesToBytes(expectedKB);
        double backToKB = DataSizeConverter.bytesToKilobytes(convertedBytes);
        
        assertEquals(expectedKB, backToKB, PRECISION_DELTA,
            String.format("Conversion bidirectionnelle KB échouée. Original: %f, Après aller-retour: %f", 
                expectedKB, backToKB));
    }

    @ParameterizedTest(name = "Conversion bidirectionnelle MB={2} -> bytes -> MB")
    @CsvFileSource(resources = "/conversion_test_data.csv", numLinesToSkip = 1)
    @DisplayName("Test conversion bidirectionnelle MB <-> Bytes")
    void testBidirectionalMegabytesConversion(long bytes, double expectedKB, double expectedMB, double expectedGB) {
        // Conversion MB -> Bytes -> MB (aller-retour)
        long convertedBytes = DataSizeConverter.megabytesToBytes(expectedMB);
        double backToMB = DataSizeConverter.bytesToMegabytes(convertedBytes);
        
        assertEquals(expectedMB, backToMB, PRECISION_DELTA,
            String.format("Conversion bidirectionnelle MB échouée. Original: %f, Après aller-retour: %f", 
                expectedMB, backToMB));
    }

    @ParameterizedTest(name = "Validation formatBytes pour {0} bytes")
    @CsvFileSource(resources = "/conversion_test_data.csv", numLinesToSkip = 1)
    @DisplayName("Test formatage des bytes avec données CSV")
    void testFormatBytes_FromCsv(long bytes, double expectedKB, double expectedMB, double expectedGB) {
        String formatted = DataSizeConverter.formatBytes(bytes);
        
        // Vérifier que le format n'est pas null ou vide
        assertNotNull(formatted, "Le format ne devrait pas être null");
        assertFalse(formatted.isEmpty(), "Le format ne devrait pas être vide");
        
        // Vérifier que le format contient l'unité appropriée
        if (bytes >= 1024L * 1024 * 1024) {
            assertTrue(formatted.contains("GB"), 
                String.format("Pour %d bytes, le format devrait contenir 'GB'. Obtenu: %s", bytes, formatted));
        } else if (bytes >= 1024L * 1024) {
            assertTrue(formatted.contains("MB"), 
                String.format("Pour %d bytes, le format devrait contenir 'MB'. Obtenu: %s", bytes, formatted));
        } else if (bytes >= 1024) {
            assertTrue(formatted.contains("KB"), 
                String.format("Pour %d bytes, le format devrait contenir 'KB'. Obtenu: %s", bytes, formatted));
        }
    }
}
