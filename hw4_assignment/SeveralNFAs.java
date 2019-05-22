import java.util.*;

public class SeveralNFAs{

    // this gets to the epsilon character
    public static char eps = (new Epsilon()).getChar();
    
    //example regex
    public static String evenAoddB = "(aa)*(bb)*b";
    
    /* HOMEWORK
        * This String should be a regex describing
        * all strings that are valid UVA computing ids.
        * A UVA computing ID is formatted as:
        * between 2-3 lowercase letters a-z
        * one digit between 2-9
        * between 1-3 lowercase letters a-z
        *
        * To keep your regex from being too cluttered,
        * we will restrict letters to be a-c and numbers 2-3
    */
    public static String compid;
    
    //use this alphabet for all NFAs below
    public static Set<Character> alphabet = new HashSet<>(Arrays.asList('a', 'g', 't', 'c')); 
    
    /* HOMEWORK
        * Huntington's disease is a trinucleotide repeat disorder.
        * Very often, the human genome has regions where 
        * the same nucleotides repeat many times.
        * Having the incorrect number of such repeats is the cause
        * of many genetic disorders.
        * Huntington's Disease is one such genetic disorder that is
        * caused by having too many copies of the trinucleotide 
        * sequence "cag".
        * An individual with <26 sequential repeats of "cag" in their 
        * genome is considered to be "normal".
        * An individual with between 26 and 35 repeats of "cag" is
        * considered to be a "carrier", and may give the disease
        * to their children.
        * An individual with between 36 and 39 repeats is said to
        * be "at risk", and may or may not ever show symptoms.
        * An individual with 40 or more repeats is said to be
        * "affected", and will eventually show symptoms of the disease.
        
        * This function should take a dna sequence (a string from the alphabet a,g,t,c)
        * and determined the classification for the individual
        * (i.e. normal, carrier, at risk, or affected)
        
        * Your function should operate by defining a regex for each category,
        * converting each to a nfa, then checking which category the given
        * dna sequence falls into.
        * The return value is the classification.
        * Note that the dna sequence may have characters before/after
        * the "cag" repeats.
        
        * source: https://en.wikipedia.org/wiki/Huntington%27s_disease
    */
    public static String huntingtons(String dna){
        return "";
    }
    
    
    /* HOMEWORK
        * For bioinformatics and network transmission, it's helpful 
        * to be able to measure how different various strings are
        * from one another. These metrics are often called string
        * distance. There are various methods from measuring string
        * distance, and which to use mostly depends on what is an
        * allowable change. 
        * For this problem we're asking you to write a function to
        * accept all strings that are within a certain Edit
        * distance (Levenshtein distance) of another string 
        * (the match parameter).
        * The Edit distance between two strings is the smallest
        * number of single-character substitutions, insertions, or
        * deletions that must be made to convert one string into the other.
        *
        * For example, if we invoked this function on:
        * match = "nate"
        * distance = 2
        *
        * The automaton should accept:
        * nate (distance 0, exact match)
        * nater (distance 1, inserting r)
        * ate (distance 1, deleting n)
        * note (distance 1, substituting a->o)
        * ale (distance 2, deleting n and subsituting t->l)
        *
        * The automaton should reject:
        * a (3 deletions required)
        * nono (3 substitutions required)
        * hatred (shortest distance is 3 from subtituting n->h, inserting r and d)
        *
        * To keep your automata from looking too cluttered,
        * we restrict our alphabet to be DNA bases (a,t,g,c).
    */
    public static NFA editDistance(String match, int distance){
        return new NFA();
    }
    
    public static NFA iCharFromEnd(char c, int i){
        // gives a NFA that accepts any string where character c is i away from the end
        // for example, if c = 'g' and i = 4, we should accept aagata, but not agaata
        Set<String> states = new HashSet<String>();
        for(int j = 0; j <= i; j++ ){
            states.add(Integer.toString(j));
        }
        String start = "0";
        Map<Tuple, Set<String>> delta = new HashMap<Tuple, Set<String>>();
        Set<String> finals = new HashSet<String>();
        NFA.addToDelta(delta, start, c, "1"); // add transition from start to second node on c
        NFA.addAllToDelta(delta, start, alphabet, start); // start transitions to itself on entire alphabet
        for(int j = 1; j < i; j++ ){
            // every state transitions to the next on entire alphabet
            NFA.addAllToDelta(delta, Integer.toString(j), alphabet, Integer.toString(j+1));
        }
        finals.add(Integer.toString(i));
        NFA nfa = new NFA(states, alphabet, delta, start, finals);
        return nfa;    
    }


    public static void main(String[]arvs){
        NFAClosure.regex2NFA(evenAoddB).toDot();
        //iCharFromEnd('a',4).toDot();
        //NFAClosure.kleene(nfa).toDot(); // Applying Kleene Start construction
        //NFAClosure.concatenate(iCharFromEnd('a',2), iCharFromEnd('a',3)).toDot(); // Applying concatenation construction
        //NFAClosure.union(iCharFromEnd('a',2), iCharFromEnd('a',3)).toDot(); // Applying union construction
    }
}
