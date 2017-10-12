import java.lang.annotation.*;

/**
 * Created by 123 on 2017/08/27.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface oneAnno {
    String value() default "123";
}
