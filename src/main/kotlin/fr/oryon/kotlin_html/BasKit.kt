package fr.oryon.kotlin_html

import fr.oryon.kotlin_html.tags.TagScopeInterface
import fr.oryon.kotlin_html.tools.HtmlBuilder

fun render(content: TagScopeInterface.() -> Unit): String {
    return HtmlBuilder.build(content)
}


fun main() {
    val elements = fun TagScopeInterface.() {
        div(attr = hashMapOf("id" to "div1")) {
            div(text = "Hello World", attr = hashMapOf("id" to "div2"))
            div(text = "Hello World", attr = hashMapOf("id" to "div3"))
            div {
                div(text = "Hello World", attr = hashMapOf("id" to "div4"))
                div(text = "Hello World", attr = hashMapOf("id" to "div5"))
            }
        }
    }
    val html = render {
        elements()
    }
    println("HTML:")
    println(html)
    println("Pretty printed:")
    println(HtmlBuilder.prettyPrint(elements))
}