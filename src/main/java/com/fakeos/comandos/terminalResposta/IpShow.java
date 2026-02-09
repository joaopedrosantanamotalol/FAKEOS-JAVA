package com.fakeos.comandos.terminalResposta;
import java.net.InetAddress;
import java.net.UnknownHostException;

//import javax.swing.JPanel;

public class IpShow {
    
    public String PegarMostrarIp(){
        try{
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch(UnknownHostException e){
            System.out.println(e);
            return null;
        }
    }

}
