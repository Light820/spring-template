package com.organisation.projectname

sealed interface PokemonError {
    data object DatabasePokemonError : PokemonError
}
