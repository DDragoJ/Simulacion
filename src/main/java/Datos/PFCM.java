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
public class PFCM extends Probabilidad{
        //M*K*LANDA*MIAW
     
    
    public PFCM(Double K,Double M, Double Landa, Double Miu) {
        this.M = M;
        this.Landa = Landa;
        this.K = K;
        this.Miu = Miu;
    }

    
    @Override
    public Double Sistema_ocupado() {
        return 1-maximo_n_clientes((int) (K-1));
    }

    @Override
    public Double Sistema_vacio() {
        Double aux1=0.0,aux2=0.0;
        Double  mfactor=metodo.fac(M);
        Double Landa_Miu=Landa/Miu;
        for(int i=0;i<K;i++){
            aux1=aux1+((mfactor)/(metodo.fac(M-i)*metodo.fac(Double.valueOf(i))))
                    *Math.pow((Landa_Miu),i);
        };
        for(int i=(int) Math.round(K);i<=M;i++){
            aux2+=((mfactor)/(metodo.fac(M-i)*metodo.fac(K)*Math.pow(K, (i-K))))
                    *Math.pow((Landa_Miu),i);
        };
        return 1/(aux1+aux2);
    }

    @Override
    public Double n_clientes(int n) {
        Double aux;
        Double M_fac=metodo.fac(M);
        if(n<=K){
            aux=M_fac/(metodo.fac(M-n)*metodo.fac(Double.valueOf(n)));
        }else{
            aux=(M_fac)/(metodo.fac(M-n)*metodo.fac(K)*Math.pow(K, n-K));
        };
        aux=aux*(Math.pow((Landa/Miu), n))*Sistema_vacio();
        return aux;
    }

    @Override
    public Double maximo_n_clientes(int n) {
        Double aux=0.0;
        for(int i=0;i<=n;i++){
            aux+=n_clientes(i);
        };
        return aux;
        
    }

    @Override
    public Double n_clientes_esperado() {
        Double aux1=0.0,aux2;
        for(int i=0;i<=K-1;i++){
            aux1+=i*(n_clientes(i));
        };
        aux2=K*(1-maximo_n_clientes((int) (K-1)));
        return (n_clientes_esperado_cola()+aux1+aux2);
    }

    @Override
    public Double n_clientes_esperado_cola() {
        Double aux=0.0;
        for(int i=(int) Math.round(K);i<=M;i++){
            aux+=(n_clientes(i))*(i-K);
        };
        return aux;
    }

    @Override
    public Double n_clientes_esperado_cola_novacia() {
        return n_clientes_esperado_cola()/Sistema_ocupado();
    }

    @Override
    public Double Tiempo_espera_sistema() {
                return Tiempo_espera_cola()+(1/Miu);
    }

    @Override
    public Double Tiempo_espera_cola() {
        return (n_clientes_esperado_cola())/((M-n_clientes_esperado())*Landa);
    }

    @Override
    public Double Tiempo_espera_cola_no_vacia() {
        return (Tiempo_espera_cola()/Sistema_ocupado());
    }

    
}
