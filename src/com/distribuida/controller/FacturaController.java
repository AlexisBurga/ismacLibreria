package com.distribuida.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dao.AutorDao;
import com.distribuida.dao.CategoriaDao;
import com.distribuida.dao.FacturaDao;
import com.distribuida.entities.Cliente;
import com.distribuida.entities.Factura;

@Controller
@RequestMapping("/Facturas")
public class FacturaController {

    @Autowired
    private FacturaDao facturaDao;
    
    @Autowired
    private AutorDao autorDao;
    
    @Autowired
    private CategoriaDao categoriaDao;

    @GetMapping("/findAll")
    public String findAll(ModelMap modelMap) {
        try {
            List<Factura> facturas = facturaDao.findAll();
            modelMap.addAttribute("facturas", facturas);
            return "Listar-Clientes"; // Make sure this matches your template name
        } catch (Exception e) {
            modelMap.addAttribute("error", "Error fetching facturas: " + e.getMessage());
            return "error"; // Provide an error page if needed
        }
    }

    @GetMapping("/findOne")
    public String findOne(@RequestParam(name = "idFactura", required = false) Integer idFactura, 
                          @RequestParam(name = "opcion", required = false) Integer opcion,
                          ModelMap modelMap) {
        if (idFactura != null) {
            Factura factura = facturaDao.findOne(idFactura);
            modelMap.addAttribute("factura", factura);
        }
        modelMap.addAttribute("autores", autorDao.findAll());
        modelMap.addAttribute("categorias", categoriaDao.findAll());

        // Actualizacion
        if (opcion != null && opcion == 1) {
            return "add-Facturas";
        } else {
            // Eliminacion
            return "del-Facturas";
        }
    }

    @PostMapping("/add")
    public String add(@RequestParam(name = "idFactura", required = false) Integer idFactura,
                      @RequestParam(name = "num_factura", required = false) String numFactura,
                      @RequestParam(name = "fecha", required = false) Date fecha,
                      @RequestParam(name = "total_neto", required = false) Float totalNeto,
                      @RequestParam(name = "iva", required = false) Float iva,
                      @RequestParam(name = "total", required = false) Float total,
                      @RequestParam(name = "id_cliente", required = false) Cliente idCliente,
                      @RequestParam(name = "version", required = false) Integer version,
                      ModelMap modelMap) {
        try {
            if (idFactura == null) {
                Factura factura = new Factura();
                factura.setNumFactura(numFactura);
                factura.setFecha(fecha);
                factura.setTotalNeto(totalNeto);
                factura.setIva(iva);
                factura.setTotal(total);
                factura.setCliente(idCliente);
                factura.setVersion(version);
                facturaDao.add(factura);
            } else {
                Factura factura = facturaDao.findOne(idFactura);
                factura.setNumFactura(numFactura);
                factura.setFecha(fecha);
                factura.setTotalNeto(totalNeto);
                factura.setIva(iva);
                factura.setTotal(total);
                factura.setCliente(idCliente);
                factura.setVersion(version);
                facturaDao.up(factura);
            }
            return "redirect:/Facturas/findAll";
        } catch (Exception e) {
            modelMap.addAttribute("error", "Error saving factura: " + e.getMessage());
            return "error"; // Provide an error page if needed
        }
    }

    @GetMapping("/del")
    public String delete(@RequestParam(name = "idFactura", required = false) Integer idFactura, ModelMap modelMap) {
        try {
            if (idFactura != null) {
                facturaDao.del(idFactura);
            }
            return "redirect:/Facturas/findAll";
        } catch (Exception e) {
            modelMap.addAttribute("error", "Error deleting factura: " + e.getMessage());
            return "error"; // Provide an error page if needed
        }
    }
}
