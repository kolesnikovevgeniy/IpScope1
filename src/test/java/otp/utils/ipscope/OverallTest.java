package otp.utils.ipscope;

/**
 * Created by user on 31.08.2016.
 */
import org.junit.Test;
import org.junit.Ignore;
import otp.utils.ipscope.model.IPAddress;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class OverallTest {

    @Test
    public void CheckIPAddress() {
        IPAddress ipaddr = new IPAddress();

        // проверяем правильность проверки по паттерну
        assertTrue("Неправильная работа проверки IP адреса, при подстановке неправильного адреса set() возвращает true", !ipaddr.set("356.300.300.300"));
        assertTrue("Неправильная работа проверки IP адреса, при подстановке правильного адреса set() возвращает false", ipaddr.set("192.168.1.000"));

        // проверяем работу инкремента
        long lIP = ipaddr.getLongIP();
        ipaddr.increment();
        long lIP2 = ipaddr.getLongIP();
        assertTrue("Неправильная работа функции increment()", lIP != lIP2);
     }
}
