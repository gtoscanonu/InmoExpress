/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.service;

import cat.xtec.ioc.domain.Vendedor;

/**
 *
 * @author root
 */
public interface VendedorDAOService {
    Vendedor getVendedorByIdVendedor(Integer idVendedor);
    Vendedor getVendedorByNombre(String nombre);
    void addVendedor(Vendedor vendedor);
    void updateVendedor(Vendedor vendedor);
    void deleteVendedor(Vendedor vendedor);
}
