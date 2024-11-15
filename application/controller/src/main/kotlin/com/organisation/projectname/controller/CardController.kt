package com.organisation.projectname.controller

import com.organisation.projectname.Card
import com.organisation.projectname.CardRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cards")
class CardController(
    private val repository: CardRepository,
) {
    @GetMapping
    private fun getAll(): ResponseEntity<GetAllCardResponse> =
        repository.getAll().fold(
            ifLeft = { ResponseEntity.internalServerError().build() },
            ifRight = { ResponseEntity.ok(GetAllCardResponse(it)) },
        )
}

data class GetAllCardResponse(
    val cards: List<Card>,
)
