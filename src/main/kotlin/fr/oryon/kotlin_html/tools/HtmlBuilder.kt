package fr.oryon.kotlin_html.tools

import fr.oryon.kotlin_html.tags.AbstractTag
import fr.oryon.kotlin_html.tags.NoTag
import fr.oryon.kotlin_html.tags.TagScopeInterface

abstract class HtmlBuilder {
    companion object {
        fun build(content: TagScopeInterface.() -> Unit): String {
            val noTag = NoTag()
            noTag.content()
            return noTag.render()
        }

        fun prettyPrint(content: TagScopeInterface.() -> Unit): String {
            val noTag = NoTag()
            noTag.content()
            fun prettyTag(tag: AbstractTag, depth: Int): String {
                val indent = "  ".repeat(depth)
                val elements = tag.getSubElements().joinToString(separator = "\n") { prettyTag(it, depth + 1) }
                return "$indent${tag.getStartTag()}${tag.text ?: ""}${if (elements.isNotEmpty()) "\n$elements\n$indent" else ""}${tag.getEndTag()}"
            }
            return noTag.getSubElements().joinToString(separator = "\n") { prettyTag(it, 0) }
        }
    }
}