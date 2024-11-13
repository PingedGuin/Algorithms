package sorting;

public class InsertionSort {

    static public int[] insertionSort(int[] array){
        int n = array.length;
        for (int i = 1; i < n;++i) {
            int key = array[i]; //1 index[1]
            int j = i - 1; // 2 index[0]
            while (j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j =  j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}
