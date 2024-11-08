package com.organisation.projectname

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "cards")
data class CardLocalEntity(
    @Id
    @Column(name = "card_id")
    val id: String,
    @Column(name = "set_id")
    val setId: String,
    @Column(name = "rarity")
    val rarity: String,
    @Column(name = "type")
    val type: String,
    @Column(name = "color")
    val color: String,
    @Column(name = "feature")
    val feature: String,
    @Column(name = "description", columnDefinition = "TEXT")
    val description: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "img")
    val img: String,
    @Column(name = "power")
    val power: Int,
    @Column(name = "counter")
    val counter: Int,
)
