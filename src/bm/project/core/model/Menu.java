package bm.project.core.model;

import java.util.ArrayList;

public class Menu{
    public int No;
    public String Name;
    public int Price;

    public Menu(int No, String Name, int Price){    //생성자
        this.No = No;
        this.Name = Name;
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