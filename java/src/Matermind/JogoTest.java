package Matermind;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class JogoTest extends MyTestCase {
    public JogoTest() {
    }

    public static void testTodos() {
        IO.println("#######################################");
        IO.println("Testes Jogo:");
        testConstrutor1();
        testGetTabuleiroAdversario();
        testGetTabuleiroJogador();
    }

    public static void testConstrutor1() {
        Tabuleiro tabuleiro1 = new Tabuleiro(new String(
                    new char[] { 'a', 'b', 'c', 'd' }));
        Tabuleiro tabuleiro2 = new Tabuleiro(new String(
                    new char[] { 'f', 'e', 'd', 'c' }));
        Jogo jogo = new Jogo(MapUtil.map(new Maplet("jogador1", tabuleiro1),
                    new Maplet("jogador2", tabuleiro2)));
        assertEqual(2L, jogo.getJogadores().size());
        assertEqual(SetUtil.set("jogador1", "jogador2"), jogo.getJogadores());
        assertEqual(tabuleiro1,
            ((Tabuleiro) Utils.get(jogo.getTabuleiros(), "jogador1")));
        assertEqual(tabuleiro2,
            ((Tabuleiro) Utils.get(jogo.getTabuleiros(), "jogador2")));
        IO.println("Passou testConstrutor1");
    }

    public static void testGetTabuleiroAdversario() {
        Tabuleiro tabuleiro1 = new Tabuleiro(new String(
                    new char[] { 'a', 'b', 'c', 'd' }));
        Tabuleiro tabuleiro2 = new Tabuleiro(new String(
                    new char[] { 'f', 'e', 'd', 'c' }));
        Jogo jogo = new Jogo(MapUtil.map(new Maplet("jogador1", tabuleiro1),
                    new Maplet("jogador2", tabuleiro2)));
        assertEqual(tabuleiro1, jogo.getTabuleiroAdversario("jogador2"));
        assertEqual(tabuleiro2, jogo.getTabuleiroAdversario("jogador1"));
        IO.println("Passou testGetTabuleiroAdversario");
    }

    public static void testGetTabuleiroJogador() {
        Tabuleiro tabuleiro1 = new Tabuleiro(new String(
                    new char[] { 'a', 'b', 'c', 'd' }));
        Tabuleiro tabuleiro2 = new Tabuleiro(new String(
                    new char[] { 'f', 'e', 'd', 'c' }));
        Jogo jogo = new Jogo(MapUtil.map(new Maplet("jogador1", tabuleiro1),
                    new Maplet("jogador2", tabuleiro2)));
        assertEqual(tabuleiro1, jogo.getTabuleiroJogador("jogador1"));
        assertEqual(tabuleiro2, jogo.getTabuleiroJogador("jogador2"));
        IO.println("Passou testGetTabuleiroJogador");
    }

    public String toString() {
        return "JogoTest{}";
    }
}
