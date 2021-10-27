package bm.project.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    static ArrayList<Menu> menuList = new ArrayList<>();
    static ArrayList<Order> orderList = new ArrayList<>();
    static HashMap<Integer, Order> orderMap = new HashMap<Integer, Order>();

    public Restaurant() {
        setMenu();
    }

    private void setMenu() {   //해당 클래스에서만 접근이 가능
        menuList.add(new Menu("김치찌개", 5000));
        menuList.add(new Menu("된장찌개", 6000));
        menuList.add(new Menu("부대찌개", 7000));
        menuList.add(new Menu("고추장찌개", 5000));
    }

    public List<Menu> getMenu() {
        return menuList;
    }

    public HashMap createOrder(List<OrderMenu> orderMenus){
        Order order = new Order(orderMenus);
        orderList.add(order);

        for(int i = 0; i < orderList.size(); i++) {
            orderMap.put(i + 1, orderList.get(i));
        }
        return orderMap;
    }

    public Order getOrder(int orderNo) {
        Order order = new Order( );
        order = orderMap.get(orderNo);
        return order;
    }

}