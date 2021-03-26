public class App {
    public static void main(String[] args) throws Exception {
        MyClass programm = new MyClass();
        programm.start();
    }
}

public class MyClass {
    public class BowlingTests {
        Game game;
        public void setup(){
        game= new Game(); 
        }
    
        public void rollZeroScoreZero(){
            setup();
            game.roll(4);
            game.roll(1);
            game.roll(7);
            game.roll(1);
            game.roll(0);
            game.roll(0);
            game.roll(3);
            game.roll(3);
            System.out.println(String.valueOf(game.score())+ ">> 0" );
        }
    
        public void openFrameAddsPins(){
            setup();
            game.roll(4);
            game.roll(2);
            assert game.score()==6;

        }
        public void aTenInTwoFramesIsNotASpare(){
            setup();
            game.roll(3);
            game.roll(6);
            game.roll(4);
            game.roll(2);
            System.out.println(String.valueOf("aTenInTwoFramesIsNotASpare  "+game.score())+ ">> 15" );

        // assert game.score()==15;
        }
        public void aStrikeAddsNextTwoBalls() {
            setup();
            game.roll(10);
            game.roll(1);
            game.roll(1);

    
            System.out.println(String.valueOf("aStrikeAddsNextTwoBalls  "+game.score())+ ">> 14" );
        }
        public void perfectGameScoreIs300() {
                    setup();

            game.roll(10);

            game.roll(10);

            game.roll(10);

            game.roll(10);

            game.roll(10);
            game.roll(10);

            game.roll(10);

            game.roll(10);

            game.roll(10);

            game.roll(10);
            game.roll(10);
            game.roll(10);



            
            
        
        
            
    
            System.out.println(String.valueOf("aTenInTwoFramesIsNotASpare  "+game.score())+ ">> 300" );
        }

    }

    public class Game{
        
        int score=0;
        int[] rolled= new int[22]; //20+2 bonus if you get 10 in Frame10
        private int currentBall=0;
        
        public void roll(int pins){

            score+=pins;
            rolled[currentBall]=pins;
            currentBall++;
            if (pins==10&&currentBall<20) {currentBall++;

            }

        }
      
        
        public int score(){
            
            for (int i=0; i<22; i++){
             System.out.println(i+">>"+rolled[i]);
            }
            
            int score=0;
            
            
            for (int i=0; i<22; i++){
                //the fix 
                
                
                if( i%2==0 &&i<20){

                    if (i<20&& rolled[i]==10) //strick
                    {
                     
                         if(rolled[i+2]==10&&i!=18){//if the other is a strick 
                                                         System.out.println(rolled[i+2]+rolled[i+4]+10);

                            score+=(rolled[i+2]+rolled[i+4]);
                        }
                        else if(rolled[i+2]==10&&i==18){
                            
                        }
                        else{
                            score+=(rolled[i+2]+rolled[i+3]);   

                        }
                        
                    }
                     else if (rolled[i]+rolled[i+1]==10) //spare
                     {
                         if(i==18){}
                         else{score+=rolled[i+2];}
                     }
                  
                }
                score+=rolled[i];
                
            }
            
            return score;
            }
    }

  
    void start(){
        BowlingTests bowlingTests=new BowlingTests();
        
       // bowlingTests.rollZeroScoreZero();
       // bowlingTests.openFrameAddsPins();
        bowlingTests.aTenInTwoFramesIsNotASpare();
        bowlingTests.aStrikeAddsNextTwoBalls();
        bowlingTests.perfectGameScoreIs300();
        



        System.out.println("Sum of x+y = " );
    }
    
    
    
}