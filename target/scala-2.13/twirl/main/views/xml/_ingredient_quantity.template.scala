
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

object _ingredient_quantity extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[IngredientQuantity,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ingredient: IngredientQuantity):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<ingredient>
    <name>"""),_display_(/*4.12*/ingredient/*4.22*/.getParentIngredient.getName),format.raw/*4.50*/("""</name>
    <quantity>"""),_display_(/*5.16*/ingredient/*5.26*/.getQuantity),format.raw/*5.38*/("""</quantity>
    <type>"""),_display_(/*6.12*/ingredient/*6.22*/.getType),format.raw/*6.30*/("""</type>
</ingredient>
"""))
      }
    }
  }

  def render(ingredient:IngredientQuantity): play.twirl.api.XmlFormat.Appendable = apply(ingredient)

  def f:((IngredientQuantity) => play.twirl.api.XmlFormat.Appendable) = (ingredient) => apply(ingredient)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/_ingredient_quantity.scala.xml
                  HASH: 3f3d196a5846850a39bc7d02881b40c75c29830e
                  MATRIX: 928->1|1053->34|1142->97|1160->107|1208->135|1257->158|1275->168|1307->180|1356->203|1374->213|1402->221
                  LINES: 27->1|32->2|34->4|34->4|34->4|35->5|35->5|35->5|36->6|36->6|36->6
                  -- GENERATED --
              */
          