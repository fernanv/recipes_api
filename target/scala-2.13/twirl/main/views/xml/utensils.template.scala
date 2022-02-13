
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

object utensils extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Utensil],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(utensils: List[Utensil]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<recipes>
    """),_display_(/*4.6*/if(utensils.size() > 0)/*4.29*/{_display_(Seq[Any](format.raw/*4.30*/("""
        """),_display_(/*5.10*/for(utensil <- utensils) yield /*5.34*/ {_display_(Seq[Any](format.raw/*5.36*/("""
            """),_display_(/*6.14*/_utensil(utensil)),format.raw/*6.31*/("""
        """)))}),format.raw/*7.10*/("""
    """)))}),format.raw/*8.6*/("""
"""),format.raw/*9.1*/("""</recipes>"""))
      }
    }
  }

  def render(utensils:List[Utensil]): play.twirl.api.XmlFormat.Appendable = apply(utensils)

  def f:((List[Utensil]) => play.twirl.api.XmlFormat.Appendable) = (utensils) => apply(utensils)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/utensils.scala.xml
                  HASH: 1afa8e53ecee3c4ed074e9069cec9c7523c4ecbe
                  MATRIX: 911->1|1029->27|1108->81|1139->104|1177->105|1213->115|1252->139|1291->141|1331->155|1368->172|1408->182|1443->188|1470->189
                  LINES: 27->1|32->2|34->4|34->4|34->4|35->5|35->5|35->5|36->6|36->6|37->7|38->8|39->9
                  -- GENERATED --
              */
          