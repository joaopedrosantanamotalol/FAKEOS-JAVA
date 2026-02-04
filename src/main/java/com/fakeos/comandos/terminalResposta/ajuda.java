package com.fakeos.comandos.terminalResposta;
import java.awt.Color;

import javax.swing.*;

public class ajuda {

    public void AjudaComando(
        JPanel painel    
    ){
        JLabel textoAjuda = new JLabel(">>> esse é o texto de ajuda");
        textoAjuda.setForeground(Color.GREEN);
        painel.add(Box.createVerticalStrut(10));
        painel.add(textoAjuda);
    }
}
