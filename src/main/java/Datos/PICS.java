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
public class PICS implements int_simulacion{

    public PICS(Double M, Double Landa, Double Miu) {
        this.M = M;
        this.Landa = Landa;
        this.K = 1.0;
        this.Miu = Miu;
    }
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
    public Double n_clientes_esperado (){
        return (Landa)/(Miu-Landa);
    }
    public Double n_clientes_esperado_cola (){
        return (Math.pow(Landa, 2))/(Miu*(Miu-Landa));
    }
    public Double n_clientes_esperado_cola_novacia (){
        return (Landa)/(Miu-Landa);
    }
    public Double Tiempo_espera_sistema(){
        return 1/(Miu-Landa);
    }
        public Double Tiempo_espera_cola(){
        return Landa/(Miu*(Miu-Landa));
    }
        public Double Tiempo_espera_cola_no_vacia(){
        return 1/(Miu-Landa);
    }
        
    public String Leer() {
        String aux="";
        aux=aux+("Tiempo del sistema ocupado: "+Sistema_ocupado());
        aux=aux+("<br> Tiempo del sistema vacio: "+Sistema_vacio(1,0));
        aux=aux+("<br> n clientes esperando: "+n_clientes_esperado());
        aux=aux+("<br> n clientes esperando en cola: "+n_clientes_esperado_cola());
        aux=aux+("<br> n clientes esperando en cols no vacia: "+n_clientes_esperado_cola_novacia());
        aux=aux+("<br> Tiempo de espera en cola: "+Tiempo_espera_cola());
        aux=aux+("<br> Tiempo de espera en cola no vacia: "+Tiempo_espera_cola_no_vacia());
        aux=aux+("<br> Tiempo de esera del sistema: "+Tiempo_espera_sistema());
        return "<html>"+aux+"<html>";
    }
}
