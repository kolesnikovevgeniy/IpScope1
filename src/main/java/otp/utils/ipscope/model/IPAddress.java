package otp.utils.ipscope.model;

/**
 * Created by user on 05.08.2016.
 */
import java.util.regex.*;

public class IPAddress {
    private int[] iIpEntrys = new int[4];
    private int iIP;

    public IPAddress()
    {

    }

    public int getIntIP()
    {
        toInt();
        return iIP;
    }

    public int[] getIP()
    {
        return iIpEntrys;
    }

    public boolean set(String stAddr)
    {
        // проверяем адрес
        String pattern = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(stAddr);
        if (m.matches())
        {
            p = p.compile("\\.");
            String[] ip_entrys = p.split(stAddr);
            iIpEntrys[0] = Integer.parseInt(ip_entrys[0]);
            iIpEntrys[1] = Integer.parseInt(ip_entrys[1]);
            iIpEntrys[2] = Integer.parseInt(ip_entrys[2]);
            iIpEntrys[3] = Integer.parseInt(ip_entrys[3]);
            toInt();
            return true;
        }
        return false;
    }
    /**
     *
     * @param addr
     * @return 0 - равно, 1 - addr значение больше, -1 - addr значение меньше
     */
    public int compare(IPAddress addr)
    {
        int comparedIP = addr.getIntIP();
        if (iIP < comparedIP)
        {
            return 1;
        }else if (iIP > comparedIP)
        {
            return -1;
        }
        return 0;
    }

    public void increment()
    {
        toInt();
        iIP++;
        toIP();
    }

    private void toInt()
    {
        iIP = iIpEntrys[0]*256*256*256+iIpEntrys[1]*256*256+iIpEntrys[2]*256+iIpEntrys[3];
    }

    private void toIP()
    {
        iIpEntrys[0]=(int)(iIP/256/256/256);
        iIpEntrys[1]=(int)((iIP-iIpEntrys[0]*256*256*256)/256/256);
        iIpEntrys[2]=(int)((iIP-iIpEntrys[0]*256*256*256-iIpEntrys[1]*256*256)/256);
        iIpEntrys[3]=iIP-iIpEntrys[0]*256*256*256-iIpEntrys[1]*256*256-iIpEntrys[2]*256;
    }

    public String toString()
    {
        return iIpEntrys[0] + "." + iIpEntrys[1] + "." + iIpEntrys[2] + "." +iIpEntrys[3];
    }

}
