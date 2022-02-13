
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

object _ingredient extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[IngredientQuantity,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ingredient: IngredientQuantity):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<ingredient>
    <name>"""),_display_(/*3.12*/ingredient/*3.22*/.getParentIngredient.getName),format.raw/*3.50*/("""</name>
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
                  HASH: 12a2dcd017d6febf1fd681e929e4666bd0c505be
                  MATRIX: 919->1|1044->34|1094->58|1112->68|1160->96
                  LINES: 27->1|32->2|33->3|33->3|33->3
                  -- GENERATED --
              */
          