package Matermind;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class TabuleiroTest extends MyTestCase {
    public TabuleiroTest() {
    }

    public static void testTodos() {
        IO.println("#######################################");
        IO.println("Testes Tabuleiro:");
        testConstrutor1();
        testConstrutor2();
        testTentativa1();
        testTentativa2();
        testTentativa3();
        testCoresSitiosCertos();
        testCoresSitiosErrados();
        testGetMaxNumTentativas();
    }

    public static void testConstrutor1() {
        Tabuleiro tabuleiro = new Tabuleiro();
        Number tamanho = 4L;
        assertEqual(tamanho, tabuleiro.getChave().length());
        tamanho = 0L;
        assertEqual(tamanho, tabuleiro.getTentativas().size());
        IO.println("Passou testConstrutor1");
    }

    public static void testConstrutor2() {
        Tabuleiro tabuleiro = new Tabuleiro(new String(
                    new char[] { 'a', 'b', 'c', 'd' }));
        Number tamanho = 4L;
        assertEqual(tamanho, tabuleiro.getChave().length());
        tamanho = 0L;
        assertEqual(tamanho, tabuleiro.getTentativas().size());
        assertEqual(new String(new char[] { 'a', 'b', 'c', 'd' }),
            tabuleiro.getChave());
        IO.println("Passou testConstrutor2");
    }

    public static void testTentativa1() {
        Tabuleiro tabuleiro = new Tabuleiro(new String(
                    new char[] { 'd', 'c', 'b', 'a' }));
        Number numTentativasRestantes = 9L;
        Number numTentativasFeitas = 0L;
        assertEqual(numTentativasRestantes, tabuleiro.numTentativasRestantes());
        assertEqual(numTentativasFeitas, tabuleiro.numTentativasFeitas());
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'a' }));
        numTentativasRestantes = 8L;
        numTentativasFeitas = 1L;
        assertEqual(numTentativasRestantes, tabuleiro.numTentativasRestantes());
        assertEqual(numTentativasFeitas, tabuleiro.numTentativasFeitas());
        IO.println("Passou testTentativa1");
    }

    public static void testTentativa2() {
        Tabuleiro tabuleiro = new Tabuleiro(new String(
                    new char[] { 'd', 'c', 'b', 'a' }));
        Number numTentativasRestantes = 9L;
        Number numTentativasFeitas = 0L;
        assertEqual(numTentativasRestantes, tabuleiro.numTentativasRestantes());
        assertEqual(numTentativasFeitas, tabuleiro.numTentativasFeitas());
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        numTentativasRestantes = 8L;
        numTentativasFeitas = 1L;
        assertEqual(numTentativasRestantes, tabuleiro.numTentativasRestantes());
        assertEqual(numTentativasFeitas, tabuleiro.numTentativasFeitas());
        assertEqual(false, tabuleiro.isChaveEncontrada());
        assertEqual(false, tabuleiro.gameOver());
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'a' }));
        numTentativasRestantes = 7L;
        numTentativasFeitas = 2L;
        assertEqual(numTentativasRestantes, tabuleiro.numTentativasRestantes());
        assertEqual(numTentativasFeitas, tabuleiro.numTentativasFeitas());
        assertEqual(true, tabuleiro.isChaveEncontrada());
        assertEqual(true, tabuleiro.gameOver());
        IO.println("Passou testTentativa2");
    }

    public static void testTentativa3() {
        Tabuleiro tabuleiro = new Tabuleiro(new String(
                    new char[] { 'd', 'c', 'b', 'a' }));
        Number numTentativasRestantes = 9L;
        Number numTentativasFeitas = 0L;
        assertEqual(numTentativasRestantes, tabuleiro.numTentativasRestantes());
        assertEqual(numTentativasFeitas, tabuleiro.numTentativasFeitas());
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        numTentativasRestantes = 1L;
        numTentativasFeitas = 8L;
        assertEqual(numTentativasRestantes, tabuleiro.numTentativasRestantes());
        assertEqual(numTentativasFeitas, tabuleiro.numTentativasFeitas());
        assertEqual(false, tabuleiro.isChaveEncontrada());
        assertEqual(false, tabuleiro.gameOver());
        tabuleiro.fazerJogada(new String(new char[] { 'd', 'c', 'b', 'b' }));
        numTentativasRestantes = 0L;
        numTentativasFeitas = 9L;
        assertEqual(numTentativasRestantes, tabuleiro.numTentativasRestantes());
        assertEqual(numTentativasFeitas, tabuleiro.numTentativasFeitas());
        assertEqual(false, tabuleiro.isChaveEncontrada());
        assertEqual(true, tabuleiro.gameOver());
        IO.println("Passou testTentativa3");
    }

    public static void testCoresSitiosCertos() {
        Tabuleiro tabuleiro = new Tabuleiro(new String(
                    new char[] { 'd', 'c', 'b', 'a' }));
        assertEqual(3L,
            tabuleiro.calcularCoresSitiosCertos(
                new String(new char[] { 'd', 'f', 'b', 'a' })));
        IO.println("Passou testCoresSitiosCertos");
    }

    public static void testCoresSitiosErrados() {
        Tabuleiro tabuleiro = new Tabuleiro(new String(
                    new char[] { 'd', 'c', 'b', 'a' }));
        assertEqual(2L,
            tabuleiro.calcularCoresSitiosErrados(
                new String(new char[] { 'd', 'f', 'a', 'b' })));
        IO.println("Passou testCoresSitiosErrados");
    }

    public static void testGetMaxNumTentativas() {
        Tabuleiro tabuleiro = new Tabuleiro(new String(
                    new char[] { 'd', 'c', 'b', 'a' }));
        assertEqual(9L, tabuleiro.getMaxNumeroTentativas());
        IO.println("Passou testMaxNumTentativas");
    }

    public String toString() {
        return "TabuleiroTest{}";
    }
}
