package com.fakeos.comandos;
import javax.swing.JPanel;

import com.fakeos.comandos.terminalResposta.*;
import com.fakeos.telas.TelaTerminal;

public class acoes {

    private TelaTerminal telaTerminal;
    exemplo exemplo = new exemplo();
    ajuda ajuda = new ajuda();
    mais mais = new mais();
    criarPasta criarPasta = new criarPasta();

    public void ajuda(JPanel painel){
       
        ajuda.AjudaComando(painel);
    }
    public void mais(JPanel painel){
        mais.MaisComando(painel);
    }
    public void criarArquivo(){
        // chamada de método
    }

    public void Exemplo(){
        exemplo.Exemplo("Funcionou");
        // levar classe acoes para enterKeyBind
    }
    public void CriarPasta(String nome){
        System.out.println("criando pasta: "+nome);
        criarPasta.createDirectory(nome);
    }
    public acoes(TelaTerminal telaTerminal){
        this.telaTerminal = telaTerminal;
    }
}
