package com.goldenfrog.formats

/**
 * Created: Miguel A. Iglesias
 * Date: 5/7/14
 */
trait Javascript {
  
  import com.goldenfrog.Parser.parsers

  def fromSeqJS(v: Traversable[_]): String = s"[${foldSequenceJS(v)}]"

  def fromMapJS(v: Traversable[_]): String = s"{${foldSequenceJS(v)}}"

  def fromScalarJS[A](v: A) = s""""${v.toString}\""""

  private def foldSequenceJS(ls: Traversable[_]): String = ls.foldLeft("") {
    case (total, (k, v)) =>
      total + s"${k.toJavascript}:${v.toJavascript},"
    case (total, elem) =>
      total + s"${elem.toJavascript},"
  }.dropRight(1)
}
