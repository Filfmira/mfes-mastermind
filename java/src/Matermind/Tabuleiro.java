package Matermind;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Tabuleiro {
    public static final Number comprimentoChave = 4L;
    public static Number maxNumeroTentativas = 9L;
    private String chave;
    private VDMSeq tentativas = SeqUtil.seq();

    public Tabuleiro() {
        cg_init_Tabuleiro_1();
    }

    public Tabuleiro(final String chaveP) {
        cg_init_Tabuleiro_2(chaveP);
    }

    public void cg_init_Tabuleiro_1() {
        chave = Cor.gerarSequenciaDeCores(comprimentoChave);
        tentativas = SeqUtil.seq();
    }

    public void cg_init_Tabuleiro_2(final String chaveP) {
        chave = chaveP;
        tentativas = SeqUtil.seq();
    }

    public Number numTentativasRestantes() {
        return maxNumeroTentativas.longValue() - tentativas.size();
    }

    public Number numTentativasFeitas() {
        return tentativas.size();
    }

    public void fazerJogada(final String tentativa) {
        tentativas = SeqUtil.conc(Utils.copy(tentativas), SeqUtil.seq(tentativa));
    }

    public Boolean isChaveEncontrada() {
        return SetUtil.inSet(chave, SeqUtil.elems(Utils.copy(tentativas)));
    }

    public Boolean gameOver() {
        Boolean orResult_4 = false;

        if (isChaveEncontrada()) {
            orResult_4 = true;
        } else {
            orResult_4 = Utils.equals(tentativas.size(), maxNumeroTentativas);
        }

        return orResult_4;
    }

    public Number calcularCoresSitiosCertos(final String tentativa) {
        return numCoresSitioCerto(tentativa, chave);
    }

    public Number calcularCoresSitiosErrados(final String tentativa) {
        Number temp = 0L;

        for (Iterator iterator_20 = Cor.Cores.iterator();
                iterator_20.hasNext();) {
            Character color = (Character) iterator_20.next();
            temp = temp.longValue() +
                Utilities.min(numOcurrencias(chave, color),
                    numOcurrencias(tentativa, color)).longValue();
        }

        return temp.longValue() -
        calcularCoresSitiosCertos(tentativa).longValue();
    }

    public String getChave() {
        return chave;
    }

    public VDMSeq getTentativas() {
        return Utils.copy(tentativas);
    }

    public Number getMaxNumeroTentativas() {
        return maxNumeroTentativas;
    }

    private static <T> Number numCoresSitioCerto(final VDMSeq firstSeq,
        final VDMSeq secondSeq) {
        if (Utils.empty(firstSeq)) {
            return 0L;
        } else {
            if (Utils.equals(((T) firstSeq.get(0)), ((T) secondSeq.get(0)))) {
                return 1L +
                numCoresSitioCerto(SeqUtil.tail(Utils.copy(firstSeq)),
                    SeqUtil.tail(Utils.copy(secondSeq))).longValue();
            } else {
                return numCoresSitioCerto(SeqUtil.tail(Utils.copy(firstSeq)),
                    SeqUtil.tail(Utils.copy(secondSeq)));
            }
        }
    }

    private static <T> Number numOcurrencias(final VDMSeq sequence,
        final T element) {
        if (Utils.empty(sequence)) {
            return 0L;
        } else {
            if (Utils.equals(((T) sequence.get(0)), element)) {
                return 1L +
                numOcurrencias(SeqUtil.tail(Utils.copy(sequence)), element)
                    .longValue();
            } else {
                return numOcurrencias(SeqUtil.tail(Utils.copy(sequence)),
                    element);
            }
        }
    }

    public String toString() {
        return "Tabuleiro{" + "comprimentoChave = " +
        Utils.toString(comprimentoChave) + ", chave := " +
        Utils.toString(chave) + ", tentativas := " +
        Utils.toString(tentativas) + ", maxNumeroTentativas := " +
        Utils.toString(maxNumeroTentativas) + "}";
    }
}
