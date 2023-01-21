package com.Hotelo;
public class Hotels {
    private int hotelID;
    private String hotelName;
    private String city;
    private int stars;

    /************************ Getters **********************/
    public int getHotelID() {
        return hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCity() {
        return city;
    }

    public int getStars() {
        return stars;
    }

    /********************* Setters **************************/

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
