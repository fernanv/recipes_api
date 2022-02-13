
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

object ingredients extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Ingredient],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ingredients: List[Ingredient]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<ingredients>
    """),_display_(/*4.6*/if(ingredients.size() > 0)/*4.32*/{_display_(Seq[Any](format.raw/*4.33*/("""
        """),_display_(/*5.10*/for(ingredient <- ingredients) yield /*5.40*/ {_display_(Seq[Any](format.raw/*5.42*/("""
            """),_display_(/*6.14*/_ingredient(ingredient)),format.raw/*6.37*/("""
        """)))}),format.raw/*7.10*/("""
    """)))}),format.raw/*8.6*/("""
"""),format.raw/*9.1*/("""</ingredients>"""))
      }
    }
  }

  def render(ingredients:List[Ingredient]): play.twirl.api.XmlFormat.Appendable = apply(ingredients)

  def f:((List[Ingredient]) => play.twirl.api.XmlFormat.Appendable) = (ingredients) => apply(ingredients)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/ingredients.scala.xml
                  HASH: 01c685a1c8cf523f91a0dd07397625f89c6b848d
                  MATRIX: 917->1|1041->33|1124->91|1158->117|1196->118|1232->128|1277->158|1316->160|1356->174|1399->197|1439->207|1474->213|1501->214
                  LINES: 27->1|32->2|34->4|34->4|34->4|35->5|35->5|35->5|36->6|36->6|37->7|38->8|39->9
                  -- GENERATED --
              */
          