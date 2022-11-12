/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosTransferencia;

/**
 *
 * @author xmnislas
 */
public class Mensaje {
    private String mensaje;
    private String claseMensaje;

    public Mensaje() {
    }

    public Mensaje(String mensaje, String claseMensaje) {
        this.mensaje = mensaje;
        this.claseMensaje = claseMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getClaseMensaje() {
        return claseMensaje;
    }

    public void setClaseMensaje(String claseMensaje) {
        this.claseMensaje = claseMensaje;
    }
}
