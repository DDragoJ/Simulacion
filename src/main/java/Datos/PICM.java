/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import interfaz.int_simulacion;

/**
 *POBLACION INFINITA CANAL MULTIPLE
 * @author cosmo
 */
public class PICM extends Probabilidad{
    
    public PICM (Double K, Double Landa, Double Miu){
    this.K=K;
    this.Landa = Landa;
    this.Miu = Miu;
    }
    
    @Override
    public Double Sistema_ocupado() {
        Double aux2=0.0,aux1=0.0,aux3=0.0;
        aux1=1/metodo.fac(K);
        aux2=Math.pow((Landa/Miu), K);
        aux3=((K*Miu)/((K*Miu)-Landa));
        
        return aux1*aux2*aux3*Sistema_vacio();
    }

    @Override
    public Double Sistema_vacio() {
        Double aux1=0.0;
        Double aux2=0.0;
        Double aux3=(Landa/Miu);
        aux2=(1/metodo.fac(K))*(Math.pow(aux3,K));
        aux2=aux2*((K*Miu)/((K*Miu)-Landa));
        for(int i=0;i<=K-1;i++){
            aux1=aux1+((1/metodo.fac(Double.valueOf(i)))*Math.pow(aux3, i));
        }
        return 1/(aux1+aux2);
    }

    @Override
    public Double n_clientes(int n) {
        Double P0=Sistema_vacio();
        Double L_M=Landa/Miu;
        Double factor1=0.0;
        Double factor2=0.0;
            if(n<K){
                return (P0/metodo.fac(Double.valueOf(n)))*Math.pow(L_M,n);
            }else{
                factor1=1/((metodo.fac(K))*(Math.pow(K, n-K)));
                factor2=Math.pow(L_M, n);
                System.out.println(n+" "+factor1+"  "+factor2);
                return factor1*factor2*P0;
            }
        };

    @Override
    public Double maximo_n_clientes(int n) {
        Double aux=0.0;
        for(int i=0;i<=n;i++){
            aux=aux+(n_clientes(i));
        }
        return aux;
    }

    @Override
    public Double n_clientes_esperado() {
        return n_clientes_esperado_cola()+(Landa/Miu);
    }

    @Override
    public  Double n_clientes_esperado_cola() {
        Double aux1=(Landa*Miu)*Math.pow((Landa/Miu), K);
        Double aux2=(Miu*K)-(Landa);
        aux2=(metodo.fac(K-1))*(Math.pow((aux2), 2));
        return (aux1/aux2)*Sistema_vacio();
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
        Double aux1=Miu*Math.pow((Landa/Miu),K);
        aux1=aux1*Sistema_vacio();
        Double aux2=metodo.fac(K-1)*Math.pow(((K*Miu)-Landa),2);
        return aux1/aux2;
    }

    @Override
    public Double Tiempo_espera_cola_no_vacia() {
        return Tiempo_espera_cola()/Sistema_ocupado();
    }

}
