package com.organisation.projectname

import arrow.core.Either

interface CardLocalDs {
    fun getAll(): Either<OpCollectorError, List<Card>>
}
