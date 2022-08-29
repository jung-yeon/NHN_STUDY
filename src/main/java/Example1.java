public class Example1 {
    public static void main(String[] args) {
        String [] words = {"hello","world!"};
        StringBuilder line = new StringBuilder();

        for(String word : words){
            line.append(word);
        }
        System.out.println(line.toString());
    }
}
