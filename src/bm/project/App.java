package bm.project;
import bm.project.core.model.*;

import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args){
        Restaurant restaurant = new Restaurant();
        List<Menu> menus = restaurant.getMenu();


        System.out.println("새마을 식당 메뉴판");

        for(Menu menu : menus){
            System.out.format("%4d.%S%5d\n",menu.No,menu.Name,menu.Price);
        }

        System.out.println();

        List<OrderMenu> orderMenus = new ArrayList<>();
        orderMenus.add(new OrderMenu(menus.get(0), 1));
        orderMenus.add(new OrderMenu(menus.get(1), 1));

        restaurant.createOrder(orderMenus);

        System.out.println(restaurant.getOrder(1));

        System.out.println(restaurant.getRestaurantInfo("새마을식당"));

        restaurant.printInfo();

        restaurant.completeOrder(1);
    }
}