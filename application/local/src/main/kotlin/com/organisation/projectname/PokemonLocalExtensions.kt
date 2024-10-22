package com.organisation.projectname

fun PokemonLocalEntity.toDomain(): Pokemon =
    Pokemon(
        id = id!!,
        name = name,
        heightInCm = heightInCm,
        weightInKg = weightInKg,
        owner = owner,
    )
