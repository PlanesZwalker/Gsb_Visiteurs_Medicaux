/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Praticien;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author passpass
 */
public class PraticienViewIT {
    
    public PraticienViewIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPraticienList method, of class PraticienView.
     */
    @Test
    public void testGetPraticienList() {
        System.out.println("getPraticienList");
        PraticienView instance = new PraticienView();
        ArrayList<Praticien> expResult = null;
        ArrayList<Praticien> result = instance.getPraticienList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select_NomByDesc method, of class PraticienView.
     */
    @Test
    public void testSelect_NomByDesc() {
        System.out.println("select_NomByDesc");
        PraticienView instance = new PraticienView();
        ArrayList<Praticien> expResult = null;
        ArrayList<Praticien> result = instance.select_NomByDesc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select_GroupByDate method, of class PraticienView.
     */
    @Test
    public void testSelect_GroupByDate() {
        System.out.println("select_GroupByDate");
        PraticienView instance = new PraticienView();
        ArrayList<Praticien> expResult = null;
        ArrayList<Praticien> result = instance.select_GroupByDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Show_Praticien_In_JTable method, of class PraticienView.
     */
    @Test
    public void testShow_Praticien_In_JTable() {
        System.out.println("Show_Praticien_In_JTable");
        PraticienView instance = new PraticienView();
        instance.Show_Praticien_In_JTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of executeSQlQuery method, of class PraticienView.
     */
    @Test
    public void testExecuteSQlQuery() {
        System.out.println("executeSQlQuery");
        String query = "";
        String message = "";
        PraticienView instance = new PraticienView();
        instance.executeSQlQuery(query, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Show_Combo1_Praticien method, of class PraticienView.
     */
    @Test
    public void testShow_Combo1_Praticien() {
        System.out.println("Show_Combo1_Praticien");
        PraticienView instance = new PraticienView();
        instance.Show_Combo1_Praticien();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
