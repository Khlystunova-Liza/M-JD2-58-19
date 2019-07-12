package by.it.academy.maven.impl;

import by.it.academy.maven.StringFunc;

public class LambdaArgumentDemo {
    public static String changeStr(StringFunc stringFunc, String s){
        return stringFunc.func(s);
    }
}
