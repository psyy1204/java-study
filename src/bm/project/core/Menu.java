package bm.project.core;

public class Menu{
    public int No;
    public String Name;
    public int Price;

    public Menu(String name, int Price){    //생성자
        this.No = Restaurant.menuList.size() + 1;
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