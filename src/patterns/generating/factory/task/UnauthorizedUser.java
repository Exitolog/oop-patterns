package patterns.generating.factory.task;


public class UnauthorizedUser implements User {
    private String login;

    @Override
    public User createUser() {
        System.out.println(" You'r sucsesfully registered ");
        return new UnauthorizedUser();
    }
}
