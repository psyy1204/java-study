package bm.project.core.model;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    public int OrderNo;
    public List<OrderMenu> OrderMenus;
    public String OrderDate;

    public Order(){ OrderMenus =  new ArrayList<>(); }

    public Order(List<OrderMenu> orderMenus) {
        this.OrderNo = Restaurant.orderNo++;
        this.OrderMenus = orderMenus;
        LocalDateTime now = LocalDateTime.now();
        this.OrderDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
    }

    @Override
    public java.lang.String toString() {
        return "Order{" +
                "OrderMenus=" + OrderMenus.toString() +
                // String 형태가 필요할 때 형식에 맞춰 출력되도록 수정
                ", OrderDate='" + OrderDate + '\'' +
                '}';
    }
}
