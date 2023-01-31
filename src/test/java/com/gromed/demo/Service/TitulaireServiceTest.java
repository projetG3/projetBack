package com.gromed.demo.Service;

import com.gromed.demo.DbConnection;
import com.gromed.demo.model.Titulaire;
import com.gromed.demo.service.TitulaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TitulaireServiceTest {

    @Autowired
    TitulaireService titulaireService;

    @Test
    void addTitulaire() {
        Titulaire test = new Titulaire();
        test.setId("test");
        titulaireService.saveTitulaire(test);
        assertThat(titulaireService.getTitulaire("test").get().getId()).isEqualTo("test");
        System.out.println("ADD TITULAIRE OK");
    }

    /*@Test
    void updateTitulaire() throws SQLException {
        Connection con = DbConnection.getConnection();
        con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

        String sql;
        PreparedStatement statement;

        sql = "UPDATE titulaire SET nom = ? WHERE nom = ?";
        statement = con.prepareStatement(sql);
        statement.setString(1, "bob2");
        statement.setString(2, "bob");
        statement.executeUpdate();

        Optional<Titulaire> t = titulaireService.getTitulaire("bob");
        System.out.println(t.get().getId());
    }
     */
}
