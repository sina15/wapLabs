public class QuizService {



       private Quiz quiz;
       private int index;
       private  boolean endGame;


       private static QuizService quizServiceInstance=null;



       private QuizService(){

           quiz = new Quiz();
           endGame = false;
           index =-1;


       }

       public  boolean getEndGame(){
           return endGame;
       }

    public static QuizService getQuizServiceInstance() {

           if(quizServiceInstance==null){
               quizServiceInstance = new QuizService();
           }
        return quizServiceInstance;
    }



    public String ChooseQuestion() {


            index += 1;

            if (index+1 == quiz.getQuestions().length ){
                endGame = true;


            }

        return quiz.getQuestions()[index];

    }





    public boolean checkAnswer( Integer ans){

        if(quiz.getAnswers()[index]==ans){
            return true;
        }else{
            return false;
        }

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

