import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import java.util.Arrays;
import java.util.List;

public class Tests {

    String[] countries;
    int[] totalWasteKgPerCapitaPerYear;
    int[] householdEstimatesKgPerCapitaPerYear;
    int[] householdEstimatesTonnesPerYear;
    int[] retailEstimatesKgPerCapitaPerYear;
    int[] retailEstimatesTonnesPerYear;
    int[] foodServiceEstimatesKgPerCapitaPerYear;
    int[] foodServiceEstimatesTonnesPerYear;
    String[] confidences;
    String[] regions;
    String[] years;
    double[] percentagesShareInPoverty;

    @Before
    public void setUp()
    {
        CSVReader.populateArrays();

        countries = CSVReader.countries.toArray(new String[CSVReader.countries.size()]);
        totalWasteKgPerCapitaPerYear = CSVReader.totalWasteKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        householdEstimatesKgPerCapitaPerYear = CSVReader.householdEstimatesKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        householdEstimatesTonnesPerYear = CSVReader.householdEstimateTonnesPerYear.stream().mapToInt(i -> i).toArray();
        retailEstimatesKgPerCapitaPerYear = CSVReader.retailEstimateKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        retailEstimatesTonnesPerYear = CSVReader.retailEstimateTonnesPerYear.stream().mapToInt(i -> i).toArray();
        foodServiceEstimatesKgPerCapitaPerYear = CSVReader.foodServiceEstimateKgPerCapitaPerYear.stream().mapToInt(i -> i).toArray();
        foodServiceEstimatesTonnesPerYear = CSVReader.foodServiceEstimateTonnesPerYear.stream().mapToInt(i -> i).toArray();
        confidences = CSVReader.confidence.toArray(new String[CSVReader.confidence.size()]);
        regions = CSVReader.region.toArray(new String[CSVReader.region.size()]);
        years = CSVReader.year.toArray(new String[CSVReader.year.size()]);
        percentagesShareInPoverty = CSVReader.percentageShareInPoverty.stream().mapToDouble(i -> i).toArray();

    }

    /**************************************************************************************************************
     * Misc Tests
     **************************************************************************************************************/

    @Test
    public void getCountryTotalWastePerYear()
    {
        assertEquals(127, Main.getCountryTotalWastePerYear("Albania", countries, totalWasteKgPerCapitaPerYear));
        assertEquals(97, Main.getCountryTotalWastePerYear("Belize", countries, totalWasteKgPerCapitaPerYear));
        assertEquals(139, Main.getCountryTotalWastePerYear("United States of America", countries, totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void getCountryWithMostWastePerCapita()
    {
        assertEquals("Malaysia", Main.getCountryWithMostWastePerCapita(countries, totalWasteKgPerCapitaPerYear));
    }

    @Test
    public void getCountriesWithHighestPovertyPercentage()
    {
        List<String> countries = Arrays.asList(Main.getCountriesWithHighestPovertyPercentage(this.countries, percentagesShareInPoverty));
        assertTrue(countries.contains("Guinea-Bissau"));
        assertTrue(countries.contains("Madagascar"));
        assertTrue(countries.contains("Mali"));
        assertTrue(countries.contains("Somalia"));
        assertEquals(4, countries.size());
    }

    @Test
    public void getCountriesWithHighConfidence()
    {
        List<String> countries = Arrays.asList(Main.getCountriesWithHighConfidence(this.countries, confidences));
        assertTrue(countries.contains("Australia"));
        assertTrue(countries.contains("Austria"));
        assertTrue(countries.contains("Denmark"));
        assertTrue(countries.contains("Germany"));
        assertTrue(countries.contains("Italy"));
        assertTrue(countries.contains("Sweden"));
        assertTrue(countries.contains("United Kingdom"));
        assertTrue(countries.contains("United States of America"));

        assertEquals(8, countries.size());
    }
    
}
