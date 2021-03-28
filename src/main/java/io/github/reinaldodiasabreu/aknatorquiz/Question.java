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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author hal
 */
public class Question {
    private static Long id = 0L;
    
    private Long code;
    private HashMap<String, String> text;
    private boolean answer;

    public Question(){
        code = ++id;
    }
    
    
    public Long getCode() {
        return code;
    }

    public String getText(String lang) {
        return text.get(lang);
    }
    
    public boolean getAnswer(){
        return this.answer;
    }


    public void setCode(Long code) {
        this.code = code;
    }

    public void setText(String lang, String text) {
        this.text.put(lang, text);
    }

    public void setAnswer(boolean answer){
        this.answer = answer;
    }

}
