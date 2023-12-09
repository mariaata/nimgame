import java.util.Random;
public class Game{
   
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;

    Random r = new Random();

    public Game(int difficulty){
        this.marbles = r.nextInt(91)+10;
        computerPlayer = new Computer(difficulty);
        humanPlayer = new Human();
    }

    public void play(){
        System.out.println("Amount of marbles to start:" + this.marbles);
        int randomTurn = r.nextInt(2);
        while(marbles>1){
        if (randomTurn==0){
            System.out.println ("Computer moves.");
            computerPlayer.move(marbles);
            int computerChoice = computerPlayer.getChoice();
            System.out.println ("Computer choice:" + computerChoice);
            marbles = marbles - computerChoice;
            System.out.println ("The amount of marbles left:" + marbles);
            randomTurn = 1;  
        }
            else if(randomTurn==1){
                System.out.println("Human moves.");
                humanPlayer.move();
                int humanChoice = humanPlayer.getChoice();
                    while (humanChoice > marbles/2){
                        System.out.println ("Enter another number.");
                        humanPlayer.move();
                        humanChoice = humanPlayer.getChoice();
                    }
                //check if humanChoice valid
                // if not, print another number 
                //humanchoice has to be less than marbles/2   
                marbles = marbles - humanChoice;
                System.out.println("The amount of marbles left:" + marbles);
                randomTurn= 0;
            }
        }

            if (randomTurn == 1){
                System.out.println("Human wins.");
            } else if (randomTurn == 0){
                System.out.println("Computer wins.");
            }
    }
}
    // you may wish to add more methods here

