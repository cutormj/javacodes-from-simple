package user;

import account.Account;
import person.Person;
import user.type.UserType;

public class User {

    private Person person;
    private UserType userType;

    private Account account;

    private User(UserBuilder builder) {
        this.person = builder.person;
        this.userType = builder.userType;
        this.account = builder.account;
    }

    public Person getPerson() {
        return person;
    }

    public UserType getUserType() {
        return userType;
    }

    public Account getAccount() {
        return account;
    }

    public static class UserBuilder {
        private Person person;
        private UserType userType;
        private Account account;

        public UserBuilder() {}

        public UserBuilder withPerson(Person person) {
            this.person = person;
            return this;
        }

        public UserBuilder withUserType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public UserBuilder withAccount(Account account) {
            this.account = account;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

