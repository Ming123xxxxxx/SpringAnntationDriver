package conditional;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/12/16 10:23
 */
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值就是导入容器中的组件全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    //此方法不能返回null,否则报NullPointerException
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"controller.BookController"};
    }

}
