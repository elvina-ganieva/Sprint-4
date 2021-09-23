package ru.sber.generics

// 1.
fun <A, B> compare(p1: Pair<A, B>, p2: Pair<A, B>): Boolean {
    return p1.first == p2.first && p1.second == p2.second
}

// 2.
fun <T : Comparable<T>> countGreaterThan(anArray: Array<T>, elem: T): Int {
    var count = 0
    for (i in anArray.indices) {
        if (anArray[i] > elem) count++
    }
    return count
}

// 3.
class Sorter<T : Comparable<T>> {
    val list: MutableList<T> = mutableListOf()

    fun add(value: T) {
        list.add(value)
        list.sort()
    }
}

// 4.
class Stack<T> {
    private val list: MutableList<T> = mutableListOf()

    fun push(elem: T): T {
        list.add(elem)
        return elem
    }

    fun pop(): T? {
        return if (list.size > 0) list.removeAt(list.size - 1) else null
    }

    fun isEmpty(): Boolean {
        return list.size == 0
    }

    fun peek(): T? {
        return if (list.size > 0) list[list.size - 1] else null
    }
}