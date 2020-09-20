package com.example.jpetstore.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.example.jpetstore.controller.Auth.Role;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface CheckPage {
	public enum Role {ADMIN}
	
	public Role role() default Role.ADMIN;
}
