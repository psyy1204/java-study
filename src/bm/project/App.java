package bm.project;
import bm.project.core.model.*;
import bm.project.core.model.restaurant.Hongkong;
import bm.project.core.model.restaurant.Restaurant;
import bm.project.core.model.restaurant.Saemaul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App{
    public static void main(String[] args) {
        Saemaul restaurant = new Saemaul(new RestaurantInfo("새마을식당","수원시 무지개로123","123-4567","10:00","22:00"));

        ArrayList<Category> saemaulMenuList = new ArrayList<>();
        saemaulMenuList = restaurant.setSaemaulMenu();

        ArrayList<Menu> meatMenus = new ArrayList<>();
        meatMenus = restaurant.setMeatMenus();
        ArrayList<Menu> mealMenus = new ArrayList<>();
        mealMenus = restaurant.setMealMenus();

        System.out.println("새마을 식당 메뉴판");

        for (Category menu : saemaulMenuList) {
            System.out.format("%S%S\n", menu.MenuCategory, menu.MenuList);
        }

        System.out.println();

        List<OrderMenu> orderMenus = new ArrayList<>();
        orderMenus.add(new OrderMenu(meatMenus.get(0), 2));
        orderMenus.add(new OrderMenu(mealMenus.get(1), 1));

        restaurant.createOrder(orderMenus);

        System.out.println(restaurant.getOrder(1));

        restaurant.completeOrder(1);

        Hongkong hongkong = new Hongkong(new RestaurantInfo("홍콩반점","수원시 무지개로124","123-5678","10:00","23:00"));

        List<Menu> HonkongMenus = hongkong.setHokongMenu();

        System.out.println("홍콩반점 메뉴판");

        for (Menu menu : HonkongMenus) {
            System.out.format("%4d.%S %5d\n", menu.No, menu.Name, menu.Price);
        }

        System.out.println();

        List<OrderMenu> hokongOrderMenus = new ArrayList<>();
        hokongOrderMenus.add(new OrderMenu(HonkongMenus.get(0), 1));
        hokongOrderMenus.add(new OrderMenu(HonkongMenus.get(1), 1));

        hongkong.createOrder(hokongOrderMenus);

        System.out.println(hongkong.getOrder(1));

        hongkong.completeOrder(1);
    }
}