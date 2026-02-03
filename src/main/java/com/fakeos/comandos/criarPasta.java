package com.fakeos.comandos;
import java.nio.file.*;
import java.io.IOException;
public class criarPasta {
    
    public static void createDirectory(String nome){
        Path dirPath = Paths.get(nome);
        try{
                Files.createDirectory(dirPath);
        }
        catch(FileAlreadyExistsException e){ // Catch para tratar erro caso diretório já exista
            System.out.println("Diretório já existe::");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        createDirectory("/home/felipe/Documents/Java/arroz_e_feijao");
    }
}
