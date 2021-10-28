package bm.project.core;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    public int OrderNo;
    public List<OrderMenu> OrderMenus;
    // 표시형식을 자유롭게 하기 위해
    // 기본자료형으로 변경
    public LocalDateTime OrderDate;

    // 생성자에서 현재 시간을 가져오도록 수정
    // LocalDateTime now = LocalDateTime.now();
    // String orderDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

    public Order(){
        OrderMenus = new ArrayList<>();
    }

    public Order(List<OrderMenu> orderMenus) {
        this.OrderNo = Restaurant.orderNo++;
        this.OrderMenus = orderMenus;
        this.OrderDate = LocalDateTime.now();
    }

    @Override
    public java.lang.String toString() {
        return "Order{" +
                "OrderMenus=" + OrderMenus.toString() +
                // String 형태가 필요할 때 형식에 맞춰 출력되도록 수정
                ", OrderDate='" + OrderDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")) + '\'' +
                '}';
    }
}
