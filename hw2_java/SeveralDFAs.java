import java.util.*;

public class SeveralDFAs{

    public static DFA evenA(){
        /*
        * This is the automaton for the language evenA from class.
        */
        char[] alph = {'a','b'};
        Set<Character> alphabet = new HashSet<Character>();
        for (int i = 0; i < alph.length; i++){
            alphabet.add(alph[i]);
        }
        Set<String> states = new HashSet<String>();
        Set<String> finals = new HashSet<String>();
        Map<Tuple, String> delta = new HashMap<Tuple, String>();
        
        states.add("E"); // We have 2 states: E and O
        states.add("O");
        
        String start = "E"; // The start state is state E
        
        finals.add("E"); // The only final state is state E
        
        delta.put(new Tuple("E",'a'), "O"); // when in state E, transition to state O on input a
        delta.put(new Tuple("E",'b'), "E");
        delta.put(new Tuple("O",'a'), "E");
        delta.put(new Tuple("O",'b'), "O");
        
        return new DFA(states, alphabet, delta, start, finals);
    }
    
    public static DFA tripleA(){
        /*
        * This is the automaton for the language tripleA from class.
        */
        char[] alph = {'a','b'};
        Set<Character> alphabet = new HashSet<Character>();
        for (int i = 0; i < alph.length; i++){
            alphabet.add(alph[i]);
        }
        Set<String> states = new HashSet<String>();
        Set<String> finals = new HashSet<String>();
        Map<Tuple, String> delta = new HashMap<Tuple, String>();
        
        states.add("zero");
        states.add("one");
        states.add("two");
        String start = "zero";
        finals.add("zero");
        delta.put(new Tuple("zero",'a'), "one");
        delta.put(new Tuple("zero",'b'), "zero");
        delta.put(new Tuple("one",'a'), "two");
        delta.put(new Tuple("one",'b'), "one");
        delta.put(new Tuple("two",'a'), "zero");
        delta.put(new Tuple("two",'b'), "two");
        
        return new DFA(states, alphabet, delta, start, finals);
    }
    
    public static DFA tripleAndEvenA(){
        return DFAClosure.intersection(evenA(), tripleA());
    }
    
    public static DFA compId(){
        /* HOMEWORK
        * This function should return a finite state automaton
        * which accepts all strings that are valid UVA computing ids.
        * A UVA computing ID is formatted as:
        * between 2-3 lowercase letters a-z
        * one digit between 2-3
        * between 1-3 lowercase letters a-z
        *
        * To keep your automata from appearing too cluttered,
        * we will restrict letters to be a-c and numbers 2-3
        */
        char[] alph = {'a','b','c','2', '3'};
        Set<Character> alphabet = new HashSet<Character>();
        for (int i = 0; i < alph.length; i++){
            alphabet.add(alph[i]);
        }
        Set<String> states = new HashSet<String>();
        Set<String> finals = new HashSet<String>();
        Map<Tuple, String> delta = new HashMap<Tuple, String>();
        String start;
        states.add("zero");
        states.add("one");
        states.add("two");
        states.add("three");
        states.add("threeA");
        states.add("fourA");
        states.add("four");
        states.add("five");
        states.add("six");
        states.add("seven");
        states.add("trash");
        String start = "zero";
        finals.add("four");
        finals.add("five");
        finals.add("six");
        finals.add("seven");
        finals.add("trash");
        
        delta.put(new Tuple("zero",'a'), "one");
        delta.put(new Tuple("zero",'b'), "one");
        delta.put(new Tuple("zero",'c'), "one");
        
        delta.put(new Tuple("zero",'2'), "trash");
        delta.put(new Tuple("zero",'3'), "trash");
        
        delta.put(new Tuple("one",'a'), "two");
        delta.put(new Tuple("one",'b'), "two");
        delta.put(new Tuple("one",'c'), "two");
        
        delta.put(new Tuple("one",'2'), "trash");
        delta.put(new Tuple("one",'3'), "trash");
        
        delta.put(new Tuple("two",'2'), "three");
        delta.put(new Tuple("two",'3'), "three");
        
        delta.put(new Tuple("two",'a'), "threeA");
        delta.put(new Tuple("two",'b'), "threeA");
        delta.put(new Tuple("two",'c'), "threeA");
        
        delta.put(new Tuple("three",'a'), "four");
        delta.put(new Tuple("three",'b'), "four");
        delta.put(new Tuple("three",'c'), "four");
        
        delta.put(new Tuple("three",'2'), "trash");
        delta.put(new Tuple("three",'3'), "trash");
        
        delta.put(new Tuple("threeA",'2'), "fourA");
        delta.put(new Tuple("threeA",'3'), "fourA");
        
        delta.put(new Tuple("threeA",'a'), "trash");
        delta.put(new Tuple("threeA",'b'), "trash");
        delta.put(new Tuple("threeA",'c'), "trash");
        
        delta.put(new Tuple("four",'a'), "five");
        delta.put(new Tuple("four",'b'), "five");
        delta.put(new Tuple("four",'c'), "five");
        delta.put(new Tuple("fourA",'a'), "five");
        delta.put(new Tuple("fourA",'b'), "five");
        delta.put(new Tuple("fourA",'c'), "five");
        
        delta.put(new Tuple("fourA",'2'), "trash");
        delta.put(new Tuple("fourA",'3'), "trash");
        delta.put(new Tuple("four",'2'), "trash");
        delta.put(new Tuple("four",'3'), "trash");
        
        delta.put(new Tuple("five",'a'), "six");
        delta.put(new Tuple("five",'b'), "six");
        delta.put(new Tuple("five",'c'), "six ");
        
        delta.put(new Tuple("six",'a'), "seven");
        delta.put(new Tuple("six",'b'), "seven");
        delta.put(new Tuple("six",'c'), "seven");
        
        delta.put(new Tuple("six",'2'), "trash");
        delta.put(new Tuple("six",'3'), "trash");
        
        delta.put(new Tuple("zero",'b'), "zero");
        delta.put(new Tuple("one",'a'), "two");
        delta.put(new Tuple("one",'b'), "one");
        delta.put(new Tuple("two",'a'), "zero");
        delta.put(new Tuple("two",'b'), "two");
        
        return new DFA(states, alphabet, delta, start, finals);
        return new DFA();
    }
    
    public static DFA password(){
        /*HOMEWORK
        * This function should return a finite state automaton
        * which checks whether or not the given string is a
        * "valid" password. The allowed characters for our 
        * passwords are {a,b,1,2,?,!}. To be valid, it must
        * satisfy the following rules:
        * It contains at least 2 letters, one number, and one punctuation
        * There are not 3 a's in a row
        * the total length of the string is at least 7 characters
        *
        * To approach this problem, I recommend making automata for each
        * requirement above, then combine them using closure properties.
        */
        return new DFA();
    }
    
    
    public static DFA hammingDistance(String match, int distance){
        /* HOMEWORK
        * For bioinformatics and network transmission, it's helpful 
        * to be able to measure how different various strings are
        * from one another. These metrics are often called string
        * distance. There are various methods from measuring string
        * distance, and which to use mostly depends on what is an
        * allowable change. 
        * For this problem we're asking you to write a function to
        * accept all strings that are within a certain Hamming
        * distance of another string (the match parameter).
        * The Hamming distance between two strings is the smallest
        * number of single-character substitutions that must be 
        * made to convert one string into the other.
        *
        * For example, if we invoked this function on:
        * match = "nate"
        * distance = 2
        *
        * The automaton should accept:
        * nate (distance 0, exact match)
        * gate (distance 1, substituting n->g)
        * note (distance 1, substituting a->o)
        * hath (distance 2, substituting n->h and e->h)
        * pale (distance 2, substituting n->p and t->l)
        *
        * The automaton should reject:
        * math (3 substitutions required)
        * rich (4 substitutions required)
        * naters (cannot be converted by substitution alone)
        *
        * To keep your automata from looking too cluttered,
        * we restrict our alphabet to be DNA bases (a,t,g,c).
        *
        * hint: you code will likely be simpler if you do this with
        * a cross product somewhere, but this is not required.
        */
        char[] alph = {'a','t','g','c'};
        Set<Character> alphabet = new HashSet<Character>();
        for (int i = 0; i < alph.length; i++){
            alphabet.add(alph[i]);
        }
        Set<String> states = new HashSet<String>();
        Set<String> finals = new HashSet<String>();
        Map<Tuple, String> delta = new HashMap<Tuple, String>();
        String start;
        
        return new DFA();
    }
    
    public static void main(String[] args){
        //evenA().toDot(); // remove the comments from these lines separately to see the graph created.
        //tripleA().toDot(); // remove the comments from these lines separately to see the graph created.
        //tripleAndEvenA().toDot();
        System.out.println(tripleAndEvenA().decide("ababaabababb"));
        //hammingDistance("aaaa", 2).toDot();
        //System.out.println(hammingDistance("aaaa", 2).decide("atat")); //Should be true
        //System.out.println(hammingDistance("aaaa", 2).decide("aaat")); //Should be true
        //System.out.println(hammingDistance("aaaa", 2).decide("atgt")); //Should be false
        compID().toDot();
    }
}
