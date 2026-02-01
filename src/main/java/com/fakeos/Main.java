package com.fakeos;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // forma segura de criar e editar a interface gráfica
        SwingUtilities.invokeLater(() -> {
            // new terminal é a instancia do construtor da pagina
            // setVisible(true) diz que a tela É visivel kkkkkkk
            new TelaTerminal().setVisible(true);
        });

    }
}