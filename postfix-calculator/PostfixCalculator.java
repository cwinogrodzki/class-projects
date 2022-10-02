/*
Claire Winogrodzki
This program calculates postfix expressions. For example, 2 1 + in postfix
is equivalent to 2 + 1 = 3. It will print out examples given in main method
and evaluate expressions from the file sample.txt. "ERR" is printed if expression
is invalid, and will indicate a result of -0.0.
2/23/2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PostfixCalculator {

    /**
     * A helper function used to retrieve expressions from the specified file
     * @param filename - name of the file where the postfix expressions are read from
     */
    public static void parseFile(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));

            while (scan.hasNextLine()) {
                String expression = scan.nextLine();
                System.out.print("\n" + expression + " = ");
                double result = evaluate(expression);
                System.out.print(result);
            }
        }
        catch(FileNotFoundException e){
                System.out.println("error: file not found");
            }
    }


    /**
     * A postfix calculator that outputs the result from the given expression
     * Assume no precedence rules and no parentheses exist.
     * For example, 11 9 - is equal to 11 - 9 in the infix notation.
     * Check out this link for more examples: https://www.free-online-calculator-use.com/postfix-evaluator.html
     * This method prints the expression and the result separated by an equal sign.
     * For example, after evaluating the expression "11 9 -", your program will print "11 9 - = 2".
     * If the input expression is invalid, print =ERR=.
     * @param expression - a postfix expression to be evaluated (hint: could be valid or invalid)
     * @return - result of the postfix expression
     */
    public static double evaluate(String expression) {
        Stack<Double> s = new Stack();
        Double result = 0.0;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            //test if char is an operand, if true then push onto stack
            if (c >= '0' && c <= '9') {
                Double a = Double.parseDouble(String.valueOf(c));
                s.push(a);
            }

            //test if char is an operator, if true then complete operation
            else if ((c == '+') || (c == '-') || (c == '*') || (c == '/') || (c == '^')) {

                if (s.size() >= 2) { //before calculating, test if there are enough operands in stack
                    Double y = s.pop();
                    Double x = s.pop();

                    switch (c) {
                        case '+':
                            result = x + y;
                            break;
                        case '-':
                            result = x - y;
                            break;
                        case '*':
                            result = x * y;
                            break;
                        case '/':
                            result = x / y;
                            break;
                        case '^':
                            result = Math.pow(x, y);
                            break;
                        default:
                            break;
                    }

                    s.push(result);
                }

                else { //invalid expression
                    System.out.print("ERR ");
                    return -0.0;
                }
            }

            else if (c != ' ') { //invalid character
                System.out.print("ERR ");
                return -0.0;
            }
        }

        //check if there is one result left in stack
        if (s.size() == 1) {
            return result;
        }

        else { //invalid if more than one
            System.out.print("ERR ");
            return -0.0;
        }
    }

    public static void main(String[] args) {
        String expression = "3 4 * 2 + 9 - 3 ^";
        System.out.print(expression + " = ");
        double result = evaluate(expression);
        System.out.println(result);

        //evaluate expressions from file
        System.out.print("\nResults from file: ");
        parseFile("/Users/clairewinogrodzki/IdeaProjects/DataStructures/src/edu/belmont/csc3130/sample.txt");

        //my file path: /Users/clairewinogrodzki/IdeaProjects/DataStructures/src/edu/belmont/csc3130/sample.txt

        //more string inputs
        expression = "3 3 3 3 + + + ";
        System.out.print("\n\n" + expression + " = ");
        result = evaluate(expression);
        System.out.print(result);

        expression = "2 + -";
        System.out.print("\n" + expression + " = ");
        result = evaluate(expression);
        System.out.print(result);
    }
}
