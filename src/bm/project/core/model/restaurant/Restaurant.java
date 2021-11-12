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
    Category category = new Category();

    int orderNo = 1;

    public Restaurant() { }

    public Restaurant(RestaurantInfo info, ArrayList<Menu> menus){
        menuList = menus;
        restaurantInfo = info;
    }

    public void setMenu(ArrayList<Menu> menus) {
        menuList = menus;
    }

    public void setCategory(int categoryNo, String categoryName, ArrayList<Menu> menus){
        // 여기에서 menus를 넣어야 하는데 menuList를 넣어서 제대로 안들어감
        category = new Category(categoryNo, categoryName, menus);
    }

    public Category getCategory(){
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

    public void removeOrder(int orderNo){
        orderMap.remove(orderNo);
    }

    public Order changeOrder(int orderNo, List<OrderMenu> orderMenus, List<OrderMenu> chageMenu){
//        Order legacyOrder = orderMap.get(orderNo);
//        legacyOrder.OrderMenus = orderMenus;

        orderMenus.remove(orderNo);
        Order order = createOrder(chageMenu);

        System.out.println("주문이 변경되었습니다.");
        System.out.println("변경내역 : " + order);

        return order;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantInfo=" + restaurantInfo +
                '}';
    }
}