/* Elizabeth Fassler and Aliyah Banmah
COP 3337 Assignment 4
Java program that simulates a preprocessor.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

// The preprocessor class analyzes the program statements
class Preprocessor {
    private String inputFile;
    private Stack<Character> stack;
    public Preprocessor(String inputFile) {
        this.inputFile = inputFile;
    }
    // Method determines if the statements are valid or not valid
    public boolean isSyntaxValid() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            stack = new Stack<>();
            String line;

            while ((line = reader.readLine()) != null) {
                line = removeComments(line); // Remove comments before processing

                for (char c : line.toCharArray()) {
                    if (isOpeningDelimiter(c)) {
                        stack.push(c);
                    } else if (isClosingDelimiter(c)) {
                        if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                            return false;
                        }
                    }
                }
            }

            return stack.isEmpty();
                // Checking if delimiters are properly closed
            }

            catch (IOException e) {
                e.printStackTrace();
                return false;
                // Error when reading the file
            }
        }
    // Check if character is an opening delimiter
    private boolean isOpeningDelimiter(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    // Check if character is a closing delimiter
    private boolean isClosingDelimiter(char c) {
        return c == ')' || c == '}' || c == ']';
    }
    private boolean stackHasOpeningCommentDelimiter() {
        Stack<Character> tempStack = new Stack<>();
        if (!stack.isEmpty() && stack.peek() == '/') {
            tempStack.addAll(stack);
            tempStack.pop(); // Remove the '/' character from the stack
            return !tempStack.isEmpty() && tempStack.peek() == '*';
        }
        return false;
    }
    private boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']');
    }
    private String removeComments(String line) {
        StringBuilder result = new StringBuilder();
        boolean insideComment = false;

        for (int i = 0; i < line.length(); i++) {
            if (insideComment) {
                if (line.charAt(i) == '*' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
                    insideComment = false;
                    i++; // Skip the '*' character
                }
            } else {
                if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '*') {
                    insideComment = true;
                    i++; // Skip the '*' character
                } else {
                    result.append(line.charAt(i));
                }
            }
        }

        return result.toString();
    }
}





