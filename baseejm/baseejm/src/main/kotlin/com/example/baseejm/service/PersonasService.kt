package com.example.baseejm.service

import com.example.baseejm.model.Personas
import com.example.baseejm.repository.PersonasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PersonasService {
    @Autowired
    lateinit var personasRepository: PersonasRepository

    fun list(): List<Personas>{
        return personasRepository.findAll()
    }

    fun save(personas: Personas):Personas{
        return personasRepository.save(personas)

    }
    fun update(personas: Personas): Personas {
        try {
            personasRepository.findById(personas.codigo)
                    ?: throw Exception("ID no existe")

            return personasRepository.save(personas)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(personas: Personas):  Personas{
        try {
            val response = personasRepository.findById(personas.codigo)
                    ?: throw Exception("ID no existe")
            response.apply {
                lic_apellido = personas.lic_apellido
                lic_nombre = personas.lic_nombre
                ruc = personas.ruc
                verficado = personas.verficado
                razon_social= personas.razon_social
            }
            return personasRepository.save(response)    
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}