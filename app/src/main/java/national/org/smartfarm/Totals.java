package national.org.smartfarm;
/*
* Date: 15/11/2017
* Written by: Asiimwe Paul
*
* Description: this class adds up the total of all fram records entered and sends them to the database for saving and display
*
*
*
* */

import java.util.ArrayList;

import national.org.smartfarm.model.FarmList;



/**
 * Created by Owner on 11/11/2017.
 */

public class Totals {
//    ArrayList<FarmList> listnow = new ArrayList<>();
//    int range = listnow.size();

    public static void main(String args[]) {
        ArrayList<FarmList> listnow = new ArrayList<>();
        FarmList farmList = new FarmList();

        myDbAdapter myDbAdapter;
    int range = listnow.size();
        int chicksBoughtTT = 0, vaccinesTT =0, feedsTT=0, chickenSoldTT=0, eggsSoldTT=0, chicksSoldTT=0, eggsCollectedTT=0, eggsHatchedTT=0, i;

        for ( i=0; i<= range; i++) {
            chicksBoughtTT += farmList.getChicksBought();
            vaccinesTT += farmList.getVaccines();
            feedsTT += farmList.getFeeds();
            chickenSoldTT += farmList.getChickenSold();
            eggsSoldTT += farmList.getEggsSold();
            chicksSoldTT += farmList.getChicksSold();
            eggsCollectedTT += farmList.getEggsCollected();
            eggsHatchedTT += farmList.getChicksHatched();
        }

        farmList.setChicksBoughtTT(chicksBoughtTT);
        farmList.setVaccinesTT(vaccinesTT);
        farmList.setChickenSoldTT(chickenSoldTT);
        farmList.setEggsSoldTT(eggsSoldTT);
        farmList.setChicksSoldTT(chicksSoldTT);
        farmList.setEggsCollectedTT(eggsCollectedTT);
        farmList.setEggsHatchedTT(eggsHatchedTT);

    }
}
