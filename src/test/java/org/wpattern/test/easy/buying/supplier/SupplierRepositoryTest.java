package org.wpattern.test.easy.buying.supplier;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.wpattern.easy.buying.supplier.Supplier;
import org.wpattern.easy.buying.supplier.SupplierRepository;
import org.wpattern.test.easy.buying.utils.BaseEntityTest;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SupplierRepositoryTest extends BaseEntityTest {

   private final Logger LOGGER = Logger.getLogger(this.getClass());

   @Autowired
    private SupplierRepository supplierRepository;

   @Test
    public void findAll_success() {
       List<Supplier> supplierList = supplierRepository.findAll();

       LOGGER.debug(supplierList);

       assertNotNull(supplierList);
       assertTrue(supplierList.size() > 0);
   }

   @Test
    public void insert() {
       Supplier supplier = new Supplier();
       supplier.setName("Fornecedor 1");
       supplier.setDescription("Fornecedor de eletronicos");
       supplier.setRegisterDate(new Date(2017,10,8));
       supplierRepository.save(supplier);
   }
}
