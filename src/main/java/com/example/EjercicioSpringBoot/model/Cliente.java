package com.example.EjercicioSpringBoot.model;

import jakarta.persistence.*;

@Table(name = "clientes")
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dni")
    private int dni;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "cuentaBancaria")
    private CuentaBancaria cuenta;
}
