package com.organisation.projectname.controller

import com.organisation.projectname.CardRepository
import com.organisation.projectname.SetRepository
import com.organisation.projectname.model.OpSetDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sets")
class SetController(
    private val setRepository: SetRepository,
    private val cardRepository: CardRepository,
) {
    @GetMapping
    private fun getAll(): ResponseEntity<List<OpSetDto>> {
        val sets =
            setRepository.getAll().fold(
                ifLeft = { emptyList() },
                ifRight = { it.filter { it.type.contains("BOOSTER") } },
            )

        val cards = cardRepository.getAll().getOrNull() ?: emptyList()

        val result =
            sets
                .map { opSet ->
                    OpSetDto(
                        opSet,
                        cards.filter { it.setId == opSet.id },
                    )
                }.sortedWith(
                    compareBy(
                        {
                            if (it.setInfo.id == "EB-01") {
                                1
                            } else if (it.setInfo.id == "PRB-01") {
                                1
                            } else {
                                0
                            }
                        }, // "EB-01" and "PRB-01" go to the end
                        { it.setInfo.id }, // Sort the rest by setInfo.id
                    ),
                )

        return ResponseEntity.ok(result)
    }
}
