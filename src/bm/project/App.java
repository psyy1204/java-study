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
        //새마을식당
        Saemaul saemaul = new Saemaul(new RestaurantInfo("새마을식당","수원시 무지개로123","123-4567","10:00","22:00"));
        saemaul.initialize();

        ArrayList<Category> saemaulMenuList = saemaul.getSaemaulMenu();

        ArrayList<Menu> meatMenus = saemaul.getMeatMenus();
        ArrayList<Menu> mealMenus = saemaul.getMealMenus();

        saemaul.printMenu();

        List<OrderMenu> orderMenus = new ArrayList<>();
        orderMenus.add(new OrderMenu(meatMenus.get(0), 2));
        orderMenus.add(new OrderMenu(mealMenus.get(1), 1));

        saemaul.createOrder(orderMenus);

        System.out.println(saemaul.getOrder(1));

        saemaul.completeOrder(1);

        //홍콩반점
        Hongkong hongkong = new Hongkong(new RestaurantInfo("홍콩반점","수원시 무지개로124","123-5678","10:00","23:00"));

        hongkong.initialize();
        ArrayList<Menu> honkongMenus = hongkong.getHongkongMenus();

        hongkong.printMenu();

        List<OrderMenu> hokongOrderMenus = new ArrayList<>();
        hokongOrderMenus.add(new OrderMenu(honkongMenus.get(0), 1));
        hokongOrderMenus.add(new OrderMenu(honkongMenus.get(1), 1));

        hongkong.createOrder(hokongOrderMenus);

        System.out.println(hongkong.getOrder(1));

        List<OrderMenu> changeMenu = new ArrayList<>();
        changeMenu.add(new OrderMenu(honkongMenus.get(2),2));
        changeMenu.add(new OrderMenu(honkongMenus.get(3),1));

        hongkong.changeOrder(1,hokongOrderMenus,changeMenu);
    }
}