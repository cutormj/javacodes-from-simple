package account;
public class Account {

    private String username;
    private String password;

    private Account(AccountBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class AccountBuilder {
        private String username;
        private String password;

        public AccountBuilder() {}

        public AccountBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
