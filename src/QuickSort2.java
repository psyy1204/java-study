public class QuickSort2 {
    static void swap(int[] a,int index1,int index2){
        int saveD = a[index1];
        a[index1] = a[index2];
        a[index2] = saveD;
    }

    static void QuickSort2(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1); //나눌범위의 왼쪽 끝 요소의 인덱스를 저장하는 스택
        IntStack rstack = new IntStack(right - left + 1); //나눌범위의 오른쪽 끝 요소의 인덱스를 저장하는 스택

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop(); //왼쪽커서
            int pr = right = rstack.pop(); //오른쪽 커서
            int x = a[(left + right) / 2]; //피벗벗

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }

            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
    }
}
