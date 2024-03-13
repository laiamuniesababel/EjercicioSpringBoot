package com.example.EjercicioSpringBoot.controller;

import com.example.EjercicioSpringBoot.model.CuentaBancaria;
import com.example.EjercicioSpringBoot.model.Operacion;
import com.example.EjercicioSpringBoot.service.CuentaBancariaService;
import com.example.EjercicioSpringBoot.service.InicializacionService;
import com.example.EjercicioSpringBoot.service.OperacionService;
import com.example.EjercicioSpringBoot.service.TransfereenciaSerevice;
import com.example.EjercicioSpringBoot.utils.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private static final Logger logger = Logger.getLogger();
    private CuentaBancariaService cuenta;
    private TransfereenciaSerevice transfereenciaSerevice;
    private OperacionService operacion;
    private InicializacionService inicializar;

    @PostMapping
    public void inicializar(){
        logger.info("Inicializando aplicacion");
        inicializar.inicializar();
        logger.info("Inicializacion terminada");
    }

    @GetMapping("/cuentas")
    public List<CuentaBancaria> listarCuentas(){
        return cuenta.listarCuentas();
    }

    @PostMapping
    public CuentaBancaria crearCuntaBancaria(CuentaBancaria cuentaBancaria){
        return cuenta.crearCuentaBancaria(cuentaBancaria);
    }

    @PostMapping("/cuentas/{iban}/ingreso")
    public void realizarIngreso(@PathVariable String iban, @RequestParam double cantidad) throws Throwable {
        cuenta.realizarIngreso(iban,cantidad);
    }

    @PostMapping("/cuentas/{iban}/retirada")
    public void  reealizarRetirada(@PathVariable String iban, @RequestParam double cantidad) throws Throwable{
        cuenta.realizarRetirada(iban,cantidad);
    }

    @PostMapping("/transferencia")
    public void reealizarTransferenica(@RequestParam String ibanO, @RequestParam String ibanD, @RequestParam double cantidad) throws Throwable{
        transfereenciaSerevice.realizarTransferencia(ibanO,ibanD,cantidad);
    }

    @PostMapping("/operaciones/{iban}")
    public List<Operacion> listarOperacionesPorCuenta(@PathVariable String iban){
        return operacion.listarOperacionesPorCuenta(iban);
    }
}
