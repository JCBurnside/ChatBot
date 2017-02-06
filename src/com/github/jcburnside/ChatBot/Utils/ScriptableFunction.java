package com.github.jcburnside.ChatBot.Utils;

import java.lang.annotation.Inherited;

import org.atteo.classindex.IndexAnnotated;
@Inherited
@IndexAnnotated
public @interface ScriptableFunction {
	String For() default "all";
}
