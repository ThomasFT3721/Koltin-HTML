package fr.oryon.kotlin_html.tags.html

import fr.oryon.kotlin_html.tags.TagClosingType

class Html(head: () -> Unit = {}, attr: HashMap<String, String> = hashMapOf(), body: (TagClosingType) -> Unit = {}) {
}