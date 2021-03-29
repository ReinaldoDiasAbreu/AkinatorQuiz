/*
 * The MIT License
 *
 * Copyright 2021 hal.
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hal
 */
@Entity
@Table(name="TblQuiz")
public class Quiz implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String titleEN;
    @Column(length = 250, nullable = false)
    private String descriptionEN;
    @Column(length = 100, nullable = false)
    private String titlePT;
    @Column(length = 250, nullable = false)
    private String descriptionPT;
    
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true    
    )
    @JoinColumn(name = "quiz_id")
    private List<Question> questions;

    public Quiz(){ 
        questions = new ArrayList<>();
    }
    
    public Quiz(String titleEN, String descriptionEN, String titlePT, String descriptionPT){
        this();
        this.titleEN = titleEN;
        this.descriptionEN = descriptionEN;
        this.titlePT = titlePT;
        this.descriptionPT = descriptionPT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleEN() {
        return titleEN;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }
    
    public String getTitlePT() {
        return titlePT;
    }

    public String getDescriptionPT() {
        return descriptionPT;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setTitlePT(String title) {
        this.titlePT = title;
    }

    public void setDescriptionPT(String description) {
        this.descriptionPT = description;
    }
    
    public void setTitleEN(String title) {
        this.titleEN = title;
    }

    public void setDescriptionEN(String description) {
        this.descriptionEN = description;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    public int getTotalScore(){
        int score = 0;
        
        for(Question q: questions)
            score += q.getScore();
        
        return score;
    }

    @Override
    public String toString() {
        return "Quiz{" + "id=" + id + ", title=" + titleEN + ", description=" + descriptionEN + ", questions=" + questions + '}';
    }
    
    
}
