package fr.oryon.kotlin_html.tags

class NoTag : AbstractTag("", TagClosingType.SELF_CLOSING, hashMapOf()) {

    override fun render(): String {
        return elements.joinToString(separator = "") { it.render() }
    }
}