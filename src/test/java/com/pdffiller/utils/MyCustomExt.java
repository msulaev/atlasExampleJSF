package com.pdffiller.utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class MyCustomExt implements TestWatcher
{
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Test successful");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test successful");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Test successful");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.printf("TEST FAILED");
    }
}
