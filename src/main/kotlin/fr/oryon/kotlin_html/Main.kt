package fr.oryon.kotlin_html

/*
fun renderHTML(block: HTML.() -> Unit): String {
    val html = HTML()
    html.block()
    return html.render()
}

interface ElementInterface {
    fun render(): String

    fun getStartTag(): String
    fun getEndTag(): String
}

abstract class Element : ElementInterface {
    protected val content: MutableList<Element> = mutableListOf()

    open fun getContent(): String {
        return content.joinToString("") { it.render() }
    }
}

open class TagElement : Element() {
    open val tag: String? = null
    private var attributes: MutableMap<String, String> = mutableMapOf()
    var attrId: String? = null
        set(value) {
            field = value
            attr("id", value!!)
        }
    var attrClass: String? = null
        set(value) {
            field = value
            attr("class", value!!)
        }

    override fun render(): String {
        return getStartTag() + getContent() + getEndTag()
    }

    override fun getStartTag(): String {
        val attributes = attributes.map { "${it.key}=\"${it.value}\"" }.joinToString(" ")
        return "<$tag${if (attributes.isNotEmpty()) " $attributes" else ""}>"
    }

    override fun getEndTag(): String {
        return "</$tag>"
    }

    fun attr(key: String, value: Any) {
        attributes[key] = value.toString()
    }
}

open class TagElementWithText : TagElement() {
    var text: String? = null

    fun text(block: () -> String) {
        text = block()
    }

    override fun getContent(): String {
        return text ?: super.getContent()
    }
}


class HTML : TagElement() {
    override val tag: String = "html"

    private val body = mutableListOf<Element>()
    private val head = mutableListOf<Element>()
    var attrXmlns: String? = null
        set(value) {
            field = value
            attr("xmlns", value!!)
        }
    var attrLang: String? = null
        set(value) {
            field = value
            attr("lang", value!!)
        }

    fun body(block: Body.() -> Unit) {
        val body = Body()
        body.block()
        this.body.add(body)
    }

    override fun render(): String {
        val head = head.joinToString("") { it.render() }
        val body = body.joinToString("") { it.render() }
        return "<!DOCTYPE $tag>$head$body</$tag>"
    }


}

class Body : TagElementWithText() {
    override val tag: String = "body"

    fun add(element: Element) {
        content.add(element)
    }
}

class Div() : TagElementWithText() {
    override val tag: String = "div"

    constructor(block: Div.() -> Unit) : this() {
        block()
    }
}

fun main() {
    val html = renderHTML {
        body {
            attrId = "app"
            attrClass = "container"
            for (i in 1..2) {
                add(Div {
                    attrClass = "card"
                    text = "Card $i"
                })
                add(Div {
                    attrClass = "card"
                    text {
                        "Card $i 2"
                    }
                })
            }
        }
    }
    println(html)
}*/