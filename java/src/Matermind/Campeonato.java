package Matermind;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Campeonato {
    private VDMSet jogadores;
    private VDMSet jogos = SetUtil.set();

    public Campeonato(final VDMSet eqs) {
        cg_init_Campeonato_1(Utils.copy(eqs));
    }

    public Campeonato() {
    }

    public void cg_init_Campeonato_1(final VDMSet eqs) {
        jogadores = Utils.copy(eqs);
    }

    public VDMSet getJogadores() {
        return Utils.copy(jogadores);
    }

    public VDMSet getJogos() {
        return Utils.copy(jogos);
    }

    public Jogo novoJogoAleatorio(final String jog1, final String jog2) {
        Jogo jogo = new Jogo(MapUtil.map(
                    new Maplet(jog1,
                        Cor.gerarSequenciaDeCores(Tabuleiro.comprimentoChave)),
                    new Maplet(jog2,
                        Cor.gerarSequenciaDeCores(Tabuleiro.comprimentoChave))),
                this);
        jogos = SetUtil.union(Utils.copy(jogos), SetUtil.set(jogo));

        return jogo;
    }

    public Jogo novoJogo(final VDMMap chaves) {
        Jogo g = new Jogo(Utils.copy(chaves), this);
        jogos = SetUtil.union(Utils.copy(jogos), SetUtil.set(g));

        return g;
    }

    public void adicionarJogadores(final VDMSet eqs) {
        jogadores = SetUtil.union(Utils.copy(jogadores), Utils.copy(eqs));
    }

    public Number getPontuacao(final String jogador) {
        VDMSet jogosFeitos = jogosJogador(jogador);
        Number score = 0L;

        for (Iterator iterator_12 = getTabuleirosJogados(Utils.copy(jogosFeitos),
                    jogador).iterator(); iterator_12.hasNext();) {
            Tabuleiro tabuleiro = (Tabuleiro) iterator_12.next();
            score = (score.longValue() +
                Tabuleiro.maxNumeroTentativas.longValue()) -
                tabuleiro.getTentativas().size();
        }

        return score;
    }

    public Number getRankJogador(final String jogador) {
        VDMMap pontuacoes = getPontuacoes();
        Number numMelhores = 0L;

        for (Iterator iterator_13 = jogadores.iterator();
                iterator_13.hasNext();) {
            String jog = (String) iterator_13.next();

            if (((Number) Utils.get(pontuacoes, jog)).longValue() > ((Number) Utils.get(
                        pontuacoes, jogador)).longValue()) {
                numMelhores = numMelhores.longValue() + 1L;
            }
        }

        numMelhores = numMelhores.longValue() + 1L;

        return numMelhores;
    }

    public VDMSeq getTabuleirosJogados(final VDMSet jogos_1,
        final String jogador) {
        VDMSeq ret = SeqUtil.seq();

        for (Iterator iterator_14 = jogos_1.iterator(); iterator_14.hasNext();) {
            Jogo jogo = (Jogo) iterator_14.next();
            ret = SeqUtil.conc(SeqUtil.seq(jogo.getTabuleiroJogador(jogador)),
                    Utils.copy(ret));
        }

        return Utils.copy(ret);
    }

    public VDMSet getJogadoresJogos() {
        VDMSet setCompResult_1 = SetUtil.set();
        VDMSet set_7 = Utils.copy(jogos);

        for (Iterator iterator_7 = set_7.iterator(); iterator_7.hasNext();) {
            Jogo jogo = ((Jogo) iterator_7.next());
            setCompResult_1 = SetUtil.union(Utils.copy(setCompResult_1),
                    SetUtil.set(jogo.getJogadores()));
        }

        return Utils.copy(setCompResult_1);
    }

    public VDMSet jogosJogador(final String jogador) {
        VDMSet setCompResult_2 = SetUtil.set();
        VDMSet set_9 = Utils.copy(jogos);

        for (Iterator iterator_9 = set_9.iterator(); iterator_9.hasNext();) {
            Jogo jogo = ((Jogo) iterator_9.next());

            if (SetUtil.inSet(jogador, jogo.getJogadores())) {
                setCompResult_2 = SetUtil.union(Utils.copy(setCompResult_2),
                        SetUtil.set(jogo));
            }
        }

        return Utils.copy(setCompResult_2);
    }

    public Number getTentativasVencedor() {
        VDMMap pontuacoes = getPontuacoes();
        VDMMap vencedor = maximumValue(Utils.copy(pontuacoes));

        {
            String x = null;
            Boolean success_1 = false;
            VDMSet set_1 = MapUtil.dom(Utils.copy(vencedor));

            for (Iterator iterator_1 = set_1.iterator();
                    iterator_1.hasNext() && !(success_1);) {
                x = ((String) iterator_1.next());
                success_1 = true;
            }

            if (!(success_1)) {
                throw new RuntimeException(
                    "Let Be St found no applicable bindings");
            }

            return getTentativasJogador(x);
        }
    }

    public VDMMap getPontuacoes() {
        VDMMap mapCompResult_1 = MapUtil.map();
        VDMSet set_10 = Utils.copy(jogadores);

        for (Iterator iterator_10 = set_10.iterator(); iterator_10.hasNext();) {
            String jogador = ((String) iterator_10.next());
            mapCompResult_1 = MapUtil.munion(Utils.copy(mapCompResult_1),
                    MapUtil.map(new Maplet(jogador, getPontuacao(jogador))));
        }

        return Utils.copy(mapCompResult_1);
    }

    public Number getTentativasJogador(final String jogador) {
        Number numTentativas = 0L;

        {
            Jogo jogo = null;
            Boolean success_2 = false;
            VDMSet set_2 = jogosJogador(jogador);

            for (Iterator iterator_2 = set_2.iterator();
                    iterator_2.hasNext() && !(success_2);) {
                jogo = ((Jogo) iterator_2.next());
                success_2 = true;
            }

            if (!(success_2)) {
                throw new RuntimeException(
                    "Let Be St found no applicable bindings");
            }

            numTentativas = numTentativas.longValue() +
                jogo.getTabuleiroJogador(jogador).numTentativasFeitas()
                    .longValue();
        }

        return numTentativas;
    }

    private VDMMap maximumValue(final VDMMap mapa) {
        if (Utils.equals(MapUtil.dom(Utils.copy(mapa)).size(), 1L)) {
            return Utils.copy(mapa);
        } else {
            String x = null;
            Boolean success_3 = false;
            VDMSet set_3 = MapUtil.dom(Utils.copy(mapa));

            for (Iterator iterator_3 = set_3.iterator();
                    iterator_3.hasNext() && !(success_3);) {
                x = ((String) iterator_3.next());
                success_3 = true;
            }

            if (!(success_3)) {
                throw new RuntimeException(
                    "Let Be St found no applicable bindings");
            }

            {
                VDMMap max = maximumValue(MapUtil.domResBy(SetUtil.set(x),
                            Utils.copy(mapa)));

                {
                    Number y = null;
                    Boolean success_4 = false;
                    VDMSet set_4 = MapUtil.rng(Utils.copy(max));

                    for (Iterator iterator_4 = set_4.iterator();
                            iterator_4.hasNext() && !(success_4);) {
                        y = ((Number) iterator_4.next());
                        success_4 = true;
                    }

                    if (!(success_4)) {
                        throw new RuntimeException(
                            "Let Be St found no applicable bindings");
                    }

                    if (((Number) Utils.get(mapa, x)).longValue() > y.longValue()) {
                        return MapUtil.map(new Maplet(x,
                                ((Number) Utils.get(mapa, x))));
                    } else {
                        return Utils.copy(max);
                    }
                }
            }
        }
    }

    public String toString() {
        return "Campeonato{" + "jogadores := " + Utils.toString(jogadores) +
        ", jogos := " + Utils.toString(jogos) + "}";
    }
}
