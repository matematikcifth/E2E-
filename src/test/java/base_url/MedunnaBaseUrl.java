package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.AuthenticationMedunna.generateToken;

public class MedunnaBaseUrl {
    public static RequestSpecification spec;
    // Testi çalıştırdığımızda spec objesinin null gelmemesi için setup() metodunun çalıştırılması gerekir.
    // Cucumber'da her testten önce çalıştırmak istediğimiz metotları Hooks class'ı içerisine ekleriz.
    //Hooks class'ini farkli bir package da olusturmak istersek Runner class'indaki glue parametresine bu
    //    package'i tanimlamamiz gerekir.
    //  //Olusturdugumuz Hooks classini glue kisminda tanimlamamiz gerekir. glue da birden fazla eleman olursa basina
    //  sonuna {  } yazip sonuna virgul koyuyorduk
    public static void setUp(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://medunna.com")
                .addHeader("Authorization", "Bearer " + generateToken())
                .setContentType(ContentType.JSON)//post islemlerind kullanmak icin get islemleri icin gerek yok
                .build();
    }
}
