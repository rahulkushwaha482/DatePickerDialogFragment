package com.roommanagement.datepickerdialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.shagi.materialdatepicker.date.DatePickerFragmentDialog;
import java.util.Calendar;


/** This a datepicker Dialog .
 * This project is created by Rahul Kushwaha .
  On 22March2019.This project is already created by Saagi in Kotlin. But I am  implementing using Java.**/

/**  you can see this documentations for full informations
 https://android-arsenal.com/details/1/6577  **/

/**Steps**/

   /**
    * 1) In manifest file add permission for Internet.

      2)Check  if  support and design library is present in build.gradle(Module:app)

      3)Implement this as given  below:-

    **/

public class MainActivity extends AppCompatActivity {

    Button showDate;
    TextView txtTodayDate;
    int mMonth,mYear,mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        showDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    private void initViews(){
        showDate=findViewById(R.id.show_calender);
        txtTodayDate=findViewById(R.id.txt_date_today);

    }


    private void showDatePickerDialog(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerFragmentDialog datePickerFragmentDialog=DatePickerFragmentDialog.newInstance(new DatePickerFragmentDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerFragmentDialog view, int year, int monthOfYear, int dayOfMonth) {
                txtTodayDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);


            }
        },mYear, mMonth, mDay);
        datePickerFragmentDialog.show(getSupportFragmentManager(),null);
        datePickerFragmentDialog.setMaxDate(System.currentTimeMillis());
        datePickerFragmentDialog.setYearRange(1900,mYear);
        datePickerFragmentDialog.setCancelColor(getResources().getColor(R.color.colorPrimaryDark));
        datePickerFragmentDialog.setOkColor(getResources().getColor(R.color.colorPrimary));
        datePickerFragmentDialog.setAccentColor(getResources().getColor(R.color.colorAccent));
        datePickerFragmentDialog.setOkText(getResources().getString(R.string.ok_dob));
        datePickerFragmentDialog.setCancelText(getResources().getString(R.string.cancel_dob));
    }
}
