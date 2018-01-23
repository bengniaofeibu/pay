package com.weichuxing.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
    String funcionExplain() default "";
}
