package com.organisation.projectname.model

data class PokemonDtoIn(
    val id: Int,
    val name: String,
    val heightInCm: Int,
    val weightInKg: Double,
    val owner: String,
)
