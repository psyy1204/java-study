package bm.project.core.model;

import java.util.ArrayList;

public class Menu{
    public int No;
    public String Name;
    public int Price;

    public Menu(String name, int Price, ArrayList<Menu> menuList){    //생성자
        this.No = menuList.size() + 1;
        this.Name = name;
        this.Price = Price;
    }

    @Override
    public java.lang.String toString() {
        return "Menu{" +
                "No=" + No +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                '}';
    }
}