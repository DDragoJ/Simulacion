package Datos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cosmo
 */
public abstract class Metodos {
    public int fac(int n){
        if (n==0)
            return 1;
        else
            return n * fac(n-1);
    }
}