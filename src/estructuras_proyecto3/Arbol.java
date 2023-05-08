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
// Clase árbol para la creación de todas funciones necesarias
public class Arbol {
    Nodo nodoRaiz;
    
    public Arbol(){
        this.nodoRaiz = null;
    }
    
    public void setRaiz(int valorE){
        this.nodoRaiz = new Nodo(valorE);
    }
    
    public void eliminarNodo(int valorNodo){
        if (valorNodo == this.nodoRaiz.getValor()){
            this.nodoRaiz = null;
        }else{
            this.nodoRaiz.eliminarNodoHijo(valorNodo);
        }
    }
    
    public boolean estaValor(Nodo entrada, int valorE){
        if (entrada.getValor() == valorE){
            return true;
        }
        else{
            if (entrada.getNodoDer() != null){
                if(estaValor(entrada.getNodoDer(),   valorE)){
                    return true;
                }
            }
            if (entrada.getNodoIzq() != null){
                if(estaValor(entrada.getNodoIzq(),   valorE)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public int calcularAltura(){
        if (this.nodoRaiz == null){
            return 0;
        }
        else{
            return nodoRaiz.alturaNodo();
        }
    }
    
    public void agregarNodo(int valorE){
        this.nodoRaiz.agregarNodo(valorE);
    }
    
    public int getAltura(){
        return this.nodoRaiz.alturaNodo();
    }
    
    public String preOrden(){
        return this.nodoRaiz.recorridoPreOrden();
    }
    public String postOrden(){
        return this.nodoRaiz.recorridoPostOrden();
    }
    public String inOrden(){
        return this.nodoRaiz.recorridoInOrden();
    }
    
    public Nodo getNodoRaiz(){
        return nodoRaiz;
    }

    public String hojasString(){
        java.util.List<Nodo> hojas = this.nodoRaiz.buscarHojas();
        String total = "";
        for (Nodo hoja : hojas){
            total =  String.valueOf(hoja.getValor())+ "  " + total;
        }
        return total;
    }
    
}
