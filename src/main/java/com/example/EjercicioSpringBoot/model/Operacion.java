package com.example.EjercicioSpringBoot.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;

@lombok.Data
@Table(name = "operacion")
@Entity
public class Operacion {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "fecha")
    private Data fecha;
    @Column(name = "cantidad")
    private Double cantidad;

    @Column(name = "cuentaBancariaOrigen")
    private CuentaBancaria cuentaO;

    @Column(name = "cuentaBancariaDestino")
    private CuentaBancaria cuentaD;

}
