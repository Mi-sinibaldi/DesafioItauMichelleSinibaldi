/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.resource.desafioItau;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mia_a
 */
public class DadosMercado {

    private long ID_PRECO;
    private int NU_PRAZO_DIAS_CORRIDOS;
    private float VL_PRECO;

    public DadosMercado(long ID_PRECO, int NU_PRAZO_DIAS_CORRIDOS, float VL_PRECO) {
        this.ID_PRECO = ID_PRECO;
        this.NU_PRAZO_DIAS_CORRIDOS = NU_PRAZO_DIAS_CORRIDOS;
        this.VL_PRECO = VL_PRECO;
    }
   
    public static List<DadosMercado> ConverterParaLista(String caminho){
        List<DadosMercado> dadosMercado = new ArrayList();
        List<String> Linhas = Arquivos.LerArquivo(caminho);

        for (String linha : Linhas) {
            String[] array = linha.split(";");
            dadosMercado.add(new DadosMercado(Long.parseLong(array[0]),
                        Integer.parseInt(array[1]), Float.parseFloat(array[2].replace(",", "."))));
        }
        
        return dadosMercado;
    }
        

    public float getID_PRECO() {
        return ID_PRECO;
    }

    public void setID_PRECO(long ID_PRECO) {
        this.ID_PRECO = ID_PRECO;
    }

    public int getNU_PRAZO_DIAS_CORRIDOS() {
        return NU_PRAZO_DIAS_CORRIDOS;
    }

    public void setNU_PRAZO_DIAS_CORRIDOS(int NU_PRAZO_DIAS_CORRIDOS) {
        this.NU_PRAZO_DIAS_CORRIDOS = NU_PRAZO_DIAS_CORRIDOS;
    }

    public float getVL_PRECO() {
        return VL_PRECO;
    }

    public void setVL_PRECO(float VL_PRECO) {
        this.VL_PRECO = VL_PRECO;
    }

    
}
