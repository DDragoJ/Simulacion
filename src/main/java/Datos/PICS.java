/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 * POBLACION INFINITA CANAL SIMPLE
 * @author cosmo
 */
public class PICS {
    //M*K*LANDA*MIAW
    Double M;
    Double Landa;
    Double K;
    Double Miu;
    public String Estabilidad (){
        String estado="Inestable";
        if (Landa/Miu<1) estado="Estable";
        return estado;
    }
    public Double Sistema_ocupado (){
        return Landa/Miu;
    }
    public Double Sistema_vacio (int op,double aux){
        if (op==1){
        return 1-Landa/Miu;}else{
        return 1-aux;
        }
    }
    public Double n_clientes (int n){
        return Sistema_vacio(1,0.0)*Math.pow(Sistema_ocupado(), n);
    }
    public Double maximo_n_clientes(int n){
        Double acum=0.0;
        if (n>0){acum=acum+maximo_n_clientes(n-1);
        }else{return acum=Sistema_vacio(1, 0);};
        return acum;
    }
}
