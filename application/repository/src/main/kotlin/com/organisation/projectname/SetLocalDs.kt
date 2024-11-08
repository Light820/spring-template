package com.organisation.projectname

import arrow.core.Either

interface SetLocalDs {
    fun getAll(): Either<OpCollectorError, List<OpSet>>
}
