

fun main() {
    val words = readWordList("data/words.txt")
    val target_word = pickRandomWord(words)

    println("Wordle: 10 attempts")

    var attempt_no = 1
    val max_attempts = 6
    while (true) {

        val guess = obtainGuess(attempt_no)
        val matches = evaluateGuess(guess, target_word)
        displayGuess(guess, matches)

        if (guess == target_word) {
            println("You guessed the word!")
            return
        } else {
            println("Incorrect")
            attempt_no++
        }

        if (attempt_no > max_attempts) {
            println("Out of guesses. Answer is: $target_word")
            return
        }
    }
}
