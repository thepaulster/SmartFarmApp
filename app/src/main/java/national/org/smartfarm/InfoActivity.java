package national.org.smartfarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoActivity extends AppCompatActivity {

    private ImageButton selectIncome;
    private ImageButton selectExpenses;
    private ImageButton selectRecords;
    private TextView mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        selectIncome = (ImageButton) findViewById(R.id.income_add);
        selectExpenses = (ImageButton) findViewById(R.id.expenses_add);
        selectRecords = (ImageButton) findViewById(R.id.collections_add);
        mDate = (TextView)findViewById(R.id.textView);

        selectIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoActivity.this, IncomeActivity.class));
            }
        });

        selectExpenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoActivity.this, ExpensesActivity.class));
            }
        });

        selectRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoActivity.this, CollectionsActivity.class));
            }
        });

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        mDate.setText(date);
    }

}