package fr.codeworks.kata.generator

import spray.json.JsonParser
import KataProtocol._

case object Util {
  def getKataFromConf(filename: String): Kata = {
    val source = scala.io.Source.fromFile(filename)
    val kataStr = try source.mkString finally source.close()

    JsonParser(kataStr).convertTo[Kata]
  }
}
