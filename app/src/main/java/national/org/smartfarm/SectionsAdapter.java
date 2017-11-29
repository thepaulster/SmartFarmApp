package national.org.smartfarm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Owner on 11/26/2017.
 */

class SectionsAdapter  extends FragmentPagerAdapter{
    public SectionsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                RecordsFragment recordsFragment = new RecordsFragment();
                return recordsFragment;

            case 1:
                TotalsFragment totalsFragment = new TotalsFragment();
                return totalsFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position){

        switch (position){
            case 0:
                return "Records";
            case 1:
                return "Totals";
            default:
                return null;
        }

    }
}
