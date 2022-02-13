
package views.xml

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.xml._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object _recipe extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Recipe,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(recipe: Recipe):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<recipe>

    <title>"""),_display_(/*4.13*/(recipe.getTitle)),format.raw/*4.30*/("""</title>
    <description>"""),_display_(/*5.19*/(recipe.getDescription.getDescription)),format.raw/*5.57*/("""</description>
    <preparation_time>"""),_display_(/*6.24*/(recipe.getPreparationTime)),format.raw/*6.51*/("""</preparation_time>
    <level>"""),_display_(/*7.13*/(recipe.getLevel)),format.raw/*7.30*/("""</level>

    """),_display_(/*9.6*/if(recipe.getTags().size() > 0)/*9.37*/{_display_(Seq[Any](format.raw/*9.38*/("""
    """),format.raw/*10.5*/("""<tags>
        """),_display_(/*11.10*/for(tag <- recipe.getTags()) yield /*11.38*/ {_display_(Seq[Any](format.raw/*11.40*/("""
            """),_display_(/*12.14*/_tag(tag)),format.raw/*12.23*/("""
        """)))}),format.raw/*13.10*/("""
    """),format.raw/*14.5*/("""</tags>
    """)))}),format.raw/*15.6*/("""
    """),_display_(/*16.6*/if(recipe.getQuantities().size() > 0)/*16.43*/{_display_(Seq[Any](format.raw/*16.44*/("""
        """),format.raw/*17.9*/("""<ingredients>
            """),_display_(/*18.14*/for(ingredient <- recipe.getQuantities()) yield /*18.55*/ {_display_(Seq[Any](format.raw/*18.57*/("""
                """),_display_(/*19.18*/_ingredient_quantity(ingredient)),format.raw/*19.50*/("""
            """)))}),format.raw/*20.14*/("""
        """),format.raw/*21.9*/("""</ingredients>
    """)))}),format.raw/*22.6*/("""
    """),_display_(/*23.6*/if(recipe.getUtensils().size() > 0)/*23.41*/{_display_(Seq[Any](format.raw/*23.42*/("""
        """),format.raw/*24.9*/("""<utensils>
            """),_display_(/*25.14*/for(utensil <- recipe.getUtensils()) yield /*25.50*/ {_display_(Seq[Any](format.raw/*25.52*/("""
                """),_display_(/*26.18*/_utensil(utensil)),format.raw/*26.35*/("""
            """)))}),format.raw/*27.14*/("""
        """),format.raw/*28.9*/("""</utensils>
    """)))}),format.raw/*29.6*/("""
    """),_display_(/*30.6*/if(recipe.getSteps().size() > 0)/*30.38*/{_display_(Seq[Any](format.raw/*30.39*/("""
        """),format.raw/*31.9*/("""<steps>
            """),_display_(/*32.14*/for(step <- recipe.getSteps()) yield /*32.44*/ {_display_(Seq[Any](format.raw/*32.46*/("""
                """),_display_(/*33.18*/_step(step)),format.raw/*33.29*/("""
            """)))}),format.raw/*34.14*/("""
        """),format.raw/*35.9*/("""</steps>
    """)))}),format.raw/*36.6*/("""
"""),format.raw/*37.1*/("""</recipe>"""))
      }
    }
  }

  def render(recipe:Recipe): play.twirl.api.XmlFormat.Appendable = apply(recipe)

  def f:((Recipe) => play.twirl.api.XmlFormat.Appendable) = (recipe) => apply(recipe)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/_recipe.scala.xml
                  HASH: cc030ac0c4d853a4a08897c480bb02d34cab89f0
                  MATRIX: 903->1|1012->18|1060->40|1097->57|1150->84|1208->122|1272->160|1319->187|1377->219|1414->236|1454->251|1493->282|1531->283|1563->288|1606->304|1650->332|1690->334|1731->348|1761->357|1802->367|1834->372|1877->385|1909->391|1955->428|1994->429|2030->438|2084->465|2141->506|2181->508|2226->526|2279->558|2324->572|2360->581|2410->601|2442->607|2486->642|2525->643|2561->652|2612->676|2664->712|2704->714|2749->732|2787->749|2832->763|2868->772|2915->789|2947->795|2988->827|3027->828|3063->837|3111->858|3157->888|3197->890|3242->908|3274->919|3319->933|3355->942|3399->956|3427->957
                  LINES: 27->1|32->2|34->4|34->4|35->5|35->5|36->6|36->6|37->7|37->7|39->9|39->9|39->9|40->10|41->11|41->11|41->11|42->12|42->12|43->13|44->14|45->15|46->16|46->16|46->16|47->17|48->18|48->18|48->18|49->19|49->19|50->20|51->21|52->22|53->23|53->23|53->23|54->24|55->25|55->25|55->25|56->26|56->26|57->27|58->28|59->29|60->30|60->30|60->30|61->31|62->32|62->32|62->32|63->33|63->33|64->34|65->35|66->36|67->37
                  -- GENERATED --
              */
          