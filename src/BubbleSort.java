public class BubbleSort {
    static void swap(int []a, int index1, int index2){
        int saveD = a[index1];
        a[index1] = a[index2];
        a[index2] = saveD;
    }

    static void bubbleSort(int[] a, int num){
        int comparison = 0, exchange = 0;
        for(int i = 0; i < num - 1; i++){
            for(int j = num - 1; j > i; j--){
                comparison++;
                System.out.println("패스"+(i+1));
                if(a[j-1]>a[j]){
                    System.out.println();
                    swap(a, j-1, j);
                    exchange++;
                }
            }
        }

        for(int i = 0; i < num; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("비교를 "+comparison+"회 했습니다.");
        System.out.println("교환을 "+exchange+"회 했습니다.");
    }
}
