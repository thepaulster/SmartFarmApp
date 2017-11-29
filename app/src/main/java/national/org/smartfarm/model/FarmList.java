package national.org.smartfarm.model;

/**
 * Created by Owner on 11/26/2017.
 */

public class FarmList {

    private String id;

    public int getChicksBought() {
        return ChicksBought;
    }

    public void setChicksBought(int chicksBought) {
        ChicksBought = chicksBought;
    }

    public int getFeeds() {
        return feeds;
    }

    public void setFeeds(int feeds) {
        this.feeds = feeds;
    }

    public int getVaccines() {
        return vaccines;
    }

    public void setVaccines(int vaccines) {
        this.vaccines = vaccines;
    }

    private int ChicksBought;
    private int feeds;
    private int vaccines;

    public int getChickenSold() {
        return ChickenSold;
    }

    public void setChickenSold(int chickenSold) {
        ChickenSold = chickenSold;
    }


    public int getChicksSold() {
        return ChicksSold;
    }

    public void setChicksSold(int chicksSold) {
        ChicksSold = chicksSold;
    }

    public int getEggsSold() {
        return EggsSold;
    }

    public void setEggsSold(int eggsSold) {
        EggsSold = eggsSold;
    }

    private int ChickenSold;
    private int ChicksSold;
    private int EggsSold;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
}
