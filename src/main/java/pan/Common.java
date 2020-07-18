package pan;

import com.google.inject.AbstractModule;
import javax.inject.Singleton;
import com.github.ecmel.router.Router;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Provides;
import org.eclipse.jetty.server.Server;
import io.openvidu.java.client.OpenVidu;

public class Common extends AbstractModule
{
    private String openViduUri;
    private String openViduPassword;

    public void setOpenViduUri(String openViduUri)
    {
        this.openViduUri = openViduUri;
    }

    protected void setOpenViduPassword(String openViduPassword)
    {
        this.openViduPassword = openViduPassword;
    }

    @Provides
    @Singleton
    public GsonBuilder provideGsonBuilder()
    {
        return new GsonBuilder();
    }

    @Provides
    @Singleton
    public Gson provideGson(GsonBuilder gsonBuilder)
    {
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    public Router provideRouter()
    {
        return new Router();
    }

    @Provides
    @Singleton
    public Server provideServer(Router router)
    {
        Server server = new Server(8080);
        server.setHandler(router);
        return server;
    }

    @Provides
    @Singleton
    public OpenVidu provideOpenVidu()
    {
        return new OpenVidu(openViduUri, openViduPassword);
    }
}
