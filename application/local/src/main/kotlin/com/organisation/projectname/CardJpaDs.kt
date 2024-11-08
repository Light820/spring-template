package com.organisation.projectname

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CardJpaDs : CrudRepository<CardLocalEntity, String>
