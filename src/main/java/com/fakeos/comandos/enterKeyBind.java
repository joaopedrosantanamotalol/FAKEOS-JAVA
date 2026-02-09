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

    private acoes acaoTerminal;

    public enterKeyBind(TelaTerminal telaTerminal) {
        this.acaoTerminal = new acoes(telaTerminal);
    }

    public ArrayList<String> bindEnter(
            JTextField area,
            ArrayList<String> lista,
            JPanel painel,
            TelaTerminal telaTerminal) {
        area.getInputMap(JComponent.WHEN_FOCUSED)
                .put(KeyStroke.getKeyStroke("ENTER"), "enviarTexto");

        area.getActionMap()
                .put("enviarTexto", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String texto = area.getText().trim();
                        

                        if (!texto.isEmpty()) {
                            telaTerminal.setValorTerminal(texto);
                            String[] partes = texto.split("\\s+");
                            String comando = partes[0].toLowerCase();
                            String argumento = partes.length > 1 ? partes[1] : null;

                            JLabel novo = new JLabel(">>> " + texto);
                            novo.setForeground(Color.GREEN);
                            novo.setAlignmentX(Component.LEFT_ALIGNMENT);

                            painel.add(Box.createVerticalStrut(10));
                            painel.add(novo);

                            area.setText("");

                            switch (comando) {
                                case "ajuda":
                                    acaoTerminal.ajuda(painel);
                                    break;
                                case "mais":
                                    acaoTerminal.mais(painel);
                                    break;
                                case "cpasta":
                                    if (argumento == null) {
                                        System.out.println("Uso correto: cpasta nomeDaPasta");
                                    } else {
                                        acaoTerminal.CriarPasta(argumento);
                                    }
                                    break;
                                case "carquivo":
                                    if(argumento == null){
                                        System.out.println("Uso correto: carquivo nomeDoArquivo");
                                    }
                                    else{
                                        acaoTerminal.CriarArquivo(argumento);
                                    }
                                    break;
                                default:
                                    System.out.println("comando não encontrado");
                            }

                            painel.revalidate();
                            painel.repaint();
                            telaTerminal.scrollToBottom();
                        }
                    }
                });

        return lista;
    }
}
