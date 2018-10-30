/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 21/07/2011
 */

package br.ufmg.reuso.negocio.carta;

/**
 * @author Michael David
 * Classe que contém constantes usadas nas cartas de conceito e problemas.
 * Constantes utilizadas para inserçãoo de efeitos nos tabuleiros dos jogadores.
 * Elas estão separadas e organizadas por ordem alfabética.
 */

public class CardsConstants 
{
	/** Início das constantes utilizadas para efeitos oriundos de cartas de problema*/
	
	public static final int NO_PROBLEM = 0;										/** Não há problema*/
	
	public static final int ADD_DIFFICULTY_INSPECT_ARTIFACTS = 1;				/** Adiciona dificuldade em inspecionar artefatos*/
	public static final int ADD_DIFFICULTY_REPAIR_ARTIFACTS = 2;				/** Adiciona dificuldade em corrigir artefatos*/
	public static final int ADD_POINTS_IN_COMPLEXITY = 3;						/** Adiciona pontos em complexidade do projeto*/ 
	public static final int ADD_PROJECT_QUALITY = 4;							/** Adiciona um valor de qualidade ao projeto*/
	public static final int ALL_ENGINEERS_LOSE_ARTIFACT = 6;					/** Todos os engenheiros perdem artefato*/
	public static final int ALL_ENGINEERS_LOSE_DESIGN_ARTIFACT = 41;			/** Todos os engenheiros perdem artefato de desenho*/
	public static final int ALL_ENGINEERS_LOSE_TRAIL_ARTIFACT = 7;				/** Todos os engenheiros perdem artefato de rasto*/
	public static final int ALL_ENGINEERS_NO_WORK = 8;							/** Nenhum engenheiro trabalha */
	public static final int ALL_ENGINEERS_NOT_PRODUCE_ARTIFACTS = 22;			/** Nenhum engenheiro produz artefato*/
	public static final int ALL_ENGINEERS_WITH_SKILL_LESS_THAN_2_NOT_INSPECT_ARTIFACTS = 42;	/** Engenheiros com habilidade menor que 2 não inspeciona artefato*/
	public static final int ALL_LOSES_EFFECTS_CONCEPT_CARDS_ON_BOARD = 9; 		/** Todos perdem efeitos existentes de cartas conceito no tabuleiro*/
	public static final int ALL_PLAYERS_WITH_MORE_2_ENGINEERS_DISMISS_ENGINEER = 10; 		/** Todos os jogadoes,com mais de 2 engenheiros, demitem engenheiro*/
	public static final int ALL_PLAYERS_WITH_MORE_3_ENGINEERS_DISMISS_ENGINEER = 5; 		/** Todos os jogadoes,com mais de 3 engenheiros, demitem engenheiro*/
	public static final int CHANGE_WHITE_DESIGN_ARTIFACTS_BY_GRAY_DESIGN_ARTIFACTS = 11; 	/** Trocar cada artefato branco de desenho por artefato cinza*/ 

	public static final int ENGINEER_CHOSEN_IS_ONLY_QUANTITY_CODE_ARTIFACT = 13;		/** Engenheiro escolhido fica somente com uma quantidade de artefato de código*/
	public static final int ENGINEER_CHOSEN_LOSE_ALL_ARTIFACTS = 14;					/** Engenheiro escolhido perde todos artefatos*/
	public static final int ENGINEER_CHOSEN_LOSE_ARTIFACT = 15;							/** Engenheiro escolhido perde artefato*/
	public static final int ENGINEER_CHOSEN_LOSE_CODE_ARTIFACT = 16;					/** Engenheiro escolhido perde artefato de código*/
	public static final int ENGINEER_CHOSEN_NO_WORK = 17;								/** Engenheiro escolhido não trabalha */
	public static final int ENGINEER_CHOSEN_PENALTY_GIVING_OR_RECEIVING_HELP = 18; 		/** Engenheiro escolhido tem penaliade para receber ou dar ajuda*/
	public static final int ENGINEER_CHOSEN_PRODUCE_ONLY_GRAY_ARTIFACTS = 19; 			/** Produz escolhido somente produz artefatos cinzas*/
	public static final int ENGINEER_CHOSEN_PRODUCE_ONLY_WHITE_ARTIFACTS = 20; 			/** Produz escolhido somente produz artefatos brancos*/
	public static final int ENGINEER_CHOSEN_UNEMPLOYMENT_LATER = 21;					/** Engenheiro escolhido é demitido no final da rodada*/
	public static final int ENGINEER_CHOSEN_UNEMPLOYMENT_NOW = 12;						/** Engenheiro escolhido é demitido no início da rodada*/
	
	public static final int LOSE_ALL_ARTIFACTS = 36;							/** Perde todos os artefatos*/
	public static final int LOSE_ALL_CODE_ARTIFACTS = 38;						/** Perde todos os artefatos de código*/
	public static final int LOSE_ALL_GRAY_DESIGN_ARTIFACTS = 43;				/** Perde todos os artefatos cinza de desenho*/
	public static final int LOSE_ALL_GRAY_REQUIREMENTS_ARTIFACTS = 44;			/** Perde todos os artefatos cinza de requisitos*/
	public static final int LOSE_ALL_DESIGN_ARTIFACTS = 23;						/** Perde todos os artefatos de desenho*/
	public static final int LOSE_ALL_REQUIREMENTS_ARTIFACTS = 24;				/** Perde todos os artefatos de requisitos*/
	public static final int LOSE_ARTIFACT = 25;									/** Perde artefato*/
	public static final int LOSE_CODE_ARTIFACT = 26;							/** Perde artefato de código*/
	public static final int LOSE_DESIGN_ARTIFACT = 27;							/** Perde artefato de desenho*/
	public static final int LOSE_HELP_ARTIFACT = 40;							/** Perde artefato de ajuda*/
	public static final int LOSE_REQUIREMENTS_ARTIFACT = 39;					/** Perde artefato de requisitos*/
	public static final int LOSE_HALF_OF_ARTIFACTS = 37; 					    /** Perde metade dos artefatos*/
	public static final int LOSE_HALF_OF_CODE_ARTIFACTS = 28; 					/** Perde metade dos artefatos de código*/
	public static final int LOSE_HALF_OF_DESIGN_ARTIFACTS = 29; 				/** Perde metade dos artefatos de desenho*/
	public static final int LOSE_REQUIREMENTS_ARTIFACTS_FOR_EACH_BUG = 30;		/** Perde artefato de requisitos por cada bug*/
	public static final int LOSE_TRAIL_ARTIFACT = 31;							/** Perde artefato de rastro*/
	public static final int LOWER_MATURITY_ENGINEER_UNEMPLOYMENT = 32;			/** Engenheiro de menor maturidade é demitido*/
	
	public static final int ONLY_INSPECT_ARTIFACTS = 33;						/** Somente inspeciona artefatos*/
	public static final int REDUCTION_IN_BUDGET = 34;							/** Redução no orçamento do projeto*/
	public static final int TABLE_CHOSEN_LOSE_ALL_CODE_ARTIFACT = 35;			/** Mesa escolhida perde todos artefatos de código*/

	
	/** Fim das constantes utilizadas para efeitos oriundos de cartas de problema*/

	
	
	/** Inicio das constantes utilizadas  para condições oriundas de cartas de problema*/

	public static final int UNCONDITIONAL = 0;	
	
	public static final int AFFECTS_ALL_PLAYERS = 132; 			//TODO era 146, vai para 132

	public static final int BUG_IN_ARTIFACTS_GREATER_THAN_1 = 1;
	public static final int BUG_IN_ARTIFACTS_GREATER_THAN_2 = 2;
	public static final int BUG_IN_ARTIFACTS_GREATER_THAN_3 = 3;
	public static final int BUG_IN_ARTIFACTS_GREATER_THAN_4 = 4;
	public static final int BUG_IN_ARTIFACTS_GREATER_THAN_5 = 5;

	public static final int BUG_IN_CODE_ARTIFACTS = 6;
	public static final int BUG_IN_CODE_ARTIFACTS_GREATER_THAN_1 = 7;
	public static final int BUG_IN_CODE_ARTIFACTS_GREATER_THAN_2 = 8;
	public static final int BUG_IN_CODE_ARTIFACTS_GREATER_THAN_3 = 9;
	public static final int BUG_IN_CODE_ARTIFACTS_GREATER_THAN_4 = 10;
	public static final int BUG_IN_CODE_ARTIFACTS_GREATER_THAN_5 = 11;

	public static final int BUG_IN_DESIGN_ARTIFACTS = 12;
	public static final int BUG_IN_DESIGN_ARTIFACTS_GREATER_THAN_1 = 13;
	public static final int BUG_IN_DESIGN_ARTIFACTS_GREATER_THAN_2 = 14; 
	public static final int BUG_IN_DESIGN_ARTIFACTS_GREATER_THAN_3 = 15;
	public static final int BUG_IN_DESIGN_ARTIFACTS_GREATER_THAN_4 = 16;
	public static final int BUG_IN_DESIGN_ARTIFACTS_GREATER_THAN_5 = 17;

	public static final int BUG_IN_REQUIREMENTS_ARTIFACTS = 18;
	public static final int BUG_IN_REQUIREMENTS_ARTIFACTS_GREATER_THAN_1 = 19;
	public static final int BUG_IN_REQUIREMENTS_ARTIFACTS_GREATER_THAN_2 = 20;
	public static final int BUG_IN_REQUIREMENTS_ARTIFACTS_GREATER_THAN_3 = 21;
	public static final int BUG_IN_REQUIREMENTS_ARTIFACTS_GREATER_THAN_4 = 22;
	public static final int BUG_IN_REQUIREMENTS_ARTIFACTS_GREATER_THAN_5 = 23;

	public static final int BUG_IN_TRAIL_ARTIFACTS = 24;
	public static final int BUG_IN_TRAIL_ARTIFACTS_GREATER_THAN_1 = 25;
	public static final int BUG_IN_TRAIL_ARTIFACTS_GREATER_THAN_2 = 26;
	public static final int BUG_IN_TRAIL_ARTIFACTS_GREATER_THAN_3 = 27;
	public static final int BUG_IN_TRAIL_ARTIFACTS_GREATER_THAN_4 = 28;
	public static final int BUG_IN_TRAIL_ARTIFACTS_GREATER_THAN_5 = 29;

	public static final int CODE_GREATER_THAN_1 = 30;
	public static final int CODE_GREATER_THAN_2 = 31;
	public static final int CODE_GREATER_THAN_3 = 32;
	public static final int CODE_GREATER_THAN_4 = 33;
	public static final int CODE_GREATER_THAN_5 = 34;
	
	public static final int CODE_LESS_THAN_1 = 127;
	public static final int CODE_LESS_THAN_2 = 128;
	public static final int CODE_LESS_THAN_3 = 129;
	public static final int CODE_LESS_THAN_4 = 130;
	public static final int CODE_LESS_THAN_5 = 131;

	public static final int DESIGN_GREATER_THAN_1 = 35;
	public static final int DESIGN_GREATER_THAN_2 = 36;
	public static final int DESIGN_GREATER_THAN_3 = 37;
	public static final int DESIGN_GREATER_THAN_4 = 38;
	public static final int DESIGN_GREATER_THAN_5 = 39;

	public static final int DESIGN_LESS_THAN_1 = 40;
	public static final int DESIGN_LESS_THAN_2 = 41;
	public static final int DESIGN_LESS_THAN_3 = 42;
	public static final int DESIGN_LESS_THAN_4 = 43;
	public static final int DESIGN_LESS_THAN_5 = 44;
	public static final int DESIGN_LESS_THAN_6 = 45;
	
	public static final int GREY_REQUIREMENTS_ARTIFACTS_GREATER_THAN_0 = 46;
	public static final int GREY_REQUIREMENTS_ARTIFACTS_GREATER_THAN_1 = 47;
	public static final int GREY_REQUIREMENTS_ARTIFACTS_GREATER_THAN_2 = 48;
	public static final int GREY_REQUIREMENTS_ARTIFACTS_GREATER_THAN_3 = 49;
	public static final int GREY_REQUIREMENTS_ARTIFACTS_GREATER_THAN_4 = 50;
	public static final int GREY_REQUIREMENTS_ARTIFACTS_GREATER_THAN_5 = 51;
	
	public static final int HELP_GREATER_THAN_1 = 121;
	public static final int HELP_GREATER_THAN_2 = 122;
	public static final int HELP_GREATER_THAN_3 = 123;
	public static final int HELP_GREATER_THAN_4 = 124;
	public static final int HELP_GREATER_THAN_5 = 125;
	public static final int HELP_GREATER_THAN_6 = 126;
	
	public static final int HELP_LESS_THAN_1 = 115;
	public static final int HELP_LESS_THAN_2 = 116;
	public static final int HELP_LESS_THAN_3 = 117;
	public static final int HELP_LESS_THAN_4 = 118;
	public static final int HELP_LESS_THAN_5 = 119;
	public static final int HELP_LESS_THAN_6 = 120;
	
	public static final int MATURITY_LESS_THAN_1 = 52;
	public static final int MATURITY_LESS_THAN_2 = 53;
	public static final int MATURITY_LESS_THAN_3 = 54;
	public static final int MATURITY_LESS_THAN_4 = 55;
	public static final int MATURITY_LESS_THAN_5 = 56;
	public static final int MATURITY_LESS_THAN_6 = 57;
	
	public static final int REQUIREMENTS_ARE_NOT_INSPECTED = 58;							
	public static final int REQUIREMENTS_ARE_NOT_INSPECTED_GREATER_THAN_1 = 59;				
	public static final int REQUIREMENTS_ARE_NOT_INSPECTED_GREATER_THAN_2 = 60;				
	public static final int REQUIREMENTS_ARE_NOT_INSPECTED_GREATER_THAN_3 = 61;				
	public static final int REQUIREMENTS_ARE_NOT_INSPECTED_GREATER_THAN_4 = 62;				
	public static final int REQUIREMENTS_ARE_NOT_INSPECTED_GREATER_THAN_5 = 63;				

	public static final int REQUIREMENTS_GREATER_THAN_1 = 110;
	public static final int REQUIREMENTS_GREATER_THAN_2 = 111;
	public static final int REQUIREMENTS_GREATER_THAN_3 = 112;
	public static final int REQUIREMENTS_GREATER_THAN_4 = 113;
	public static final int REQUIREMENTS_GREATER_THAN_5 = 114;
	
	public static final int REQUIREMENTS_LESS_THAN_1 = 64;
	public static final int REQUIREMENTS_LESS_THAN_2 = 65;
	public static final int REQUIREMENTS_LESS_THAN_3 = 66;
	public static final int REQUIREMENTS_LESS_THAN_4 = 67;
	public static final int REQUIREMENTS_LESS_THAN_5 = 68;
	public static final int REQUIREMENTS_LESS_THAN_6 = 133;     //TODO era 145 vai para 133

	public static final int SKILL_ENGINEER_GREATER_THAN_1 = 69;
	public static final int SKILL_ENGINEER_GREATER_THAN_2 = 70;
	public static final int SKILL_ENGINEER_GREATER_THAN_3 = 71;
	public static final int SKILL_ENGINEER_GREATER_THAN_4 = 72;
	public static final int SKILL_ENGINEER_GREATER_THAN_5 = 73;

	public static final int SKILL_ENGINEER_LESS_THAN_1 = 74;
	public static final int SKILL_ENGINEER_LESS_THAN_2 = 75;
	public static final int SKILL_ENGINEER_LESS_THAN_3 = 76;
	public static final int SKILL_ENGINEER_LESS_THAN_4 = 77;
	public static final int SKILL_ENGINEER_LESS_THAN_5 = 78;
	
	public static final int TABLE_WITH_BUG_CODE_ARTIFACTS = 94;	 
	public static final int TABLE_WITH_BUG_TRAIL_ARTIFACTS = 134;	 //TODO era 144 vai para 134
	
	public static final int TABLE_WITH_CODE_LESS_THAN_1 = 79;  
	public static final int TABLE_WITH_CODE_LESS_THAN_2 = 80;  
	public static final int TABLE_WITH_CODE_LESS_THAN_3 = 81;  

	public static final int TABLE_WITH_DESIGN_GREATER_THAN_1 = 82;	 
	public static final int TABLE_WITH_DESIGN_GREATER_THAN_2 = 83;	 
	public static final int TABLE_WITH_DESIGN_GREATER_THAN_3 = 84;	 
	
	public static final int TABLE_WITH_DESIGN_LESS_THAN_1 = 85;  
	public static final int TABLE_WITH_DESIGN_LESS_THAN_2 = 86;  
	public static final int TABLE_WITH_DESIGN_LESS_THAN_3 = 87;  

	public static final int TABLE_WITH_REQUIREMENTS_LESS_THAN_1 = 88;  
	public static final int TABLE_WITH_REQUIREMENTS_LESS_THAN_2 = 89;  
	public static final int TABLE_WITH_REQUIREMENTS_LESS_THAN_3 = 90;  
	
	public static final int TABLE_WITH_TRAILS_LESS_THAN_1 = 91;  
	public static final int TABLE_WITH_TRAILS_LESS_THAN_2 = 92;  
	public static final int TABLE_WITH_TRAILS_LESS_THAN_3 = 93;  

	public static final int TRAIL_GREATER_THAN_1 = 95;
	public static final int TRAIL_GREATER_THAN_2 = 96;
	public static final int TRAIL_GREATER_THAN_3 = 97;
	public static final int TRAIL_GREATER_THAN_4 = 98;
	public static final int TRAIL_GREATER_THAN_5 = 99;

	public static final int TRAIL_LESS_THAN_1 = 100;
	public static final int TRAIL_LESS_THAN_2 = 101;
	public static final int TRAIL_LESS_THAN_3 = 102;
	public static final int TRAIL_LESS_THAN_4 = 103;
	public static final int TRAIL_LESS_THAN_5 = 104;
	
	public static final int TWO_ENGINEERS_MATURITY_LESS_THAN_1 = 105;
	public static final int TWO_ENGINEERS_MATURITY_LESS_THAN_2 = 106;
	public static final int TWO_ENGINEERS_MATURITY_LESS_THAN_3 = 107;
	public static final int TWO_ENGINEERS_MATURITY_LESS_THAN_4 = 108;
	public static final int TWO_ENGINEERS_MATURITY_LESS_THAN_5 = 109;

	/** Fim das constantes utilizadas  para condições oriundas de cartas de problema*/
	
	/** Início das constantes utilizadas para efeitos oriundos de cartas de conceito*/

	
	public static final int NO_BENEFITS = 0;										/** Não há benefício*/

	public static final int BUDGET_INCREASE = 1;									/**Incrementa valor do orçamento*/
	public static final int CHANGE_GRAY_ARTIFACTS_BY_WHITE_ARTIFACTS = 2; 			/** Trocar cada artefatos cinzas por artefatos brancos*/ 

	public static final int ENGINEER_CHOSEN_INSPECT_FREE_ARTIFACTS = 10;			/**Engenheiro escolhido inspeciona artefatos gratuitamente*/
	public static final int ENGINNER_CHOSEN_RECEIVE_HELP_ARTIFACTS = 3;				/**Engenheiro escolhido recebe artefato de ajuda*/
	public static final int ENGINNER_CHOSEN_RECEIVE_MATURITY_POINTS_NOW = 4; 		/**Engenheiro escolhido recebe pontos em maturidade, nessa rodada*/
	public static final int ENGINNER_CHOSEN_RECEIVE_REQUIREMENTS_ARTIFACTS = 5;		/**Engenheiro escolhido recebe artefato de requisitos*/
	public static final int ENGINNER_CHOSEN_RECEIVE_SKILL_POINTS_LATER = 6; 		/**Engenheiro escolhido recebe pontos em habilidade na próxima rodada*/
	public static final int ENGINNER_CHOSEN_RECEIVE_SKILL_POINTS_NOW = 7; 			/**Engenheiro escolhido recebe pontos em habilidade, nessa rodada*/
	public static final int ENGINNER_CHOSEN_RECEIVE_TRAIL_ARTIFACTS = 8;			/**Engenheiro escolhido recebe artefato de rastro*/
	public static final int ENGINNER_CHOSEN_RECEIVE_WHITE_ARTIFACT = 9; 			/**Engenheiro escolhido recebe artefato branco*/
	public static final int ENGINNER_CHOSEN_RECEIVE_WHITE_CODE_ARTIFACT = 19; 		/**Engenheiro escolhido recebe artefato de código branco*/
	
	public static final int TWO_ENGINNERS_CHOSEN_RECEIVE_DESIGN_ARTIFACTS = 11;		/** 2 Engenheiros escolhidos recebem artefato de desenho*/
	public static final int TWO_ENGINNERS_CHOSEN_RECEIVE_TRAIL_ARTIFACTS = 12;		/** 2 Engenheiros escolhidos recebem artefato de rastro*/

	public static final int	UNIZING_COMPONENT_NOW = 13;								/**Imunizar componente nessa rodada*/
	public static final int	UNIZING_COMPONENT_VALIDATION_PHASE = 14;				/**Imunizar componente na fase de validação.*/
	public static final int	UNIZING_HELP_ARTIFACTS_VALIDATION_PHASE = 15;			/**Imunizar artefatos de ajuda na fase de validação.*/
	public static final int UNIZING_PROBLEM_CARD_RELATED_CODE = 16;					/**Neutraliza carta de problema relacionada é artefatos de código*/ /*TODO*/ //- usou e acabou né?
	public static final int UNIZING_PROBLEM_CARD_RELATED_REQUIREMENTS = 17;			/**Neutraliza carta de problema relacionada é artefatos de requisitos*/ /*TODO*/ //- usou e acabou n�?
	public static final int UNIZING_PROBLEM_CARD_RELATED_TRAILSS = 18;				/**Neutraliza carta de problema relacionada é artefatos de rastros*/ /*TODO*/ //- usou e acabou né?
	
	/** Fim das constantes utilizadas para efeitos oriundos de cartas de conceito*/



}
