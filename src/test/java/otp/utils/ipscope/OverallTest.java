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

        // проверяем правильность проверки по маске
        assertTrue("Неправильная работа проверки IP адреса", ipaddr.set("256.300.300.300"));
        assertTrue("Неправильная работа проверки IP адреса", !ipaddr.set("192.168.1.0000"));

        /*PhoneBook pb = new PhoneBook();
        ArrayList<String> result = pb.searchPhone("");
        assertNull("Значений в базе быть не должно", result);

        result = pb.searchPhone("Иванов И.И.");
        assertNotNull("Отсутствует значения в базе для ключа Иванов И.И.", result);
        assertTrue("Неверное количество записей для Иванов И.И.!", result.size() == 2);

        result = pb.searchPhone("Петров П.П.");
        assertNotNull("Отсутствует значения в базе для ключа Петров П.П.", result);
        assertTrue("Неверное количество записей для Петров П.П.!", result.size() == 1);

        result = pb.searchPhone("Сидоров С.С.");
        assertNotNull("Отсутствует значения в базе для ключа Сидоров С.С.", result);
        assertTrue("Неверное количество записей для Сидоров С.С.!", result.size() == 3);*/
    }
}
