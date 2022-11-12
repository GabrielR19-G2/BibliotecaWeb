/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosTransferencia;

import java.util.List;

/**
 *
 * @author xmnislas
 */
public class Lista<E> {

    private String tituloTabla;
    private List<E> lista;

    public Lista() {
    }

    public Lista(String tituloTabla, List<E> lista) {
        this.tituloTabla = tituloTabla;
        this.lista = lista;
    }

    public String getTituloTabla() {
        return tituloTabla;
    }

    public void setTituloTabla(String tituloTabla) {
        this.tituloTabla = tituloTabla;
    }

    public List<E> getLista() {
        return lista;
    }

    public void setLista(List<E> lista) {
        this.lista = lista;
    }
}
