/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.ads.simuladorestocastico.gui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.function.Consumer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Quantidade de tarefas a simular
 */
public class QuantityTextField extends JPanel {

    /**
     * Campo texto
     */
    private JTextField textField;
    /**
     * Valor default
     */
    private final int originalValue;

    /**
     * Construtor
     *
     * @param qtdDefault
     * @param label
     * @param callback
     */
    public QuantityTextField(int qtdDefault, String label, Consumer<Integer> callback) {
        super();
        originalValue = qtdDefault;
        textField = new JTextField();
        textField.setColumns(5);
        textField.setText(String.valueOf(qtdDefault));
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    callback.accept(0);
                } else {
                    callback.accept(Integer.parseInt(textField.getText()));
                }
            }
        });
        JLabel labelField = new JLabel(label);
        add(labelField);
        add(textField);
    }

    /**
     * Reseta o valor original do campo
     */
    void resetValue() {
        textField.setText(String.valueOf(originalValue));
    }

}
