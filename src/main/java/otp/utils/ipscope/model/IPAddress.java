package otp.utils.ipscope.model;

/**
 * Created by user on 05.08.2016.
 */
import java.util.regex.*;

public class IPAddress {

    private long iIP;

    public IPAddress()
    {

    }

    //возвращаем значение адреса
    public long getIntIP()
    {
        return iIP;
    }

    // проверяем и задаем значение адреса
    public boolean set(String stAddr)
    {
        // проверяем адрес
        String pattern = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        // разбиваем на паттерны
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(stAddr);
        if (m.matches())
        {
            p = p.compile("\\.");
            String[] ip_entrys = p.split(stAddr);
            // переводим в long
            iIP = Long.parseLong(ip_entrys[0])*256*256*256+Long.parseLong(ip_entrys[1])*256*256+Long.parseLong(ip_entrys[2])*256+Long.parseLong(ip_entrys[3]);
            return true;
        }
        return false;
    }

    // увеличиваем на 1 адрес
    public void increment()
    {
        iIP++;
    }

    // выводим в виде строки
    public String toString()
    {
        long[] iIpEntrys = new long[4];
        iIpEntrys[0]=(long)(iIP/256/256/256);
        iIpEntrys[1]=(long)((iIP-iIpEntrys[0]*256*256*256)/256/256);
        iIpEntrys[2]=(long)((iIP-iIpEntrys[0]*256*256*256-iIpEntrys[1]*256*256)/256);
        iIpEntrys[3]=iIP-iIpEntrys[0]*256*256*256-iIpEntrys[1]*256*256-iIpEntrys[2]*256;

        return iIpEntrys[0] + "." + iIpEntrys[1] + "." + iIpEntrys[2] + "." +iIpEntrys[3];
    }

}
