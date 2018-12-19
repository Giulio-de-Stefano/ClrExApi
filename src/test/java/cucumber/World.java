package cucumber;

import okhttp3.OkHttpClient;
import okhttp3.Response;

public class World {

    public OkHttpClient client;
    public Response response;

    public World() {
        client = new OkHttpClient();
    }

}


