package test.thenewyorktime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logoBt = findViewById<ImageView>(R.id.logo)
        logoBt.setOnClickListener {
            val intent = Intent(this,ListActivity::class.java)
            startActivity(intent)
        }



    }
}