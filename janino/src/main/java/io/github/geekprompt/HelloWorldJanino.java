package io.github.geekprompt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ClassBodyEvaluator;

public class HelloWorldJanino {

    public static void main(String[] args) throws CompileException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String codeString = "public static void main(String[] args) {" +
                            "   System.out.println(\"Hello World!\" );" +
                            "}";

        // Compile the class body, and get the loaded class
        Class<?> cl = new ClassBodyEvaluator(codeString).getClazz();

        // Invoke the "public static main(String[])" method
        Method mainMeth = cl.getMethod("main", String[].class);

        mainMeth.invoke(null, new Object[]{new String[]{}});
    }
}
