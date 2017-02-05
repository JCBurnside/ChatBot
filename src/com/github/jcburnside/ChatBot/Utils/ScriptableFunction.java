package com.github.jcburnside.ChatBot.Utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

import org.atteo.classindex.IndexAnnotated;
@Inherited
@Target(ElementType.METHOD)
@IndexAnnotated
public @interface ScriptableFunction {

}
