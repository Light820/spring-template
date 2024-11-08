package com.organisation.projectname

import org.springframework.stereotype.Repository

@Repository
class CardRepositoryImpl(
    private val cardLocalDs: CardLocalDs,
) : CardRepository {
    override fun getAll() = cardLocalDs.getAll()
}
