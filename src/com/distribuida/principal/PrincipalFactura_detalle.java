package com.distribuida.principal;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.distribuida.dao.FacturaDao;
import com.distribuida.dao.Factura_detalleDao;
import com.distribuida.dao.LibroDao;
import com.distribuida.entities.Factura_detalle;
import java.util.List;

public class PrincipalFactura_detalle {

    public static void main(String[] args) {
        // Crear el contexto de Spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        // Obtener los DAOs desde el contexto
        Factura_detalleDao facturaDetalleDao = context.getBean("factura_detalleDaoImpl", Factura_detalleDao.class);
        FacturaDao facturaDao = context.getBean("facturaDaoImpl", FacturaDao.class);
        LibroDao libroDao = context.getBean("libroDaoImpl", LibroDao.class);

        // CRUD: CREATE, READ, UPDATE, DELETE

        // CREATE
        Factura_detalle facturaDetalle = new Factura_detalle(1, 2, 39.90);
        facturaDetalleDao.add(facturaDetalle);

        // UPDATE (Ejemplo comentado)
        // Factura factura = new Factura(87, "FAC-0091", new Date(), 123.63, 23.36, 80.35);
        // factura.setCliente(clienteDao.findOne(2)); // Asegúrate de que clienteDao está correctamente configurado
        // facturaDao.update(factura);

        // DELETE (Ejemplo comentado)
        // facturaDao.delete(83);

        // READ (FINDONE)
        Factura_detalle foundFacturaDetalle = facturaDetalleDao.findOne(1);
        System.out.println("********************FINDONE**************" + foundFacturaDetalle);

        // READ (FINDALL)
        List<Factura_detalle> facturasDetalle = facturaDetalleDao.findAll();
        facturasDetalle.forEach(item -> System.out.println(item.toString()));

        // Cerrar el contexto de Spring
        context.close();
    }
}
