/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Castro
 */
public class listaDoble {
    private Nodo ptr;

    public listaDoble(){
        this.ptr = null;
    }
    public listaDoble(Nodo ptr) {
        this.ptr = ptr;
    }

    public Nodo getPtr() {
        return ptr;
    }

    public void setPtr(Nodo ptr) {
        this.ptr = ptr;
    }
    
    public boolean isVacia(){
        return this.getPtr() == null;
    }
    
    public Nodo buscarNodo(int dato){
        if(!this.isVacia()){//si no esta vacia la lista
            Nodo aux = this.getPtr();//creamos un auxiliar y lo colocamos en la cabeza de la lista
            while(aux!=null){//recorremos la lista con el auxiliar
                if(aux.getDato() == dato){// pregunto si es el dato que estoy buscando
                    return aux; // retorno el nodo que encontre
                }
                aux=aux.getSgt();//avanzo hasta el proximo nodo
            }
        }
        return null;//retorna null en caso que no se encuentre el nodo o la lista este vacia
    }
    
    public void insertarInicio(Nodo nodo){
        if(this.isVacia()){
            this.setPtr(nodo);
        }else{
            nodo.setSgt(this.getPtr());
            this.getPtr().setAnt(nodo);
            this.setPtr(nodo);
        }
        JOptionPane.showMessageDialog(null, "Nodo insertado");
    }
    
    public void insertarFinal(Nodo nodo){
        if(this.isVacia()){
            this.setPtr(nodo);
        }else{
            Nodo aux=this.getPtr();
            while(aux.getSgt()!=null){
                aux = aux.getSgt();
            }
            nodo.setAnt(aux);
            aux.setSgt(nodo);
        }
        JOptionPane.showMessageDialog(null, "Nodo insertado");
    }
    
    public void insertarAntes(Nodo nodo, int dato){
        if(this.isVacia()){
            this.setPtr(nodo);
            JOptionPane.showMessageDialog(null, "Nodo insertado");
        }else{
            Nodo aux = buscarNodo(dato);
            if(aux!=null){
                if(aux==this.getPtr()){
                    nodo.setSgt(aux);
                    aux.setAnt(nodo);
                    this.setPtr(nodo);
                }else{
                    nodo.setAnt(aux.getAnt());
                    nodo.setSgt(aux);
                    aux.getAnt().setSgt(nodo);
                    aux.setAnt(nodo);
                }
                JOptionPane.showMessageDialog(null, "Nodo insertado");
            }else{
                JOptionPane.showMessageDialog(null, "Dato no encontrado, no se pudo ingresar el nuevo nodo");
            }
        }
    }
    
    public void insertarDespues(Nodo nodo, int dato){
        if(this.isVacia()){
            this.setPtr(nodo);
            JOptionPane.showMessageDialog(null, "Nodo insertado");
        }else{
            Nodo aux = buscarNodo(dato);
            if(aux!=null){
                if(aux.getSgt()==null){
                    nodo.setAnt(aux);
                    aux.setSgt(nodo);
                }else{
                    nodo.setAnt(aux);
                    nodo.setSgt(aux.getSgt());
                    aux.getSgt().setAnt(nodo);
                    aux.setSgt(nodo);
                }
                JOptionPane.showMessageDialog(null, "Nodo insertado");
            }else{
                JOptionPane.showMessageDialog(null, "Dato no encontrado, no se pudo ingresar el nuevo nodo");
            }
        }
    }
    
    public void eliminar(int dato){
        if(!this.isVacia()){//pregunto si hay elementos en la lista
            Nodo aux = buscarNodo(dato);
            if(aux!=null){
                if(aux==this.getPtr()){
                    this.setPtr(this.getPtr().getSgt());
                    this.getPtr().setAnt(null);
                    aux.setSgt(null);
                }else if(aux.getSgt()==null){
                    aux.getAnt().setSgt(null);
                    aux.setAnt(null);
                }else{
                    aux.getAnt().setSgt(aux.getSgt());
                    aux.getSgt().setAnt(aux.getAnt());
                }
                aux.setSgt(null);
                aux.setAnt(null);
                JOptionPane.showMessageDialog(null, "Nodo eliminado correctamente");
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro el nodo a eliminar");
            }
        }
    }
    
    public void editarNodo(int nuevodato, int datoEditar){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(datoEditar);
            if(aux!=null){
                aux.setDato(nuevodato);
                JOptionPane.showMessageDialog(null, "Nodo editado con exito");
            }else{
                JOptionPane.showMessageDialog(null, "Nodo no encontrado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "La lista está vacia");
        }
    }
    
    public void mostrarLista(){
        if(!this.isVacia()){
            String datos = "||";
            Nodo aux = this.getPtr();
            while(aux!=null){
                datos += "<-[" + aux.getDato() + "]->";
                aux=aux.getSgt();
            }
            datos += "||";
            JOptionPane.showMessageDialog(null, datos);
        }
    }
    
    public void eliminarRepetidos(){
        if(!this.isVacia()){
            Nodo aux = this.getPtr();
            Nodo aux2 = this.getPtr().getSgt();
            while(aux.getSgt()!=null){
                while(aux2!=null){
                    if(aux.getDato()==aux2.getDato()){
                        if(aux.getSgt()==aux2){
                            aux.setSgt(aux2.getSgt());
                            aux2.getSgt().setAnt(aux);
                            aux2.setAnt(null);
                            aux2.setSgt(null);
                        }else if(aux2.getSgt()==null){
                            aux2.getAnt().setSgt(null);
                            aux.setAnt(null);
                        }else{
                            aux2.getSgt().setAnt(aux2.getAnt());
                            aux2.getAnt().setSgt(aux2.getSgt());
                        }
                        aux2 = aux.getSgt();
                    }
                    aux2=aux2.getSgt();
                }
                aux = aux.getSgt();
                aux2 = aux.getSgt();
            }
        }
    }
    
    public void ordenarAscendente(){
        if(this.isVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }else{
            Nodo aux = this.getPtr();
            Nodo aux2 = this.getPtr().getSgt();
            while(aux.getSgt()!=null){
                if(aux.getDato() < aux2.getDato()){
                    if(aux==this.getPtr()){
                        aux2.getSgt().setAnt(aux);
                        aux.setSgt(aux2.getSgt());
                        aux.setAnt(aux2);
                        aux2.setSgt(aux);
                        aux2.setAnt(null);
                        this.setPtr(aux2);
                    }else if(aux2.getSgt()==null){
                        aux.getAnt().setSgt(aux2);
                        aux2.setAnt(aux.getAnt());
                        aux2.setSgt(aux);
                        aux.setAnt(aux2);
                        aux.setSgt(null);
                    }else{
                        aux.getAnt().setSgt(aux2);
                        aux2.getSgt().setAnt(aux);
                        aux.setSgt(aux2.getSgt());
                        aux2.setAnt(aux.getAnt());
                        aux2.setSgt(aux);
                        aux.setAnt(aux2);
                    }
                    aux = this.getPtr();
                    aux2 = this.getPtr().getSgt();
                }else{
                    aux = aux.getSgt();
                    aux2 = aux.getSgt();
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Lista ordenada exitosamente");
    }

    
    public void ordenarDescendente(){
        if(this.isVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }else{
            Nodo aux = this.getPtr();
            Nodo aux2 = aux.getSgt();
            while(aux.getSgt()!=null){
                if(aux.getDato() > aux2.getDato()){
                    if(aux==this.getPtr()){
                        aux2.getSgt().setAnt(aux);
                        aux.setSgt(aux2.getSgt());
                        aux.setAnt(aux2);
                        aux2.setSgt(aux);
                        aux2.setAnt(null);
                        this.setPtr(aux2);
                    }else if(aux2.getSgt()==null){
                        aux.getAnt().setSgt(aux2);
                        aux2.setAnt(aux.getAnt());
                        aux2.setSgt(aux);
                        aux.setAnt(aux2);
                        aux.setSgt(null);
                    }else{
                        aux.getAnt().setSgt(aux2);
                        aux2.getSgt().setAnt(aux);
                        aux.setSgt(aux2.getSgt());
                        aux2.setAnt(aux.getAnt());
                        aux2.setSgt(aux);
                        aux.setAnt(aux2);
                    }
                    aux = this.getPtr();
                    aux2 = aux.getSgt();
                }else{
                    aux = aux.getSgt();
                    aux2 = aux.getSgt();
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Lista ordenada exitosamente");
    }
    
}
