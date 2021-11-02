package bm.project.core;

public class RestaurantInfo {
    public String Address;         //주소
    public String PhoneNumber;     //전화번호
    public Hours OpeningHours;

    public RestaurantInfo(String address, String phoneNumber, String open, String close){
        this.Address = address;
        this.PhoneNumber = phoneNumber;
        Hours openingHours = new Hours(open,close);
        this.OpeningHours = openingHours;

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
