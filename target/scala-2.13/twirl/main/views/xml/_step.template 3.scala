
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


Seq[Any](format.raw/*2.1*/("""<step>
    <description>"""),_display_(/*3.19*/step/*3.23*/.getDescription),format.raw/*3.38*/("""</description>
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
                  HASH: b300bd644c55b02a09b0dcd343215b78fb0410d2
                  MATRIX: 899->1|1004->14|1055->39|1067->43|1102->58
                  LINES: 27->1|32->2|33->3|33->3|33->3
                  -- GENERATED --
              */
          