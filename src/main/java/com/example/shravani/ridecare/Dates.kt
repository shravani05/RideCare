package com.example.shravani.ridecare

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_dates.*
import java.util.*

class Dates : AppCompatActivity() {
    var title2 : TextView? = null
    var rideName : String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dates)

        title2 = findViewById(R.id.title2)
        rideName = getIntent().getExtras().getString("ride")
        title2?.setText(rideName)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        iButton.setOnClickListener({
            val idpd =DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,mYear,mMonth,mDay->
                iDate.setText("" + mDay + "/" + (mMonth+1) + "/" + mYear)
                val startMillis: Long = Calendar.getInstance().run {
                    set(mYear, mMonth, mDay, 7, 30)
                    timeInMillis
                }
                val endMillis: Long = Calendar.getInstance().run {
                    set(mYear, mMonth, mDay, 19, 30)
                    timeInMillis
                }
                val intent = Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startMillis)
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endMillis)
                    .putExtra(CalendarContract.Events.TITLE, "Insurance Expiry Date")

                    .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)

                startActivity(intent)
            },year,month,day)
            idpd.show()


        })



        sButton.setOnClickListener({
            val sdpd =DatePickerDialog(this,DatePickerDialog.OnDateSetListener{view,mYear,mMonth,mDay->
                sDate.setText("" + mDay + "/" + (mMonth+1) + "/" + mYear)

                val startMillis: Long = Calendar.getInstance().run {
                    set(mYear, mMonth, mDay, 7, 30)
                    timeInMillis
                }
                val endMillis: Long = Calendar.getInstance().run {
                    set(mYear, mMonth, mDay, 19, 30)
                    timeInMillis
                }
                val intent = Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startMillis)
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endMillis)
                    .putExtra(CalendarContract.Events.TITLE, "Servicing Date")

                    .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)

                startActivity(intent)




            },year,month,day)
            sdpd.show()
        })






    }
}
