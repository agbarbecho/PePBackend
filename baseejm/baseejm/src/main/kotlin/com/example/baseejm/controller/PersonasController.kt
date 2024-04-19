package com.example.baseejm.controller

import com.example.baseejm.model.Personas
import com.example.baseejm.service.PersonasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RequestMapping("/personas")
class PersonasController {

    @Autowired
    lateinit var personasService: PersonasService

    @GetMapping
    fun list(): ResponseEntity<*>{
        return ResponseEntity(personasService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody @Validated personas: Personas): ResponseEntity<Personas>{
        return ResponseEntity(personasService.save(personas), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody personas: Personas): ResponseEntity<Personas> {
        return ResponseEntity(personasService.update(personas), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody personas: Personas): ResponseEntity<Personas> {
        return ResponseEntity(personasService.updateName(personas), HttpStatus.OK)
    }
}