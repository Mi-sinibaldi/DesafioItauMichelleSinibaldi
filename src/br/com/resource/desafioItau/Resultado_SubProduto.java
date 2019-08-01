/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.resource.desafioItau;

/**
 *
 * @author mia_a
 */
public class Resultado_SubProduto {
    
    private String NM_SUBPRODUTO;
    private float RESULTADO;

    public Resultado_SubProduto(String NM_SUBPRODUTO, float RESULTADO) {
        this.NM_SUBPRODUTO = NM_SUBPRODUTO;
        this.RESULTADO = RESULTADO;
    }

    public String getNM_SUBPRODUTO() {
        return NM_SUBPRODUTO;
    }

    public void setNM_SUBPRODUTO(String NM_SUBPRODUTO) {
        this.NM_SUBPRODUTO = NM_SUBPRODUTO;
    }

    public float getRESULTADO() {
        return RESULTADO;
    }

    public void setRESULTADO(float RESULTADO) {
        this.RESULTADO = RESULTADO;
    }
    
}
