
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

object _utensil extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Utensil,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(utensil: Utensil):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<utensil>
    <name>"""),_display_(/*3.12*/utensil/*3.19*/.getName),format.raw/*3.27*/("""</name>
</utensil>"""))
      }
    }
  }

  def render(utensil:Utensil): play.twirl.api.XmlFormat.Appendable = apply(utensil)

  def f:((Utensil) => play.twirl.api.XmlFormat.Appendable) = (utensil) => apply(utensil)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/_utensil.scala.xml
                  HASH: 267b85d267223fb0c5305386c9e9c4da5cff437e
                  MATRIX: 905->1|1016->20|1063->41|1078->48|1106->56
                  LINES: 27->1|32->2|33->3|33->3|33->3
                  -- GENERATED --
              */
          