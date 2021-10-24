package bm.project.core;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public int No;
    public List<OrderMenu> OrderMenus;
    public String OrderDate;

    public Order(){
        OrderMenus = new ArrayList<>();
    }

    public Order(int num, List<OrderMenu> orderMenus, String orderDate) {
        this.No = num;
        this.OrderMenus = orderMenus;
        this.OrderDate = orderDate;
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
