/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Datos;
import Datos.Metodos;
import interfaz.int_simulacion;
/**
 *POBLACION FINITA CANAL SIMPLE
 * @author cosmo
 */
public class PFCS implements int_simulacion{
    public PFCS (Double M, Double Landa, Double Miu){
    this.M=M;
    this.Landa = Landa;
    this.K = 1.0;
    this.Miu = Miu;
    }
    //M*K*LANDA*MIAW
    Double M;
    Double Landa;
    Double K;
    Double Miu;
    Metodos metodo=new Metodos();
    
    @Override
    public Double Sistema_vacio(){
        Double aux1=0.0;
        Double aux2=0.0;
        Double m_factorial=metodo.fac(M);
        Double s_factor=(Landa/Miu);
        Double Dividendo=0.0;
        for(int i=0;i<=M;i++){
            Dividendo=metodo.fac(M-i);
            aux1=(m_factorial/Dividendo)*Math.pow(s_factor,i);
            aux2=aux1+aux2;
        }
        return  (1/aux2);
    }

    @Override
    public Double Sistema_ocupado() {
        return  (1-Sistema_vacio());
    }

    @Override
    public Double n_clientes(int n) {
        Double aux=0.0;
        aux=(metodo.fac(M)/metodo.fac((M-n)));
        aux=aux*Math.pow((Landa/Miu),n)*Sistema_vacio();
        return  (aux);
    }

    @Override
    public Double maximo_n_clientes(int n) {
        Double aux=0.0;
        for (int i=0;i<=n;i++){ aux=aux+n_clientes(i);};
        return  (aux);
    }

    @Override
    public Double n_clientes_esperado() {
        return  (M-(Miu/Landa)*(1-Sistema_vacio()));
    }

    @Override
    public Double n_clientes_esperado_cola() {
        return  (M-((Landa+Miu)/Landa)*(1-Sistema_vacio()));
    }

    @Override
    public Double n_clientes_esperado_cola_novacia() {
        return  (n_clientes_esperado_cola()/Sistema_ocupado());
    }

    @Override
    public Double Tiempo_espera_sistema() {
        return  (Tiempo_espera_cola()+(1/Miu));
    }

    @Override
    public Double Tiempo_espera_cola() {
        Double aux=(M-n_clientes_esperado())*Landa;
        return  (n_clientes_esperado_cola()/aux);
    }

    @Override
    public Double Tiempo_espera_cola_no_vacia() {
        return  (Tiempo_espera_cola()/Sistema_ocupado());
    }

    }