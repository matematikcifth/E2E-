package hooks;

import io.cucumber.java.Before;

import static base_url.MedunnaBaseUrl.setUp;

public class Hooks {
    @Before
    public void beforeApi(){
        setUp();
    }
}
