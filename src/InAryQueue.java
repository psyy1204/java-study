public class InAryQueue {

    private int max; //큐 용량
    private int num; //현재 데이터 수
    private int[] que; //큐 본체

    //큐가 비어있음
    public class EmptyInAryQueueException extends RuntimeException {
        public EmptyInAryQueueException () { }
    }

    //큐가 가득참
    public class OverflowInAryQueueException extends RuntimeException {
        public OverflowInAryQueueException() { }
    }

    //생성자
    public InAryQueue (int capacity) {
        num = 0;
        max = capacity;
        //try 예외를 처리하기 원하는 실행 코드작성 부분
        try {
            que = new int[max];      //큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {//생성할 수 없음
            max = 10;
        }
    }

    public int enque(int x) throws OverflowInAryQueueException {
        if(num > max)
            throw new OverflowInAryQueueException();
        return que[num++] = x; //전달받은 x를 que에 전달하고, num을 증가시킴
    }

    public int deque() throws EmptyInAryQueueException {
        if(num <= 0)
            throw new EmptyInAryQueueException();

        int x = que[0];
        for(int i = 0 ; i < num; i++)
            que[i] = que[i+1];
        return x;
    }

    public int peek() throws EmptyInAryQueueException {
        if (num <= 0)
            throw new EmptyInAryQueueException();
        return que[0];
    }

    public void printInAry(){
        for(int i =0 ; i < num ; i++) {
            System.out.print(que[i]);
        }
        System.out.println();
    }

    public int indexOf(int x) {
        for(int i = 0; i < num-1 ; i++)
            if(que[i] == x)
                return i;
            return -1;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump () {
        if(num <= 0)
            System.out.println("큐가 비어있습니다.");
        else{
            for(int i = num-1; i >= 0; i--)
                System.out.println(que[i] + " ");
            System.out.println();
        }
    }
}
