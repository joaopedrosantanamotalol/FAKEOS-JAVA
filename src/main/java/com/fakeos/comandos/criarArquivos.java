package com.fakeos.comandos;
import java.nio.file.*;
import java.io.IOException;

public interface criarArquivos   {
    
    //Função que cria arquivos no diretório atual
    public static void create (String nome){

        Path nomeArquivo = Paths.get(nome);
        try{
            if(checkArchiveExistence(nome)){
                String resposta = "Arquivo já existe, deseja sobscreve-lo ?";
                // Pedir entrada para confirmar a sobscrita do arquivo já existente
                /**if (){

                }else{
                    System.out.println("algo");
                }  **/              
            }else{
            Files.createFile(nomeArquivo); // Função principal por criar os arquivos
            }
    }catch(IOException e){
        System.out.println(e);
    }
    }

    // Função que recebe o caminho para criar o arquivo
    public static void create(Path caminhoCompleto){
        Path path = caminhoCompleto;
        try{
            if(checkArchiveExistence(caminhoCompleto.toString())){ // Chama a função para verificar se o arquivo existe convertendo para String o caminho completo
                // Pedir entrada do usuário para confirmar a sobscrita do arquivo já existente

            }else {
                Files.createFile(caminhoCompleto);
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }


    //Função para checar se arquivo existe antes de tentar criar
    public static Boolean checkArchiveExistence(String filePath){
        Path path = FileSystems.getDefault().getPath(filePath);
        boolean existe = false;
        if (Files.exists(path)){
            existe = true;
        }
        return existe;
    }
}
