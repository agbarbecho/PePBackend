package com.example.baseejm.repository

import com.example.baseejm.model.Personas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonasRepository: JpaRepository<Personas, Long> {
    fun findById(codigo: Long?):Personas?
}