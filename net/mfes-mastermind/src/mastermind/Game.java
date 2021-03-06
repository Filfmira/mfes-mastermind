package mastermind;

//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at Sun 27-Nov-2011 by the VDM++ to JAVA Code Generator
// (v8.0 - Mon 09-Jul-2007 09:32:40)
//
// Supported compilers:
// jdk1.4
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
import jp.co.csk.vdm.toolbox.VDM.jdk.*;
// ***** VDMTOOLS END Name=imports



public class Game implements EvaluatePP {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=gameInstances KEEP=NO
  private volatile HashMap gameInstances = new HashMap();
// ***** VDMTOOLS END Name=gameInstances

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=GameSentinel KEEP=NO
  class GameSentinel extends Sentinel {

    public final int Game = 0;

    public final int getParticipantTeams = 1;

    public final int getBoardPlayedByTeam = 2;

    public final int getBoardPlayedByOpponent = 3;

    public final int nr_functions = 4;


    public GameSentinel () throws CGException {}


    public GameSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=GameSentinel
;

// ***** VDMTOOLS START Name=evaluatePP KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return new Boolean(true);
  }
// ***** VDMTOOLS END Name=evaluatePP


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new GameSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=Game KEEP=NO
  public Game () throws CGException {
    try {
      setSentinel();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=Game


// ***** VDMTOOLS START Name=Game KEEP=NO
  public Game (final HashMap teamsSolutions, final Championship championship) throws CGException {

    try {
      setSentinel();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    if (!this.pre_Game(teamsSolutions, championship).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in Game");
    {

      boolean succ_3;
      HashSet tmpVal_4 = new HashSet();
      tmpVal_4.clear();
      tmpVal_4.addAll(teamsSolutions.keySet());
      String team1 = null;
      String team2 = null;
      succ_3 = true;
      boolean succ_set_v_9 = false;
      if ((tmpVal_4 instanceof HashSet)) {

        HashSet tmpvarExpr_10 = (HashSet) tmpVal_4;
        if (tmpvarExpr_10.size() == 2) {

          Vector valSeq_6 = new Vector();
          for (Iterator enm_12 = tmpvarExpr_10.iterator(); enm_12.hasNext(); ) {

            String e_11 = UTIL.ConvertToString(enm_12.next());
            valSeq_6.add(e_11);
          }
          HashSet permSL_7 = UTIL.Permute(valSeq_6);
          for (Iterator enm_13 = permSL_7.iterator(); enm_13.hasNext() && !succ_set_v_9; ) {

            Vector perm_8 = (Vector) UTIL.ConvertToList(enm_13.next());
            if (succ_set_v_9 = 2 == perm_8.size()) {

              team1 = UTIL.ConvertToString(perm_8.get(0));
              team2 = UTIL.ConvertToString(perm_8.get(2 - 1));
            }
          }
        }
        else 
          succ_set_v_9 = false;
      }
      else 
        succ_set_v_9 = false;
      if (!succ_set_v_9) 
        succ_3 = false;
      if (!succ_3) 
        UTIL.RunTime("Run-Time Error:Pattern match did not succeed in value definition");
      HashMap rhs_14 = new HashMap();
      rhs_14 = new HashMap();
      rhs_14.put(team1, new Board((Vector) UTIL.ConvertToList(teamsSolutions.get(team2))));
      rhs_14.put(team2, new Board((Vector) UTIL.ConvertToList(teamsSolutions.get(team1))));
      gameInstances = (HashMap) UTIL.clone(rhs_14);
    }
  }
// ***** VDMTOOLS END Name=Game


// ***** VDMTOOLS START Name=pre_Game KEEP=NO
  public Boolean pre_Game (final HashMap teamsSolutions, final Championship championship) throws CGException {

    Boolean varRes_3 = null;
    Boolean var1_4 = null;
    Integer var1_5 = null;
    HashSet unArg_6 = new HashSet();
    unArg_6.clear();
    unArg_6.addAll(teamsSolutions.keySet());
    var1_5 = new Integer(unArg_6.size());
    var1_4 = new Boolean(var1_5.intValue() == new Integer(2).intValue());
    {
      if ((varRes_3 = var1_4).booleanValue()) {

        Boolean var2_9 = null;
        boolean tmpQuant_10 = true;
        {

          HashSet e_set_27 = new HashSet();
          e_set_27.clear();
          e_set_27.addAll(teamsSolutions.keySet());
          String team = null;
          {
            for (Iterator enm_30 = e_set_27.iterator(); enm_30.hasNext() && tmpQuant_10; ) {

              String elem_29 = UTIL.ConvertToString(enm_30.next());
              team = elem_29;
              Boolean pred_11 = null;
              Boolean var1_12 = null;
              HashSet var2_14 = new HashSet();
              var2_14 = championship.getTeams();
              var1_12 = new Boolean(var2_14.contains(team));
              {
                if ((pred_11 = var1_12).booleanValue()) {

                  Boolean var2_15 = null;
                  boolean tmpQuant_16 = true;
                  {

                    HashSet e_set_22 = new HashSet();
                    e_set_22.clear();
                    e_set_22.addAll(teamsSolutions.values());
                    Vector solution = null;
                    {
                      for (Iterator enm_25 = e_set_22.iterator(); enm_25.hasNext() && tmpQuant_16; ) {

                        Vector elem_24 = (Vector) UTIL.ConvertToList(enm_25.next());
                        solution = elem_24;
                        if (new Boolean(new Integer(solution.size()).intValue() == Board.attemptLength.intValue()).booleanValue()) {}
                        else 
                          tmpQuant_16 = false;
                      }
                    }
                  }
                  var2_15 = new Boolean(tmpQuant_16);
                  pred_11 = var2_15;
                }
              }
              if (pred_11.booleanValue()) {}
              else 
                tmpQuant_10 = false;
            }
          }
        }
        var2_9 = new Boolean(tmpQuant_10);
        varRes_3 = var2_9;
      }
    }
    return varRes_3;
  }
// ***** VDMTOOLS END Name=pre_Game


// ***** VDMTOOLS START Name=getParticipantTeams KEEP=NO
  public HashSet getParticipantTeams () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).getParticipantTeams);
    try {

      HashSet rexpr_1 = new HashSet();
      rexpr_1.clear();
      rexpr_1.addAll(gameInstances.keySet());
      return rexpr_1;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getParticipantTeams);
    }
  }
// ***** VDMTOOLS END Name=getParticipantTeams


// ***** VDMTOOLS START Name=getBoardPlayedByTeam KEEP=NO
  public Board getBoardPlayedByTeam (final String team) throws CGException {

    sentinel.entering(((GameSentinel) sentinel).getBoardPlayedByTeam);
    try {
      return (Board) (Board) gameInstances.get(team);
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getBoardPlayedByTeam);
    }
  }
// ***** VDMTOOLS END Name=getBoardPlayedByTeam


// ***** VDMTOOLS START Name=getBoardPlayedByOpponent KEEP=NO
  public Board getBoardPlayedByOpponent (final String team) throws CGException {

    if (!this.pre_getBoardPlayedByOpponent(team).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in getBoardPlayedByOpponent");
    sentinel.entering(((GameSentinel) sentinel).getBoardPlayedByOpponent);
    try {

      HashSet tmpSet_2 = new HashSet();
      HashSet var1_6 = new HashSet();
      var1_6.clear();
      var1_6.addAll(gameInstances.keySet());
      HashSet var2_8 = new HashSet();
      var2_8 = new HashSet();
      var2_8.add(team);
      tmpSet_2 = (HashSet) var1_6.clone();
      tmpSet_2.removeAll(var2_8);
      String opponent = null;
      boolean succ_4 = false;
      for (Iterator enm_10 = tmpSet_2.iterator(); enm_10.hasNext() && !succ_4; ) {

        String tmpElem_5 = UTIL.ConvertToString(enm_10.next());
        succ_4 = true;
        opponent = tmpElem_5;
      }
      if (!succ_4) 
        UTIL.RunTime("Run-Time Error:The binding environment was empty");
      return (Board) (Board) gameInstances.get(opponent);
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getBoardPlayedByOpponent);
    }
  }
// ***** VDMTOOLS END Name=getBoardPlayedByOpponent


// ***** VDMTOOLS START Name=pre_getBoardPlayedByOpponent KEEP=NO
  public Boolean pre_getBoardPlayedByOpponent (final String team) throws CGException {

    Boolean varRes_2 = null;
    HashSet var2_4 = new HashSet();
    var2_4.clear();
    var2_4.addAll(gameInstances.keySet());
    varRes_2 = new Boolean(var2_4.contains(team));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_getBoardPlayedByOpponent

}
;
