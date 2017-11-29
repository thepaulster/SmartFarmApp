package national.org.smartfarm.model;

/**
 * Created by Owner on 11/26/2017.
 */

public class FarmList {

    private String id;
    private int chicksBoughtTT , vaccinesTT , feedsTT, chickenSoldTT, eggsSoldTT, chicksSoldTT, eggsCollectedTT, eggsHatchedTT;

    public int getChicksBought() {
        return ChicksBought;
    }

    public int getChicksBoughtTT() {
        return chicksBoughtTT;
    }

    public void setChicksBoughtTT(int chicksBoughtTT) {
        this.chicksBoughtTT = chicksBoughtTT;
    }

    public int getVaccinesTT() {
        return vaccinesTT;
    }

    public void setVaccinesTT(int vaccinesTT) {
        this.vaccinesTT = vaccinesTT;
    }

    public int getFeedsTT() {
        return feedsTT;
    }

    public void setFeedsTT(int feedsTT) {
        this.feedsTT = feedsTT;
    }

    public int getChickenSoldTT() {
        return chickenSoldTT;
    }

    public void setChickenSoldTT(int chickenSoldTT) {
        this.chickenSoldTT = chickenSoldTT;
    }

    public int getEggsSoldTT() {
        return eggsSoldTT;
    }

    public void setEggsSoldTT(int eggsSoldTT) {
        this.eggsSoldTT = eggsSoldTT;
    }

    public int getChicksSoldTT() {
        return chicksSoldTT;
    }

    public void setChicksSoldTT(int chicksSoldTT) {
        this.chicksSoldTT = chicksSoldTT;
    }

    public int getEggsCollectedTT() {
        return eggsCollectedTT;
    }

    public void setEggsCollectedTT(int eggsCollectedTT) {
        this.eggsCollectedTT = eggsCollectedTT;
    }

    public int getEggsHatchedTT() {
        return eggsHatchedTT;
    }

    public void setEggsHatchedTT(int eggsHatchedTT) {
        this.eggsHatchedTT = eggsHatchedTT;
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

    public int getChicksHatched() {
        return ChicksHatched;
    }

    public void setChicksHatched(int chicksHatched) {
        ChicksHatched = chicksHatched;
    }

    public int getEggsCollected() {
        return EggsCollected;
    }

    public void setEggsCollected(int eggsCollected) {
        EggsCollected = eggsCollected;
    }

    public int getChickenVaccinated() {
        return ChickenVaccinated;
    }

    public void setChickenVaccinated(int chickenVaccinated) {
        ChickenVaccinated = chickenVaccinated;
    }

    private int ChicksHatched;
    private int EggsCollected;
    private  int ChickenVaccinated;



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
