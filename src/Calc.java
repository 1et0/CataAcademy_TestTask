class Calc {
    static String calcAction(int a, char operation, int b) {

        switch (operation) {
            case '+':
                return String.valueOf(a + b);
            case '-':
                return String.valueOf(a - b);
            case '*':
                return String.valueOf(a * b);
            case '/':
                if (b == 0) {
                    return "на ноль делить нельзя";
                } else {
                    return String.valueOf(a / b);
                }
            default:
                throw new RuntimeException("Эта операция не поддерживается.");
        }
    }
}
