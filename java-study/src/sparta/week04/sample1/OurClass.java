package sparta.week04.sample1;

public class OurClass {

    private final boolean just = true;

    public void thisMethodIsDangerous() throws OurBadException {

        if (just) {
            throw new OurBadException();
        }
    }

}
