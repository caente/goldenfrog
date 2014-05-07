package com.goldenfrog

/**
 * Created: Miguel A. Iglesias
 * Date: 5/7/14
 */
object Letters {

  private val shi = 32

  def transform(text: String): String = text.reverse.map {
    a =>
      if ((a == 65) || (a == 69) || (a == 73) || (a == 79) || (a == 85) || (a == 65 + shi) || (a == 69 + shi) || (a == 73 + shi) || (a == 79 + shi) || (a == 85 + shi))
        a.toUpper
      else a.toLower
  }

}
