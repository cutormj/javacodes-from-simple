package person;

import name.Name;
public class Person {
    private Name name;
    private String email;
    private String phoneNumber;

    private Person(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class Builder {
        private Name name;
        private String email;
        private String phoneNumber;

        public Builder() {}

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    // getters for name, email, phoneNumber
    public Name getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPersonInfo() {
        return "Name: " + name.getFullName() + "\nEmail: " + email + "\nPhone Number: " + phoneNumber;
    }


}
