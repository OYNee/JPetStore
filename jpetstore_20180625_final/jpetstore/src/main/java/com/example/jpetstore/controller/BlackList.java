package com.example.jpetstore.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface BlackList {
	public enum Role {ADMIN}
	
	public Role role() default Role.ADMIN;
}
