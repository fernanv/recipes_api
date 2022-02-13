
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

object steps extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Step],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(steps: List[Step]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<recipes>
    """),_display_(/*4.6*/if(steps.size() > 0)/*4.26*/{_display_(Seq[Any](format.raw/*4.27*/("""
        """),_display_(/*5.10*/for(step <- steps) yield /*5.28*/ {_display_(Seq[Any](format.raw/*5.30*/("""
            """),_display_(/*6.14*/_step(step)),format.raw/*6.25*/("""
        """)))}),format.raw/*7.10*/("""
    """)))}),format.raw/*8.6*/("""
"""),format.raw/*9.1*/("""</recipes>"""))
      }
    }
  }

  def render(steps:List[Step]): play.twirl.api.XmlFormat.Appendable = apply(steps)

  def f:((List[Step]) => play.twirl.api.XmlFormat.Appendable) = (steps) => apply(steps)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/steps.scala.xml
                  HASH: efd9470a7ae9fbdda7870858994bf2ff4c22ef92
                  MATRIX: 905->1|1017->21|1096->75|1124->95|1162->96|1198->106|1231->124|1270->126|1310->140|1341->151|1381->161|1416->167|1443->168
                  LINES: 27->1|32->2|34->4|34->4|34->4|35->5|35->5|35->5|36->6|36->6|37->7|38->8|39->9
                  -- GENERATED --
              */
          