import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivConq{
    public static void main (String[] args) {

        int[] test = {1,3,7,9};
        int[] result = mergeSort(test);
        System.out.println(result.length);
        System.out.println(Arrays.toString(result));
    }

    public static List<Integer> mergeSort(List<Integer> list) {
        if(list.size() <= 1) {
            return list;
        }

        List<Integer> firstHalf = list.subList( 0, list.size()/2);

        List<Integer> secondHalf = list.subList(list.size()/2, list.size());

        firstHalf = mergeSort(firstHalf);

        secondHalf = mergeSort(secondHalf);

        List<Integer> result = merge(firstHalf, secondHalf);

        return result;

    }

    public static List<Integer> merge(List<Integer> firstArray, List<Integer> secondArray){
        List<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < firstArray.size() + secondArray.size(); i++) {
            
        }

    }

}