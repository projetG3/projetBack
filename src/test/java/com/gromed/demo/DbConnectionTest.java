package com.gromed.demo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DbConnectionTest {

    @Test
    void connection(){
        DbConnection db = new DbConnection();
        DataSource dataSource = db.myDataSource(
                "jdbc:oracle:thin:@im2ag-oracle.univ-grenoble-alpes.fr:1521:im2ag?NLS_LANG=FRENCH_FRANCE.AL32UTF8",
                "bouissai",
                "d9365417e5");
        assertThat(dataSource).isNotNull();
    }

}
