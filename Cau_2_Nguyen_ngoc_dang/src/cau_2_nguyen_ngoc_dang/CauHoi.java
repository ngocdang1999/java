/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cau_2_nguyen_ngoc_dang;

/**
 *
 * @author NguyenNgocDang
 */
public class CauHoi {
    public String Question;
    public String Suggestion;
    public String Answer;

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public String getSuggestion() {
        return Suggestion;
    }

    public void setSuggestion(String Suggestion) {
        this.Suggestion = Suggestion;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }
    
    

    public CauHoi(String Question, String Suggestion, String Answer) {
        this.Question = Question;
        this.Suggestion = Suggestion;
        this.Answer = Answer;
    }
    
}
