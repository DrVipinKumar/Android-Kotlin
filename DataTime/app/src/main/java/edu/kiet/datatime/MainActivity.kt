package edu.kiet.datatime

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.DialogFragment
import edu.kiet.datatime.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var cal=Calendar.getInstance()
        var year=cal.get(Calendar.YEAR)
        var month=cal.get(Calendar.MONTH)
        var day=cal.get(Calendar.DAY_OF_MONTH)
        binding.datepicker.init(year,month, day, DatePicker.OnDateChangedListener(){ datePicker: DatePicker, i: Int, i1: Int, i2: Int ->
            Toast.makeText(applicationContext,""+binding.datepicker.dayOfMonth+"/"+binding.datepicker.month+"/"+binding.datepicker.year,Toast.LENGTH_SHORT).show()

        })
        binding.btnDatePicker.setOnClickListener(View.OnClickListener {
            var cal=Calendar.getInstance()
            var year=cal.get(Calendar.YEAR)
            var month=cal.get(Calendar.MONTH)
            var day=cal.get(Calendar.DAY_OF_MONTH)
            var datepickerdialog =DatePickerDialog(this@MainActivity,DatePickerDialog.THEME_HOLO_DARK,DatePickerDialog.OnDateSetListener{ datePicker: DatePicker, year: Int, month: Int, day: Int ->
                Toast.makeText(applicationContext,""+day+"/"+month+"/"+year,Toast.LENGTH_SHORT).show()
            },year,month,day)
            datepickerdialog.show()
        })

    }


    }

