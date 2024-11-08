package com.organisation.projectname

import arrow.core.Either

interface SetRepository {
    fun getAll(): Either<PokemonError, List<OpSet>>
}
