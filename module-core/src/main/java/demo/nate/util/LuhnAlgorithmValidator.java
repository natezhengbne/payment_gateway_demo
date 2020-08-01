package demo.nate.util;

/**
 * https://en.wikipedia.org/wiki/Luhn_algorithm
 */
public class LuhnAlgorithmValidator {

    public static Boolean check(String cardNo){
        int nDigits = cardNo.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--)
        {

            int d = cardNo.charAt(i) - '0';

            if (isSecond == true){
                d = d * 2;
            }

            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }
}
