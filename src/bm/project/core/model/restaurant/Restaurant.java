package bm.project.core.model.restaurant;

import bm.project.core.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    ArrayList<Menu> menuList = new ArrayList<>();
    HashMap<Integer, Order> orderMap = new HashMap<>();
    ArrayList<Order> orders = new ArrayList<>();
    RestaurantInfo restaurantInfo = new RestaurantInfo();
    ArrayList<Category> menuCategoryList = new ArrayList<>();
    Category category = new Category();
    ArrayList<Table> tables = new ArrayList<>();
    Table table = new Table();

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
        orderNo++;
        return order;
    }

    public Order getOrder(int orderNo) {
        return orderMap.get(orderNo);
    }

    public void addOrder(){}

    public void completeOrder(int orderNo) {
        Order order = orderMap.get(orderNo);
        order.Completed = true;
        orderMap.put(orderNo, order);
        System.out.println("주문번호" + orderNo + " 완성되었습니다.");
        System.out.println(orderMap.get(orderNo));
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

    public Order changeOrder(int orderNo, List<OrderMenu> orderMenus/*, List<OrderMenu> chageMenu*/){
        Order legacyOrder = orderMap.get(orderNo);
        legacyOrder.OrderMenus = orderMenus;

//        orderMenus.remove(orderNo);
//        Order order = createOrder(chageMenu);

        System.out.println("주문이 변경되었습니다.");
        System.out.println("변경내역 : " + legacyOrder.OrderMenus);

        return legacyOrder;
    }

    public void setTable(int tableNo, Order order){
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        table = new Table(tableNo, orders);
        tables.add(table);
    }

    public Table getTable(){ return table; }

    public void printTableInfo(){
        int totalPrice = 0;
        for(Table table : tables){
            System.out.println("TableNo : " + table.TableNo);
            System.out.println("주문내역");
            for(Order order : table.Orders) {
                System.out.println("No"+order.OrderNo);
                for(OrderMenu orderMenu : order.OrderMenus) {
                    System.out.println(orderMenu.Menu+" "+orderMenu.Count);
                }
                totalPrice += table.TotalPrice;
            }
        }
        System.out.println("총 금액 : " + totalPrice);
    }
    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantInfo=" + restaurantInfo +
                '}';
    }
}