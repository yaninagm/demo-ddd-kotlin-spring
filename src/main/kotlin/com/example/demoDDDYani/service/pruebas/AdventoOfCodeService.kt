package com.example.demoDDDYani.service.pruebas

open class AdventoOfCodeService{
    fun searchPairToSum(numbers: List<Int>, limitSearching: Int?): Pair<Int, Int> {
        val complements = numbers.associateBy { limitSearching?.minus(it) }
        return numbers.firstNotNullOf { number ->
            val complement = complements[number]
            if (complement != null) {
                Pair(number, complement)
            } else null
        }
    }
}