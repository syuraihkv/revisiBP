package com.example.uasbro

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }

    private fun updateActiveIcon(activeImageView: ImageView, otherImageViews: List<ImageView>) {
        activeImageView.setColorFilter(ContextCompat.getColor(this, R.color.purple_700))
        otherImageViews.forEach {
            it.setColorFilter(ContextCompat.getColor(this, R.color.white))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imgBeranda: ImageView = findViewById(R.id.imageBeranda)
        val imgOrder: ImageView = findViewById(R.id.imageOrder)
        val imgPaket: ImageView = findViewById(R.id.imagePaket)
        val imgPrepaid: ImageView = findViewById(R.id.imagePrepaid)
        val imgAkun: ImageView = findViewById(R.id.imageAkun)

        replaceFragment(BerandaFragment())
        imgBeranda.setColorFilter(ContextCompat.getColor(this, R.color.ecru))

        imgBeranda.setOnClickListener {
            replaceFragment(BerandaFragment())
            updateActiveIcon(imgBeranda, listOf(imgOrder, imgPaket, imgPrepaid, imgAkun))
        }

        imgOrder.setOnClickListener {
            replaceFragment(OrderFragment())
            updateActiveIcon(imgOrder, listOf(imgBeranda, imgPaket, imgPrepaid, imgAkun))
        }

        imgPaket.setOnClickListener {
            replaceFragment(PaketFragment())
            updateActiveIcon(imgPaket, listOf(imgBeranda, imgOrder, imgPrepaid, imgAkun))
        }

        imgPrepaid.setOnClickListener {
            replaceFragment(PrepaidFragment())
            updateActiveIcon(imgPrepaid, listOf(imgBeranda, imgOrder, imgPaket, imgAkun))
        }

        imgAkun.setOnClickListener {
            replaceFragment(AkunFragment())
            updateActiveIcon(imgAkun, listOf(imgBeranda, imgOrder, imgPaket, imgPrepaid))
        }
    }
}
