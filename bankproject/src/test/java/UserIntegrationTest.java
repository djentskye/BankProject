import com.hibernate.Main;
import com.hibernate.entity.User;
import com.hibernate.json.controllers.UserController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertNotNull;

@Category(IntegrationTest.class)
public class UserIntegrationTest {

    private UserController uc;
    private String loginToken;

    @Before
    public void setData() {
        uc = new UserController();
    }

    @After
    public void endProgram() {

    }

    @Test
    public void testLogin() {
        loginToken = String.valueOf(uc.login("dr3", 123456789));
        assertNotNull(loginToken);
    }

    @Test
    public void testShowData() {
        if(loginToken==null) {
            loginToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJiYW5rcHJvamVjdCIsImV4cCI6MTU0OTYxNjk2MCwidXNlcm5hbWUiOiJkcjMiLCJwYXNzbnVtIjoxMjM0NTY3ODl9.etOMpLPGrURh0M3lhd5GpLFecHW1lUwXRlcMRrCj1ic";
        }
//        ResponseEntity<User> data = uc.showData(loginToken);
        ResponseEntity<User> data = uc.showData("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJiYW5rcHJvamVjdCIsImV4cCI6MTU0OTYxNjk2MCwidXNlcm5hbWUiOiJkcjMiLCJwYXNzbnVtIjoxMjM0NTY3ODl9.etOMpLPGrURh0M3lhd5GpLFecHW1lUwXRlcMRrCj1ic");
        assertNotNull(data);
    }
}
