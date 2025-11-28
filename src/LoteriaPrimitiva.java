import java.util.Arrays;
import java.util.Random;

/* Partiendo del ejercicio de Loteria Primitiva que genera una combinacion de 6 numeros ordenada.
Crea una función que reciba dos arrays, uno con los 6 números de la puesta y otro
con los 6 números de la combinacion ganadora (ordenada). La funcion devolvera el número de aciertos.
Arrays.binarySearch */

public class LoteriaPrimitiva {
    public static void main(String[] args) {
        int[] apuesta = generarNumerosAleatorios();
        int[] ganadora = generarNumerosAleatorios();

        Arrays.sort(apuesta);
        Arrays.sort(ganadora);


        int aciertos = contarAciertos(apuesta, ganadora);

        System.out.println("Apuesta: " + Arrays.toString(apuesta));

        System.out.println("Combinación ganadora: " + Arrays.toString(ganadora));

        System.out.println("Aciertos: " + aciertos);
    }

    public static int[] generarNumerosAleatorios() {
        Random random = new Random();
        int[] apuesta = new int[6];
        int i = 0;

        while (i < 6) {
            int n = random.nextInt((48)+1);
            boolean repetido = false;

            for (int j = 0; j < i; j++) {
                if (apuesta[j] == n) {
                repetido = true;
                break;

            }
        }
        if (!repetido) {
            apuesta[i] = n;
            i++;
        }
    }
    return apuesta;
}

  public static int contarAciertos(int[] apuesta, int[] ganadora) {
        int aciertos=0;

        for(int numero : apuesta) {

            if (Arrays.binarySearch(ganadora, numero) >= 0) {
                aciertos++;
            }

        }
        return aciertos;

  }

}