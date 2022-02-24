import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tx.TxConfig;
import tx.UserService;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/23 12:44
 */
public class te {

    @Test
    public void t1(){
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
        applicationContext.close();
    }
}
