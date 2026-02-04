package com.fakeos.comandos;
import javax.swing.JPanel;

import com.fakeos.comandos.terminalResposta.*;

public class acoes {

    exemplo exemplo = new exemplo();
    ajuda ajuda = new ajuda();
    
    public void ajuda(JPanel painel){
       
        ajuda.AjudaComando(painel);
    }
    public void criarArquivo(){
        // chamada de método
    }

    public void Exemplo(){
        exemplo.Exemplo("Funcionou");
        // levar classe acoes para enterKeyBind
    }
}
