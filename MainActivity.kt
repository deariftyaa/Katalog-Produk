package id.ac.pnm.katalogproduk

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val email: String = intent.getStringExtra(LoginActivity.KEY_USERNAME) ?: ""
        val textViewUsername = findViewById<TextView>(R.id.textViewUsername)
        textViewUsername.text = "SELAMAT DATANG DI KATALOG PRODUK GLAD2GLOW"

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val listProduk: List<Produk> = getProduk()
        recyclerView.adapter = ProdukAdapter(listProduk)
    }

    fun getProduk(): List<Produk> {
        val data = mutableListOf<Produk>()
        data.add(
            Produk(
                "G2G BLUEBERRY CERAMIDE MOISTURIZER",
                45000, Kategori.SKINCARE
            )
        )

        data.add(
            Produk(
                "G2G MUGWORT ACNE GEL MASK",
                45000, Kategori.SKINCARE
            )
        )

        data.add(
            Produk(
                "G2G KIWI ACNE MOISTURIZER",
                45000, Kategori.SKINCARE
            )
        )

        data.add(
            Produk(
                "G2G SALICYLID ACID ACNE SERUM ",
                45000, Kategori.SKINCARE
            )
        )

        data.add(
            Produk(
                "G2G POMEGRANATE NIACINAMIDE SERUM",
                35000, Kategori.SKINCARE
            )
        )

        data.add(
            Produk(
                "G2G PEACH RETINOL SERUM",
                49000, Kategori.SKINCARE
            )
        )

        data.add(
            Produk(
                "G2G BLUEBERRY CERAMIDE MOISTURIZER ",
                45000, Kategori.SKINCARE
            )
        )

        data.add(
            Produk(
                "G2G PEELING SOLUTION SERUM",
                49000, Kategori.SKINCARE
            )
        )

        data.add(
            Produk(
                "G2G MILK AMINO FACIAL WASH",
                45000, Kategori.SKINCARE
            )
        )

        data.add(
            Produk(
                "G2G PERFECT COVER CUSHION",
                69000, Kategori.MAKEUP
            )
        )

        data.add(
            Produk(
                "G2G 2in1 PAIR CUSHION POWDER FOUNDATION",
                145000, Kategori.MAKEUP
            )
        )

        data.add(
            Produk(
                "G2G DOUBLE BRIGHT DAY CREAM",
                75000, Kategori.MAKEUP
            )
        )
        return data
    }
}