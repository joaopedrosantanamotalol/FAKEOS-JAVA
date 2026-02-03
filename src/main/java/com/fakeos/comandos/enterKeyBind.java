package com.fakeos.comandos;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.*;

public class enterKeyBind {
    // ===== FUNÇÃO PARA O ENTER ENVIAR OS DADOS DO JTEXFIELD
    public static void bindEnter(
        JTextField area,
        ArrayList<String> lista,
        JPanel painel
) {
    area.getInputMap(JComponent.WHEN_FOCUSED)
        .put(KeyStroke.getKeyStroke("ENTER"), "enviarTexto");

    area.getActionMap()
        .put("enviarTexto", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = area.getText().trim();

                if (!texto.isEmpty()) {
                    lista.add(texto);

                    JLabel novo = new JLabel(">>> " + texto);
                    novo.setForeground(Color.GREEN);
                    novo.setAlignmentX(Component.LEFT_ALIGNMENT);

                    painel.add(Box.createVerticalStrut(10));
                    painel.add(novo);

                    painel.revalidate();
                    painel.repaint();    

                    area.setText("");
                }
            }
        });
}

}
