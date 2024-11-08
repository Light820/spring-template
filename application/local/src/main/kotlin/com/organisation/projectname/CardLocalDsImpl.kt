package com.organisation.projectname

import arrow.core.Either
import org.springframework.stereotype.Repository

@Repository
class CardLocalDsImpl(
    private val cardJpaDs: CardJpaDs,
) : CardLocalDs {
    override fun getAll(): Either<OpCollectorError, List<Card>> =
        Either
            .catch {
                cardJpaDs.findAll().map {
                    Card(
                        id = it.id,
                        setId = it.setId,
                        rarity = it.rarity,
                        name = it.name,
                        feature = it.feature,
                        type = it.type,
                        color = it.color,
                        img = it.img,
                        power = it.power,
                        counter = it.counter,
                        description = it.description,
                    )
                }
            }.mapLeft { OpCollectorError.DatabaseOpCollectorError }
}
