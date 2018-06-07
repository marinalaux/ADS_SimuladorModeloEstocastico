package simuladormodeloestocastico;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Campo texto com legenda
 */
public class ProbsTextField extends JPanel {
    
    public ProbsTextField(String label) {
        super();
        JTextField textField = new JTextField();
        textField.setColumns(5);
        JLabel labelField = new JLabel(label);
        add(labelField);
        add(textField);
    }
    
}
