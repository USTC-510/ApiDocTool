package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Author:   周康睿
 * @Description:  为Api文档添加标题
 * @Version:   1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@SuppressWarnings("all")
public @interface Api {
    String value() default "还没有填写哦...";
}
