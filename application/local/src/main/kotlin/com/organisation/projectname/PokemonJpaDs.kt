package com.organisation.projectname

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonJpaDs :
    PagingAndSortingRepository<PokemonLocalEntity, Int>,
    CrudRepository<PokemonLocalEntity, Int> {
    fun findByIdAndOwner(
        id: Int,
        owner: String,
    ): PokemonLocalEntity?

    fun findByOwner(
        owner: String,
        pageRequest: PageRequest,
    ): Page<PokemonLocalEntity>

    fun existsByIdAndOwner(
        id: Int,
        owner: String,
    ): Boolean
}
