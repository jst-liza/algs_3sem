import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner flow = new Scanner(System.in);
        String userExpression = flow.nextLine();
        String[] exDivided = userExpression.split("(?<=[+-/*^()])|(?=[+-/*^()])");
        ShuntingYard.algorithm(exDivided);
    }
}

/*
    RegEx can be changed into " ", then it will work with float nums, but this way much easier to input without space-tockens
 */


