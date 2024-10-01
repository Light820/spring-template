package com.organisation.projectname

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import org.springframework.stereotype.Repository

@Repository
class PokemonLocalDsImpl(
    private val jpaDataSource: PokemonJpaDs,
) : PokemonLocalDs {
    override fun findByIdAndOwner(id: Int, owner: String): Either<PokemonError, Pokemon> {
        val request = Either.catch {
            jpaDataSource.findByIdAndOwner(id, owner)
        }

        return request.fold(
            ifLeft = { PokemonError.DatabasePokemonError.left() },
            ifRight = {
                it?.toDomain()?.right() ?: return@fold PokemonError.DatabasePokemonError.left()
            },
        )
    }


    override fun findByOwner(name: String, pageInfo: PageInfo): Either<PokemonError, List<Pokemon>> {
        val request = Either.catch {
            jpaDataSource.findByOwner(name, pageInfo.toPage())
        }

        return request.fold(
            ifLeft = { PokemonError.DatabasePokemonError.left() },
            ifRight = { it.content.map { it.toDomain() }.right() }
        )

    }

    override fun existsByIdAndOwner(id: Int, owner: String): Either<PokemonError, Boolean> {
        val request = Either.catch {
            jpaDataSource.existsByIdAndOwner(id, owner)
        }

        return request.fold(
            ifLeft = { PokemonError.DatabasePokemonError.left() },
            ifRight = { it.right() }
        )
    }

    override fun save(pokemon: Pokemon): Either<PokemonError, Pokemon> {
        val request = Either.catch {
            jpaDataSource.save(pokemon.toLocal())
        }

        return request.fold(
            ifLeft = { PokemonError.DatabasePokemonError.left() },
            ifRight = { it.toDomain().right() }
        )
    }

    override fun deleteById(id: Int): Either<PokemonError, Unit> {
        val request = Either.catch {
            jpaDataSource.deleteById(id)
        }

        return request.fold(
            ifLeft = { PokemonError.DatabasePokemonError.left() },
            ifRight = { Unit.right() }
        )
    }
}