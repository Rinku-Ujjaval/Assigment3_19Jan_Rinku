package com.example.assigment3_19jan_rinku


fun main() {

    val a = { a: Int, b: Int -> a + b }
    println(a)

    val list = listOf<String>("a")

    fun higherorder(a: Int, b: Int, opration: (Int, Int) -> Int): Int {
        return opration(a, b)
    }

    val result = higherorder(10, 3) { a, b -> a + b }


    fun String.addNew(a: String): String {
        return a.length.toString()
    }

    fun add(a: Int, b: Int, opra: (Int, Int) -> Int) {
        opra(a, b)
    }

    lateinit var mentor: String
    val aw: String by lazy {
        "10"
    }

}

class Exmaple {
}