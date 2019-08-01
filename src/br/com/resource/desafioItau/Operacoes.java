/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.resource.desafioItau;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mia_a
 */
public  class Operacoes {

    private  long CD_OPERACAO;
    private  Date DT_INICIO;
    private  Date DT_FIM;
    private  String NM_EMPRESA;
    private  String NM_MESA;
    private  String NM_ESTRATEGIA;
    private  String NM_CENTRALIZADOR;
    private  String NM_GESTOR;
    private  String NM_SUBGESTOR;
    private  String NM_SUBPRODUTO;
    private  String NM_CARACTERISTICA;
    private  String CD_ATIVO_OBJETO;
    private  float QUANTIDADE;
    private  long ID_PRECO;
    private  float RESULTADO;

    public  float getRESULTADO() {
        return RESULTADO;
    }

    public void setRESULTADO(float RESULTADO) {
        this.RESULTADO = RESULTADO;
    }

    public Operacoes(long CD_OPERACAO, Date DT_INICIO, Date DT_FIM, String NM_EMPRESA, String NM_MESA, String NM_ESTRATEGIA, String NM_CENTRALIZADOR, String NM_GESTOR, String NM_SUBGESTOR, String NM_SUBPRODUTO, String NM_CARACTERISTICA, String CD_ATIVO_OBJETO, float QUANTIDADE, long ID_PRECO) {
        this.CD_OPERACAO = CD_OPERACAO;
        this.DT_INICIO = DT_INICIO;
        this.DT_FIM = DT_FIM;
        this.NM_EMPRESA = NM_EMPRESA;
        this.NM_MESA = NM_MESA;
        this.NM_ESTRATEGIA = NM_ESTRATEGIA;
        this.NM_CENTRALIZADOR = NM_CENTRALIZADOR;
        this.NM_GESTOR = NM_GESTOR;
        this.NM_SUBGESTOR = NM_SUBGESTOR;
        this.NM_SUBPRODUTO = NM_SUBPRODUTO;
        this.NM_CARACTERISTICA = NM_CARACTERISTICA;
        this.CD_ATIVO_OBJETO = CD_ATIVO_OBJETO;
        this.QUANTIDADE = QUANTIDADE;
        this.ID_PRECO = ID_PRECO;
    }

    
    public static  List<Operacoes> ConverteParaLista(String caminho) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<String> Linhas = Arquivos.LerArquivo(caminho);
        
        List<Operacoes> operacoes = new ArrayList();
        for (String linha : Linhas) {
            String[] array = linha.split(";");

            operacoes.add(new Operacoes(
                    Long.parseLong(array[0]),
                    sdf.parse(array[1]),
                    sdf.parse(array[2]),
                    array[3],
                    array[4],
                    array[5],
                    array[6],
                    array[7],
                    array[8],
                    array[9],
                    array[10],
                    array[11],
                    Float.parseFloat(array[12].replace(",", ".")),
                    Long.parseLong(array[13])
            ));
        }

        return operacoes;
    }

    public  long getCD_OPERACAO() {
        return CD_OPERACAO;
    }

    public  Date getDT_INICIO() {
        return DT_INICIO;
    }

    public  Date getDT_FIM() {
        return DT_FIM;
    }

    public  String getNM_EMPRESA() {
        return NM_EMPRESA;
    }

    public  String getNM_MESA() {
        return NM_MESA;
    }

    public  String getNM_ESTRATEGIA() {
        return NM_ESTRATEGIA;
    }

    public  String getNM_CENTRALIZADOR() {
        return NM_CENTRALIZADOR;
    }

    public  String getNM_GESTOR() {
        return NM_GESTOR;
    }

    public  String getNM_SUBGESTOR() {
        return NM_SUBGESTOR;
    }

    public  String getNM_SUBPRODUTO() {
        return NM_SUBPRODUTO;
    }

    public  String getNM_CARACTERISTICA() {
        return NM_CARACTERISTICA;
    }

    public  String getCD_ATIVO_OBJETO() {
        return CD_ATIVO_OBJETO;
    }

    public  float getQUANTIDADE() {
        return QUANTIDADE;
    }

    public  long getID_PRECO() {
        return ID_PRECO;
    }

}
