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
        //M*K*LANDA*MIAW
     Double M;
     Double Landa;
     Double K;
     Double Miu;
     Metodos metodo = new Metodos();
    
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
            aux=M_fac/((M-n)*metodo.fac(Double.valueOf(n)));
        }else{
            aux=(M_fac)/(M-n)*metodo.fac(K)*Math.pow(K, n-K);
        };
        aux=aux*(Math.pow((Landa/Miu), n))*Sistema_vacio();
        return aux;
    }

    @Override
    public Double maximo_n_clientes(int n) {
        Double aux=0.0;
        for(int i=1;i<=n;i++){
            aux+=n_clientes(i);
        };
        return aux+Sistema_vacio();
    }

    @Override
    public Double n_clientes_esperado() {
        Double aux=0.0;
        int K_1=(int) Math.round(K);
        for(int i=0;i<=K-1;i++){
            aux=(aux)+(n_clientes(i)*i);
        };
        for(int i=(K_1);i<=M;i++){
            aux=(aux)+(n_clientes(i)*(i-K));
        };
        aux=aux*K;
        for(int i=0;i<=K-1;i++){
            aux=(aux)+(1-n_clientes(i));
        };
        
        return aux;
    }

    @Override
    public Double n_clientes_esperado_cola() {
        Double aux=0.0;
        int K_1 =(int)Math.round(K);
        for(int i=(K_1);i<=M;i++){
            aux=(aux)+(n_clientes(i)*(i-K));
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
        return n_clientes_esperado()/((M-n_clientes_esperado())*Landa);
    }

    @Override
    public Double Tiempo_espera_cola_no_vacia() {
        return (Tiempo_espera_cola()/Sistema_ocupado());
    }

    @Override
    public String Leer() {
        String aux="";
        aux=aux+("Tiempo del sistema ocupado: "+metodo.redondear(Sistema_ocupado()));
        aux=aux+("<br> Tiempo del sistema vacio: "+metodo.redondear(Sistema_vacio()));
        aux=aux+("<br> n clientes esperando: "+metodo.redondear(n_clientes_esperado()));
        aux=aux+("<br> n clientes esperando en cola: "+metodo.redondear(n_clientes_esperado_cola()));
        aux=aux+("<br> n clientes esperando en cols no vacia: "+metodo.redondear(n_clientes_esperado_cola_novacia()));
        aux=aux+("<br> Tiempo de espera en cola: "+metodo.redondear(Tiempo_espera_cola()));
        aux=aux+("<br> Tiempo de espera en cola no vacia: "+metodo.redondear(Tiempo_espera_cola_no_vacia()));
        aux=aux+("<br> Tiempo de espera en el sistema: "+metodo.redondear(Tiempo_espera_sistema()));
        return "<html>"+aux+"<html>";}
    
}
