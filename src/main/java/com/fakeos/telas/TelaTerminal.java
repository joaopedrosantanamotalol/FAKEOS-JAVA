package com.fakeos.telas;

import java.awt.*;
import javax.swing.*;

public class TelaTerminal extends JFrame {

    JPanel painelTopo = new JPanel();
    JPanel painelBaixo = new JPanel();
    JLabel titulo = new JLabel("BEM-VINDO");
    JLabel introducao = new JLabel(">>>Ola, você tem os comandos:");
    // ===== STRING MOMENTANEO PARA EXIBIÇÃO =====
    String[] comandos = { ">>>HelloWorld", ">>>help", ">>>Insert" };
    JLabel[] labels = new JLabel[comandos.length];

    public TelaTerminal() {

        // ===== JFRAME =====
        setTitle("Tela Terminal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ===== PAINEL TOPO (ALTURA FIXA) =====
        painelTopo.setPreferredSize(new Dimension(600, 50));
        painelTopo.setBackground(Color.BLACK);
        painelTopo.setLayout(new BoxLayout(painelTopo, BoxLayout.Y_AXIS));

        // ===== PAINEL BAIXO (OCUPA O RESTO) =====
        painelBaixo.setBackground(Color.BLACK);
        painelBaixo.setLayout(new BoxLayout(painelBaixo, BoxLayout.Y_AXIS));

        titulo.setForeground(Color.GREEN);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelTopo.add(Box.createVerticalGlue());
        painelTopo.add(titulo);
        painelTopo.add(Box.createVerticalGlue());

        introducao.setVisible(false);
        introducao.setForeground(Color.GREEN);

        Timer timerIntro = new Timer(1500, e -> introducao.setVisible(true));
        Timer timerComandos = new Timer(2500, e -> {
            for (JLabel label : labels) {
                label.setVisible(true);
            }
        });

        timerIntro.setRepeats(false);
        timerComandos.setRepeats(false);

        timerIntro.start();
        timerComandos.start();

        painelBaixo.add(introducao);

        painelBaixo.add(Box.createVerticalStrut(10));
        
        for (int i = 0; i < comandos.length; i++) {
            labels[i] = new JLabel(comandos[i]);
            labels[i].setForeground(Color.GREEN);
            labels[i].setVisible(false);
            labels[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            painelBaixo.add(labels[i]);
        }

        // ===== ADICIONANDO NO FRAME =====
        add(painelTopo, BorderLayout.NORTH);
        add(painelBaixo, BorderLayout.CENTER);

        setVisible(true);
    }
}
