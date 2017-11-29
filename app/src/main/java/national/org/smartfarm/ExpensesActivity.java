package national.org.smartfarm;

/*
Date :  19/11/2017
Written by: abila joshua
Description : this is a class that captures expenditures of the farm
*/

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import national.org.smartfarm.helper.InputValidation;
import national.org.smartfarm.model.FarmList;
import national.org.smartfarm.sql.DatabaseHelper;

public class ExpensesActivity extends AppCompatActivity implements View.OnClickListener  {
    private final AppCompatActivity activity = ExpensesActivity.this;

    private NestedScrollView nestedScrollView;

        private TextInputLayout textInputLayoutChicksBought;
    private TextInputLayout textInputLayoutfeeds;
    private TextInputLayout textInputLayoutvaccines;

    private TextInputEditText textInputEditTextChicksBought;
    private TextInputEditText textInputEditTextfeeds;
    private TextInputEditText textInputEditTextvaccines;

    private AppCompatButton appCompatExpenseButton;
    private AppCompatTextView appCompatTextViewBenefList;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private FarmList farmList;
    private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    myDbAdapter myDbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        initViews();
        initObjects();
        initListeners();
    }

    //Initialize Views
    private void initViews() {

        textInputLayoutChicksBought = (TextInputLayout) findViewById(R.id.textInputLayoutChicksBought);
        textInputLayoutfeeds = (TextInputLayout) findViewById(R.id.textInputLayoutfeeds);
        textInputLayoutvaccines = (TextInputLayout) findViewById(R.id.textInputLayoutvaccines);


        textInputEditTextChicksBought = (TextInputEditText) findViewById(R.id.textInputEditTextChicksBought);
        textInputEditTextfeeds = (TextInputEditText) findViewById(R.id.textInputEditTextfeeds);
        textInputEditTextvaccines = (TextInputEditText) findViewById(R.id.textInputEditTextvaccines);


        appCompatExpenseButton = (AppCompatButton) findViewById(R.id.appCompatexpensesButton);


    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        appCompatExpenseButton.setOnClickListener(this);

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

            case R.id.appCompatexpensesButton:
                postDataToSQLite();
                break;

        }
    }

    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextChicksBought, textInputLayoutChicksBought, getString(R.string.error_message_display))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextfeeds, textInputLayoutfeeds, getString(R.string.error_message_display))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextvaccines, textInputLayoutvaccines, getString(R.string.error_message_display))) {
            return;
        }



        farmList.setId(date.toString().trim());

        farmList.setChicksBought(Integer.parseInt(textInputEditTextChicksBought.getText().toString().trim()));
        farmList.setFeeds(Integer.parseInt(textInputEditTextfeeds.getText().toString().trim()));
        farmList.setVaccines(Integer.parseInt(textInputEditTextvaccines.getText().toString().trim()));
//
//
//
        myDbAdapter.insertData(farmList);
        Intent accountsIntent = new Intent(activity, MainActivity.class);
        Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT)
                .show();
        accountsIntent.putExtra("ID", date.toString().trim());
        accountsIntent.putExtra("CHICKS_BOUGHT", textInputEditTextChicksBought.getText().toString().trim());
        accountsIntent.putExtra("FEEDS", textInputEditTextfeeds.getText().toString().trim());
        accountsIntent.putExtra("VACCINES", textInputEditTextvaccines.getText().toString().trim());

        emptyInputEditText();
        startActivity(accountsIntent);
//

//
//
    }
    //
    private void emptyInputEditText() {
        textInputEditTextChicksBought.setText(null);
        textInputEditTextfeeds.setText(null);
        textInputEditTextvaccines.setText(null);
    }
}
