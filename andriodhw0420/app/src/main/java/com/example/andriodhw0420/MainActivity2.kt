package com.example.andriodhw0420

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import java.time.Year
import java.util.*

class MainActivity2 : AppCompatActivity() ,DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{
    private lateinit var btn_timePicker:Button;
    private lateinit var btn_logout:Button;
    private lateinit var tv_textTime:TextView;
    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var min = 0

    var saveDay = 0
    var saveMonth = 0
    var saveYear =0
    var saveHour = 0
    var saveMinute = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btn_timePicker = findViewById(R.id.btn_timerPicker)
        btn_logout = findViewById(R.id.btn_logout)
        tv_textTime = findViewById(R.id.tv_timeText)
        pickDate()

    }
    private fun getDateTimeCalendar(){
        var cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        min = cal.get(Calendar.MINUTE)

    }
    private fun pickDate(){
        btn_timePicker.setOnClickListener {
            getDateTimeCalendar()
            DatePickerDialog(this,this,year,month,day).show()

            /*
            setResult(Activity.RESULT_OK)
            finish()
             */
        }
        btn_logout.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
    override  fun  onDateSet(view: DatePicker?, year: Int,month:Int, dayofMonth:Int){
        saveDay = dayofMonth
        saveMonth = month
        saveYear = year
        TimePickerDialog(this, this, hour, min, true).show()
    }
    override  fun  onTimeSet(view: TimePicker?, hourOfDay:Int,minute:Int){
        saveHour = hourOfDay
        saveMinute = minute

        tv_textTime.text = "$saveDay-$saveMonth-$saveYear\n Hour: $saveHour Minute: $saveMinute"
    }
}