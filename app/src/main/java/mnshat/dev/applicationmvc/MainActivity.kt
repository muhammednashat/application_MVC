package mnshat.dev.applicationmvc

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mnshat.dev.data.model.DetailsOfMovie

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvId: TextView
    private lateinit var tVName: TextView
    private lateinit var tVDescription: TextView
    private lateinit var btnDisplay: Button
    private var counter: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeVariables()

    }
    private fun initializeVariables() {
        tVName = findViewById(R.id.tv_name)
        tvId = findViewById(R.id.tv_id)
        tVDescription = findViewById(R.id.tv_description)
        btnDisplay = findViewById(R.id.button)
        btnDisplay.setOnClickListener(this)
    }
    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {


        val details: DetailsOfMovie
        if (counter % 2 == 0) {
            details = DetailsOfMovie("Be Smart", "101", " Very caver")
            setDataToViews(details)
            btnDisplay.text = "Delete Movie"
            counter++
        } else {

            details = DetailsOfMovie("", "", "")
            setDataToViews(details)
            btnDisplay.text = "Display Movie"
            counter++
        }


    }

    private fun setDataToViews(details: DetailsOfMovie) {
        tvId.text = details.id
        tVName.text = details.name
        tVDescription.text = details.description
    }
}