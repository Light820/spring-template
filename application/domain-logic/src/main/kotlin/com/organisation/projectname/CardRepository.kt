package com.organisation.projectname

import arrow.core.Either

interface CardRepository {
    fun getAll(): Either<OpCollectorError, List<Card>>
}
