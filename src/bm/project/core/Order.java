package bm.project.core;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    public List<OrderMenu> OrderMenus;
    public String OrderDate;

    LocalDateTime now = LocalDateTime.now();
    String orderDate = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

    public Order(){
        OrderMenus = new ArrayList<>();
    }

    public Order(List<OrderMenu> orderMenus) {
        this.OrderMenus = orderMenus;
        this.OrderDate = orderDate;
    }

    @Override
    public java.lang.String toString() {
        return "Order{" +
                "OrderMenus=" + OrderMenus.toString() +
                ", OrderDate='" + OrderDate + '\'' +
                '}';
    }
}
