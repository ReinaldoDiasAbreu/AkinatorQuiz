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

/**
 *
 * @author hal
 */
public class Option {
    private static Long id = 0l;
    
    private Long code;
    private String text;
    private int points;
    private boolean marked;

    public Option(){
        code = ++id;
    }
    
    public Option(String text, int points, boolean marked){
        this();
        this.text = text;
        this.points = points;
        this.marked = marked;
    }
    
    public Long getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public int getPoints() {
        return points;
    }
    
    public boolean getMarked(){
        return marked;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
