/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author xmnislas
 */
public class Valida {

    public boolean cadenaVacia(String s) {
        CharSequence cadena = s;
        String reCadena = "^\\s*$";
        Pattern pattern = Pattern.compile(reCadena);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    }

    public boolean validaCadena(int longMax, String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una cadena de longitud maxima dada
        String reCadena = "^.{1," + longMax + "}$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        return matcher.matches();
    }

    public boolean validaIsbn(String s) {
        CharSequence cadena = s.trim();
        String reCadena = "^[0-9]{13}$";
        Pattern pattern = Pattern.compile(reCadena);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    }

    public boolean validaEntero(String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una cadena con puros digitos
        String reCadena = "^\\d+$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        return matcher.matches();
    }

    public boolean validaEnteroMaxDigitos(int numDigitos, String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una cadena con cuando mucho
        // numDigitos
        String reCadena = "^\\d{1," + numDigitos + "}$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        return matcher.matches();
    }

    public boolean validaEnteroRango(int min, int max, String s) {
        // Convierte la cadena a un entero
        int n = Integer.parseInt(s);

        return !(n < min || n > max);
    }

    public boolean validaFecha(String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una fecha
        String reCadena = "^(([0-2]?[0-9])|([3][0-1]))\\/(([0]?[0-9])|([1][0-2]))\\/[0-9]{4}$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        return matcher.matches();
    }

    public boolean validaEmail(String s) {
        CharSequence cadena = s.trim();

        // Define una expresión regular para una dirección de correo electrónico
        String reCadena = "^([\\-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$";

        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena, Pattern.CASE_INSENSITIVE);

        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);

        return matcher.matches();
    }
}
