package br.feevale.ads.simuladorestocastico.gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Campo texto com legenda
 */
public class ProbsTextField extends JPanel {

    /**
     * Construtor
     *
     * @param probDefault
     * @param label
     * @param callback
     */
    public ProbsTextField(Double probDefault, String label, Consumer<Double> callback) {
        super();
        JTextField textField = new JTextField();
        textField.setColumns(5);
        textField.setText(String.valueOf(probDefault));
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    callback.accept(0.0);
                } else {
                    callback.accept(Double.parseDouble(textField.getText()));
                }
            }
        });
        JLabel labelField = new JLabel(label);
        add(labelField);
        add(textField);
    }

}
