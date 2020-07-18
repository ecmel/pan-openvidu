package pan;

import javax.inject.Named;
import com.google.inject.Provides;

public class Development extends Common
{
    @Provides
    @Named("httpURI")
    public String provideTestURI()
    {
        return "http://localhost:8080";
    }

    public Development()
    {
        setOpenViduUri("https://localhost:4443");
        setOpenViduPassword("MY_SECRET");
    }
}
