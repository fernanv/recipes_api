
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

object tags extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Tag],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tags: List[Tag]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""        """),format.raw/*2.9*/("""<?xml version="1.0" encoding="UTF-8"?>
<tags>
    """),_display_(/*4.6*/if(tags.size() > 0)/*4.25*/{_display_(Seq[Any](format.raw/*4.26*/("""
        """),_display_(/*5.10*/for(tag <- tags) yield /*5.26*/ {_display_(Seq[Any](format.raw/*5.28*/("""
            """),_display_(/*6.14*/_tag(tag)),format.raw/*6.23*/("""
        """)))}),format.raw/*7.10*/("""
    """)))}),format.raw/*8.6*/("""
"""),format.raw/*9.1*/("""</tags>"""))
      }
    }
  }

  def render(tags:List[Tag]): play.twirl.api.XmlFormat.Appendable = apply(tags)

  def f:((List[Tag]) => play.twirl.api.XmlFormat.Appendable) = (tags) => apply(tags)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/tags.scala.xml
                  HASH: b5d012394f9076cb8bbe2d4e6fc718506c874cea
                  MATRIX: 903->1|1013->19|1047->27|1123->78|1150->97|1188->98|1224->108|1255->124|1294->126|1334->140|1363->149|1403->159|1438->165|1465->166
                  LINES: 27->1|32->2|32->2|34->4|34->4|34->4|35->5|35->5|35->5|36->6|36->6|37->7|38->8|39->9
                  -- GENERATED --
              */
          