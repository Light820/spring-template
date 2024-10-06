package com.organisation.projectname

import arrow.core.Either

interface PokemonLocalDs {
    fun findByIdAndOwner(
        id: Int,
        owner: String,
    ): Either<PokemonError, Pokemon>

    fun findByOwner(
        name: String,
        pageInfo: PageInfo,
    ): Either<PokemonError, List<Pokemon>>

    fun existsByIdAndOwner(
        id: Int,
        owner: String,
    ): Either<PokemonError, Boolean>

    fun save(pokemon: Pokemon): Either<PokemonError, Pokemon>

    fun deleteById(id: Int): Either<PokemonError, Unit>
}
