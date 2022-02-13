
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

object _step extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Step,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(step: Step):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<step>
    <description>"""),_display_(/*4.19*/step/*4.23*/.getDescription),format.raw/*4.38*/("""</description>
</step>"""))
      }
    }
  }

  def render(step:Step): play.twirl.api.XmlFormat.Appendable = apply(step)

  def f:((Step) => play.twirl.api.XmlFormat.Appendable) = (step) => apply(step)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/_step.scala.xml
                  HASH: ede555f805081a8fe76b5b20ab49ea9c01dc6c99
                  MATRIX: 899->1|1004->14|1094->78|1106->82|1141->97
                  LINES: 27->1|32->2|34->4|34->4|34->4
                  -- GENERATED --
              */
          