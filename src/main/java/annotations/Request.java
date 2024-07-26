package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Author:   周康睿
 * @Description:  为Api文档添加请求体参数的名称和类型
 * @Version:   1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("all")
public @interface Request {
    String[] name() default {"无"};
    String[] type() default {"无"};
}
