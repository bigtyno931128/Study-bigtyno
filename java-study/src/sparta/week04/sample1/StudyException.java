package sparta.week04.sample1;

public class StudyException {

    public static void main(String[] args) throws OurBadException {

        OurClass ourClass = new OurClass();

        // try ~ catch ~ finally
        try  {
            ourClass.thisMethodIsDangerous();
        } catch (OurBadException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("우리는 방금 예외를 핸들링 완료 했다");
        }

    }
}
