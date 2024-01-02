package desafios

class User(val id: Int, val name: String)

/*
 * No Kotlin, a declaração de um objeto (por meio da palavra-chave object)
 * é uma maneira concisa e eficaz de implementar o padrão Singleton.
 */
object UserManager {

    private val users = mutableListOf<User>()

    val listandoUsuario: List<User> = users


    fun addUser(name: String, id: Int) {
        // TODO("Implementar a lógica de adicionar um novo usuário na lista mutável $users.")
        val novoUsuario = User(id, name)
        users.add(novoUsuario)
    }


    fun listUsers() {
        // TODO("Implementar a impressão dos $users, seguindo o padrão definido no enunciado.")
        users.forEach{
                user -> println("${user.id} - ${user.name}")
        }

    }

}

fun main() {

    // Pede a quantidade de usuários que serão cadastrados na lista
    val quantity = readLine()?.toIntOrNull() ?: 0

    // Faz uma repetição em que solicita os nomes dos usuários baseado na quantidade definida acima
    for (i in 1..quantity) {
        val name = readLine() ?: ""
        UserManager.addUser(name, i)
    }

    UserManager.listUsers()

}