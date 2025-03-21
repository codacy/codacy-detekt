package codacy.detekt

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.model.Element

object FormattingRulesDescriptionBuilder extends App {

  def build(rules: List[String], docsUrl: String): List[RuleDetails] = {

    val browser = JsoupBrowser()
    val doc = browser.get(docsUrl)

    val h3s = doc.toString.split("<h3").map(s => s"<h3$s").toList

    val rulesUrls: List[(String, Option[String])] = rules
      .map(rule => {

        val www = h3s
          .find(h3 => h3.contains(rule))
          .map(h => {
            val header = browser.parseString(h)
            val href = header >> element("p") >> element("a")
            href.attr("href")
          })

        (rule, www)
      })

    rulesUrls.flatMap {
      case (rule, Some(url)) =>
        val ruleHtml = browser.get(url)

        val anchor = s"""id="${url.split("#")(1)}""""

        val ruleHtmlString =
          ruleHtml.toString.split("<h3").toList.find(_.contains(anchor)).map(s => s"<h3$s").getOrElse("")

        if (ruleHtmlString.isEmpty) None
        else {

          val doc2 = browser.parseString(ruleHtmlString)

          val blocksOfCode = doc2 >> elementList("code")

          val nonEmptyBlocksOfCode = extractBlocksOfCode(blocksOfCode)

          nonEmptyBlocksOfCode.map {
            case (compliantCode, nonCompliantCode) =>
              val ruleSetName = "formatting"
              val ruleName = rule
              val description = (doc2 >> element("p")).ownText

              RuleDetails(ruleSetName, ruleName, description, nonCompliantCode, compliantCode)
          }
        }
      case _ => List.empty
    }
  }

  private def extractBlocksOfCode(blocksOfCode: List[Element]): Option[(String, String)] = {

    blocksOfCode.headOption.flatMap(
      compliantCodeExample =>
        blocksOfCode.tail.headOption.map(nonCompliantCodeExample => {
          (compliantCodeExample.text, nonCompliantCodeExample.text)
        })
    )

  }
}

case class RuleDetails(
    ruleSetName: String,
    ruleName: String,
    description: String,
    nonCompliantCodeExample: String,
    compliantCodeExample: String
)
