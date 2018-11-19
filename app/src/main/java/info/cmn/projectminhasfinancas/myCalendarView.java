package info.cmn.projectminhasfinancas;

import android.os.Bundle;
import android.app.Activity;
import android.widget.CalendarView;
import android.content.Intent;

public class myCalendarView  extends Activity {

    private int mYear;
    private int mMonth;
    private int mDay;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalendarView calendar = new CalendarView(this);
        calendar.setOnDateChangeListener(mDateSetListener);
        setContentView(calendar);

    }

    // the callback received when the user "sets" the date in the dialog
    private CalendarView.OnDateChangeListener mDateSetListener =
            new CalendarView.OnDateChangeListener() {

                public void onSelectedDayChange(CalendarView view, int year,
                                                int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    String selectedDate = new StringBuilder().append(mMonth + 1).append("-").append(mDay).append("-")
                            .append(mYear).append(" ").toString();

                    Bundle b = new Bundle();
                    b.putString("dateSelected", selectedDate);

                    //Add the set of extended data to the intent and start it
                    Intent intent = new Intent();
                    intent.putExtras(b);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            };

}
