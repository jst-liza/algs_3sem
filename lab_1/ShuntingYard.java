class ShuntingYard {

    public static boolean numChecker(String num) {
        String regex = "\\d*\\.?\\d+";
        return num.matches(regex);
    }

    public static int oPriority(String sign) {
        String[] list = {"-", "+", "/", "*", "^"};
        for (int j = 0; j < 5; j++) {
            if (sign.equals(list[j])) {
                if (j <= 1)
                    return 1;
                else if (j <= 3)
                    return 2;
                else
                    return 3;
            }
        }
        return 0;
    }

    public static boolean trigonometric(String func) {
        String[] list = {"cos", "sin"};
        if (func.equals(list[0]) || func.equals(list[1]))
            return true;
        return false;
    }

    public static void algorithm(String[] input) {
        Stack expression = new Stack(input.length);

        for (int i = 0; i < input.length; i++) {
            if (numChecker(input[i])) {
                    System.out.print(input[i] + " ");
                continue;
            }

            if (trigonometric(input[i])) {
                expression.push(input[i]);
                continue;
            }

            if (input[i].equals("(")) {
                expression.push(input[i]);
            }

            if (input[i].equals(")")) {
                while (!expression.top().equals("(")) {
                    System.out.print(expression.top() + " ");
                    expression.pop();
                }
                expression.pop();
                continue;
            }

            if (oPriority(input[i]) != 0) {
                while (!expression.isEmpty() && oPriority(expression.top()) >= oPriority(input[i])) {
                    if (oPriority(expression.top()) == oPriority(input[i]) && input[i].equals("^"))
                        break;
                    System.out.print(expression.top() + " ");
                    expression.pop();
                }
                expression.push(input[i]);
            }
        }
        while (!expression.isEmpty()) {
            System.out.print(expression.top() + " ");
            expression.pop();
        }
    }
}
