package com.example.EjercicioSpringBoot.service;

import com.example.EjercicioSpringBoot.model.Operacion;

import java.util.List;

public interface IOperacionService {
    List<Operacion> listarOperacionesPorCuenta(String iban);
}
