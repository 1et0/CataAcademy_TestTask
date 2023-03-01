class ConvertInRoman {

    static String[] romanDozens = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
    static String[] romanNumber = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    static String getValue(String arabicDigit) {
        String resultRoman = null;
        int indexRoman = Integer.parseInt(arabicDigit) / 10;
        int remainRoman = Integer.parseInt(arabicDigit) % 10;

        if (indexRoman == 0) {
            return resultRoman = romanNumber[remainRoman - 1];
        }
        if (remainRoman == 0) {
            return resultRoman = romanDozens[indexRoman - 1];
        }
        return resultRoman = romanDozens[indexRoman - 1] + romanNumber[remainRoman - 1];
    }
}


