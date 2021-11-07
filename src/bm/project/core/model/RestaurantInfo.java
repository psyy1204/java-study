package bm.project.core.model;

public class RestaurantInfo {
    public String Name;
    public String Address;         //주소
    public String PhoneNumber;     //전화번호
    public Hours OpeningHours;

    public RestaurantInfo(){

    }

    public RestaurantInfo(String name, String address, String phoneNumber, String open, String close){
        this.Name = name;
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        this.OpeningHours = new Hours(open,close);
    }

    @Override
    public java.lang.String toString() {
        return "RestaurantInfo{" +
                "Address=" + Address +
                ", PhoneNumber='" + PhoneNumber +
                ", Openinghours='" + OpeningHours+'\'' +
                '}';
    }
}
