package national.org.smartfarm;
/*
*
*Name: Kyambadde Elisha
*
*
*Description: this is used to enter data and save it to the database
*
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

public class IncomeActivity extends AppCompatActivity implements View.OnClickListener  {

    private final AppCompatActivity activity = IncomeActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutChickenSold;
    private TextInputLayout textInputLayoutChicksSold;
    private TextInputLayout textInputLayoutEggsSold;
    private TextInputLayout textInputLayoutBeneficiaryCountry;
    private TextInputLayout textInputLayoutBeneficiaryId;

    private TextInputEditText textInputEditTextChickenSold;
    private TextInputEditText textInputEditTextChicksSold;
    private TextInputEditText textInputEditTextEggsSold;
    private TextInputEditText textInputEditTextBeneficiaryCountry;
    private TextInputEditText textInputEditTextBeneficiaryId;

    private AppCompatButton appCompatIncomeButton;
    private AppCompatTextView appCompatTextViewBenefList;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private FarmList farmList;
    private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    myDbAdapter myDbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        initViews();
        initObjects();
        initListeners();
    }

    //Initialize Views
    private void initViews() {
//        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutChickenSold = (TextInputLayout) findViewById(R.id.textInputLayoutChickenSold);
        textInputLayoutChicksSold = (TextInputLayout) findViewById(R.id.textInputLayoutChicksSold);
        textInputLayoutEggsSold = (TextInputLayout) findViewById(R.id.textInputLayouteggsSold);


        textInputEditTextChickenSold = (TextInputEditText) findViewById(R.id.textInputEditTextChickenSold);
        textInputEditTextChicksSold = (TextInputEditText) findViewById(R.id.textInputEditTextChicksSold);
        textInputEditTextEggsSold = (TextInputEditText) findViewById(R.id.textInputEditTexteggsSold);


        appCompatIncomeButton = (AppCompatButton) findViewById(R.id.appCompatincomeButton);

//        appCompatTextViewBenefList = (AppCompatTextView) findViewById(R.id.appCompatTextViewBenefList);

    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        appCompatIncomeButton.setOnClickListener(this);
//        appCompatTextViewBenefList.setOnClickListener(this);

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

            case R.id.appCompatincomeButton:
                postDataToSQLite();
                break;

//            case R.id.appCompatTextViewBenefList:
//                Intent accountsIntent = new Intent(activity, BeneficiaryListActivity.class);
//                accountsIntent.putExtra("ID", textInputEditTextBeneficiaryId.getText().toString().trim());
//                accountsIntent.putExtra("NAME", textInputEditTextBeneficiaryName.getText().toString().trim());
//                accountsIntent.putExtra("EMAIL", textInputEditTextBeneficiaryEmail.getText().toString().trim());
//                accountsIntent.putExtra("ADDRESS", textInputEditTextBeneficiaryAddress.getText().toString().trim());
//                accountsIntent.putExtra("COUNTRY", textInputEditTextBeneficiaryCountry.getText().toString().trim());
//                emptyInputEditText();
//                startActivity(accountsIntent);
//                break;
        }
    }

    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextChickenSold, textInputLayoutChickenSold, getString(R.string.error_message_display))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextChicksSold, textInputLayoutChicksSold, getString(R.string.error_message_display))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEggsSold, textInputLayoutEggsSold, getString(R.string.error_message_display))) {
            return;
        }
//
////        if (!databaseHelper.checkUser(textInputEditTextBeneficiaryEmail.getText().toString().trim())) {
//
////            farmList.setId(Integer.parseInt(textInputEditTextBeneficiaryId.getText().toString().trim()));
            farmList.setId(date.toString().trim());
//            farmList.setEmail(textInputEditTextBeneficiaryEmail.getText().toString().trim());
//            farmList.setAddress(textInputEditTextBeneficiaryAddress.getText().toString().trim());
////            farmList.setCountry(textInputEditTextBeneficiaryCountry.getText().toString().trim());
            farmList.setChickenSold(Integer.parseInt(textInputEditTextChickenSold.getText().toString().trim()));
            farmList.setChicksSold(Integer.parseInt(textInputEditTextChicksSold.getText().toString().trim()));
            farmList.setEggsSold(Integer.parseInt(textInputEditTextEggsSold.getText().toString().trim()));
//
//
//            databaseHelper.addBeneficiary(farmList);
//
                myDbAdapter.insertData(farmList);
//            // Snack Bar to show success message that record saved successfully
            Intent accountsIntent = new Intent(activity, MainActivity.class);
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT)
                    .show();
            accountsIntent.putExtra("ID", date.toString().trim());
            accountsIntent.putExtra("CHICKEN_SOLD", textInputEditTextChickenSold.getText().toString().trim());
            accountsIntent.putExtra("CHICKS_SOLD", textInputEditTextChicksSold.getText().toString().trim());
            accountsIntent.putExtra("EGGS_SOLD", textInputEditTextEggsSold.getText().toString().trim());
//            accountsIntent.putExtra("COUNTRY", textInputEditTextBeneficiaryCountry.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);
//

//
////        } else {
//            // Snack Bar to show error message that record already exists
////            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
////        }
//
//
    }
//
    private void emptyInputEditText() {
        textInputEditTextChickenSold.setText(null);
        textInputEditTextChicksSold.setText(null);
        textInputEditTextEggsSold.setText(null);
////        textInputEditTextBeneficiaryCountry.setText(null);
    }
}
