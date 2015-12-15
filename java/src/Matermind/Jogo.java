package Matermind;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Jogo {
    private VDMMap tabuleiros;

    public Jogo(final VDMMap chaves, final Campeonato campeonato) {
        cg_init_Jogo_1(Utils.copy(chaves), campeonato);
    }

    public Jogo(final VDMMap tabuleirosP) {
        cg_init_Jogo_2(Utils.copy(tabuleirosP));
    }

    public Jogo() {
    }

    public void cg_init_Jogo_1(final VDMMap chaves, final Campeonato campeonato) {
        VDMSeq domMapSeq = SeqUtil.seq();

        for (Iterator iterator_19 = MapUtil.dom(Utils.copy(chaves)).iterator();
                iterator_19.hasNext();) {
            String x = (String) iterator_19.next();
            domMapSeq = SeqUtil.conc(Utils.copy(domMapSeq), SeqUtil.seq(x));
        }

        tabuleiros = MapUtil.map(new Maplet(
                    ((String) Utils.get(domMapSeq, 1L)),
                    new Tabuleiro(
                        ((String) Utils.get(chaves,
                            ((String) Utils.get(domMapSeq, 2L)))))),
                new Maplet(((String) Utils.get(domMapSeq, 2L)),
                    new Tabuleiro(((String) Utils.get(chaves,
                            ((String) Utils.get(domMapSeq, 1L)))))));
    }

    public void cg_init_Jogo_2(final VDMMap tabuleirosP) {
        tabuleiros = Utils.copy(tabuleirosP);
    }

    public VDMMap getTabuleiros() {
        return Utils.copy(tabuleiros);
    }

    public VDMSet getJogadores() {
        return MapUtil.dom(Utils.copy(tabuleiros));
    }

    public Tabuleiro getTabuleiroJogador(final String jogador) {
        return ((Tabuleiro) Utils.get(tabuleiros, jogador));
    }

    public Tabuleiro getTabuleiroAdversario(final String jogador) {
        String adversario = null;
        Boolean success_5 = false;
        VDMSet set_5 = SetUtil.diff(MapUtil.dom(Utils.copy(tabuleiros)),
                SetUtil.set(jogador));

        for (Iterator iterator_5 = set_5.iterator();
                iterator_5.hasNext() && !(success_5);) {
            adversario = ((String) iterator_5.next());
            success_5 = true;
        }

        if (!(success_5)) {
            throw new RuntimeException("Let Be St found no applicable bindings");
        }

        return ((Tabuleiro) Utils.get(tabuleiros, adversario));
    }

    public String toString() {
        return "Jogo{" + "tabuleiros := " + Utils.toString(tabuleiros) + "}";
    }
}
