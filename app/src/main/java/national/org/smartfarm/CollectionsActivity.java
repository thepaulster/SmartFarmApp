package national.org.smartfarm;
/*  Date: 10/11/2017
*   Name:OJOK ISAAC
    Desc:Daily records class.
it records and stores the daily records that is met at the farm.
*
* */
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import national.org.smartfarm.helper.InputValidation;
import national.org.smartfarm.model.FarmList;
import national.org.smartfarm.sql.DatabaseHelper;

public class CollectionsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextInputLayout textInputLayoutEggsCollected;
    private TextInputLayout textInputLayoutChicksHatched;
    private TextInputLayout textInputLayoutChickenvaccinated;

    private TextInputEditText textInputEditTextEggsCollected;
    private TextInputEditText textInputEditTextChicksHatched;
    private TextInputEditText textInputEditChickenvaccinated;

    private final AppCompatActivity activity = national.org.smartfarm.CollectionsActivity.this;

    private AppCompatButton appCompatDailyButton;


    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private FarmList farmList;
    private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    myDbAdapter myDbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);



                initViews();
                initObjects();
                initListeners();
            }

            //Initialize Views
            private void initViews() {

                textInputLayoutEggsCollected
                        = (TextInputLayout) findViewById(R.id.textInputLayoutEggsCollected);
                textInputLayoutChicksHatched = (TextInputLayout) findViewById(R.id.textInputLayoutChicksHatched);
                textInputLayoutChickenvaccinated = (TextInputLayout) findViewById(R.id.textInputLayoutchickenVaccinated);


                textInputEditTextEggsCollected = (TextInputEditText) findViewById(R.id.textInputEditTextEggsCollected);
                textInputEditTextChicksHatched = (TextInputEditText) findViewById(R.id.textInputEditTextChicksHatched);
                textInputEditChickenvaccinated = (TextInputEditText) findViewById(R.id.textInputEditTextchickenVaccinated);


                appCompatDailyButton = (AppCompatButton) findViewById(R.id.appCompatdailyButton);


            }

            /**
             * This method is to initialize listeners
             */
            private void initListeners() {
                appCompatDailyButton.setOnClickListener(this);

            }

            /**
             * This method is to initialize objects to be used
             */
            private void initObjects() {
                inputValidation = new InputValidation(activity);
                databaseHelper = new DatabaseHelper(activity);
                farmList = new FarmList();
                myDbAdapter = new myDbAdapter(activity);
            }

            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.appCompatdailyButton:
                        postDataToSQLite();
                        break;

                }
            }

            private void postDataToSQLite() {
                if (!inputValidation.isInputEditTextFilled(textInputEditTextEggsCollected, textInputLayoutEggsCollected, getString(R.string.error_message_display))) {
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(textInputEditTextChicksHatched, textInputLayoutChicksHatched, getString(R.string.error_message_display))) {
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(textInputEditChickenvaccinated, textInputLayoutChickenvaccinated, getString(R.string.error_message_display))) {
                    return;
                }



                farmList.setId(date.toString().trim());

                farmList.setChicksBought(Integer.parseInt(textInputEditTextEggsCollected.getText().toString().trim()));
                farmList.setFeeds(Integer.parseInt(textInputEditTextChicksHatched.getText().toString().trim()));
                farmList.setVaccines(Integer.parseInt(textInputEditChickenvaccinated.getText().toString().trim()));
//
//
//
                myDbAdapter.insertData(farmList);
                Intent accountsIntent = new Intent(activity, MainActivity.class);
                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT)
                        .show();
                accountsIntent.putExtra("ID", date.toString().trim());
                accountsIntent.putExtra("CHICKS_BOUGHT", textInputEditTextEggsCollected.getText().toString().trim());
                accountsIntent.putExtra("FEEDS", textInputEditTextChicksHatched.getText().toString().trim());
                accountsIntent.putExtra("VACCINES", textInputEditChickenvaccinated.getText().toString().trim());

                emptyInputEditText();
                startActivity(accountsIntent);
//

//
//
            }
            //
            private void emptyInputEditText() {
                textInputEditTextEggsCollected.setText(null);
                textInputEditTextChicksHatched.setText(null);
                textInputEditChickenvaccinated.setText(null);
            }
        }
