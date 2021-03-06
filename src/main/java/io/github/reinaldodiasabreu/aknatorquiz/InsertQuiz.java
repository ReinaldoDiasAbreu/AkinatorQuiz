/*
 * The MIT License
 *
 * Copyright 2021 Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.github.reinaldodiasabreu.aknatorquiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 *
 * @author Reinaldo Junio Dias de Abreu <rjdda at aluno.ifnmg.edu.br>
 */
@WebServlet(name = "ServletQuizInsert", urlPatterns = {"/InsertQuiz"})
@Transactional
public class InsertQuiz extends HttpServlet {
    
    @Inject
    QuizBeanLocal QuizBean;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* ########### Quiz Natureza ###########*/
            Quiz quiz1 = new Quiz("Nature", "Test your knowledge of nature.", "Natureza", "Teste seus conhecimentos sobre a natureza.");
            
            Question q1 = new Question("A gesta????o dos cavalos-marinhos ?? feita pelos machos.", true);
            Question q2 = new Question("Por causa do tamanho, as girafas ficam o tempo todo em p?? e s?? se deitam quando v??o dar ?? luz.", false);
            Question q3 = new Question("Os ornitorrincos s??o os ??nicos mam??feros venenosos que se tem not??cia.", false);
            Question q4 = new Question("Os louva-a-deus s??o capazes de capturar aranhas, lagartos e at?? ratos.", true);
            Question q5 = new Question("Apesar de serem os mais famosos, os morcegos n??o s??o os ??nicos mam??feros capazes de voar.", false);
            
            List<Question> questoes = new ArrayList<>();
            questoes.add(q1);
            questoes.add(q2);
            questoes.add(q3);
            questoes.add(q4);
            questoes.add(q5);
            quiz1.setQuestions(questoes);
            QuizBean.save(quiz1);
            
            /* ########### Quiz Tenologia ###########*/
            Quiz quiz2 = new Quiz("Technology", "Test your knowledge of technology.", "Tecnologia", "Teste seus conhecimentos sobre tecnologia.");
            
            Question q12 = new Question("A sigla LGPD significa Lei Geral de Prote????o de Dados", true);
            Question q22 = new Question("Os aplicativos de mensagens n??o usam criptografia de ponta a ponta.", false);
            Question q32 = new Question("?? poss??vel financiar um projeto com a ajuda de tecnologia?", true);
            Question q42 = new Question("Todos os smartphones precisam ter a bateria carregada via cabo USB.", false);
            Question q52 = new Question(" Os assistentes inteligentes nos smartphones n??o possuem fun????es que respondem ao comando de voz.", false);
            
            List<Question> questoes2 = new ArrayList<>();
            questoes2.add(q12);
            questoes2.add(q22);
            questoes2.add(q32);
            questoes2.add(q42);
            questoes2.add(q52);
            quiz2.setQuestions(questoes2);
            QuizBean.save(quiz2);
            
            /* ########### Quiz Anatomia ###########  */
            
            Quiz quiz3 = new Quiz("Anatomy test", "What do you know about the human body?", "Teste sobre anatomia", "O que voc?? sabe sobre anatomia?");
            
            List<Question> questoes3 = new ArrayList<>();
            questoes3.add(new Question("Unhas humanas n??o servem para escalar paredes.",true));
            questoes3.add(new Question("O ombro humano ?? adaptado para resistir a choques de carros desgovernados.",false));
            questoes3.add(new Question("N??o ?? uma boa id??ia lamber postes gelados.",true));
            questoes3.add(new Question("A l??ngua ?? um m??sculo.",true));
            questoes3.add(new Question("Sobrancelhas s?? crescem se voc?? rap??-las.",true));
            quiz3.setQuestions(questoes3);
            QuizBean.save(quiz3);
            
            /* ########### Quiz Natureza ###########  */
            
            Quiz quiz4 = new Quiz("Anatomy test", "What do you know about the human body?", "Teste sobre anatomia", "O que voc?? sabe sobre anatomia?");
            
            List<Question> questoes4 = new ArrayList<>();
            questoes3.add(new Question("Se fingir de morto ao afundar faz a ??gua achar que voc?? est?? morto e deixar que voc?? flutue de volta.",false));
            questoes3.add(new Question("Lascas de granito s??o uma ??tima fonte de prote??na.",false));
            questoes3.add(new Question("Abelhas se comunicam via LSA, ou L??nguagem de Sinais Ap??cola.",false));
            questoes3.add(new Question("Le??s s??o extremamente competitivos no boliche.",false));
            questoes3.add(new Question("N??o ?? uma boa ideia enviar sinais de domin??ncia na frente de um gorila.",true));
            quiz4.setQuestions(questoes4);
            QuizBean.save(quiz4);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Akinator Quiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Akinator Quiz</h3>");
            out.println("<p>Quiz Adicionado!</>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
