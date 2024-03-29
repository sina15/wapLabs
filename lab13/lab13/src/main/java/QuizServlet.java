import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="quiz",urlPatterns={"/","/quiz"})

public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        QuizService quizService = QuizService.getQuizServiceInstance();

        HttpSession session = req.getSession();

          System.out.println("in get");

        if (quizService.getEndGame() == true) {

            req.setAttribute("totalQuiz", quizService.getIndex());
            req.getRequestDispatcher("endGame.jsp").forward(req, resp);


        } else {

            if(session.getAttribute("score")==null){
                session.setAttribute("score", "0");
            }


            if(session.getAttribute("question")==null){
                String question = quizService.ChooseQuestion();
                System.out.println("calling question");
                session.setAttribute("question",question);
            }

            req.getRequestDispatcher("startGame.jsp").forward(req, resp);

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if(req.getParameter("result")!=null && req.getParameter("result")!="" ) {

        QuizService quizService = QuizService.getQuizServiceInstance();

        HttpSession session = req.getSession();
        if(session.getAttribute("score")==null){
            session.setAttribute("score", "0");
        }
        int score = Integer.parseInt(session.getAttribute("score").toString());




            int result = Integer.parseInt(req.getParameter("result"));
            boolean isTrue = quizService.checkAnswer(result);

            if (isTrue) {
                score += 1;
                session.setAttribute("score", "" + score + "");
            }

            String question = quizService.ChooseQuestion();
            session.setAttribute("question", question);



        if (quizService.getEndGame() == true) {

            req.setAttribute("totalQuiz", quizService.getIndex());
            req.getRequestDispatcher("endGame.jsp").forward(req, resp);
            req.removeAttribute("question");

        } else {



            req.getRequestDispatcher("startGame.jsp").forward(req, resp);

        }

        }else{
            req.getRequestDispatcher("startGame.jsp").forward(req, resp);
        }
    }
}
