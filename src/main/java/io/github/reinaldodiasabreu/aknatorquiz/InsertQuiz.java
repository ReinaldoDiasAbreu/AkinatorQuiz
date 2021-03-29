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
            
            Question q1 = new Question("A gestação dos cavalos-marinhos é feita pelos machos.", true);
            Question q2 = new Question("Por causa do tamanho, as girafas ficam o tempo todo em pé e só se deitam quando vão dar à luz.", false);
            Question q3 = new Question("Os ornitorrincos são os únicos mamíferos venenosos que se tem notícia.", false);
            Question q4 = new Question("Os louva-a-deus são capazes de capturar aranhas, lagartos e até ratos.", true);
            Question q5 = new Question("Apesar de serem os mais famosos, os morcegos não são os únicos mamíferos capazes de voar.", false);
            
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
            
            Question q12 = new Question("A sigla LGPD significa Lei Geral de Proteção de Dados", true);
            Question q22 = new Question("Os aplicativos de mensagens não usam criptografia de ponta a ponta.", false);
            Question q32 = new Question("É possível financiar um projeto com a ajuda de tecnologia?", true);
            Question q42 = new Question("Todos os smartphones precisam ter a bateria carregada via cabo USB.", false);
            Question q52 = new Question(" Os assistentes inteligentes nos smartphones não possuem funções que respondem ao comando de voz.", false);
            
            List<Question> questoes2 = new ArrayList<>();
            questoes2.add(q12);
            questoes2.add(q22);
            questoes2.add(q32);
            questoes2.add(q42);
            questoes2.add(q52);
            quiz2.setQuestions(questoes2);
            QuizBean.save(quiz2);
            
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
