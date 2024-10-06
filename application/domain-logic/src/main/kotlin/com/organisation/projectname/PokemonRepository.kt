package org.example.com.organisation.projectname

import arrow.core.Either
import com.organisation.projectname.PageInfo
import com.organisation.projectname.Pokemon
import com.organisation.projectname.PokemonError

interface PokemonRepository {
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
