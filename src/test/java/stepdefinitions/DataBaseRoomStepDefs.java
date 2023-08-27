package stepdefinitions;

import io.cucumber.java.en.*;
import pojos.RoomPojo;

import java.sql.*;

import static org.junit.Assert.assertEquals;
import static stepdefinitions.MedunnaRoomStepDefs.odaNo;

public class DataBaseRoomStepDefs {
    Connection connection;
    Statement statement;

    @Given("Database baglantisini kur")
    public void database_baglantisini_kur() throws SQLException {
        // 1.Adım: Connection oluştur
//        connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "Medunna_pass_@6");
        connection = DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2", "select_user", "Medunna_pass_@6");

        // 2.Adım: Statement oluştur
        statement = connection.createStatement();
    }
    @Then("Oda bilgilerini dogrula")
    public void oda_bilgilerini_dogrula() throws SQLException {
        // 3.Adım: Query (Sorgu) oluştur
        ResultSet resultSet = statement.executeQuery("select * from room where room_number = " + odaNo);
        resultSet.next();

        RoomPojo expectedData = new RoomPojo(odaNo, "SUITE", true, 123, "End To End Test için oluşturulmuştur");

        assertEquals(expectedData.getRoomNumber(), resultSet.getInt("room_number"));
        assertEquals(expectedData.getRoomType(), resultSet.getString("room_type"));
        assertEquals(expectedData.isStatus(), resultSet.getBoolean("status"));
        assertEquals(expectedData.getPrice(), resultSet.getInt("price"));
        assertEquals(expectedData.getDescription(), resultSet.getString("description"));

        // Room Number kullanarak ID noyu aldık
//        int roomId = resultSet.getInt("id");
//        System.out.println(roomId);

    }
}
