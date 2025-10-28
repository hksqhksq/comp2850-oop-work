import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldNotContain
import java.io.File
// hi
@Suppress("unused")

// write your tests here
class isValidTest : StringSpec({
    "returns true for words 5 letters in length" {
        isValid("aback") shouldBe true
    }
})

class readWordListTest: StringSpec({
    "returns a list of all the words in words.txt" {
        val test_file = readWordList("data/words.txt") 
        val expected = File("data/words.txt").readLines()
        test_file shouldBe expected
    }
})


class pickRandomWordTest: StringSpec({
    "returns a random word. word should be removed from list" {
        val test_list = mutableListOf("apple", "berry", "cherry") // test list

        val chosen_test = pickRandomWord(test_list)

        listOf("apple", "berry", "cherry").contains(chosen_test) shouldBe true
        test_list shouldNotContain chosen_test
    }
})

class evaluateGuessTest: StringSpec({

    "guess = answer, should return 1 for all 5" {
        val result_test = evaluateGuess("chose", "chose")
        result_test shouldBe listOf(1, 1, 1, 1, 1)
    }

    "guess != answer completely, should return 0 for all 5" {
        val result_test = evaluateGuess("hmmmm", "chose")
        result_test shouldBe listOf(0, 0, 0, 0, 0)
    }

    "guess != answer partially, should return some 0's, some 1's" {
        val result_test = evaluateGuess("scone", "chose")
        result_test shouldBe listOf(0, 0, 1, 0, 1)
    }

    "guess != answer except the very first letter, should return 10000" {
        val result_test = evaluateGuess("hmmmm", "hired")
        result_test shouldBe listOf(1, 0, 0, 0, 0)
    }
})

