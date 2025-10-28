// Implement the six required functions here
import kotlin.io.readLine // Implement the six required functions here
import java.io.File
import kotlin.random.Random
import kotlin.text.uppercase

fun isValid(word: String): Boolean {
    return word.length == 5 // if word length is 5, return true
}

fun readWordList(filename: String): MutableList<String> {
    val word_file = filename // change later if needed
    val words = File(word_file).readLines() // read lines of file specified and give as list
    return words.toMutableList() // pickRandomWord needs a mutable list, cos it removes words from the list
}

fun pickRandomWord(words: MutableList<String>): String {
    val random_number = Random.nextInt(words.size) // choose an item from the list randomly as its index
    val random_word = words[random_number] // use integer index to find said word in list
    words.removeAt(random_number) 
    return random_word
}

fun obtainGuess(attempt: Int): String {
    val attempt_no = attempt
    while(true) {
        print("[ATTEMPT $attempt_no] Enter a word of 5 letters: ")
        val guess_input = readLine()?.uppercase() ?: ""
        if (isValid(guess_input)) {
            return guess_input
        } else {
            println("Entry not recognised. Try again: ")
        }
    }


}

fun evaluateGuess(guess: String, target: String): List<Int> {
    val evaluation = mutableListOf<Int>()
    for (i in 0 until 5) {
        if (guess[i] == target[i]) {
            evaluation.add(1) 
            } else {
            evaluation.add(0)
        }

    }
    return evaluation
}

fun displayGuess(guess: String, matches: List<Int>) {
    var display_guess = ""
    for (i in 0 until 5) {
        if (matches[i] == 1) {
            display_guess += matches[i]
        } else {
            display_guess += '?'
        }
    }
    println(display_guess)
}