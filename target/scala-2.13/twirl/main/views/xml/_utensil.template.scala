
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


Seq[Any](format.raw/*2.1*/("""<?xml version="1.0" encoding="UTF-8"?>
<utensil>
    <name>"""),_display_(/*4.12*/utensil/*4.19*/.getName),format.raw/*4.27*/("""</name>
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
                  HASH: 756aedb617cb4260951fd95235b0b15763715726
                  MATRIX: 905->1|1016->20|1102->80|1117->87|1145->95
                  LINES: 27->1|32->2|34->4|34->4|34->4
                  -- GENERATED --
              */
          