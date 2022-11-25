/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import interfaz.int_simulacion;

/**
 * POBLACION FINITA CANAL MULTIPLE
 * @author cosmo
 */
public class PFCM implements int_simulacion{
    public PFCM(Double K,Double M, Double Landa, Double Miu) {
        this.M = M;
        this.Landa = Landa;
        this.K = K;
        this.Miu = Miu;
    }
    //M*K*LANDA*MIAW
    Double M;
    Double Landa;
    Double K;
    Double Miu;
    Metodos metodo;
    
    @Override
    public Double Sistema_ocupado() {
        Double aux=0.0;
        Double  m_fac=metodo.fac(M);
        Double Landa_Miu=Landa/Miu;
        for(int i=0;i<K;i++){
            aux=aux+((m_fac/((M-i)*metodo.fac(Double.valueOf(i))))
                    *Math.pow(Landa_Miu, i));
        };
        return aux;
    }

    @Override
    public Double Sistema_vacio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Double n_clientes(int n) {
        Double aux=0.0; 
        return aux;
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
        String aux="";
        aux=aux+("Tiempo del sistema ocupado: "+Sistema_ocupado());
        aux=aux+("<br> Tiempo del sistema vacio: "+Sistema_vacio());
        aux=aux+("<br> n clientes esperando: "+n_clientes_esperado());
        aux=aux+("<br> n clientes esperando en cola: "+n_clientes_esperado_cola());
        aux=aux+("<br> n clientes esperando en cols no vacia: "+n_clientes_esperado_cola_novacia());
        aux=aux+("<br> Tiempo de espera en cola: "+Tiempo_espera_cola());
        aux=aux+("<br> Tiempo de espera en cola no vacia: "+Tiempo_espera_cola_no_vacia());
        aux=aux+("<br> Tiempo de esera del sistema: "+Tiempo_espera_sistema());
        return "<html>"+aux+"<html>";
    }
    
}
