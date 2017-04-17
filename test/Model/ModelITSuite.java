/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author passpass
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Model.EchantillonIT.class, Model.RoleIT.class, Model.UtilisateurIT.class, Model.VisiteurmedicalIT.class, Model.MedicamentIT.class, Model.VisiteurDAOIT.class, Model.RoleDAOIT.class, Model.RapportdevisiteIT.class, Model.UtilisateurDAOIT.class, Model.PraticienIT.class, Model.ComposeIT.class})
public class ModelITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
