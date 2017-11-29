package national.org.smartfarm;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private SectionsAdapter mSectionsAdapter;
    private TabLayout mTabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.tabPager);
        mSectionsAdapter = new SectionsAdapter(getSupportFragmentManager());
        mTabLayout = (TabLayout) findViewById(R.id.main_Tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.setAdapter(mSectionsAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_add){
            startActivity(new Intent(MainActivity.this, InfoActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
