package bm.project.core.model;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Table {
    public int TableNo;
    public List<Order> Orders; //주문번호, 메뉴, 주문시간

    public Table(){ }

    public Table(int tableNo, List<Order> orders){
        this.TableNo = tableNo;
        this.Orders = orders;
    }

    @Override
    public java.lang.String toString() {
        return "Table{" +
                "TableNo=" + TableNo +
                "Orders=" + Orders +
                '}';
    }
}
