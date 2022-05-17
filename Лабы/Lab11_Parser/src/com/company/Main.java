package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /* -------------------------------------------------------
    * PARSER RULES
     */

    // <Bool>::= <Term> <Ors>
    // <Ors>::= or <Term> <Ors> | ε
    // <Term>::= <Factor> <Ands>
    // <Ands>::= and <Factor> <Ands> |
    // <Factor>::= IDENT | true | false | (<Bool>)

    public static void main(String[] args) {
	    //String expressionText = "A and (B or D) or false \n and true";
        String expressionText = "(B or C) and true \n or (D or C) and \n ((red and white      or false))";
        //String expressionText = "A or B or true or false or A and R";
        List<Lexeme> lexemes = lexAnalyze(expressionText);
        System.out.println(lexemes);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        System.out.println(Bool(lexemeBuffer));
    }

    public enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_OR, OP_AND,
        IDENT, TRUE, FALSE, EOF;
    }

    public static class Lexeme {
        LexemeType type;
        String value;
        Integer line, column;

        public Lexeme (LexemeType type, Character value, Integer line, Integer column) {
            this.type  = type;
            this.value = value.toString();
            this.line = line;
            this.column = column;
        }

        public Lexeme(LexemeType type, String value, Integer line, Integer column) {
            this.type = type;
            this.value = value;
            this.line = line;
            this.column = column;
        }

        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    ", row=" + line + ", column=" + column +
                    '}' + '\n';
        }
    }

    public static class LexemeBuffer{
        private int pos;

        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }

        public Lexeme current() {
            return lexemes.get(pos);
        }

        public int getPos() {
            return pos;
        }
    }

    public static List<Lexeme> lexAnalyze(String expText) {
        int row = 1, column = 1;
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos < expText.length()) {
            char c = expText.charAt(pos);
            if (c == '(') {
                lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c, row, column));
                pos++;
                column++;
                continue;
            }
            if (c ==  ')') {
                lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c, row, column));
                pos++;
                column++;
                continue;
            }
            if (pos + 1 < expText.length() && expText.startsWith("or", pos)){
                    lexemes.add(new Lexeme(LexemeType.OP_OR, "or", row, column));
                    pos+=2;
                    column += 2;
                    continue;
            }
            if (pos + 2 < expText.length() && expText.startsWith("and", pos)) {
                lexemes.add(new Lexeme(LexemeType.OP_AND, "and", row, column));
                pos += 3;
                column += 3;
                continue;
            }
            if (pos + 3 < expText.length() && expText.startsWith("true", pos)) {
                lexemes.add(new Lexeme(LexemeType.TRUE, "true", row, column));
                pos += 4;
                column += 4;
                continue;
            }
            if (pos + 4 < expText.length() && expText.startsWith("false", pos)) {
                lexemes.add(new Lexeme(LexemeType.FALSE, "false", row, column));
                pos += 5;
                column += 5;
                continue;
            }
                    if (Character.isLetter(c)){
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            column++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (Character.isLetter(c) || Character.isDigit(c));
                        lexemes.add(new Lexeme(LexemeType.IDENT, sb.toString(), row, column));
                    }
                    else if (c == '\n') {
                        row++;
                        pos++;
                        column = 1;
                    }
                    else if (c == ' '){
                        pos++;
                        column++;
                        continue;
                    }
                    else{
                        throw new RuntimeException("Unexpected character: " + c + "\nline: "
                                + row + " column: " + column);
                    }
            }
        lexemes.add(new Lexeme(LexemeType.EOF, "", row, column));
        return lexemes;
    }

    // <Bool>::= <Term> <Ors>
    // <Ors>::= or <Term> <Ors> | ε
    // <Term>::= <Factor> <Ands>
    // <Ands>::= and <Factor> <Ands> |
    // <Factor>::= IDENT | true | false | (<Bool>)

    public static String Bool(LexemeBuffer lexemes) {
        return Term(lexemes) + Ors(lexemes);
    }

    public static String Ors(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.EOF){
          // System.out.println("ors::eof");
            return "<eof> ";
        }
        else if (lexeme.type == LexemeType.RIGHT_BRACKET) {
            lexemes.back();
            return "";
        }
        else if (lexeme.type == LexemeType.OP_OR){
           // System.out.println("ors::full");
            return "or " + Term(lexemes) + Ors(lexemes);
        }
        else{
            throw new RuntimeException("syntax error at (" + lexemes.current().line
                    + ", " + lexemes.current().column + ")");
        }
    }

    public static String Term(LexemeBuffer lexemes) {
        //System.out.println(lexemes.current());
        return Factor(lexemes) + Ands(lexemes);
    }

    public static String Ands(LexemeBuffer lexemes) {
        if (lexemes.current().type != LexemeType.EOF) {
            Lexeme lexeme = lexemes.next();
            if (lexeme.type == LexemeType.OP_AND) {
                return "and " + Factor(lexemes);
            } else {
               // System.out.println("Ands2");
                lexemes.back();
                return "";
            }
        }
        return "";
    }

    public static String Factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.IDENT || lexeme.type == LexemeType.TRUE || lexeme.type == LexemeType.FALSE){
           // System.out.println("factor1");
            return "<Factor> ";
        }
        else if (lexeme.type == LexemeType.LEFT_BRACKET){
            String bool = Bool(lexemes);
            lexeme = lexemes.next();
            if (lexeme.type != LexemeType.RIGHT_BRACKET){
               // System.out.println("true");
                lexemes.back();

                throw new RuntimeException("syntax error at (" + lexemes.current().line
                        + ", " + lexemes.current().column + ")");
            }
            return "( " + bool + " )";
        }
        else {
            throw new RuntimeException("syntax error at (" + lexeme.line
                    + ", " + lexeme.column + ")");
        }
    }

}
