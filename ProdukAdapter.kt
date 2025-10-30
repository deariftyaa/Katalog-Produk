package id.ac.pnm.katalogproduk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale

class ProdukAdapter(val data: List<Produk>): RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, ViewType: Int
    ): ProdukViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produk, parent, false)

        return ProdukViewHolder(layout)
    }
    override fun onBindViewHolder(
        holder: ProdukViewHolder, position: Int,
    ) {
        val produk: Produk = data[position]
        holder.textViewName.text = produk.name
        holder.textViewHarga.text = formatRupiah(produk.harga)
        holder.textViewKategori.text = produk.kategori.toString()
    }

    override fun getItemCount(): Int = data.size
    class ProdukViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val textViewName: TextView = row.findViewById<TextView>(R.id.textViewName)
        val textViewHarga: TextView = row.findViewById<TextView>(R.id.textViewHarga)
        val textViewKategori: TextView = row.findViewById<TextView>(R.id.textViewKategori)
    }
    private fun formatRupiah(harga: Int): String {
        val localeID = Locale("in", "ID")
        val format = NumberFormat.getCurrencyInstance(localeID)
        return format.format(harga).replace(",00", "")
    }
}