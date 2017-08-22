package log;

import java.lang.annotation.*;

/**
 * Created by 123 on 2017/08/18.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String desc() default "没有标准描述";

    boolean view() default true;

    String operationDesc() default "没有默认描述";
}

