/**
 * A testing purpose sub-class word WordsList -- reimplements everything.
 */
package Java.project2Reg.src;

public class FakeWordList extends WordsList {
    private String word;

    public FakeWordList(String word) {
        super(null);
        this.word = word;
    }

    @Override
    public String getWord() {
        System.out.println("getWord -- no min/max");
        return word;
    }

    @Override
    public String getWord(int minLength, int maxLength) {
        System.out.println("getWord "+minLength+" to "+maxLength);
        return word;
    }
}
