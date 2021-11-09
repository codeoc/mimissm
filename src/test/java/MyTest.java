import com.bjpowernode.utils.MD5Util;
import org.junit.Test;


public class MyTest {
    @Test
     public void testmd5() {

        String miPwd = MD5Util.getMD5("0000");
        System.out.println(miPwd);
    }
}
