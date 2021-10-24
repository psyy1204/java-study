import java.util.Comparator;
import java.util.Scanner;

public class Linkedlist<E> {
    class Node<E> {
        private E data; //클래스 내에서만
        private Node<E> next; //뒤쪽 포인터 다음 노드 참조

        //생성자
        Node(E data,Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; //머리노드
    private Node<E> crnt; //현재 선택한 노드

    //생성자
    public Linkedlist(){
        head = crnt = null;  //노드가 없이 비어있는 연결리스트
    }

    //노드 검색
    public E search(E obj, Comparator<? super E> c) {
        //obj 검색할때 key가되는 데이터를 넣어둠
        //두번째 매개변수 comparator c에 의해 obj와 선택한 노드의 데이터를 비교하여 0이면 검색조건이 성립하는것
        Node<E> ptr = head;  //현재 스캔중인 노드

        while(ptr != null) {
            if(c.compare(obj, ptr.data) == 0) { //검색성공
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;  //다음 노드를 선택
        }
        return null; //검색 실패
    }

    //머리에 노드 삽입
    public void addFirst(E obj) {
        Node<E> ptr = head; //삽입전의 머리노드
        head = crnt = new Node<E>(obj, ptr);
    }

    //꼬리에 노드 삽입
    public void addLast(E obj) {
        if(head == null){    //리스트가 비어있으면
            addFirst(obj);   //머리에 삽입
        } else {
            Node<E> ptr = head;
            while(ptr.next != null) {   //while문 종료시 ptr은 꼬리노드
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<E>(obj, null);
        }
    }
    //머리노드를 삭제
    public void removeFirst() {
        if (head != null) {
            head = crnt = head.next;
        }
    }

    //꼬리노드를 삭제
    public void removeLast() {
        if(head != null) {
            if(head.next == null) {  //노드가 하나만 있으면
                removeFirst();       //머리노드를 삭제
            } else {
                Node<E> ptr = head; //스캔중인 노드
                Node<E> pre = head;  //스캔중인 노드의 앞쪽 노드

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null; //pre는 삭제 후의 꼬리노드
                crnt = pre;
            }
        }
    }

    //선택한 노드 p를 삭제
    public void remove(Node p){
        if(head != null) {
            if(p == head) {
                removeFirst();
            } else {
                Node<E> ptr = head;

                while(ptr.next != p) {
                    ptr = ptr.next;
                    if(ptr == null) return; //p가 리스트에 없습니다.
                }

                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    //선택 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    //모든 노드를 삭제
    public void clear(){
        while(head != null){
            removeFirst();
        }
        crnt = null;
    }

    //선택한 노드를 하나 뒤쪽으로 이동
    public boolean next(){
        if(crnt == null || crnt.next == null) return false;
        crnt = crnt.next;
        return true;
    }

    //선택한 노드를 출력
    public void printCurrentNode() {
        if(crnt == null) System.out.println("선택한 노드가 없습니다");
        else System.out.println(crnt.data);
    }

    //모든 노드를 출력
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
