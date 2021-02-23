public class InfixToPostFix { 
  public static String infixToPostfix(String expression) {
        Stack<Character> operatorStack = new Stack<>();
        Stack<Character> postFixStack = new Stack<>();

        if (expression.length() == 0)
            return expression;

        String str = expression.replaceAll("\\s+", "");

        for (int i = 0; i < str.length(); i++) {
            char scan = str.charAt(i);

            if (scan == '+' || scan == '*' ||
                scan == '-' || scan == '/' ||
                scan == '(' || scan == ')') {

                if (operatorStack.isEmpty())
                    operatorStack.push(scan);

                else if (scan == '+' || scan == '-' &&
                        operatorStack.peek() == '*' || operatorStack.peek() == '/') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(')
                        postFixStack.push(operatorStack.pop());
                    operatorStack.push(scan);
                }
                else if (scan == ')') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(')
                        postFixStack.push(operatorStack.pop());
                    operatorStack.pop();
                }

                else
                    operatorStack.push(scan);
            }

            else
                postFixStack.push(scan);
        }

        while (!operatorStack.isEmpty())
            postFixStack.push(operatorStack.pop());

        StringBuilder strBuilder = new StringBuilder();
        for (Character c : postFixStack)
            strBuilder.append(c).append(" ");

        return strBuilder.toString();
    }

  public static void main (String[]args) throws IOException {
        System.out.println(infixToPostfix("2 * (1 + 3)"));
    }
}
