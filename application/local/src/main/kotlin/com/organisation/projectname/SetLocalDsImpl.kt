package com.organisation.projectname

import arrow.core.Either
import org.springframework.stereotype.Repository

@Repository
class SetLocalDsImpl(
    private val setJpaDs: SetJpaDs,
) : SetLocalDs {
    override fun getAll(): Either<OpCollectorError, List<OpSet>> =
        Either
            .catch {
                setJpaDs.findAll().map {
                    OpSet(
                        id = it.id,
                        name = it.name,
                        description = it.description,
                        img = it.img,
                        type = it.type,
                    )
                }
            }.mapLeft { OpCollectorError.DatabaseOpCollectorError }
}
