package fr.oryon.kotlin_html.tags.div

import fr.oryon.kotlin_html.tags.AbstractTag
import fr.oryon.kotlin_html.tags.TagClosingType

class Div(text: String? = null, attr: HashMap<String, String> = hashMapOf(), content: DivScopeInterface.() -> Unit = {}) :
    AbstractTag("div", TagClosingType.WITH_CLOSING, attr, text),
    DivScopeInterface