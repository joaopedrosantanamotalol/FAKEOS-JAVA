package com.fakeos.comandos;
import java.nio.file.*;
import java.io.IOException;

public interface criarArquivos   {
    
    //Função que cria arquivos no diretório atual
    public static void create (String nome){

        Path nomeArquivo = Paths.get(nome);
        try{
            if(checkArchiveExistence(nome)){
                    /// Implementar GUI para questionar se deseja sobscrever
            }else{
            Files.createFile(nomeArquivo); // Função principal por criar os arquivos
            }
    }catch(IOException e){
        System.out.println(e);
    }
    }

    // Função que recebe o caminho para criar o arquivo
    public static void create(Path caminhoCompleto){

    }


    //Função para checar se arquivo existe antes de tentar criar
    public static Boolean checkArchiveExistence(String filePath){
        Path path = FileSystems.getDefault().getPath(filePath);
        boolean existe = false;
        if (Files.exists(path)){
            existe = true;
        }else {
            System.out.println("batata");
        }
        return existe;
    }
}
