package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import com.kodilla.hibernate.invoice.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ItemDao itemDao;

    @Test
    void testProductDaoSave() {
        //Given
        Product product = new Product("Nowy produkt");

        //When
        productDao.save(product);
        int productId = product.getId();

        //Then
        assertNotEquals(0, productId);

        //CleanUp
        try {
            productDao.deleteById(productId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testItemDaoSave() {
        //Given
        Product product = new Product("Nowy produkt dwa");
        Item item = new Item(product, new BigDecimal(100), 2,
                new BigDecimal(200));
        Item item2 = new Item(product, new BigDecimal(100), 4,
                new BigDecimal(400));

        //When
        productDao.save(product);
        int productId = product.getId();
        itemDao.save(item);
        int itemId = item.getId();
        itemDao.save(item2);
        int item2Id = item2.getId();

        //Then
        assertNotEquals(0, productId);
        assertNotEquals(0, itemId);
        assertNotEquals(0, item2Id);

        //CleanUp
        try {
            itemDao.deleteById(itemId);
            itemDao.deleteById(item2Id);
            productDao.deleteById(productId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product = new Product("Nowy produkt trzy");
        Item item = new Item(product, new BigDecimal(100), 3,
                new BigDecimal(300));
        Item item2 = new Item(product, new BigDecimal(100), 5,
                new BigDecimal(500));
        Invoice invoice = new Invoice("2/09/2021");
        invoice.getItems().add(item);
        invoice.getItems().add(item2);
        item.setInvoice(invoice);
        item2.setInvoice(invoice);

        //When
        productDao.save(product);
        int productId = product.getId();
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        itemDao.save(item);
        int itemId = item.getId();
        itemDao.save(item2);
        int item2Id = item2.getId();

        //Then
        assertNotEquals(0, productId);
        assertNotEquals(0, itemId);
        assertNotEquals(0, item2Id);
        assertNotEquals(0, invoiceId);

        //CleanUp
        try {
            itemDao.deleteById(itemId);
            itemDao.deleteById(item2Id);
            productDao.deleteById(productId);
            invoiceDao.deleteById(invoiceId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
