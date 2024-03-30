package fr.oryon.kotlin_html.tags

import fr.oryon.kotlin_html.tags.div.Div
import fr.oryon.kotlin_html.tags.div.DivScopeInterface


abstract class AbstractTag(private val tag: String, private val closingType: TagClosingType, private val attributes: MutableMap<String, String>, var text: String? = null) : TagScopeInterface {

    protected val elements = mutableListOf<AbstractTag>()

    fun getSubElements() = elements

    open fun getAttributesAsString(): String {
        val result = attributes.map { "${it.key}=\"${it.value}\"" }.joinToString(" ")
        return if (result.isNotEmpty()) " $result" else ""
    }

    open fun getStartTag(): String {
        return "<$tag${getAttributesAsString()}${if (closingType == TagClosingType.WITH_CLOSING) "" else "/"}>"
    }
    open fun getContent(): String {
        return "${text ?: ""}${elements.joinToString("") { it.render() }}"
    }
    open fun getEndTag(): String {
        return "</$tag>"
    }

    open fun render(): String {
        return if (closingType == TagClosingType.WITH_CLOSING) {
            "${getStartTag()}${getContent()}${getEndTag()}"
        } else {
            getStartTag()
        }
    }

    override fun div(text: String?, attr: HashMap<String, String>, content: DivScopeInterface.() -> Unit) {
        val div = Div(text = text, attr = attr, content = content)
        div.content()
        elements.add(div)
    }
}