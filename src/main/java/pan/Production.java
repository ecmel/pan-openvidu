package pan;

public class Production extends Common
{
    public Production(String[] args)
    {
        setOpenViduUri("http://localhost:4443");
        setOpenViduPassword(args[0]);
    }
}
