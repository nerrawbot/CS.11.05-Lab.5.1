import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static int getCountryTotalWastePerYear(String country, String[] countries, int[] totalWasteKgPerCapitaPerYear)
    {
        for (int i = 0; i < countries.length; i++) {
            if (country.equals(countries[i])) {
                return totalWasteKgPerCapitaPerYear[i];
            }
        }
        return 0;
    }

    public static String getCountryWithMostWastePerCapita(String[] countries, int[] totalWasteKgPerCapitaPerYear)
    {
        int b = 0;
        int index = 0;
        for (int i = 0; i < countries.length; i++) {
            if (totalWasteKgPerCapitaPerYear[i] > b) {
                b = totalWasteKgPerCapitaPerYear[i];
                index = i;
            }
        }
        return countries[index];
    }

    public static String[] getCountriesWithHighestPovertyPercentage(String[] countries, double[] percentagesShareInPoverty)
    {
        double b = 0;
        int index = 0;
        int counter = 0;
        for (int i = 0; i < countries.length; i++){
            if (percentagesShareInPoverty[i] > b) {
                b = percentagesShareInPoverty[i];
            }
        }
        for (int i = 0; i < countries.length; i++){
            if (percentagesShareInPoverty[i] == b) {
                counter++;
            }
        }
        String[] countriesPer = new String[counter];
        int cIndex = 0;
        for (int i = 0; i < countries.length; i++) {
            if (percentagesShareInPoverty[i] == b) {
                countriesPer[cIndex++] = countries[i];
            }
        }
        return countriesPer;
    }

    public static String[] getCountriesWithHighConfidence(String[] countries, String[] confidences)
    {
        double b = 0;
        int index = 0;
        int counter = 0;
        for (int i = 0; i < countries.length; i++){
            if (confidences[i].equals("High Confidence")) {
                counter++;
            }
        }
        System.out.println(counter);
        String[] con = new String[counter];
        int cIndex = 0;
        for (int i = 0; i < countries.length; i++) {
            if (confidences[i].equals("High Confidence")) {
                con[cIndex++] = countries[i];
            }
        }
        System.out.println(Arrays.toString(con));
        return con;
    }
}
