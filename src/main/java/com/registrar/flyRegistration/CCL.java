package com.registrar.flyRegistration;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class CCL extends ClassLoader
{

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException
    {
        String fileName = "target/classes/" + className.replace('.', File.separatorChar) + ".class";
        if (!new File(fileName).exists())
        {
            log.warn("File {} doesn't exist", fileName);
            return null;
        }
        try (InputStream inputStream = Files.newInputStream(Path.of(fileName)))
        {
            byte[] bytecode = inputStream.readAllBytes();
            return defineClass(className, bytecode, 0, bytecode.length);
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
