//package bm.project.core.model.bin;
//
//import bm.project.core.model.Menu;
//import bm.project.core.model.Order;
//import bm.project.core.model.OrderMenu;
//import bm.project.core.model.RestaurantInfo;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class Restaurant2{
//    static ArrayList<Menu> menuList = new ArrayList<>();
//    static HashMap<Integer, Order> orderMap2 = new HashMap<>();
//    static int orderNo2 = 1;
//
//    public Restaurant2() {
//        setMenu();
//        setRestaurantInfo();
//    }
//
//    private void setMenu() {   //해당 클래스에서만 접근이 가능
////        menuList.add(new Menu("참치샌드위치", 6000, menuList));
////        menuList.add(new Menu("계란샌드위치", 5000, menuList));
////        menuList.add(new Menu("야채샌드위치", 4500, menuList));
////        menuList.add(new Menu("닭가슴살샌드위치", 5000, menuList));
//    }
//
//    public List<Menu> getMenu() { return menuList; }
//
//    public Order createOrder(List<OrderMenu> orderMenus){
//        Order order2 = new Order(orderMenus, orderNo2);
//        orderMap2.put(order2.OrderNo, order2);
//        return order2;
//    }
//
//    public Order getOrder(int orderNo) {
//        return orderMap2.get(orderNo);
//    }
//
//    private void setRestaurantInfo(){
//        RestaurantInfo restaurantInfo2 = new RestaurantInfo
//                ("서브웨이","수원시 무지개로124","123-5678","07:00","20:00");
//        System.out.println(restaurantInfo2);
//    }
//
//    public void completeOrder(int orderNo) {
//        orderMap2.remove(orderNo);
//        System.out.println("주문번호" + orderNo + " 완성되었습니다.");
//    }
//}
