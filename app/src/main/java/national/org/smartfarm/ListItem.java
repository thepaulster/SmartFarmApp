package national.org.smartfarm;

/**
 * Created by Owner on 11/15/2017.
 */

public class ListItem {

    private String head;
    private String eggsSold;
    private String chickenSold;
    private String chicksSold;
    private String chicknSold;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEggsSold() {
        return eggsSold;
    }

    public void setEggsSold(String eggsSold) {
        this.eggsSold = eggsSold;
    }

    public String getChickenSold() {
        return chickenSold;
    }

    public void setChickenSold(String chickenSold) {
        this.chickenSold = chickenSold;
    }

    public String getChicksSold() {
        return chicksSold;
    }

    public void setChicksSold(String chicksSold) {
        this.chicksSold = chicksSold;
    }

    public String getDailyRecords() {
        return dailyRecords;
    }

    public void setDailyRecords(String dailyRecords) {
        this.dailyRecords = dailyRecords;
    }

    private String dailyRecords;

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    private String expenses;

//    public ListItem(String head, String expenses, String chicknSold, String dailyRecords) {
//        this.head = head;
//        this.expenses = expenses;
//        this.chicknSold = chicknSold;
//        this.dailyRecords = dailyRecords;
//    }



    public String getChicknSold() {
        return chicknSold;
    }

    public void setChicknSold(String chicknSold) {
        this.chicknSold = chicknSold;
    }



//    public ListItem(String head) {
//        this.head = head;
//    }

    public String getHead() {
        return head;
    }

}
