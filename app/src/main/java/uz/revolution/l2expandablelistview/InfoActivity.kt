package uz.revolution.l2expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var image = intent.getIntExtra("image", R.drawable.ic_launcher_background)
        Log.d("AAAA", "onCreate: ${image}")
        image_view.setImageResource(image)

    }
}