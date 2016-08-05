package otp.utils.ipscope.model;

/**
 * Created by user on 05.08.2016.
 */
import java.util.regex.*;

public class IPAddress {
    public int first;
    public int second;
    public int third;
    public int fourth;
    private int[] iIpEntrys = new int[4];

    public IPAddress()
    {

    }

    public int[] getIP()
    {
        return iIpEntrys;
    }

    public boolean set(String stAddr)
    {
        System.out.println("IP set");
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

            this.first = Integer.parseInt(ip_entrys[0]);
            this.second = Integer.parseInt(ip_entrys[1]);
            this.third = Integer.parseInt(ip_entrys[2]);
            this.fourth = Integer.parseInt(ip_entrys[3]);
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
        for(int i = 0; i < 4; i++)
        {
            if (this.iIpEntrys[i] < addr.getIP()[i])
            {
                return 1;
            }
            else if (this.iIpEntrys[i] > addr.getIP()[i])
            {
                return -1;
            }
        }
        return 0;
    }

    public void increment()
    {
        //boolean next_dis = true;
        for(int i = 3; i >= 0; i--)
        {
            if (iIpEntrys[i] == 255)
            {
                iIpEntrys[i] = 0;
            }
            else
            {
                iIpEntrys[i]++;
                return;
            }
        }
    }

    public String toString()
    {
        return iIpEntrys[0] + "." + iIpEntrys[1] + "." + iIpEntrys[2] + "." +iIpEntrys[3];
    }

}
