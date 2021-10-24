public class QuickSort {
    static void swap(int[] a,int index1,int index2){
        int saveD = a[index1];
        a[index1] = a[index2];
        a[index2] = saveD;
    }

    static void quickSort(int[] a, int leftP, int rightP) {
        int pL = leftP;          //왼쪽커서
        int pR = rightP;         //오른쪽 커서
        int x = a[(pL + pR) / 2];  //피벗

        do {
            while (a[pL] < x) pL++;
            while (a[pR] > x) pR--;
            if(pL <= pR){
                swap(a, pL++, pR--);
            }
        } while(pL <= pR);

        if(leftP < pR) quickSort(a, leftP, pR); //재귀호출
        if(pL < rightP) quickSort(a, pL, rightP);
    }
}
