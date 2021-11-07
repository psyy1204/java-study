package bm.project.core.model.restaurant;

import bm.project.core.model.RestaurantInfo;

public class Saemaul extends Restaurant {
    public Saemaul(){

    }

    public Saemaul(RestaurantInfo restaurantInfo){
        this.restaurantInfo = restaurantInfo;
    }

    // 초기화
    public void init(){

    }

    @Override
    public void printMenu() {
        super.printMenu();
    }
}
