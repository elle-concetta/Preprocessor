/* Elizabeth Fassler and Aliyah Banmah
COP 3337 Assignment 4
Java program that simulates a preprocessor.
 */
public class MyPreprocessor {
    public static void main(String[] args) {
        BasicFile fileSelector = new BasicFile();
        String inputFile = fileSelector.selectFile("Select the Java File.");

        if (inputFile == null) {
            System.err.println("No file selected. Exiting program...");
            return;
        }
        Preprocessor preprocessor = new Preprocessor(inputFile);
        boolean isSyntaxValid = preprocessor.isSyntaxValid();
        System.out.println("Input passed preprocessing: " + isSyntaxValid);
    }
}
