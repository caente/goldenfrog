package com.goldenfrog

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Created: Miguel A. Iglesias
 * Date: 5/7/14
 */
class ParserSuite extends FunSuite with ShouldMatchers {

  import Parser._

  val ls = List(0, 1, Map("a" -> "ah", "b" -> "bee"), "string")

  test("an array should be a valid javascript") {
    val js = ls.toJavascript
    js should be === """["0","1",{"a":"ah","b":"bee"},"string"]"""
  }

  test("an array should be a valid html") {
    val html = ls.toHTML
    html should be === """<ol><li>0</li><li>1</li><li><dl><dt>a</dt><dd>ah</dd><dt>b</dt><dd>bee</dd></dl></li><li>string</li></ol>"""
  }

}
