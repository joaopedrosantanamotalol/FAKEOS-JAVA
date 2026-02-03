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
import com.fakeos.telas.TelaTerminal;

public class enterKeyBind {
    
    acoes AcaoTerminal = new acoes();
    
    // ===== FUNÇÃO PARA O ENTER ENVIAR OS DADOS DO JTEXFIELD
    public ArrayList<String> bindEnter(
        JTextField area,
        ArrayList<String> lista,
        JPanel painel,
        TelaTerminal telaTerminal
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
                    AcaoTerminal.Exemplo();

                    JLabel novo = new JLabel(">>> " + texto);
                    novo.setForeground(Color.GREEN);
                    novo.setAlignmentX(Component.LEFT_ALIGNMENT);

                    painel.add(Box.createVerticalStrut(10));
                    painel.add(novo);

                    painel.revalidate();
                    painel.repaint();    

                    area.setText("");
                    telaTerminal.scrollToBottom();
                }
            }
        });
        return(lista);
}

}
