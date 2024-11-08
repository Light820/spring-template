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
            sets.map { opSet ->
                OpSetDto(
                    opSet,
                    cards.filter { it.setId == opSet.id },
                )
            }
        return ResponseEntity.ok(result)
    }
}
