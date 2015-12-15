package Matermind;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Utilities {
    public Utilities() {
    }

    public static Number min(final Number a, final Number b) {
        if (a.longValue() <= b.longValue()) {
            return a;
        } else {
            return b;
        }
    }

    public String toString() {
        return "Utilities{}";
    }
}
