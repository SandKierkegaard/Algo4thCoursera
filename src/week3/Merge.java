package week3;
//  coping the code from the txt. Not Finished
public class Merge {
    private Merge() { }
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
//        assert isSorted (a, lo, mid);
//        assert isSorted (a, mid + 1 , hi);
        
        for (int k=lo; k<= hi; k++) { 
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) { 
            if (i > mid )  a[k] = aux[j++];
            else if (j > hi) a[k] = aux[j++];
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
