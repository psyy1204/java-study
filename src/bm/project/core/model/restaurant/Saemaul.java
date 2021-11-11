package bm.project.core.model.restaurant;

import bm.project.core.model.Category;
import bm.project.core.model.Menu;
import bm.project.core.model.RestaurantInfo;

import java.util.ArrayList;

public class Saemaul extends Restaurant {
    ArrayList<Category> SaemaulMenuList = new ArrayList<>();
    ArrayList<Menu> MeatMenus = new ArrayList<>();
    ArrayList<Menu>  MealMenus = new ArrayList<>();

    public Saemaul(){ }

    public Saemaul(RestaurantInfo restaurantInfo){
        this.restaurantInfo = restaurantInfo;
    }

    // 초기화
    public void init(){ }

    public ArrayList<Menu> setMeatMenus(){
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "열탄불고기", 9000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "새마을불고기", 9000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "소금구이", 10000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "양념구이", 10000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "항정살", 11000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "오겹살", 11000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "차돌박이", 18000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "훈제막창", 9000));
        MeatMenus.add(new Menu(MeatMenus.size() + 1, "껍데기", 6000));

        return MeatMenus;
    }

    public ArrayList<Menu> setMealMenus(){
        MealMenus.add(new Menu(MealMenus.size() + 1, "7분돼지김치", 6000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "얼큰김치찌개", 6000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "새마을 된장찌개", 6000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "냉김치말이국수", 5000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "멸치국수", 3000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "계란찜", 3000));
        MealMenus.add(new Menu(MealMenus.size() + 1, "옛날도시락", 3000));

        return MealMenus;
    }

    public ArrayList<Category> setSaemaulMenu(){
        SaemaulMenuList.add(setMenuCategory("고기류", MeatMenus));
        SaemaulMenuList.add(setMenuCategory("식사류", MealMenus));

        return SaemaulMenuList;
    }

    @Override
    public void printMenu() { super.printMenu(); }
}
