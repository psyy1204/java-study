package bm.project.core.model.restaurant;

import bm.project.core.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    ArrayList<Menu> menuList = new ArrayList<>();
    HashMap<Integer, Order> orderMap = new HashMap<>();
    RestaurantInfo restaurantInfo = new RestaurantInfo();
    ArrayList<Category> menuCategoryList = new ArrayList<>();

    int orderNo = 1;

    public Restaurant() { }

    public Restaurant(RestaurantInfo info, ArrayList<Menu> menus){
        menuList = menus;
        restaurantInfo = info;
    }

    public void setMenu(ArrayList<Menu> menus) {
        menuList = menus;
    }

    public Category setMenuCategory(String menuCategory, ArrayList<Menu> menus){
        menuList = menus;
        Category category = new Category(menuCategory, menuList);
        return category;
    }

    public List<Category> getMenu() {
        return menuCategoryList;
    }

    public void printMenu(){ }

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