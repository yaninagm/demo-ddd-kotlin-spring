package com.example.demoDDDYani.infrastructure.framework.controller

import com.example.demoDDDYani.service.pruebas.AdventoOfCodeService
import java.io.File
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController(
    private val adventoOfCodeService: AdventoOfCodeService
) {

    @GetMapping("/")
    fun blog(model: Model): String {
        val expenseReport = File("src/main/kotlin/com/example/demoDDDYani/expense_report")
            .readLines()
            .map(String::toInt)
        model["title"] = getMessage() + " " + getSummaryOfNumber2020(expenseReport)

        return "blog"
    }

    fun getSummaryOfNumber2020(numbers: List<Int>, limitSearching: Int? = 2020): String? {
        val pair = adventoOfCodeService.searchPairToSum(numbers, limitSearching)
        return "${pair.first} ${pair.second} = " + pair.first * pair.second
    }
}

private fun getMessage() = "Blog2"
