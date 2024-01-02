package desafios

class Product(val name: String, val price: Double, val quantity: Int)

class CustomOrder private constructor(
    val customerName: String,
    val products: List<Product>,
    val total: Double,
    val deliveryAddress: String
) {
    /** Classe interna para "linkar" o Bulder com a classe CustomOrder **/
    class Builder {
        private var customerName: String = ""
        private var products: MutableList<Product> = mutableListOf()
        private var deliveryAddress: String = ""

        fun setCustomerName(name: String) = apply { customerName = name }
        fun addProduct(product: Product) = apply { products.add(product) }
        fun setDeliveryAddress(address: String) = apply { deliveryAddress = address }

        fun build(): CustomOrder {
            //TODO("Implemente a lógica para calcular o Total do Pedido (a partir dos dados de Produtos).")
            var total = calcularTotal(products)
            // TODO("Instancie corretamente um CustomOrder, consolidando o Builder!")
            return CustomOrder(customerName, products, total, deliveryAddress)
        }

        fun calcularTotal(produto: List<Product>): Double {
            return produto.sumByDouble{it.price * it.quantity}
        }
    }

    fun printReceipt() {
        println("${this.customerName}")
        this.products.forEachIndexed { index, product ->
            println("${index + 1}. ${product.name} | ${product.price} | ${product.quantity}")
        }
        println("Total: ${this.total}")
        println("End: ${this.deliveryAddress}")
    }
}

fun main() {

    // Solicita nome do usuário
    val customerName = readLine() ?: ""

    val orderBuilder = CustomOrder.Builder().setCustomerName(customerName)

    // Solicita quantidade de produtos
    val numProducts = readLine()?.toIntOrNull() ?: 0
    // Solicita nome, preço e quantidade dos itens
    for (i in 1..numProducts) {
        val productName = readLine() ?: ""
        val productPrice = readLine()?.toDoubleOrNull() ?: 0.0
        val productQuantity = readLine()?.toIntOrNull() ?: 0

        orderBuilder.addProduct(Product(productName, productPrice, productQuantity))
    }

    // Solicita endereco
    val deliveryAddress = readLine() ?: ""

    val customOrder = orderBuilder.setDeliveryAddress(deliveryAddress).build()

    customOrder.printReceipt()
}