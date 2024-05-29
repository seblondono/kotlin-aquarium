enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game(var path: MutableList<Directions> = mutableListOf(Directions.START)) {
    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }
    val end = {
        path.add(Directions.END)
        println("Game Over")
        println(path)
        path.clear()
        false
    }

    private fun move(where: () -> Boolean) = where()
    fun makeMove(dir: String?) {
        when (dir) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }
}

fun main(args: Array<String>) {
    val game = Game()
    println(game.path)

    while (true) {
        println("Where do you want to go? n/s/e/w")
        val dir = readLine()
        if (dir == null) break
        game.makeMove(dir)
    }
}