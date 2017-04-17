/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Compose;
import Model.Echantillon;
import Model.Medicament;
import Model.Rapportdevisite;
import Model.Utilisateur;
import View.EchantillonAdd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author passpass
 */
public class RapportController {

    /**
     *
     * @return
     */
    public ArrayList<Rapportdevisite> getRapportdevisiteList() {

        ArrayList<Rapportdevisite> RapportdevisiteList = new ArrayList<Rapportdevisite>();
        Connection connection = MysqlConnection.ConnectDB();

        String query = "SELECT * FROM rapportdevisite ";

        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Rapportdevisite rapportdevisite;
            while (rs.next()) {
                rapportdevisite = new Rapportdevisite(rs.getString("bilan"), rs.getString("motifvisite"), rs.getDate("date_visite"), rs.getInt("id_praticien"), rs.getInt("id_echantillon"), rs.getInt("id_visiteur"));
                RapportdevisiteList.add(rapportdevisite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return RapportdevisiteList;
    }

    /**
     *
     * @return
     */
    public ArrayList<Rapportdevisite> getRapportdevisiteListByDateASC() {

        ArrayList<Rapportdevisite> RapportdevisiteList = new ArrayList<Rapportdevisite>();
        Connection connection = MysqlConnection.ConnectDB();

        String query = "SELECT * FROM  rapportdevisite ORDER BY date_visite ASC";

        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Rapportdevisite rapportdevisite;
            while (rs.next()) {
                rapportdevisite = new Rapportdevisite(rs.getString("bilan"), rs.getString("motifvisite"), rs.getDate("date_visite"), rs.getInt("id_praticien"), rs.getInt("id_echantillon"), rs.getInt("id_visiteur"));
                RapportdevisiteList.add(rapportdevisite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return RapportdevisiteList;
    }

    /**
     * @desription Permet de récupérer l'id du rapport de visite. Cela permettra
     * de définir une id_rapport pour la table échantillon, cette fonction est
     * l'équivalent php d'un mysql_insert_id
     * @return int
     * @throws SQLException
     */
    public int insertId() throws SQLException {
        int key = 0; //Variable Contenant l'id de la dernière insertion
        Connection connection = MysqlConnection.ConnectDB();
        PreparedStatement pst = null;
        ResultSet rs;
        Rapportdevisite rapport;
        String sql = "INSERT INTO rapportdevisite(motifvisite, bilan, date_visite, id_visiteur, id_praticien, id_echantillon)"
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement prest;
            prest = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prest.setString(1, null);
            prest.setString(2, null);
            prest.setString(3, null);
            prest.setString(4, null);
            prest.setString(5, null);
            prest.setString(6, null);
            prest.executeUpdate();
            rs = prest.getGeneratedKeys();
            if (rs.next()) {
                key = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return key;
    }

    public int getVisiteurId(int id_utilisateur) throws SQLException {
        int id = 0;
        Connection connection = MysqlConnection.ConnectDB();
        String query = "SELECT id_visiteur FROM visiteurmedical WHERE id_utilisateur = " + id_utilisateur;
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getInt("id_visiteur");
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return id;
    }
}
