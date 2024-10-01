package com.organisation.projectname

import jakarta.persistence.*

@Entity
@Table(name = "pokemon")
data class PokemonLocalEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val name: String,
    val heightInCm: Int,
    val weightInKg: Double,
    val owner: String,
)
