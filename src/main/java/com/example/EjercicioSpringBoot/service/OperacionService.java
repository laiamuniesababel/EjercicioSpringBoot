package com.example.EjercicioSpringBoot.service;

import com.example.EjercicioSpringBoot.model.Operacion;
import com.example.EjercicioSpringBoot.repository.CuentaBancariaRepository;
import com.example.EjercicioSpringBoot.repository.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OperacionService implements IOperacionService{
    private OperacionRepository operacionRepository;

    @Autowired
    public OperacionService(OperacionRepository operacionRepository) {
        this.operacionRepository = operacionRepository;
    }

    public List<Operacion> listarOperacionesPorCuenta(String iban){
        return operacionRepository.findAllById(Collections.singleton(Integer.valueOf(iban)));
    }
}
