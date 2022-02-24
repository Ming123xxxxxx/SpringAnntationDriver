package conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/15 12:21
 */

//判断是否为Linux系统
public class LinuxCondition implements Condition {

    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        //能获取到环境信息
        Environment environment = conditionContext.getEnvironment();

        String property = environment.getProperty("os.name");

        //若包含linux则返回true,
        if(property.contains("Linux")){
            return true;
        }

        return false;
    }

}
