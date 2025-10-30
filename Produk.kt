package id.ac.pnm.katalogproduk

data class Produk (
    val name: String,
    val harga: Int,
    val kategori: Kategori
)

enum class Kategori {
    SKINCARE,
    MAKEUP
}

fun main() {
    //val SERUM = Produk
}
