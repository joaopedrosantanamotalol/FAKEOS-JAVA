package com.fakeos.comandos.terminalResposta;
import java.awt.Color;

import javax.swing.*;

public class mais {

    public void MaisComando(
        JPanel painel
    ){
        JLabel textoAjuda = new JLabel("<html>>> Os comandos presentes são:<br><br>"
        + "ajuda<br>"
        + "mais<br>"
        + "cpasta<br>"
        + "carquivo<br>"
        + "meuip<br>"
        +"wifi</html>");
        textoAjuda.setForeground(Color.GREEN);
        painel.add(Box.createVerticalStrut(20));
        painel.add(textoAjuda);
    }
}
