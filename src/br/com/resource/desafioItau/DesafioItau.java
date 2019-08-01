/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.resource.desafioItau;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author mia_a
 */
public class DesafioItau {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        List<DadosMercado> dados = DadosMercado.ConverterParaLista(
                "C:\\users\\mia_a\\Desktop\\desafioItau\\DadosMercado.csv");
        List<Operacoes> dadosOperacoes = Operacoes.ConverteParaLista(
                "C:\\users\\mia_a\\Desktop\\desafioItau\\Operacoes.csv");

        List<Resultado_SubProduto> SpResultado = new ArrayList();

        for (Operacoes op : dadosOperacoes) {
            Period dias = op.getDT_INICIO().until(op.getDT_FIM());
            
            //int diffDays = (int) (diff / (24 * 60 * 60 * 1000));

            DadosMercado result = dados.stream()
                    .filter(line -> line.getID_PRECO() == op.getID_PRECO()
                            && line.getNU_PRAZO_DIAS_CORRIDOS() == dias.getDays())
                    .findAny()
                    .orElse(null);

            if (result != null) {
                long cota = (long) (op.getQUANTIDADE() * result.getVL_PRECO());
                op.setRESULTADO(cota);
            } else {
                op.setRESULTADO(0);
            }

            Resultado_SubProduto retorno = SpResultado.stream()
                    .filter(line -> line.getNM_SUBPRODUTO().equals(op.getNM_SUBPRODUTO()))
                    .findAny()
                    .orElse(null);

            if (retorno != null) {
                float cotas = retorno.getRESULTADO() + op.getRESULTADO();
                retorno.setRESULTADO(cotas);
            } else {
                SpResultado.add(new Resultado_SubProduto(op.getNM_SUBPRODUTO(), op.getRESULTADO()));
            }
        }

        Arquivos.Write("C:\\users\\mia_a\\Desktop\\desafioItau\\Resultado.csv", SpResultado);
        
        System.out.println("Numero de registros no dados mercado: " + dados.size());
        System.out.println("Numero de registros no Operacoes: " + dadosOperacoes.size());
        System.out.println("Numero de registros no Operacoes: " + SpResultado.size());

    }
}
