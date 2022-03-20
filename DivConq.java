import java.util.Arrays;
import java.util.Random;

public class DivConq{
    public static void main (String[] args) {
        int[] test = geraVetor(20, 30);
        System.out.println(Arrays.toString(test));
        long startCount = System.nanoTime();
        int[] result = mergeSort(test);
        long endCount = System.nanoTime();
        double difference = endCount-startCount;
        double finalTime = difference/1000000000.0;
        System.out.println(Arrays.toString(result));
        System.out.println(finalTime);
    }

    public static int[] mergeSort(int[] list) {
        if(list.length <= 1) {
            return list;
        }

        int[] firstHalf = Arrays.copyOfRange(list, 0, list.length/2);

        int[] secondHalf = Arrays.copyOfRange(list, list.length/2, list.length);

        firstHalf = mergeSort(firstHalf);

        secondHalf = mergeSort(secondHalf);

        int[] result = merge(firstHalf, secondHalf);

        return result;

    }

    public static int[] merge(int[] firstArray, int[] secondArray){
        int[] finalList = new int[firstArray.length + secondArray.length];
        int firstArrayCounter = 0;
        int secondArrayCounter = 0;
        for (int i = 0; i < finalList.length; i++) {
            if (secondArrayCounter < secondArray.length && (firstArrayCounter >= firstArray.length || secondArray[secondArrayCounter] < firstArray[firstArrayCounter])) {
                finalList[i] =secondArray[secondArrayCounter];
                secondArrayCounter++;
            } else {
                finalList[i] = firstArray[firstArrayCounter];
                firstArrayCounter++;
            }
        }
        return finalList;
    }

    private static int[] geraVetor(int nroPares, int nroImpares){
        int [] res = null;
        int contPar = 0, contImpar = 0, novoNum;
        Random rnd = new Random();

        if ((nroPares >= 0) ||
                (nroImpares >= 0) &&
                (nroPares + nroImpares > 0)) {

            res = new int[nroPares + nroImpares];

            while ((contPar < nroPares) || (contImpar < nroImpares)) {
                novoNum = rnd.nextInt(98)+1;

                if ((novoNum % 2 == 0) && (contPar < nroPares)) {
                    res[contPar+contImpar] = novoNum;
                    contPar++;
                }
                else if ((novoNum % 2 == 1) && (contImpar < nroImpares)) {
                    res[contPar+contImpar] = novoNum;
                    contImpar++;
                }
            }
        }

        return res;
    }

}