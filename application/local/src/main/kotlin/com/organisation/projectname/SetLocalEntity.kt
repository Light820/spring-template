package com.organisation.projectname

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "sets")
data class SetLocalEntity(
    @Id
    @Column(name = "id")
    val id: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "description")
    val description: String,
    @Column(name = "img")
    val img: String,
    @Column(name = "type")
    val type: String,
)
