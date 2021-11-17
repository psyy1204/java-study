package bm.project.core.model.restaurant;

import bm.project.core.model.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Restaurant {
    ArrayList<Menu> menuList = new ArrayList<>();
    HashMap<Integer, Order> orderMap = new HashMap<>();
    RestaurantInfo restaurantInfo = new RestaurantInfo();
    ArrayList<Category> menuCategoryList = new ArrayList<>();
    Category category = new Category();
    HashMap<Integer,Table> tableMap = new HashMap<>();

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
        if(tableMap.size() >= 10) System.out.println("테이블이 가득 찼습니다.");
        else tableMap.put(tableNo,table);
        System.out.println("남은 테이블 수 : " + (10-tableMap.size()));
    }

    public void addTableOrder(int tableNo, Order order) {
        Table table = tableMap.get(tableNo);
        table.Orders.add(order);
        tableMap.put(tableNo,table);
    }

    public void removeTableOrder(int tableNo, int orderNo){
        Table table = tableMap.get(tableNo);
        System.out.println("테이블 No"+tableNo+"의 주문 "+table.Orders.get(orderNo)+"가 취소되었습니다.");
        table.Orders.remove(orderNo);
    }

    public Table getTable(){ return table; }

    public void printTableInfo(int tableNo){
        int totalPrice = 0;
        Table table = tableMap.get(tableNo);

        System.out.println("TableNo : " + tableNo);
        System.out.println("주문내역");
        for(Order order : table.Orders) {
            System.out.print("No"+order.OrderNo);
            if(order.Completed == false) System.out.println(" 미완료");
            else System.out.println(" 완료");
            System.out.println("주문시간 : "+ order.OrderDate.format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH:mm:ss")));
            for(OrderMenu orderMenu : order.OrderMenus) {
                System.out.println(orderMenu.Menu+" "+orderMenu.Count);
                totalPrice += orderMenu.MenuPrice;
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