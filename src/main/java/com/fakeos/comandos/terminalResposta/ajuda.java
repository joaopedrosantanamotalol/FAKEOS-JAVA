package com.fakeos.comandos.terminalResposta;
import java.awt.Color;

import javax.swing.*;

public class ajuda {

    public void AjudaComando(
        JPanel painel    
    ){
        JLabel textoAjuda = new JLabel("Ajudado");
        textoAjuda.setForeground(Color.GREEN);
        painel.add(Box.createVerticalStrut(20));
        painel.add(textoAjuda);
    }
}
