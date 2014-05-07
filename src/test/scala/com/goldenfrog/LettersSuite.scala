package com.goldenfrog

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created: Miguel A. Iglesias
 * Date: 5/7/14
 */
class LettersSuite extends FunSuite with ShouldMatchers {

  import Letters._
  test("text inverted and every consonant lower cased and every vowel upper cased") {
    val text = "Working Hard"
    val result =transform(text)
    result should be === "drAh gnIkrOw"
  }

}
