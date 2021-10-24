import java.util.Scanner;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        LinkedListTester.Menu menu; //메뉴
        LinkedListTester.Data data; //추가용 데이터 참조
        LinkedListTester.Data ptr;  //검색용 데이터 참조
        LinkedListTester.Data temp = new LinkedListTester.Data(); //입력용

        Linkedlist<LinkedListTester.Data> list = new Linkedlist<LinkedListTester.Data>(); //리스트를 생성

        do{
            switch (menu = LinkedListTester.SelectMenu()){

                case ADD_FIRST :
                    data = new LinkedListTester.Data();
                    data.scanData("머리에 삽입", LinkedListTester.Data.NO | LinkedListTester.Data.NAME);
                    list.addFirst(data);
                    break;

                case ADD_LAST :
                    data = new LinkedListTester.Data();
                    data.scanData("꼬리에 삽입", LinkedListTester.Data.NO | LinkedListTester.Data.NAME);
                    list.addLast(data);
                    break;

                case RMV_FIRST :
                    list.removeFirst();
                    break;

                case RMV_LAST :
                    list.removeLast();
                    break;

                case RMV_CRNT :
                    list.removeCurrentNode();
                    break;

                case SEARCH_NO :  //회원 번호로 검색
                    temp.scanData("검색", LinkedListTester.Data.NO);
                    ptr = list.search(temp, LinkedListTester.Data.NO_ORDER);
                    if(ptr == null) {
                        System.out.println("그 번호의 데이터가 없습니다");
                    } else {
                        System.out.println("검색 성공 : "+ ptr);
                    }
                    break;

                case SEARCH_NAME :
                    temp.scanData("검색", LinkedListTester.Data.NAME);
                    ptr = list.search(temp, LinkedListTester.Data.NAME_ORDER);
                    if(ptr == null){
                        System.out.println("그 이름의 데이터가 없습니다.");
                    } else {
                        System.out.println("검색 성공 : "+ ptr);
                    }
                    break;

                case NEXT :
                    list.next();
                    break;

                case PRINT_CRNT:
                    list.printCurrentNode();
                    break;

                case DUMP:
                    list.dump();

                case CLEAR:
                    list.clear();
                    break;
            }
        } while (menu != LinkedListTester.Menu.TERMINATE);
    }
}
