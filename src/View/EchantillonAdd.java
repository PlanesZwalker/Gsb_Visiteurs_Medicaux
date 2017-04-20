/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ComposeController;
import Controller.MedicamentController;
import Controller.MysqlConnection;
import Model.Compose;
import Model.Echantillon;
import Model.Medicament;
import Model.Praticien;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elise
 */
public class EchantillonAdd extends javax.swing.JFrame 
{    
    PreparedStatement pst = null ;
    private int id_medicament;
    private int rapport;
    private final int key;
    public int MYSQL_DUPLICATE_PK;
    
    /**
     * Nouvelle Vue pour créer l'échantillon (EchantillonAdd)
     * @param key
     * @param rapport
     * @throws SQLException
     */        
    public EchantillonAdd(int key, int rapport) throws SQLException
    {
        // key = id de l'echantillon récupérer 
        this.key = key;
        // id du rapport (table rapport)
        this.rapport = rapport;    
        initComponents();
        Show_Compose_In_JTable();
        Show_Combo_Medicament();
    }

    private EchantillonAdd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        c_medicament = new javax.swing.JComboBox<>();
        T_quantite = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        b_ajouter_ech = new javax.swing.JButton();
        b_annuler = new javax.swing.JButton();
        B_valid_echantillon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_compose = new javax.swing.JTable();

        jLabel1.setText("                               AJOUTER UN ECHANTILLON");

        jLabel2.setText("Quantité :");

        jLabel3.setText("Médicament :");

        b_ajouter_ech.setText("Ajouter");
        b_ajouter_ech.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_ajouter_echMouseClicked(evt);
            }
        });

        b_annuler.setText("Annuler");
        b_annuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_annulerMouseClicked(evt);
            }
        });

        B_valid_echantillon.setText("Valider Echantillon");
        B_valid_echantillon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B_valid_echantillonMouseClicked(evt);
            }
        });

        table_compose.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dénomination", "Quantité"
            }
        ));
        jScrollPane1.setViewportView(table_compose);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_medicament, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T_quantite, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_ajouter_ech)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(B_valid_echantillon, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(b_annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(B_valid_echantillon)
                        .addComponent(b_annuler))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(T_quantite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(c_medicament, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_ajouter_ech))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cette fonction Permet d'ajouter l'échantillon dans la
     * base de données
     * @param evt
     */
    private void b_ajouter_echMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ajouter_echMouseClicked
        // TODO add your handling code here:
        
        int quantite = Integer.parseInt(T_quantite.getText());
        String medicament = (String) c_medicament.getSelectedItem();
        
        // Recupère le medicament en fonction de la denomination 
        try 
        {
            Connection connection = MysqlConnection.ConnectDB();
            Statement st = connection.createStatement();
            String query = "SELECT * FROM medicament WHERE denomination = '"+medicament+"'";
            ResultSet rs = st.executeQuery(query);
            

            while (rs.next())
            {      
                id_medicament = rs.getInt("id_medicament");
            }//end while
            connection.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        // Insère les élément dans la table compose
        try 
        {            
            String query = "INSERT INTO compose(id_medicament, quantite, id_echantillon) VALUES "
               + "('"+id_medicament+"','"+quantite+"','"+this.key+"')";
            executeSQlQuery(query, "Ajoutées");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_b_ajouter_echMouseClicked
    
    /**
     * Supprime l'échantillon en cours de création et ferme la 
     * Vue en cours (this.setVisible(false)
     * @param evt
     */
    private void b_annulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_annulerMouseClicked
        //String key = Integer.toString(this.key);
        try 
        {
            Connection connection = MysqlConnection.ConnectDB();
            Statement st = connection.createStatement();
            String query = "DELETE FROM echantillon WHERE id_echantillon = " + this.key;
            int rs = st.executeUpdate(query);
            if (rs == 1);
            {
                this.setVisible(false);
            }
        }
        catch (SQLException e)
        {
            e.getMessage();
        }
            
            
            
    }//GEN-LAST:event_b_annulerMouseClicked
    
    /**
     * Mets a jour l'id_echantillon de la table Rapport de Visite
     * @param evt 
     */
    private void B_valid_echantillonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_valid_echantillonMouseClicked
        
        try
        {
            Connection connection = MysqlConnection.ConnectDB();
            String query = "UPDATE rapportdevisite SET id_echantillon = ? WHERE id_rapport = "+this.rapport;
            pst = (PreparedStatement) connection.prepareStatement(query);
            pst.setInt(1, this.key);
            pst.executeUpdate();
            connection.close();
            this.setVisible(false);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
}
    }//GEN-LAST:event_B_valid_echantillonMouseClicked
    
    /**
     * Permet d'afficher la table Médicament dans une JcomboBox 
     */
    public void Show_Combo_Medicament()
    {
        try 
        {
            Connection connection = MysqlConnection.ConnectDB();
            Statement st = connection.createStatement();
            String query = "SELECT * FROM medicament";
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {      
                
                c_medicament.addItem(rs.getString("denomination"));
            }//end while
            connection.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Fonction Permettant d'afficher en direct les éléments de la table
     * Compose
     */
    public void Show_Compose_In_JTable() throws SQLException
    {
        ComposeController composeController = new ComposeController();
        ArrayList<Compose> list = composeController.getComposeList(this.key);
        DefaultTableModel model = (DefaultTableModel) table_compose.getModel();
        Object[] row = new Object[2];
        
        int nbRapport = list.size();
        
        // Object[] rowP = new Object[nbRapport];
        // Object[] rowV = new Object[nbRapport];
        // Object[] rowE = new Object[nbRapport];
        
        Medicament nameMedicament = new Medicament();

        
        for(int i = 0; i < list.size(); i++)
        {  
            //On récupère tout d'abord l'id_medicament de la list Compose
            int id_medicament = list.get(i).getId_medicament();
            // On instancie le Controller medicament
            MedicamentController myMedicament = new MedicamentController();
            // on récupere la dénomination du medicament grace à l'id du medicament
            nameMedicament = myMedicament.showDenominationById(id_medicament);
            row[0] = nameMedicament.getDenomination();
            row[1] = list.get(i).getQuantite();
          
            model.addRow(row);
        }
    }
    
    /**
     * Permet d'éxecuter la requète SQL et de la transmettre à la 
     * JTable souhaité. La fonction gère les doublons, 
     * Un médicament ne peut être dupliqué
     * @param query
     * @param message
     * @throws SQLException
     * 
     */
    public void executeSQlQuery(String query, String message) throws SQLException
    {
        Connection con = MysqlConnection.ConnectDB();
        Statement st;
        try{
            st = con.createStatement();
            if((st.executeUpdate(query)) == 1)
            {
                // refresh jtable data
                DefaultTableModel model = (DefaultTableModel)table_compose.getModel();
                model.setRowCount(0);
                Show_Compose_In_JTable();
               
                JOptionPane.showMessageDialog(null, "Données "+message+" avec Succès");
            }else{
                JOptionPane.showMessageDialog(null, "Données impossible à "+message);
            }
        }catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null, "Médicament déjà ajouté à votre échantillon !!");
       }
    }
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EchantillonAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EchantillonAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EchantillonAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EchantillonAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EchantillonAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_valid_echantillon;
    private javax.swing.JTextField T_quantite;
    private javax.swing.JButton b_ajouter_ech;
    private javax.swing.JButton b_annuler;
    private javax.swing.JComboBox<String> c_medicament;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_compose;
    // End of variables declaration//GEN-END:variables
}
