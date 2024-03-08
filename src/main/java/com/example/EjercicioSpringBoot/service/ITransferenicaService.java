package com.example.EjercicioSpringBoot.service;

public interface ITransferenicaService {
    void realizarTransferencia(String ibanO, String ibanD, double cantidad) throws Throwable;
}
