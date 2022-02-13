
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

object _tag extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Tag,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tag: Tag):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<tag>
    <name>"""),_display_(/*4.12*/tag/*4.15*/.getName),format.raw/*4.23*/("""</name>
</tag>"""))
      }
    }
  }

  def render(tag:Tag): play.twirl.api.XmlFormat.Appendable = apply(tag)

  def f:((Tag) => play.twirl.api.XmlFormat.Appendable) = (tag) => apply(tag)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/_tag.scala.xml
                  HASH: 3914fbf24dc6dba8cf2e78c80525603269bed316
                  MATRIX: 897->1|1000->12|1082->68|1093->71|1121->79
                  LINES: 27->1|32->2|34->4|34->4|34->4
                  -- GENERATED --
              */
          