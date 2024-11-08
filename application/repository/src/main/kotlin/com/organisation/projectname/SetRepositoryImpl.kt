package com.organisation.projectname

import org.springframework.stereotype.Repository

@Repository
class SetRepositoryImpl(
    private val setLocalDs: SetLocalDs,
) : SetRepository {
    override fun getAll() = setLocalDs.getAll()
}
