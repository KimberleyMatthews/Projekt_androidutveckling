package com.example.projekt_androidutveckling.api

// Template from API Object
data class API (

    var quote : String = "",
    var author : String = ""

) {
    override fun toString(): String {
        return "API(quote='$quote', author='$author')"
    }

}