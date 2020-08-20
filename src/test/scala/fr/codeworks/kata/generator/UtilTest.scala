package fr.codeworks.kata.generator

class UtilTest extends ContextUtils {

  it("should output the expected Kata object") {
    // GIVEN
    val functionParameters = List(FunctionParameters("str", "String"), FunctionParameters("length", "Integer"))
    val tests = List(Test(List("azerty", "6"), "ytreza"))
    val expectedKata = Kata("Reverse", 1, "Given a string and its length, reverse the input string.",
      "reverseTheString", functionParameters, tests)

    // WHEN
    val outputKata = Util.getKataFromConf("conf/kata1.json")

    // THEN
    outputKata shouldBe expectedKata
  }
}
