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
        setTitle("Tela Terminal"); // define titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fala que é pra sair quando fechar 
        setSize(600, 600); // tamanho da janela
        setLocationRelativeTo(null); // relativo a nada
        setLayout(new BorderLayout()); // layout definido como BorderLayout

        // ===== PAINEL TOPO (ALTURA FIXA) =====
        painelTopo.setPreferredSize(new Dimension(600, 50)); // panel width 600 height 50
        painelTopo.setBackground(Color.BLACK); // define a cor como preta
        painelTopo.setLayout(new BoxLayout(painelTopo, BoxLayout.Y_AXIS)); // layout baseado no eixo Y

        // ===== PAINEL BAIXO (OCUPA O RESTO) =====
        painelBaixo.setBackground(Color.BLACK); // define a cor como preto
        painelBaixo.setLayout(new BoxLayout(painelBaixo, BoxLayout.Y_AXIS));// layout baseado no eixo Y

        titulo.setForeground(Color.GREEN); // define a cor como verde
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT); // alinha ao centro

        painelTopo.add(Box.createVerticalGlue());// componente invisivel que age de forma elastica
        painelTopo.add(titulo);// adciona titulo ao painel de cima
        painelTopo.add(Box.createVerticalGlue());// componente invisivel que age de forma elastica

        introducao.setVisible(false); // define introducao como invisivel
        introducao.setForeground(Color.GREEN); // define a cor verde (mesmo que esteja invisivel)

        Timer timerIntro = new Timer(1500, e -> introducao.setVisible(true)); //timer para fazer introducao ser visivel
        Timer timerComandos = new Timer(2500, e -> { // timer para criar as Jlabel's baseada em labels
            for (JLabel label : labels) {
                label.setVisible(true);// define como visivel
            }
        });

        timerIntro.setRepeats(false);// fala pro timer nao repetir
        timerComandos.setRepeats(false);// fala pro timer nao repetir

        timerIntro.start();// começa a ação do timer
        timerComandos.start();// começa a ação do timer

        painelBaixo.add(introducao);// adciona introducao no painelBaixo

        painelBaixo.add(Box.createVerticalStrut(10));// adciona espaço invisivel com o tamanho de 10 px
        
        for (int i = 0; i < comandos.length; i++) {// criação de cada JLabel com o laço for
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
