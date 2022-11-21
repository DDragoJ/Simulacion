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
    public PFCS (Double M, Double Landa, Double Miu){ this.M = M;
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
    public Double Sistema_Vacio(){
        Double aux=0.0;
        Integer p_factor=metodo.fac((int)Math.round(M));
        Double s_factor=(Landa/Miu);
        for(int i=0;i<=M;i++){
            aux=aux+(metodo.fac((int)Math.round(M-i))*Math.pow(s_factor,i));
        }
        return 1/aux;
    }

    @Override
    public Double Sistema_ocupado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double Sistema_vacio(int op, double aux) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double n_clientes(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double maximo_n_clientes(int n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double n_clientes_esperado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double n_clientes_esperado_cola() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double n_clientes_esperado_cola_novacia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double Tiempo_espera_sistema() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double Tiempo_espera_cola() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double Tiempo_espera_cola_no_vacia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String Leer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}