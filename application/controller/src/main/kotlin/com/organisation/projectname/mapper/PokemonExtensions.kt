package com.organisation.projectname.mapper

import com.organisation.projectname.Pokemon
import com.organisation.projectname.model.PokemonDtoIn
import com.organisation.projectname.model.PokemonDtoOut

fun Pokemon.toDto(): PokemonDtoOut {
    return PokemonDtoOut(
        id = id,
        name = name,
        heightInCm = heightInCm,
        weightInKg = weightInKg,
    )
}

fun PokemonDtoIn.toDomain(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        heightInCm = heightInCm,
        weightInKg = weightInKg,
        owner = owner,
    )
}