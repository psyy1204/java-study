package bm.project.core.model;

import java.util.List;

public class Category {
    public String MenuCategory;
    public List<Menu> MenuList;

    public Category(String menuCategory, List<Menu> menuList){
        this.MenuCategory = menuCategory;
        this.MenuList = menuList;
    }
}
