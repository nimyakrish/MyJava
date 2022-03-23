package nimya;

import java.lang.reflect.Array;

public class Sports {

	public static void main(String[] args) {
		
		/* INDOOR CHESS OUTDOOR FOOTBALL
		 * 
		 */
		Game chessgame		=new Game("Chess","bla bla",0,2);
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
		TeamMember.addScore(t1[0]);
		TeamMember.addScore(t1[1]);
		TeamMember.addScore(t1[1]);
		chessgame.endGame(t1);
		
		
	}
}
class Game{
	private String gameName;
	private String rules;
	private int lastScore;
	private int noOfTeamMembers;
	private String winner;
	public Game(String gameName, String rules,int lastScore,int noOfTeamMembers) {
		this.gameName = gameName;
		this.rules = rules;
		this.lastScore = lastScore;
		this.noOfTeamMembers = noOfTeamMembers;
		
	}
	private void whoWon(TeamMember[] t1) {
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
	public void endGame(TeamMember[] t) {
		whoWon(t);
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
				+ ", noOfTeamMembers=" + noOfTeamMembers + "]";
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
	
}
class Team extends TeamMember{
	int teamCount;
	private TeamMember teamLeader=new TeamMember();
	private TeamMember[] contestant=new TeamMember[teamCount]; 
	int highScore;
}
class TeamMember{
	
	String contName;
	int contAge;
	int currScore;
	String contGame;
	
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
	public static void addScore(TeamMember teamMember) {
		// TODO Auto-generated method stub
		teamMember.currScore+=1;
		
	}
}
