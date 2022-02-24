package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/19 11:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Human {

    //使用@Value赋值:
    //1.基本数值
    //2.可以写SpEl,#{}
    //3.可以写${},取出配置文件【properties】中的值(在运行的环境变量里的值)

    @Value("${human.name}")
    private String name;
    @Value("${human.age}")
    private int age;
    @Value("${human.nickName}")
    private String nickName;
}
