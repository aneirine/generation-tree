package com.aneirine.generation_tree.logging;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * Handles writing exceptions to the Logger Tab and and utility methods needed
 * to facilitate logging of exceptions
 */
public class ExceptionWriter extends PrintWriter {
    public ExceptionWriter(Writer writer) {
        super(writer);
    }

    private String wrapAroundWithNewlines(String stringWithoutNewlines) {
        return ("\n" + stringWithoutNewlines + "\n");
    }

    public String getExceptionAsString(Throwable throwable) {
        throwable.printStackTrace(this);

        String exception = super.out.toString();

        return (wrapAroundWithNewlines(exception));
    }
}

