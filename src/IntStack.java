public class IntStack {
    private int max; //private ->이 클래스에서만 접근이 가능  <스택의 용량>
    private int ptr; // 스택 포인터(탑)
    private int[] stk; //스택 본체배열, 인덱스 0 ->bottom -> 첫번째 데이터는 stk[0]

    // 실행 시 예외 : 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException {
        //      확장을 받는 하위 클래스       확장     확장을 해주는 상위클래스
        public EmptyIntStackException() { }
    }

    // 실행 시 예외 : 스택이 가득 참참
   public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() { }
    }

   public IntStack(int capacity){
        ptr = 0;
        max = capacity;
        try{
            stk = new int[max];       //스택 본체용 배열
        } catch (OutOfMemoryError e){ //생성할 수 없음
            max = 10; //이 에러 발생시 max = 10으로 처리 후 진행됨
        }
   }

    //스택에 x를 푸쉬         처리하지 않은 예외를 호출한 곳으로 떠넘기는 역할
    public int push(int x) throws OverflowIntStackException{
        if (ptr > max)                  //스택이 가득참
            throw new OverflowIntStackException();
        return stk[ptr++] = x; //전달받은 x를 stk[ptr]에 저장하고, 스택포인터를 증가시킴, 반환값은 푸시한 값
    }

    //스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
    public int pop() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();

        int pop = stk[--ptr];
        stk[ptr] = 0;
        System.out.println("Pop : " + pop);
        return pop; //먼저 ptr값을 감소시키고 그때 stk[ptr]에 저장된 값을 반환
    }

    //스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr-1];
    }

    //스택에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) //정상 쪽에서 선형검색
            if(stk[i] == x)
                return  i; // 검색성공
            return -1;     //실패
    }

    //스택을 비움
    public void clear(){
        ptr = 0;
    }

    //스택의 용량을 반환
    public int capacity(){
        return max;
    }

    //스택에 쌓여있는 데이터 수를 반환
    public int size(){
        return ptr;
    }

    //스택이 비어있는가?
    public boolean isEmpty() {
        return ptr <= 0;
    }

    //스택이 가득 찼는가?
    public boolean isFull(){
        return ptr >= max;
    }

    //스택안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump (){
        if(ptr <= 0)
            System.out.println("스택이 비어 있습니다");
        else{
            for (int i = 0 ; i < ptr ; i++ )
                System.out.println(stk[i] + " ");
            System.out.println();
        }
    }

    public void printStack(){
        for(int i = 0; i < max ; i++)
            System.out.println(stk[i]);
    }
}