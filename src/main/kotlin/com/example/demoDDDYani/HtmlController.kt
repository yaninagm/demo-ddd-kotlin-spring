package com.example.demoDDDYani

import java.io.File
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun blog(model: Model): String {
        val expenseReport = File("src/main/kotlin/com/example/demoDDDYani/expense_report")
            .readLines()
            .map(String::toInt)
        model["title"] = getMessage() + " " + getSummaryOfNumber2020(expenseReport)

        return "blog"
    }
}

private fun getMessage() = "Blog2"


private fun getSummaryOfNumber2020(numbers: List<Int>): String {

    val complements = numbers.associateBy { 2020 - it }

    if (complements != null) {
        numbers.forEach { number ->
            val complement = complements[number]
            if (complement != null) {
                println(">>>> + $number + $complement ")
                return "$number $complement = " + number * complement
            }
        }
    }
    return "1"
}