package com.fakeos.telas;

import java.awt.Color;
//comentado para nao ficar com warning chato import javax.swing.JFileChooser;
import javax.swing.*;

public class TelaTerminal extends JFrame {
    JPanel painel = new JPanel(); // instancia do painel
    JLabel titulo = new JLabel("BEM-VINDO"); // instancia do titulo presente

    public TelaTerminal() {

        setTitle("Tela Terminal"); // define titulo da barra do app
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // você sai do programa quando fecha
        setSize(600, 600); // declara o tamanho da tela
        setLocationRelativeTo(null); // o posicionamento ta relativo a nada
        painel.setLayout(null); // com o setLauout null você pode definir as posições dos objetos
        painel.setBackground(Color.BLACK); // define a cor do painel

        titulo.setForeground(Color.GREEN); // declara o objeto titulo
        titulo.setBounds(280, 30, 200, 20); // posiciona o titulo dentro do painel x,y,width,height

        add(painel); // adciona o painel a tela
        painel.add(titulo); // adciona o titulo ao painel
    }

}