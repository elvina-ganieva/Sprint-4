package ru.sber.generics

// 1.
fun <A, B> compare(p1: Pair<A, B>, p2: Pair<A, B>): Boolean {
    return p1.first == p2.first && p1.second == p2.second
}

// 2.
fun <Any: Comparable<Any>> countGreaterThan(anArray: Array<Any>, elem: Any): Int {
    var count = 0
    for (i in anArray.indices) {
        if (anArray[i] > elem)
        count++
    }
    return count
}

// 3.
class Sorter<T: Comparable<T>> {
    val list: MutableList<T> = mutableListOf()

    fun add(value: T) {
        list.add(value)
        list.sort()
    }
}

// 4.
class Stack<T> {
    private val list: MutableList<T> = mutableListOf()

    fun push(elem: T) {
        list.add(elem)
    }

    fun pop(): T {
        return list.removeAt(list.size - 1)
    }

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    fun peek(): T{
        return list[list.size - 1]
    }
}