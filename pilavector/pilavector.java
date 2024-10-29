import java.util.Scanner;
import java .util.ArrayList;

public class pilavector {
    private int maxSize;      // Tamaño máximo de la pila
    private int[] stackArray; // Array que representa la pila
    private int top;          // Índice del tope de la pila

    // Constructor que inicializa la pila con un tamaño dado
    public pilavector(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Pila vacía, por lo tanto top inicia en -1
    }

    //  apilar o insertar un elemento 
    public void apilar(int elemento) {
        if (!estaLlena()) {
            stackArray[++top] = elemento;
            System.out.println("Elemento " + elemento + " apilado.");
        } else {
            System.out.println("Error: La pila está llena.");
        }
    }

    // desapilar o eliminar el elemento de la pila
    public void desapilar() {
        if (!estaVacia()) {
            int elemento = stackArray[top--];
            System.out.println("Elemento " + elemento + " desapilado.");
        } else {
            System.out.println("Error: La pila está vacía.");
        }
    }

    // elemento en el tope de la pila 
    public int obtenerTope() {
        if (!estaVacia()) {
            return stackArray[top];
        } else {
            System.out.println("Error: La pila está vacía.");
            return -1; // Retorna -1 en caso de error
        }
    }

    // Método para mostrar todos los elementos de la pila
    public void mostrarElementos() {
        if (!estaVacia()) {
            System.out.print("Elementos en la pila: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("La pila está vacía.");
        }
    }

    // verificar si la pila está vacía
    public boolean estaVacia() {
        return (top == -1);
    }

    //  si la pila está llena
    public boolean estaLlena() {
        return (top == maxSize - 1);
    }

    //  el tamaño actual de la pila
    public int obtenerTamaño() {
        return top + 1;
    }

    //   vaciar completamente la pila
    public void vaciar() {
        top = -1;
        System.out.println("La pila ha sido vaciada.");
    }

    // se crea el menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la pila: ");
        int tamaño = scanner.nextInt();
        pilavector pila = new pilavector(tamaño);

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE OPERACIONES EN LA PILA ---");
            System.out.println("1. Apilar (Insertar)");
            System.out.println("2. Desapilar");
            System.out.println("3. Obtener Tope");
            System.out.println("4. Mostrar Elementos");
            System.out.println("5. Verificar si está vacía");
            System.out.println("6. Verificar si está llena");
            System.out.println("7. Obtener Tamaño");
            System.out.println("8. Vaciar Pila");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a apilar: ");
                    int elemento = scanner.nextInt();
                    pila.apilar(elemento);
                    break;
                case 2:
                    pila.desapilar();
                    break;
                case 3:
                    int tope = pila.obtenerTope();
                    if (tope != -1) {
                        System.out.println("El elemento en el tope es: " + tope);
                    }
                    break;
                case 4:
                    pila.mostrarElementos();
                    break;
                case 5:
                    if (pila.estaVacia()) {
                        System.out.println("La pila está vacía.");
                    } else {
                        System.out.println("La pila no está vacía.");
                    }
                    break;
                case 6:
                    if (pila.estaLlena()) {
                        System.out.println("La pila está llena.");
                    } else {
                        System.out.println("La pila no está llena.");
                    }
                    break;
                case 7:
                    System.out.println("El tamaño actual de la pila es: " + pila.obtenerTamaño());
                    break;
                case 8:
                    pila.vaciar();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
                    break;
            }
        } while (opcion != 9);

        scanner.close();
    }
}
 
    
