package com.organisation.projectname

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SetJpaDs : CrudRepository<SetLocalEntity, String>
