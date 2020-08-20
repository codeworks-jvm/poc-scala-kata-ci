package fr.codeworks.kata.generator

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

case class FunctionParameters(name: String, `type`: String)

case class Test(parameters: List[String], result: String)

case class Kata(title: String, difficulty: Int, description: String,
                functionName: String, functionParameters: List[FunctionParameters],
                test: List[Test]) {
}

object KataProtocol extends DefaultJsonProtocol {
  implicit val functionParametersFormat: RootJsonFormat[FunctionParameters] = jsonFormat(FunctionParameters, "name", "type")
  implicit val testFormat: RootJsonFormat[Test] = jsonFormat(Test, "parameters", "result")
  implicit val kataFormat: RootJsonFormat[Kata] = jsonFormat6(Kata)
}
