package bm.project;
import bm.project.core.model.*;
import bm.project.core.model.restaurant.Restaurant;
import bm.project.core.model.restaurant.Saemaul;

import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args) {
        Saemaul restaurant = new Saemaul(new RestaurantInfo("새마을식당","수원시 무지개로123","123-4567","10:00","22:00"));

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu(menuList.size() + 1, "김치찌개", 5000));
        menuList.add(new Menu(menuList.size() + 1, "된장찌개", 6000));
        menuList.add(new Menu(menuList.size() + 1, "부대찌개", 7000));
        menuList.add(new Menu(menuList.size() + 1, "고추장찌개", 5000));
        restaurant.setMenu(menuList);

        List<Menu> menus = restaurant.getMenu();

        System.out.println("새마을 식당 메뉴판");

        for (Menu menu : menus) {
            System.out.format("%4d.%S%5d\n", menu.No, menu.Name, menu.Price);
        }

        System.out.println();

        List<OrderMenu> orderMenus = new ArrayList<>();
        orderMenus.add(new OrderMenu(menus.get(0), 1));
        orderMenus.add(new OrderMenu(menus.get(1), 1));

        restaurant.createOrder(orderMenus);

        System.out.println(restaurant.getOrder(1));

        restaurant.completeOrder(1);

        Restaurant subway = new Restaurant();
        subway.setRestaurantInfo(new RestaurantInfo("서브웨이","수원시 무지개로124","123-5678","07:00","20:00"));
        ArrayList<Menu> subwayMenuList = new ArrayList<>();
        subwayMenuList.add(new Menu(subwayMenuList.size() + 1, "참치샌드위치", 6000));
        subwayMenuList.add(new Menu(subwayMenuList.size() + 1, "계란샌드위치", 5000));
        subwayMenuList.add(new Menu(subwayMenuList.size() + 1, "야채샌드위치", 4500));
        subwayMenuList.add(new Menu(subwayMenuList.size() + 1, "닭가슴살샌드위치", 5000));

        subway.setMenu(subwayMenuList);

        List<Menu> subwayMenus = subway.getMenu();

        System.out.println("서브웨이 메뉴판");

        for (Menu menu : subwayMenus) {
            System.out.format("%4d.%S%5d\n", menu.No, menu.Name, menu.Price);
        }

        System.out.println();

        List<OrderMenu> subwayOrderMenus = new ArrayList<>();
        subwayOrderMenus.add(new OrderMenu(subwayMenus.get(0), 1));
        subwayOrderMenus.add(new OrderMenu(subwayMenus.get(1), 1));

        subway.createOrder(subwayOrderMenus);

        System.out.println(subway.getOrder(1));

        subway.completeOrder(1);

        System.out.println(subway);
    }
}