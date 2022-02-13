
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

object recipes extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Recipe],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(recipes: List[Recipe]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<recipes>
    """),_display_(/*4.6*/if(recipes.size() > 0)/*4.28*/{_display_(Seq[Any](format.raw/*4.29*/("""
        """),_display_(/*5.10*/for(recipe <- recipes) yield /*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
            """),_display_(/*6.14*/_recipe(recipe)),format.raw/*6.29*/("""
        """)))}),format.raw/*7.10*/("""
    """)))}),format.raw/*8.6*/("""
"""),format.raw/*9.1*/("""</recipes>"""))
      }
    }
  }

  def render(recipes:List[Recipe]): play.twirl.api.XmlFormat.Appendable = apply(recipes)

  def f:((List[Recipe]) => play.twirl.api.XmlFormat.Appendable) = (recipes) => apply(recipes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/recipes.scala.xml
                  HASH: c2d4973557e73ff1962aa3e6ad4172afbad8cec3
                  MATRIX: 909->1|1025->25|1104->79|1134->101|1172->102|1208->112|1245->134|1284->136|1324->150|1359->165|1399->175|1434->181|1461->182
                  LINES: 27->1|32->2|34->4|34->4|34->4|35->5|35->5|35->5|36->6|36->6|37->7|38->8|39->9
                  -- GENERATED --
              */
          