package cucumber.stepdefs;

import cucumber.World;
import cucumber.api.java8.En;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import static org.testng.Assert.assertEquals;

public class Login implements En {

    public Login(World world) {

        When("^I attempt to login with invalid credentials$", () -> {
            String loginUrl = "https://api.clearscore.com/caesium-api/users/signIn";
            String badCredentials = "{\"email\":\"wrong_email@google.com\",\"password\":\"wrong_password\"}";
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");

            RequestBody body = RequestBody.create(JSON, badCredentials);

            Request request = new Request.Builder()
                    .url(loginUrl)
                    .header("Content-Type", "application/json")
                    .post(body)
                    .build();

            world.response = world.client.newCall(request).execute();
        });

        Then("^the status code received is (\\d+)$", (Integer expStatusCode) -> {
            assertEquals((Integer) world.response.code(), expStatusCode);
        });
    }


}
