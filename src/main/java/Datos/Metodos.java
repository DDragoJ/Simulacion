package Datos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cosmo
 */
public class Metodos {
    DecimalFormat df=new DecimalFormat(".##");
    

    public Metodos() {}
    
    public Double fac(Double n){
        if (n==0.0)
            return 1.0;
        else
            return n * fac(n-1);
    }
    public Double redondear(Double n){
        String aux=df.format(n).replace(",", ".");
        return Double.valueOf(aux);
    }
        public Double truncar(Double n){
        BigDecimal bd = new BigDecimal(String.valueOf(n));
        BigDecimal rounded = bd.setScale(2,RoundingMode.FLOOR);
        return Double.valueOf(rounded.toString());
    }
}
