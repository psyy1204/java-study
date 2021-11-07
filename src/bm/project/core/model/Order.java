package bm.project.core.model;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    public int OrderNo;
    public List<OrderMenu> OrderMenus;
    public LocalDateTime OrderDate;

    public Order(){
        OrderMenus =  new ArrayList<>();
    }

    public Order(List<OrderMenu> orderMenus, int orderNo) {
        this.OrderNo = orderNo;
        this.OrderMenus = orderMenus;
        this.OrderDate = LocalDateTime.now();
    }

    @Override
    public java.lang.String toString() {
        return "Order{" +
                "OrderMenus=" + OrderMenus.toString() +
                // String 형태가 필요할 때 형식에 맞춰 출력되도록 수정
                ", OrderDate='" + OrderDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + '\'' +
                '}';
    }
}
