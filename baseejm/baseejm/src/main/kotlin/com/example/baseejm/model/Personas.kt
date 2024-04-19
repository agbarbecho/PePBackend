package com.example.baseejm.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "personas")
class Personas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var codigo: Long? = null
    var identificacion: String? = null
    var lic_apellido:String? = null
    var lic_nombre:String? =null
    var ruc:String? = null
    var verficado: String?= null
    var razon_social: String?= null
}
