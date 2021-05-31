package test.thenewyorktime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val backBtn = findViewById<ImageView>(R.id.backbtn)
        backBtn.setOnClickListener {
            val intent = Intent(this,ListActivity::class.java)
            startActivity(intent)
        }

        val image = intent.getIntExtra("image",0)
        detail_img.setImageResource(image)

        val title = intent.getStringExtra("title")
        title_txt.text = title
    }
}

