package national.org.smartfarm;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import national.org.smartfarm.adapter.FarmRecyclerAdapter;
import national.org.smartfarm.model.FarmList;
import national.org.smartfarm.sql.DatabaseHelper;

public class Main2Activity extends AppCompatActivity {


    private AppCompatActivity activity = Main2Activity.this;
    Context context = Main2Activity.this;
    private RecyclerView recyclerViewBeneficiary;
    private ArrayList<FarmList> listFarmList;
    private FarmRecyclerAdapter farmRecyclerAdapter;
    private DatabaseHelper databaseHelper;
    SearchView searchBox;
    private ArrayList<FarmList> filteredList;

    myDbAdapter myadpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
        initObjects();

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra("ID")) {

            //get all needed extras intent

            int id = getIntent().getExtras().getInt("CHICKEN_SOLD");
//            String email = getIntent().getExtras().getString("EMAIL");
            String address = getIntent().getExtras().getString("ADDRESS");
            String country = getIntent().getExtras().getString("COUNTRY");



        }else{

            Toast.makeText(this, "No API Data", Toast.LENGTH_SHORT).show();

        }

    }



    /**
     * This method is to initialize views
     */
    private void initViews() {
        recyclerViewBeneficiary = (RecyclerView) findViewById(R.id.recyclerViewBeneficiary);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listFarmList = new ArrayList<>();
        farmRecyclerAdapter = new FarmRecyclerAdapter(listFarmList, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewBeneficiary.setLayoutManager(mLayoutManager);
        recyclerViewBeneficiary.setItemAnimator(new DefaultItemAnimator());
        recyclerViewBeneficiary.setHasFixedSize(true);
        recyclerViewBeneficiary.setAdapter(farmRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);
        myadpter = new myDbAdapter(activity);

        getDataFromSQLite();

    }





    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listFarmList.clear();
                listFarmList.addAll(myadpter.getData());
//                listFarmList.addAll(databaseHelper. getAllBeneficiary());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                farmRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
