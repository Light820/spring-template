package com.organisation.projectname

internal fun Pokemon.toLocal(): PokemonLocalEntity {
    return PokemonLocalEntity(
        id = id,
        name = name,
        heightInCm = heightInCm,
        weightInKg = weightInKg,
        owner = owner,
    )
}