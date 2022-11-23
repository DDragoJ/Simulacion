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
    Metodos metodo;
    
    @Override
    public Double Sistema_vacio(){
        Double aux=0.0;
        Integer p_factor=metodo.fac((int)Math.round(M));
        Double s_factor=(Landa/Miu);
        for(int i=0;i<=M;i++){
            aux=aux+(((p_factor)/(metodo.fac((int)Math.round(M-i))))*Math.pow(s_factor,i));
        }
        return 1/aux;
    }

    @Override
    public Double Sistema_ocupado() {
        return 1-Sistema_vacio();
    }

    @Override
    public Double n_clientes(int n) {
        Double aux=0.0;
        aux=(double)(metodo.fac((int)Math.round(M))/metodo.fac((int)Math.round(M-n)));
        aux=aux*Math.pow((Landa/Miu),n)*Sistema_vacio();
        return aux;
    }

    @Override
    public Double maximo_n_clientes(int n) {
        Double aux=0.0;
        for (int i=0;i<=n;i++){ aux=aux+n_clientes(i);};
        return aux;
    }

    @Override
    public Double n_clientes_esperado() {
        return M-(Miu/Landa)*(1-Sistema_vacio());
    }

    @Override
    public Double n_clientes_esperado_cola() {
        return M-((Landa+Miu)/Landa)*(1-Sistema_vacio());
    }

    @Override
    public Double n_clientes_esperado_cola_novacia() {
        return n_clientes_esperado_cola()/Sistema_ocupado();
    }

    @Override
    public Double Tiempo_espera_sistema() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double Tiempo_espera_cola() {
        return n_clientes_esperado_cola()/((M-n_clientes_esperado())*Landa);
    }

    @Override
    public Double Tiempo_espera_cola_no_vacia() {
        return Tiempo_espera_cola()/Sistema_ocupado();
    }

    @Override
    public String Leer() {
        String aux=""+metodo.fac((int)Math.round(M));/**
        aux=aux+("Tiempo del sistema ocupado: "+Sistema_ocupado());
        aux=aux+("<br> Tiempo del sistema vacio: "+Sistema_vacio());
        aux=aux+("<br> n clientes esperando: "+n_clientes_esperado());
        aux=aux+("<br> n clientes esperando en cola: "+n_clientes_esperado_cola());
        aux=aux+("<br> n clientes esperando en cols no vacia: "+n_clientes_esperado_cola_novacia());
        aux=aux+("<br> Tiempo de espera en cola: "+Tiempo_espera_cola());
        aux=aux+("<br> Tiempo de espera en cola no vacia: "+Tiempo_espera_cola_no_vacia());
        aux = (metodo.fac((int)Math.round(M)));**/

        return "<html>"+aux+"<html>";}
    }