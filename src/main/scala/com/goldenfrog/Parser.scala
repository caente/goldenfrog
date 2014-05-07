package com.goldenfrog

import com.goldenfrog.formats.{Javascript, HTML}

/**
 * Created: Miguel A. Iglesias
 * Date: 5/7/14
 */

trait Parser {
  private def mapper[A](value: A)(
    fromSeq: Traversable[_] => String,
    fromMap: Traversable[_] => String,
    fromScalar: A => String
    ): String =
    value match {
      case v: Seq[_] => fromSeq(v)
      case v: Array[_] => fromSeq(v)
      case v: Map[_, _] => fromMap(v)
      case _ => fromScalar(value)
    }
}

object Parser extends Parser with HTML with Javascript {


  implicit def parsers[A](value: A) = new {

    def toHTML: String = mapper(value)(
      fromSeqHtml,
      fromMapHtml,
      fromScalarHtml
    )

    def toJavascript: String = mapper(value)(
      fromSeqJS,
      fromMapJS,
      fromScalarJS
    )
  }


}

