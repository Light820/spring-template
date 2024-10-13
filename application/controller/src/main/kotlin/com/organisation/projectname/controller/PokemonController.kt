package com.organisation.projectname.controller

import com.organisation.projectname.PageInfo
import com.organisation.projectname.PokemonRepository
import com.organisation.projectname.mapper.toDomain
import com.organisation.projectname.mapper.toDto
import com.organisation.projectname.model.PokemonDtoIn
import com.organisation.projectname.model.PokemonDtoOut
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.security.Principal

@RestController
@RequestMapping("/pokemon")
class PokemonController(
    private val repository: PokemonRepository,
) {
    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: Int,
        principal: Principal,
    ): ResponseEntity<PokemonDtoOut> =
        repository.findByIdAndOwner(id, principal.name).fold(
            ifLeft = { ResponseEntity.internalServerError().build() },
            ifRight = { ResponseEntity.ok(it.toDto()) },
        )

    @PostMapping
    fun create(
        @RequestBody pokemonDtoOut: PokemonDtoIn,
        ucb: UriComponentsBuilder,
        principal: Principal,
    ): ResponseEntity<PokemonDtoOut> {
        val updatedPokemonDtoIn = pokemonDtoOut.copy(owner = principal.name)
        val savedPokemon = repository.save(updatedPokemonDtoIn.toDomain())

        return savedPokemon.fold(
            ifLeft = { ResponseEntity.internalServerError().build() },
            ifRight = {
                val locationOfNewPokemon =
                    ucb
                        .path("pokemon/{id}")
                        .buildAndExpand(it.id)
                        .toUri()

                ResponseEntity.created(locationOfNewPokemon).body(it.toDto())
            },
        )
    }

    @GetMapping
    private fun findAll(
        pageable: Pageable,
        principal: Principal,
    ): ResponseEntity<List<PokemonDtoOut>> =
        repository
            .findByOwner(principal.name, PageInfo(pageable.pageNumber, pageable.pageSize))
            .fold(
                ifLeft = { ResponseEntity.notFound().build() },
                ifRight = { ResponseEntity.ok(it.map { it.toDto() }) },
            )

    @PutMapping("/{requestedId}")
    fun put(
        @PathVariable requestedId: Int,
        @RequestBody pokemonDtoIn: PokemonDtoIn,
        principal: Principal,
    ): ResponseEntity<Void> {
        val existingPokemon = repository.findByIdAndOwner(requestedId, principal.name)
        return existingPokemon.fold(
            ifLeft = { ResponseEntity.notFound().build() },
            ifRight = {
                val updatedPokemon =
                    it.copy(
                        owner = principal.name,
                        id = requestedId,
                        name = pokemonDtoIn.name,
                        heightInCm = pokemonDtoIn.heightInCm,
                        weightInKg = pokemonDtoIn.weightInKg,
                    )
                val result = repository.save(updatedPokemon)
                result.fold(
                    ifLeft = { ResponseEntity.internalServerError().build() },
                    ifRight = {
                        return ResponseEntity.notFound().build()
                    },
                )
            },
        )
    }

    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable id: Int,
        principal: Principal,
    ): ResponseEntity<PokemonDtoOut> {
        val exists = repository.existsByIdAndOwner(id, principal.name)
        return exists.fold(
            ifLeft = { ResponseEntity.notFound().build() },
            ifRight = {
                repository.deleteById(id).fold(
                    ifLeft = { ResponseEntity.notFound().build() },
                    ifRight = { ResponseEntity.noContent().build() },
                )
            },
        )
    }
}
