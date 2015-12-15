package Matermind;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class CampeonatoTest extends MyTestCase {
    public CampeonatoTest() {
    }

    public static void testTodos() {
        IO.println("#######################################");
        IO.println("Testes Campeonato:");
        testNovoJogo();
        testTentativasVencedor();
        testAdicionarNovoJogoAleatorio();
        testAdicionarJogadores();
        testGetJogadoresJogos();
        testRankJogador();
    }

    public static void testNovoJogo() {
        Campeonato campeonato = new Campeonato(SetUtil.set("Bandeira", "Mira",
                    "FilipeDeBraga", "Pires"));
        Jogo jogo = campeonato.novoJogo(MapUtil.map(
                    new Maplet("Bandeira",
                        new String(new char[] { 'a', 'b', 'c', 'd' })),
                    new Maplet("Mira",
                        new String(new char[] { 'f', 'e', 'd', 'c' }))));
        assertEqual(1L, campeonato.getJogos().size());
        IO.println("Passou testNovoJogo");
    }

    public static void testTentativasVencedor() {
        Campeonato campeonato = new Campeonato(SetUtil.set("Bandeira", "Mira",
                    "FilipeDeBraga", "Pires"));
        Jogo jogo = campeonato.novoJogo(MapUtil.map(
                    new Maplet("Bandeira",
                        new String(new char[] { 'a', 'b', 'c', 'd' })),
                    new Maplet("Mira",
                        new String(new char[] { 'f', 'e', 'd', 'c' }))));
        Tabuleiro tabuleiro1 = jogo.getTabuleiroJogador("Bandeira");
        Tabuleiro tabuleiro2 = jogo.getTabuleiroJogador("Mira");
        tabuleiro1.fazerJogada(new String(new char[] { 'a', 'b', 'c', 'd' }));
        tabuleiro1.fazerJogada(new String(new char[] { 'd', 'e', 'f', 'f' }));
        tabuleiro1.fazerJogada(new String(new char[] { 'f', 'e', 'd', 'c' }));
        tabuleiro2.fazerJogada(new String(new char[] { 'a', 'b', 'c', 'd' }));
        assertEqual(1L, campeonato.getTentativasVencedor());
        IO.println("Passou testTentativasVencedor");
    }

    public static void testAdicionarNovoJogoAleatorio() {
        Campeonato campeonato = new Campeonato(SetUtil.set("Bandeira", "Mira",
                    "FilipeDeBraga", "Pires"));
        Jogo jogo = campeonato.novoJogoAleatorio("Bandeira", "Mira");
        VDMSet jogadores = SetUtil.set("Bandeira", "Mira");
        assertEqual(1L, campeonato.getJogos().size());
        assertEqual(Utils.copy(jogadores), jogo.getJogadores());
        IO.println("Passou testAdicionarNovoJogoAleatorio");
    }

    public static void testAdicionarJogadores() {
        Campeonato campeonato = new Campeonato(SetUtil.set("Bandeira", "Mira"));
        assertEqual(2L, campeonato.getJogadores().size());
        campeonato.adicionarJogadores(SetUtil.set("FilipeDeBraga", "Pires"));
        assertEqual(4L, campeonato.getJogadores().size());
        IO.println("Passou testAdicionarJogadores");
    }

    public static void testGetJogadoresJogos() {
        Campeonato campeonato = new Campeonato(SetUtil.set("Bandeira", "Mira",
                    "FilipeDeBraga", "Pires"));
        Jogo jogo1 = campeonato.novoJogoAleatorio("Bandeira", "Mira");
        Jogo jogo2 = campeonato.novoJogoAleatorio("FilipeDeBraga", "Pires");
        VDMSet jogadores = SetUtil.set(SetUtil.set("Bandeira", "Mira"),
                SetUtil.set("FilipeDeBraga", "Pires"));
        assertEqual(Utils.copy(jogadores), campeonato.getJogadoresJogos());
        IO.println("Passou testGetEquipasJogos");
    }

    public static void testRankJogador() {
        Campeonato campeonato = new Campeonato(SetUtil.set("Bandeira", "Mira",
                    "FilipeDeBraga", "Pires"));
        Jogo jogo1 = campeonato.novoJogo(MapUtil.map(
                    new Maplet("Bandeira",
                        new String(new char[] { 'a', 'b', 'c', 'd' })),
                    new Maplet("Mira",
                        new String(new char[] { 'f', 'e', 'd', 'c' }))));
        Tabuleiro tabuleiro1 = jogo1.getTabuleiroJogador("Bandeira");
        Tabuleiro tabuleiro2 = jogo1.getTabuleiroJogador("Mira");
        Jogo jogo2 = campeonato.novoJogo(MapUtil.map(
                    new Maplet("FilipeDeBraga",
                        new String(new char[] { 'a', 'b', 'c', 'd' })),
                    new Maplet("Pires",
                        new String(new char[] { 'f', 'e', 'd', 'c' }))));
        Tabuleiro tabuleiro3 = jogo2.getTabuleiroJogador("FilipeDeBraga");
        Tabuleiro tabuleiro4 = jogo2.getTabuleiroJogador("Pires");
        tabuleiro1.fazerJogada(new String(new char[] { 'a', 'b', 'c', 'd' }));
        tabuleiro1.fazerJogada(new String(new char[] { 'd', 'e', 'f', 'f' }));
        tabuleiro1.fazerJogada(new String(new char[] { 'f', 'e', 'd', 'c' }));
        tabuleiro2.fazerJogada(new String(new char[] { 'a', 'b', 'c', 'd' }));
        tabuleiro3.fazerJogada(new String(new char[] { 'a', 'b', 'c', 'd' }));
        tabuleiro3.fazerJogada(new String(new char[] { 'd', 'e', 'f', 'f' }));
        tabuleiro3.fazerJogada(new String(new char[] { 'd', 'e', 'f', 'f' }));
        tabuleiro3.fazerJogada(new String(new char[] { 'f', 'e', 'd', 'c' }));
        tabuleiro4.fazerJogada(new String(new char[] { 'b', 'b', 'c', 'd' }));
        tabuleiro4.fazerJogada(new String(new char[] { 'a', 'b', 'c', 'd' }));
        assertEqual(1L, campeonato.getRankJogador("Mira"));
        assertEqual(2L, campeonato.getRankJogador("Pires"));
        assertEqual(3L, campeonato.getRankJogador("Bandeira"));
        assertEqual(4L, campeonato.getRankJogador("FilipeDeBraga"));
        IO.println("Passou testRankJogador");
    }

    public String toString() {
        return "CampeonatoTest{}";
    }
}
