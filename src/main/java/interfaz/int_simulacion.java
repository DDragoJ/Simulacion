/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

/**
 *
 * @author cosmo
 */
public interface int_simulacion {
    public Double Sistema_ocupado ();
    public Double Sistema_vacio ();
    public Double n_clientes (int n);
    public Double maximo_n_clientes(int n);
    public Double n_clientes_esperado ();
    public Double n_clientes_esperado_cola ();
    public Double n_clientes_esperado_cola_novacia ();
    public Double Tiempo_espera_sistema();
    public Double Tiempo_espera_cola();
    public Double Tiempo_espera_cola_no_vacia();    
    public String Leer();
}
