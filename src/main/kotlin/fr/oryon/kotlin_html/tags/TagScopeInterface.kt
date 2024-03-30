package fr.oryon.kotlin_html.tags

import fr.oryon.kotlin_html.tags.div.DivScopeInterface

interface TagScopeInterface {
    fun div(text: String? = null, attr: HashMap<String, String> = hashMapOf(), content: DivScopeInterface.() -> Unit = {})
}