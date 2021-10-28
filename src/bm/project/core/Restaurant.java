package bm.project.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    static ArrayList<Menu> menuList = new ArrayList<>();
    // 주문을 관리하는 자료형 변경
    // ArrayList -> HashMap
    // static ArrayList<Order> orderList = new ArrayList<>();
    static HashMap<Integer, Order> orderMap = new HashMap<>();
    // 주문번호 관리를 위한 변수 추가
    static int orderNo = 1;

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

    public Order createOrder(List<OrderMenu> orderMenus){
        Order order = new Order(orderMenus);
        orderMap.put(order.OrderNo, order);

        // List를 loop 하면서 번호를 생성하게 되는 경우
        // 매번 orderMap의 주문번호가 변경되게 됨
        // for(int i = 0; i < orderList.size(); i++) {
        //     orderMap.put(i + 1, orderList.get(i));
        //}

        return order;
    }

    public Order getOrder(int orderNo) {
        // Order order = new Order( );
        // order = orderMap.get(orderNo);
        // return order;

        // orderMap에서 찾은 order를 바로 return
        return orderMap.get(orderNo);
    }

}