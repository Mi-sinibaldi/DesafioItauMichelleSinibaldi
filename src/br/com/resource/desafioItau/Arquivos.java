package br.com.resource.desafioItau;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

    public static List<String> LerArquivo(String Caminho) {
        List<String> linhas = new ArrayList();

        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                //ignorar a primeira linhda o arquivo
                int contador = 0;
                while (linha != null) {
                    if (contador != 0) {
                        linhas.add(linha);
                    }
                    contador++;
                    linha = lerArq.readLine();
                }
                arq.close();
                return linhas;
            } catch (IOException e) {
                System.out.println("Não foi possível ler o arquivo: DadosMercado!");
                return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            return null;
        }
    }

    public static boolean Write(String Caminho, List<Resultado_SubProduto> Retorno) {
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println("NM_SUBPRODUTO;RESULTADO");
            for(Resultado_SubProduto item: Retorno){
                gravarArq.println(item.getNM_SUBPRODUTO()+";"+item.getRESULTADO());
            }
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
