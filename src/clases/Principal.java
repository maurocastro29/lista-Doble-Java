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
public class Principal {
    public static void main(String[] args){
        int dato, op;
        boolean sw = true;
        listaDoble ld = new listaDoble();
        do{
            op=new Integer(JOptionPane.showInputDialog(""
                    + "Digite una opcion\n\n"
                    + "1. Insertar inicio\n"
                    + "2. Insertar final \n"
                    + "3. Insertar antes \n"
                    + "4. Insertar despues \n"
                    + "5. Buscar nodo\n"
                    + "6. Eliminar nodo\n"
                    + "7. Editar nodo\n"
                    + "8. Listar\n"
                    + "9. Eliminar Repetidos\n"
                    + "10. Ordenar ascendentemente\n"
                    + "11. Ordenar descendentemente\n"
                    + "12. salir\n"));
            switch(op){
                case 1:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite un dato"));
                    Nodo nodo = new Nodo(dato);
                    ld.insertarInicio(nodo);
                    break;
                }
                case 2:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite un dato"));
                    Nodo nodo = new Nodo(dato);
                    ld.insertarFinal(nodo);
                    break;
                }
                case 3:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el nuevo dato"));
                    int datobuscar = new Integer(JOptionPane.showInputDialog("Digite el dato a buscar"));
                    Nodo nodo = new Nodo(dato);
                    ld.insertarAntes(nodo, datobuscar);
                    break;
                }
                case 4:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el nuevo dato"));
                    int datobuscar = new Integer(JOptionPane.showInputDialog("Digite el dato a buscar"));
                    Nodo nodo = new Nodo(dato);
                    ld.insertarDespues(nodo, datobuscar);
                    break;
                }
                case 5:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el dato a buscar"));
                    Nodo aux = ld.buscarNodo(dato);
                    if(aux!=null){
                        JOptionPane.showMessageDialog(null, "El dato existe en la lista");
                    }else{
                        JOptionPane.showMessageDialog(null, "El dato no existe en la lista");
                    }
                    break;
                }
                case 6:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite un dato a eliminar"));
                    ld.eliminar(dato);
                    break;
                }
                case 7:{
                    dato = new Integer(JOptionPane.showInputDialog("Digite el nuevo dato"));
                    int datobuscar = new Integer(JOptionPane.showInputDialog("Digite el dato a editar"));
                    ld.editarNodo(dato, datobuscar);
                    break;
                }
                case 8:{
                    ld.mostrarLista();
                    break;
                }
                case 9:{
                    ld.eliminarRepetidos();
                    JOptionPane.showMessageDialog(null, "Repetidos eliminados");
                    break;
                }
                case 10:{
                    ld.ordenarAscendente();
                    break;
                }
                case 11:{
                    ld.ordenarDescendente();
                    break;
                }
                case 12:{
                    int salir = JOptionPane.showConfirmDialog(null, "Realmente desea salir?");
                    if(salir == 0){
                        sw = false;
                    }
                    break;
                }
                default:{
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                }
            }
        }while(sw);
    }
}
