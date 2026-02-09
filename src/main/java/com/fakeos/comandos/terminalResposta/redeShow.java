package com.fakeos.comandos.terminalResposta;

import java.io.*;

public class redeShow {
    public String mostrarWifi() {
        StringBuilder resultado = new StringBuilder();
        try {
            Process processo = Runtime.getRuntime()
                    .exec(new String[] {
                            "bash", "-c",
                            "nmcli -t -f IN-USE,SSID,SIGNAL,SECURITY dev wifi list"
                    });

            BufferedReader leitor = new BufferedReader(
                    new InputStreamReader(processo.getInputStream(), "CP850"));

            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    resultado.append(linha.replace(":", "  "))
                            .append("<br>");
                }
            }
        } catch (Exception e) {
            return "Erro ao obter redes Wi-Fi";
        }

        return resultado.length() == 0
                ? "Nenhuma rede encontrada"
                : "<html>" + resultado + "</html>";
    }
}
