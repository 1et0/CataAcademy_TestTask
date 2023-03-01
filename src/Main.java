import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифместическое выражение из 2-х чисел, через пробел:");
        String formula = scanner.nextLine();

        System.out.println("Ответ - " + calc(formula));
    }
    public static String calc(String input) {

        if (input.isEmpty()) {
            throw new RuntimeException("Вы ничего не ввели.");
        }

        String[] mathExp = input.split(" "); // разбиваем по пробелам

        if (mathExp.length != 3) {
            throw new RuntimeException("Ошибка ввода выражения");
        }

        if (isDigit(mathExp[0]) && isDigit(mathExp[2])) { // проверка на арабские числа
            int firstNum = Integer.parseInt(mathExp[0]);
            int secondNum = Integer.parseInt(mathExp[2]);
            char operation = mathExp[1].charAt(0);
            if (rangeDigit(firstNum) && rangeDigit(secondNum)) {
                return Calc.calcAction(firstNum, operation, secondNum);
            }
        } else if (isRoman(mathExp[0]) && isRoman(mathExp[2])) { // проверка на римские числа
            int firstNum = convertIsRoman(mathExp[0]);
            int secondNum = convertIsRoman(mathExp[2]);
            char operation = mathExp[1].charAt(0);
            String resultRoman;
            if (rangeDigit(firstNum) && rangeDigit(secondNum)) {
                resultRoman = Calc.calcAction(firstNum, operation, secondNum);
                if (Integer.parseInt(resultRoman) > 0) {
                    resultRoman = ConvertInRoman.getValue(resultRoman); // конвертация ответа в римское число
                    return resultRoman;
                }
                throw new RuntimeException("Результат меньше 1");
            }
        }
        throw new RuntimeException("Ошибка в написании выражения.");
    }

    static boolean isDigit(String mathExpression) {
        try {
            Integer.parseInt(mathExpression);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    static boolean isRoman(String value) {
        String[] romanArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String romanDigit : romanArray) {
            if (romanDigit.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
    static boolean rangeDigit(int rangeDigit) {
        if (rangeDigit > 0 && rangeDigit < 11) {
            return true;
        } else throw new RuntimeException("Вы вышли за допустимый диапазон числа");
    }
    static int convertIsRoman(String romanValue) {

        String[] romanArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int result = -100;

        for (int i = 1; i < romanArray.length + 1; i++) {
            if (romanValue.equalsIgnoreCase(romanArray[i - 1])) {
                result = i;
                return result;
            }
        }
        return result;
    }
}