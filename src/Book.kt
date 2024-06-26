open class Book(var title: String, var author: String) {
    private var currentPage = 0

    open fun readPage() {
        currentPage++
    }
}

class EBook(title: String, author: String, var format: String = "text") : Book(title, author) {
    private var wordCount = 0
    override fun readPage() {
        wordCount += 250
    }
}