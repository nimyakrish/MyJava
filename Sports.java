package nimya;

import java.lang.reflect.Array;

public class Sports {

	public static void main(String[] args) {
		
		/* INDOOR CHESS OUTDOOR KABADI
		 * 
		 */
		Game chessgame		=new Game("Chess","bla bla",0,false);
		System.out.println("Game Details "+chessgame);
		IndoorGame chess	=new IndoorGame();
		TeamMember[] t1		=new TeamMember[2];
		t1[0]				=new TeamMember("Nimya",34,0,"Chess");
		t1[1]				=new TeamMember("Kamal",44,0,"Chess");
		System.out.println("Contestants.....");
		System.out.println(" "+t1[0]);
		System.out.println(" "+t1[1]);
		chess.setIndoorGame(231,"SADGURU PALACE","RAO UPENDRA",t1,chessgame);
		System.out.println("Arrangement Details....");
		System.out.println(chess);
		chessgame.startGame();
		t1[0].addScore();
		t1[1].addScore();
		t1[1].addScore();
		chessgame.whoWon(t1);
		chessgame.endGame();
		
		//////KABADI
		Game kabadiGame		=new Game("Kabadi","bla bla",0,true);
		System.out.println("Game Details "+kabadiGame);
		OutdoorGame kabadi	=new OutdoorGame();
		kabadi.setLandmark("Jewel of Navi Mumbai");
		kabadi.setReferee("Kishore Kumar");
		kabadi.setScoreBoradOfficial("Williams");
		kabadi.getOutdoorGame();
		System.out.println("Contestants.....");
		
		TeamMember[] kt1	=new TeamMember[8];
		Team abc				= new Team();
		abc.setTeamCount(7);
		abc.setTeamLeader(kt1[5]);
		abc.setTeamName("Cubs");
		abc.setTeampersons(kt1);
		abc.addTeamDetails("Kabadi",kt1);		
		
		TeamMember[] kt2	=new TeamMember[8];
		Team xyz			= new Team();
		xyz.setTeamCount(7);
		xyz.setTeamLeader(kt2[2]);
		xyz.setTeamName("BullBulls");
		xyz.setTeampersons(kt2);
		xyz.addTeamDetails("Kabadi",kt2);
		
		kabadiGame.startGame();
		abc.addTeamScore();
		kt1[6].addScore();
		xyz.addTeamScore();
		kt2[0].addScore();
		
		abc.addTeamScore();
		kt1[1].addScore();
		kabadiGame.whoWonTeam(abc, xyz);
		kabadiGame.endGame();
		
		
	}
}
class Game {
	private String gameName;
	private String rules;
	private int lastScore;
	boolean isTeamPlay;
	private String winner;
	
	public Game(String gameName, String rules,int lastScore,boolean isTeamPlay) {
		this.gameName = gameName;
		this.rules = rules;
		this.lastScore = lastScore;
		this.isTeamPlay = isTeamPlay;
		
	}
	public void whoWon(TeamMember[] t1) {
		// TODO Auto-generated method stub
		int count	= Array.getLength(t1);
		int no,i;
		for(i=0;i<count;i++) {
			if(lastScore<=t1[i].currScore) {
				lastScore=t1[i].currScore;
				winner	=t1[i].contName;
			}else {
				lastScore=t1[i].currScore;
				winner	=t1[i].contName;

			}
			System.out.println(t1[i].contName+" : "+t1[i].currScore+"");
		}
		
		System.out.println(winner+" wins the game with "+lastScore+" Point!!");
	}
	
	public void whoWonTeam(Team t1,Team t2) {
		// TODO Auto-generated method stub
			System.out.println(t1.getTeamName()+" : "+t1.currTeamScore+"");
			System.out.println(t2.getTeamName()+" : "+t2.currTeamScore+"");
			if(lastScore<=t1.currTeamScore) {
				lastScore=t1.currTeamScore;
				winner	=t1.getTeamName();
				
			}else {
				lastScore=t2.currTeamScore;
				winner	=t2.getTeamName();
			}
			
	
		System.out.println(winner+" wins the game with "+lastScore+" Point!!");
	}
	public void endGame() {
		// TODO Auto-generated method stub
		System.out.println("CONGRATS THE WINNER!!");
		
	}
	
	public void startGame() {
		// TODO Auto-generated method stub
		System.out.println("Game Started!!! ALL THE BEST!!");
	}
	Game(){
		
	}
	@Override
	public String toString() {
		return "Game [gamename=" + gameName + ", rules=" + rules + ", score=" + lastScore
				+ ", isTeamPlay=" + isTeamPlay + "]";
	}
	
	

	

}
class IndoorGame extends Game{
	int RooomNo;
	String buildingName;
	String scoreBoradOfficial;
	public IndoorGame() {
		
	}
	public void setIndoorGame(int rooomNo, String buildingName, String scoreBoradOfficial,TeamMember[] contestants,Game xyz) {
		this.RooomNo = rooomNo;
		this.buildingName = buildingName;
		this.scoreBoradOfficial = scoreBoradOfficial;
		
		
	}
	@Override
	public String toString() {
		return "IndoorGame [RooomNo=" + RooomNo + ", buildingName=" + buildingName + ", scoreBoradOfficial="
				+ scoreBoradOfficial + "]";
	}
	
	
	
	
}
class OutdoorGame extends Game{
	String landmark;
	String scoreBoradOfficial;
	String referee;
	public void getOutdoorGame() {
		System.out.println("Arrangement Details...");
		System.out.println("Landmark 				:"+this.landmark);
		System.out.println("Score Borad Official 	:"+this.scoreBoradOfficial);
		System.out.println("Referee					: "+this.referee);
		
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public void setScoreBoradOfficial(String scoreBoradOfficial) {
		this.scoreBoradOfficial = scoreBoradOfficial;
	}
	public void setReferee(String referee) {
		this.referee = referee;
	}
	
	
}
class TeamMember{
	
	String contName;
	int contAge;
	int currScore;
	String contGame;
	TeamMember(){
		
	}
	public TeamMember(String contName, int contAge, int currScore, String contGame) {
		super();
		this.contName = contName;
		this.contAge = contAge;
		this.currScore = currScore;
		this.contGame = contGame;
		
	}
	@Override
	public String toString() {
		return "TeamMember [contName=" + contName + ", contAge=" + contAge + ", currScore=" + currScore
				+ ", contGame=" + contGame + "]";
	}
	public void addScore() {
		// TODO Auto-generated method stub
		currScore+=1;
		
	}
}
class Team extends TeamMember{
	private int teamCount;
	private String teamName;
	TeamMember[] teampersons;
	TeamMember teamLeader;
	int currTeamScore=0;
	Team(){}
	public int getTeamCount() {
		return teamCount;
	}
	public void addTeamScore() {
		// TODO Auto-generated method stub
		currTeamScore+=1;
		
	}
	public void addTeamDetails(String gameName, TeamMember[] kt1) {
		// TODO Auto-generated method stub
		System.out.println("Team :"+this.teamName);
		int count	=Array.getLength(kt1);
		for(int i=0;i<count;i++) {
			kt1[i] =new TeamMember(this.teamName+" "+(i+1), 15, 0, gameName);
			System.out.println(" "+kt1[i]);
		}
	}
	public void setTeamCount(int teamCount) {
		this.teamCount = teamCount;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public TeamMember[] getTeampersons() {
		return teampersons;
	}
	public void setTeampersons(TeamMember[] teampersons) {
		this.teampersons = teampersons;
	}
	public TeamMember getTeamLeader() {
		return teamLeader;
	}
	public void setTeamLeader(TeamMember teamLeader) {
		this.teamLeader = teamLeader;
	}
	
}
