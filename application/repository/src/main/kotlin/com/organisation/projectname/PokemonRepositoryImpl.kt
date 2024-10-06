package com.organisation.projectname

import org.example.com.organisation.projectname.PokemonRepository
import org.springframework.stereotype.Repository

@Repository
class PokemonRepositoryImpl(
    private val pokemonLocalDs: PokemonLocalDs,
) : PokemonRepository {
    override fun findByIdAndOwner(
        id: Int,
        owner: String,
    ) = pokemonLocalDs.findByIdAndOwner(id, owner)

    override fun findByOwner(
        name: String,
        pageInfo: PageInfo,
    ) = pokemonLocalDs.findByOwner(name, pageInfo)

    override fun existsByIdAndOwner(
        id: Int,
        owner: String,
    ) = pokemonLocalDs.existsByIdAndOwner(id, owner)

    override fun save(pokemon: Pokemon) = pokemonLocalDs.save(pokemon)

    override fun deleteById(id: Int) = pokemonLocalDs.deleteById(id)
}
