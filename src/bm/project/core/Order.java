package bm.project.core;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    public int No;
    public List<OrderMenu> OrderMenus;
    public String OrderDate;

    LocalDateTime now = LocalDateTime.now();
    String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

    public Order(){
        OrderMenus = new ArrayList<>();
    }

    public Order(List<OrderMenu> orderMenus) {
        this.No = Restaurant.orderList.size() + 1;
        this.OrderMenus = orderMenus;
        this.OrderDate = formatedNow;
    }

    @Override
    public java.lang.String toString() {
        return "Order{" +
                "Num=" + No +
                ", OrderMenus=" + OrderMenus.toString() +
                ", OrderDate='" + OrderDate + '\'' +
                '}';
    }
}
