package bm.project.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    static ArrayList<Menu> menuList = new ArrayList<>();
    static HashMap<Integer, Order> orderMap = new HashMap<>();
    static int orderNo = 1;

    public Restaurant() {
        setMenu();
        setRestaurantInfo();
    }

    private void setMenu() {   //해당 클래스에서만 접근이 가능
        menuList.add(new Menu("김치찌개", 5000, menuList));
        menuList.add(new Menu("된장찌개", 6000, menuList));
        menuList.add(new Menu("부대찌개", 7000, menuList));
        menuList.add(new Menu("고추장찌개", 5000, menuList));
    }

    public List<Menu> getMenu() {
        return menuList;
    }

    public Order createOrder(List<OrderMenu> orderMenus){
        Order order = new Order(orderMenus, orderNo);
        orderMap.put(order.OrderNo, order);
        return order;
    }

    public Order getOrder(int orderNo) {
        return orderMap.get(orderNo);
    }

    private void setRestaurantInfo(){
        RestaurantInfo restaurantInfo = new RestaurantInfo
                ("새마을식당","수원시 무지개로123","123-4567","10:00","22:00");
        System.out.println(restaurantInfo);
    }

    public void completeOrder(int orderNo) {
        orderMap.remove(orderNo);
        System.out.println("주문번호" + orderNo + " 완성되었습니다.");
    }

}