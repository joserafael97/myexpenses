package br.com.jrafael.myexpenses.domain.models

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Spent(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val name: String,
    val description: String,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = LocalDateTime.now()
)