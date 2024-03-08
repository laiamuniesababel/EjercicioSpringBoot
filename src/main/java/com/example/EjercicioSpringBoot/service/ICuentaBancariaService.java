package com.example.EjercicioSpringBoot.service;

import com.example.EjercicioSpringBoot.model.CuentaBancaria;

import java.util.List;

public interface ICuentaBancariaService {
    List<CuentaBancaria> listarCuentas();
    CuentaBancaria crearCuentaBancaria(CuentaBancaria cuentaBancaria);
    void realizarIngreso(String iban, double cantidad) throws Throwable;

    void realizarRetirada(String iban, double cantidad) throws Throwable;
}
