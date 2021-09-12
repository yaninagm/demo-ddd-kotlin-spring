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

    for ((index1, n1) in list.withIndex()) {
        for ((index2, n2) in list.withIndex()){
            if(n1 + n2 == 2020 && index2 > index1){
                val operationMult = n1 * n2
                val response = "$n1 $n2 = $operationMult"
                println( response)
                return response

            }
        }
    }

    return "1"
}

private val exampleNumberList = listOf(1721, 979, 366, 299, 675, 1456)