package Matermind;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Cor {
    public static VDMSet Cores = SetUtil.set('a', 'b', 'c', 'd', 'e', 'f');

    public Cor() {
    }

    public static String gerarSequenciaDeCores(final Number tamanho) {
        if (Utils.equals(tamanho, 1L)) {
            return new String(new char[] { corAleatoria() });
        } else {
            return new String(new char[] { corAleatoria() }) +
            gerarSequenciaDeCores(tamanho.longValue() - 1L);
        }
    }

    private static Character corAleatoria() {
        String coresSet = new String(new char[] { 'a', 'b', 'c', 'd', 'e', 'f' });

        return coresSet.charAt(Utils.index(MATH.rand(6L).longValue() + 1L));
    }

    public String toString() {
        return "Cor{" + "Cores := " + Utils.toString(Cores) + "}";
    }
}
