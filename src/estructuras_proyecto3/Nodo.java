/*
 * Universidad Estatal a Distancia de Costa Rica
 * Estructuras de Datos
 * Jose Rodolto Rojas Ocampo 702390149
 */
package estructuras_proyecto3;

/**
 *
 * @author joser
 */
// Clase Nodo
public class Nodo {
    // Variables de la clase nodo
    private final int valor; // valor del nodo actual
    private Nodo nodoIzq; // Nodo izquierdo
    private Nodo nodoDer; // Nodo derecho
    
    // Constructor de la clase, para crear el nodo solo se precisa de 
    public Nodo(int valorE){
        this.valor = valorE;
        this.nodoIzq = this.nodoDer = null;
        
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public Nodo getNodoIzq(){
        return this.nodoIzq;
    }
    
    public Nodo getNodoDer(){
        return this.nodoDer;
    }
    // Indica si el nodo actual es una hoja
    public boolean esHoja(){
        if (this.nodoDer == null && this.nodoIzq == null){
            return true;
        }
        return false;
    }
    
    // Agregar Nodo a la izquierda,  privado ya que se llama desde una funcion agregar Nodo
    private void agregarNodoIzq(int valorE){
        if (this.nodoIzq == null){
            this.nodoIzq = new Nodo(valorE);
        } else{
            this.nodoIzq.agregarNodo(valorE);
        }
    }
    // Agregar Nodo a la izquierda,  privado ya que se llama desde una funcion agregar Nodo
    private void agregarNodoDer(int valorE){
        if (this.nodoDer == null){
            this.nodoDer = new Nodo(valorE);
        } else {
            this.nodoDer.agregarNodo(valorE);
        }
    }
    // Función para agregar el nodo
    public void agregarNodo(int valorE){
        if (this.valor != valorE){ // el valor ingresado debe ser diferente al valor actual, con esto ya se asegura que no hayan valores repetidos.
            if (valorE > this.valor){
                agregarNodoDer(valorE);
            }
            else if (valorE< this.valor){
                agregarNodoIzq(valorE);
            }
        }
    }
    // Eliminar el nodo Izquierdo
    private void eliminarNodoIzq(){
        this.nodoIzq = null;
    }
    // Eliminar el nodo Derecho
    private void eliminarNodoDer(){
        this.nodoDer = null;
    }
    
    // Funcion para eliminar nodo
    public void eliminarNodoHijo(int valorE){
        if (this.nodoDer != null || this.nodoIzq != null){ // Si ambos son nulos no va a hacer nada
            if (valorE != this.valor){
                if (valorE > this.valor){
                    // Derecha
                    if (this.nodoDer != null){
                        if (this.nodoDer.getValor() == valorE){eliminarNodoDer();}
                        else{this.nodoDer.eliminarNodoHijo(valorE);}
                    }
                } else if (valorE < this.valor){
                    // Izquierda
                    if (this.nodoIzq != null){
                        if (this.nodoIzq.getValor() == valorE){eliminarNodoIzq();}
                        else{this.nodoIzq.eliminarNodoHijo(valorE);}
                    }
                
                }
            }
            
        }    
    }
    
    // Calcular la altura desdeun nodo
    
    public int alturaNodo(){
        if (this.nodoDer != null && this.nodoIzq != null){
            return 1 + Math.max(this.nodoDer.alturaNodo(), this.nodoIzq.alturaNodo()); // Maximo entre la altura de dos nodos
        }else if (this.nodoDer != null){
            return 1 + this.nodoDer.alturaNodo(); // la altura solo del nodo derecho
        } else if (this.nodoIzq != null){
            return 1 + this.nodoIzq.alturaNodo(); // altura solo del nodo izquierdo
        }
        return 1; // Si no tiene hijo devuelve un 1
    }
    
    // Recorrido Preorden de los nodos
    public String recorridoPreOrden(){
        String total = "";
        total = total + "  " +String.valueOf(this.valor);
        if (this.nodoIzq != null){total = total + "  " +this.nodoIzq.recorridoPreOrden();}
        if (this.nodoDer != null){total = total + "  " +this.nodoDer.recorridoPreOrden();}
        return total;
    }
    
    // Recorrido Postorden de los nodos
    public String recorridoPostOrden(){
        String total = "";
        if (this.nodoIzq != null){total = total + "  " +this.nodoIzq.recorridoPreOrden();}
        if (this.nodoDer != null){total = total + "  " +this.nodoDer.recorridoPreOrden();}
        total = total + "  " +String.valueOf(this.valor);
        return total;
    }
    
    // Recorrido Inorden de los nodos
    public String recorridoInOrden(){
        String total = "";
        if (this.nodoIzq != null){total =  total + "  " + this.nodoIzq.recorridoPreOrden();}
        total =  total + "  " + String.valueOf(this.valor); 
        if (this.nodoDer != null){total = total + "  " + this.nodoDer.recorridoPreOrden();}
        return total;
    }
    
    
    public java.util.List<Nodo> buscarHojas(){
        java.util.List<Nodo> hojas = new java.util.ArrayList<>();
        if (this.esHoja()){
            hojas.add(this);
        } 
        if (this.nodoDer != null){
            hojas.addAll(this.nodoDer.buscarHojas());
        }
        if (this.nodoIzq != null){
            hojas.addAll(this.nodoIzq.buscarHojas());
        }
        return hojas;
    }
    
    
}
