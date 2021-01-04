package com.registrar;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CCL extends ClassLoader
{
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException
    {
        String fileName = "target/classes" + className.replace('.', File.separatorChar) + ".class";
        byte[] bytecode = new byte[0];
        try (InputStream inputStream = Files.newInputStream(Path.of(fileName)))
        {
            bytecode = inputStream.readAllBytes();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return defineClass(className, bytecode, 0, bytecode.length);
    }
}
