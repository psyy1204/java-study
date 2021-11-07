package bm.project.core.model.restaurant;

import bm.project.core.model.Menu;
import bm.project.core.model.Order;
import bm.project.core.model.OrderMenu;
import bm.project.core.model.RestaurantInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    ArrayList<Menu> menuList = new ArrayList<>();
    HashMap<Integer, Order> orderMap = new HashMap<>();
    RestaurantInfo restaurantInfo = new RestaurantInfo();
    int orderNo = 1;

    public Restaurant() {

    }

    public Restaurant(RestaurantInfo info, ArrayList<Menu> menus){
        menuList = menus;
        restaurantInfo = info;
    }

    public void setMenu(ArrayList<Menu> menus) {   //해당 클래스에서만 접근이 가능
        menuList = menus;
    }

    public List<Menu> getMenu() {
        return menuList;
    }

    public void printMenu(){

    }

    public Order createOrder(List<OrderMenu> orderMenus){
        Order order = new Order(orderMenus, orderNo);
        orderMap.put(order.OrderNo, order);
        return order;
    }

    public Order getOrder(int orderNo) {
        return orderMap.get(orderNo);
    }

    public void completeOrder(int orderNo) {
        orderMap.remove(orderNo);
        System.out.println("주문번호" + orderNo + " 완성되었습니다.");
    }

    public void setRestaurantInfo(RestaurantInfo restaurantInfo){
        this.restaurantInfo = restaurantInfo;
    }

    public RestaurantInfo getRestaurantInfo(){
        return restaurantInfo;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantInfo=" + restaurantInfo +
                '}';
    }
}