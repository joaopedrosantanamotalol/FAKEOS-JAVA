package com.fakeos.comandos;
import java.nio.file.*;
import java.io.IOException;

public interface criarArquivos   {
    
    //Função que cria arquivos no diretório atual
    public static void createArchive(String nome){

        Path nomeArquivo = Paths.get(nome);
        try{
            Files.createFile(nomeArquivo); // Função principal por criar os arquivos
            System.out.println("Arquivo criado ");

        }catch(FileAlreadyExistsException e){
        System.out.println("Arquivo já existe");
    }
        catch(IOException e){
            System.out.println(e);
        }
    }

    // Função que recebe o caminho para criar o arquivo
    public static void createArchive(Path caminhoCompleto){
        try{
            Files.createFile(caminhoCompleto);
            System.out.println("Arquivo criado");
        }
        catch(FileAlreadyExistsException e){
            System.out.println("Arquivo ja existe:: "+e);
        }
        catch(IOException e){
            System.out.println("Erro:: "+e);
        }
    }

}
