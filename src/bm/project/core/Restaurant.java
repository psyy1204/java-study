package bm.project.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    static ArrayList<Menu> menuList = new ArrayList<>();
    static HashMap<Integer, Order> orderMap = new HashMap<>();
    static int orderNo = 1;
    static HashMap<String, RestaurantInfo> infoMap = new HashMap<>();

    public Restaurant() {
        setMenu();
        setRestaurantInfo();
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
        return order;
    }

    public Order getOrder(int orderNo) {
        return orderMap.get(orderNo);
    }


    public void setRestaurantInfo(){
        infoMap.put("새마을식당",new RestaurantInfo
                ("수원시 무지개로1","123-4567","10:00","22:00"));
        infoMap.put("서브웨이",new RestaurantInfo
                ("수원시 무지개로2","123-5677","08:00","18:00"));
    }
    public void printInfo() {
        for(Map.Entry<String, RestaurantInfo> entrySet : infoMap.entrySet()) {
            System.out.println(entrySet.getKey() + " : " +entrySet.getValue());
            //전체 목록을 얻고 싶을때
        }
    }

    public RestaurantInfo getRestaurantInfo(String Name){  return infoMap.get(Name); }
}