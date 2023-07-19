/* Elizabeth Fassler and Aliyah Banmah
COP 3337 Assignment 4
Java program that simulates a preprocessor.
 */
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BasicFile {
    public String selectFile(String dialogTitle) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle(dialogTitle);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Java Files", "java"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }
}

