package ecg_irl;

abstract public class Room {
	
	protected Professor professor;
	protected Trivia trivia;
	
	public Room(Professor profName, Trivia triviaQuiz){
		professor = profName;
		trivia = triviaQuiz;
	}
}
