/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import interfaz.int_simulacion;

/**
 * POBLACION INFINITA CANAL SIMPLE
 * @author cosmo
 */
public class PICS extends Probabilidad{

    public PICS(Double M, Double Landa, Double Miu) {
        this.M = M;
        this.Landa = Landa;
        this.K = 1.0;
        this.Miu = Miu;
    }
    //M*K*LANDA*MIAW
/*
    public String Estabilidad (){
        String estado="Inestable";
        if (Landa/Miu<1) estado="Estable";
        return estado;
    }*/
    @Override
    public Double Sistema_ocupado (){
        return Landa/Miu;
    }
    @Override
    public Double Sistema_vacio (){
        return 1-Landa/Miu;
    }
    @Override
    public Double n_clientes (int n){
        return Sistema_vacio()*Math.pow(Sistema_ocupado(), n);
    }
    @Override
    public Double maximo_n_clientes(int n){
        Double acum=0.0;
        if (n>0){acum=acum+maximo_n_clientes(n-1);
        }else{return acum=Sistema_vacio();};
        return acum;
    }
    @Override
    public Double n_clientes_esperado (){
        return (Landa)/(Miu-Landa);
    }
    @Override
    public Double n_clientes_esperado_cola (){
        return (Math.pow(Landa, 2))/(Miu*(Miu-Landa));
    }
    @Override
    public Double n_clientes_esperado_cola_novacia (){
        return (Landa)/(Miu-Landa);
    }
    @Override
    public Double Tiempo_espera_sistema(){
        return 1/(Miu-Landa);
    }
    @Override
        public Double Tiempo_espera_cola(){
        return Landa/(Miu*(Miu-Landa));
    }
        @Override
        public Double Tiempo_espera_cola_no_vacia(){
        return 1/(Miu-Landa);
    }
}
