package com.goldenfrog.formats

/**
 * Created: Miguel A. Iglesias
 * Date: 5/7/14
 */
trait HTML {

  import com.goldenfrog.Parser.parsers

  def fromSeqHtml(v: Traversable[_]): String = s"<ol>${foldSequenceHTMl(v)}</ol>"

  def fromMapHtml(v: Traversable[_]): String = s"<dl>${foldSequenceHTMl(v)}</dl>"

  def fromScalarHtml[A](v: A) = v.toString


  private def foldSequenceHTMl(ls: Traversable[_]): String = ls.foldLeft("") {
    case (total, (k, v)) =>
      total + s"<dt>${k.toHTML}</dt><dd>${v.toHTML}</dd>"
    case (total, elem) =>
      total + s"<li>${elem.toHTML}</li>"
  }
}
