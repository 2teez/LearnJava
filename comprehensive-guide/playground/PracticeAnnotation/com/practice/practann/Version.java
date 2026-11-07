package com.practice.practann;

public @interface Version {
    int major() default 0;

    int minor() default 0;
}
