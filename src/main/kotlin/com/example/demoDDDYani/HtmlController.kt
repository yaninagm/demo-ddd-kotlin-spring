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
            .map { it.toInt() }
        model["title"] = getMessage() + " " + getSummaryOfNumber2020(expenseReport)

        return "blog"
    }
}

private fun getMessage() = "Blog2"


private fun getSummaryOfNumber2020(list: List<Int>): String {

    list.forEachIndexed { index1, n1 ->
        list.forEachIndexed { index2, n2 ->
            if(n1 + n2 == 2020 && index2 > index1){
                return "$n1 $n2 = " + n1 * n2
            }
        }
    }
    return "1"
}