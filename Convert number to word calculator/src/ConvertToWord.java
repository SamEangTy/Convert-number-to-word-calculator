
public class ConvertToWord {
	
		// convert to english word
	 	private static final String[] UNITS_EN = {
	            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
	            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
	    };

	    private static final String[] TENS_EN = {
	            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
	    };
	    public static String ConvertToWordEN(int number) {
	        if (number == 0) {
	            return "";
	        } else if (number < 0 || number > 99999) {
	            throw new IllegalArgumentException("Number out of range");
	        }

	        if (number < 20) {
	            return UNITS_EN[number];
	        } else if (number < 100) {
	            int TENS_ENDigit = number / 10;
	            int UNITS_ENDigit = number % 10;
	            return TENS_EN[TENS_ENDigit] + " " + UNITS_EN[UNITS_ENDigit];
	        } else if (number < 1000) {
	            int hundredsDigit = number / 100;
	            int remainingNumber = number % 100;
	            return UNITS_EN[hundredsDigit] + " hundred " + ConvertToWordEN(remainingNumber);
	        } else if (number < 10000) {
	            int thousandsDigit = number / 1000;
	            int remainingNumber = number % 1000;
	            return UNITS_EN[thousandsDigit] + " thousand " + ConvertToWordEN(remainingNumber);
	        } else {
	            int tenThousandsDigit = number / 10000;
	            int remainingNumber = number % 10000;
	            return TENS_EN[tenThousandsDigit] + " thousand " + ConvertToWordEN(remainingNumber);
	        }
	    }
	    // covert to khmer word
	    private static final String[] UNITS_KH = {
	            "", "មួយ", "ពីរ", "បី", "បួន", "ប្រាំ", "ប្រាំមួយ", "ប្រាំពីរ", "ប្រាំបី", "ប្រាំបួន",
	            "ដប់", "ដប់មួយ", "ដប់ពីរ", "ដប់បី", "ដប់បួន", "ដប់ប្រាំ", "ដប់ប្រាំមួយ", "ដប់ប្រាំពីរ", "ដប់ប្រាំបី", "ដប់ប្រាំបួន"
	    };

	    private static final String[] TENS_KH = {
	            "", "", "ម្ភៃ", "សាមសិប", "សែសិប", "ហាសិប", "ហុកសិប", "ចិតសិប", "ប៉ែតសិប", "កៅសិប"
	    };
	    public static String ConvertToWordKH(int number) {
	        if (number == 0) {
	            return "";
	        } else if (number < 0 || number > 99999) {
	            throw new IllegalArgumentException("Number out of range");
	        }

	        if (number < 20) {
	            return UNITS_KH[number];
	        } else if (number < 100) {
	            int tensDigit = number / 10;
	            int unitsDigit = number % 10;
	            return TENS_KH[tensDigit] + "" + UNITS_KH[unitsDigit];
	        } else if (number < 1000) {
	            int hundredsDigit = number / 100;
	            int remainingNumber = number % 100;
	            return UNITS_KH[hundredsDigit] + "​រយ" + ConvertToWordKH(remainingNumber);
	        } else if (number < 10000) {
	            int thousandsDigit = number / 1000;
	            int remainingNumber = number % 1000;
	            return UNITS_KH[thousandsDigit] + "​ពាន់" + ConvertToWordKH(remainingNumber);
	        } else {
	            int tenThousandsDigit = number / 10000;
	            int remainingNumber = number % 10000;
	            return UNITS_KH[tenThousandsDigit] + "ម៉ឺន" + ConvertToWordKH(remainingNumber);
	        }
	    }
	   // covert to USD 
	    public static double ConvertToUSD(double amountInRiel) {
	        double exchangeRate = 4000; // 1 USD = 4000 Riel
	        return amountInRiel / exchangeRate;
	    }
}


