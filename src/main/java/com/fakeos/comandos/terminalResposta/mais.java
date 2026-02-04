package com.fakeos.comandos.terminalResposta;
import java.awt.Color;

import javax.swing.*;

public class mais {

    public void MaisComando(
        JPanel painel
    ){
        JLabel textoAjuda = new JLabel("<html>>> Os comandos presentes são:<br><br>"
        + "HelloWorld<br>"
        + "ajuda<br>"
        + "insert<br>"
        +"Mais</html>");
        textoAjuda.setForeground(Color.GREEN);
        painel.add(Box.createVerticalStrut(10));
        painel.add(textoAjuda);
    }
}
