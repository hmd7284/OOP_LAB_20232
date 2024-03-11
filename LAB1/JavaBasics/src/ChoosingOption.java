import javax.swing.*;

public class ChoosingOption {
    public static void main(String[] args) {
        int option1 = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket", "Title", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option1 == JOptionPane.YES_OPTION ? "YES" : "NO"));
        String[] options = {"I do", "I don't"};
        int option2 = JOptionPane.showOptionDialog(null,
                "Do you want to change to the first class ticket??",
                "Title", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);

        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (option2 == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}