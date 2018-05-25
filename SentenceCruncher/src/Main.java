public class Main {
    public static void main(String[] args) {
        String sentences = "Deep episodes of Deep Space Nine came on the television only after the news.\n";
        SentenceCompressor sentenceCompressor = new SentenceCompressor();
        sentenceCompressor.getSentence(sentences);
        sentenceCompressor.getUserSentence();

    }
}
