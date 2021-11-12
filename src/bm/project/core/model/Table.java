package bm.project.core.model;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Table {
    public int TableNo;
    public List<Order> Orders; //주문번호, 메뉴, 주문시간
    public int TotalPrice = 0;

    public Table(){ }

    public Table(int tableNo, List<Order> orders){
        this.TableNo = tableNo;
        this.Orders = orders;
        for (Order order : Orders){
            for(OrderMenu orderMenu : order.OrderMenus) {
                TotalPrice += orderMenu.MenuPrice;
            }
        }
    }

    @Override
    public java.lang.String toString() {
        return "Table{" +
                "TableNo=" + TableNo +
                "Orders=" + Orders +
                "TotalPrice='" + TotalPrice + '\'' +
                '}';
    }
}
