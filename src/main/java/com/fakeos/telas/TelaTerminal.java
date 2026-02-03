package com.fakeos.telas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.ArrayList;

import com.fakeos.comandos.enterKeyBind;

public class TelaTerminal extends JFrame {

    JPanel painelTopo = new JPanel();
    JPanel painelBaixo = new JPanel();
    JPanel painelMeio = new JPanel();
    JScrollPane scroll = new JScrollPane(painelMeio);
    JLabel titulo = new JLabel("BEM-VINDO");
    JLabel introducao = new JLabel(">>>Ola, você tem os comandos:");
    JLabel textoInput = new JLabel("Digite o comando Desejado");

    ArrayList<String> inputs = new ArrayList<>();

    // ===== STRING MOMENTANEO PARA EXIBIÇÃO =====
    String[] comandos = { ">>>HelloWorld", ">>>help", ">>>Insert" };
    JLabel[] labels = new JLabel[comandos.length];
    JLabel[] congelados = new JLabel[inputs.size()];
    JTextField inputArea = new JTextField();

    Color borda = Color.GREEN;
    int expessura = 2;
    Border bordaCustomizada = BorderFactory.createLineBorder(borda, expessura);

    enterKeyBind entkey = new enterKeyBind();

    public TelaTerminal() {

        // ===== JFRAME =====
        setTitle("Tela Terminal"); // define titulo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fala que é pra sair quando fechar
        setSize(600, 600); // tamanho da janela
        setLocationRelativeTo(null); // relativo a nada
        setLayout(new BorderLayout()); // layout definido como BorderLayout

        // ===== PAINEL TOPO (ALTURA FIXA) =====
        painelTopo.setPreferredSize(new Dimension(600, 50)); // panel width 600 height 50
        painelTopo.setBackground(Color.BLACK); // define a cor como preta
        painelTopo.setLayout(new BoxLayout(painelTopo, BoxLayout.Y_AXIS)); // layout baseado no eixo Y

        // ===== PAINEL TOPO (ALTURA FIXA) =====
        painelMeio.setBackground(Color.BLACK); // define a cor como preta
        painelMeio.setLayout(new BoxLayout(painelMeio, BoxLayout.Y_AXIS)); // layout baseado no eixo Y

        // ===== PAINEL BAIXO (OCUPA O RESTO) =====
        painelBaixo.setBackground(Color.BLACK); // define a cor como preto
        painelBaixo.setLayout(new BoxLayout(painelBaixo, BoxLayout.Y_AXIS));// layout baseado no eixo Y

        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);

        SwingUtilities.invokeLater(() -> {
            JScrollBar bar = scroll.getVerticalScrollBar();
            bar.setValue(bar.getMaximum());
        });

        // ===== ESTILIZAÇÃO DO TITULO =====
        titulo.setForeground(Color.GREEN); // define a cor como verde
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT); // alinha ao centro

        // ===== ESTILIZAÇÃO DAS OPÇÕES DE COMANDOS =====
        introducao.setVisible(false); // define introducao como invisivel
        introducao.setForeground(Color.GREEN); // define a cor verde (mesmo que esteja invisivel)

        // ===== ESTILIZAÇÃO DO INPUT =====
        inputArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        inputArea.setPreferredSize(new Dimension(600, 30));
        inputArea.setBackground(Color.BLACK);
        inputArea.setForeground(Color.GREEN);
        inputArea.setBorder(bordaCustomizada);

        // ===== CHAMADA DO MÉTODO KEYBIND PRO ENTER =====
        entkey.bindEnter(inputArea, inputs, painelMeio, this);

        for (int i = 0; i < inputs.size(); i++) {
            congelados[i] = new JLabel(inputs.get(i));
            congelados[i].setForeground(Color.GREEN);
            congelados[i].setVisible(false);
            congelados[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            painelMeio.add(congelados[i]);
        };

        // ===== ESTILIZAÇÃO DA LABEL DO INPUT =====
        textoInput.setForeground(Color.GREEN);
        textoInput.setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));

        Timer timerIntro = new Timer(1500, e -> {
            introducao.setVisible(true); 
            painelMeio.revalidate();
            painelMeio.repaint();
            scrollToBottom();
        }); // timer para fazer introducao ser visivel
        Timer timerComandos = new Timer(2500, e -> { // timer para criar as Jlabel's baseada em labels
            for (JLabel label : labels) {
                label.setVisible(true);// define como visivel
            }
            painelMeio.revalidate();
            painelMeio.repaint();
            scrollToBottom();
        });

        timerIntro.setRepeats(false);// fala pro timer nao repetir
        timerComandos.setRepeats(false);// fala pro timer nao repetir

        timerIntro.start();// começa a ação do timer
        timerComandos.start();// começa a ação do timer

        // ===== SECÇÃO DOS ADD =====
        painelTopo.add(Box.createVerticalGlue());// componente invisivel que age de forma elastica
        painelTopo.add(titulo);// adciona titulo ao painel de cima
        painelTopo.add(Box.createVerticalStrut(10));// componente invisivel que age de forma elastica

        painelMeio.add(introducao);// adciona introducao no painelBaixo
        painelMeio.add(Box.createVerticalStrut(30));// componente invisivel que age de forma elastica

        for (int i = 0; i < comandos.length; i++) {// criação de cada JLabel com o laço for
            labels[i] = new JLabel(comandos[i]);
            labels[i].setForeground(Color.GREEN);
            labels[i].setVisible(false);
            labels[i].setAlignmentX(Component.LEFT_ALIGNMENT);
            painelMeio.add(labels[i]);
        }

        painelBaixo.add(Box.createVerticalStrut(10));
        painelBaixo.add(textoInput);
        painelBaixo.add(Box.createVerticalStrut(10));
        painelBaixo.add(inputArea);

        // ===== ADICIONANDO NO FRAME =====
        add(painelTopo, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelBaixo, BorderLayout.SOUTH);

        setVisible(true);
    }
     public void scrollToBottom() {
        SwingUtilities.invokeLater(() -> {
        painelMeio.revalidate();
        JScrollBar vertical = scroll.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
        });
    }
}
