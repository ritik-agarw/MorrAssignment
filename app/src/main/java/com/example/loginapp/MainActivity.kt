package com.example.loginapp

import android.graphics.Color
import android.graphics.ColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var card = findViewById<TextInputLayout>(R.id.cardInput)
        val date = findViewById<TextInputLayout>(R.id.dateInput)
        val cvv = findViewById<TextInputLayout>(R.id.cvvInput)
        val fname = findViewById<TextInputLayout>(R.id.firstName)
        val lname = findViewById<TextInputLayout>(R.id.lastName)
        val submit = findViewById<Button>(R.id.submit)
        val obj = Validation()


        submit.setOnClickListener {
            var count = 0;

            if(obj.IsValid(card.editText?.text.toString())){
                if(!obj.type_validation(card.editText?.text.toString())){
                    card.error = "Invalid Credit card number!"
                    count = 0
                } else {
                    card.error = ""
                    count+=1
                }
            } else {
                card.error = "Invalid Credit card number!"
                count = 0
            }

            if(!obj.cvv_validation(cvv.editText?.text.toString())){
                cvv.error = "Invalid cvv!"
                count = 0
            } else {
                cvv.error = ""
                count+=1
            }

            if(!obj.date_validation(date.editText?.text.toString())){
                date.error = "Invalid date!"
                count = 0
            } else {
                date.error = ""
                count+=1
            }

            if(!obj.Name_validation(fname.editText?.text.toString())){
                fname.error = "Invalid name!"
                count = 0
            } else {
                fname.error = ""
                count+=1
            }

            if(!obj.Name_validation(lname.editText?.text.toString())){
                lname.error = "Invalid lastname!"
                count = 0
            } else {
                lname.error = ""
                count += 1
            }

            if(count == 5){
                MaterialAlertDialogBuilder(this)
                .setTitle("Payment Successful")
                    .setPositiveButton("OK") { dialog, which ->
                        // Respond to positive button press
                    }
                .show()
            }

        }

    }
}