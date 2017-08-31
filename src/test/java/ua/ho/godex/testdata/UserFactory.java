package ua.ho.godex.testdata;

import ua.ho.godex.domain.Role;
import ua.ho.godex.domain.User;

public class UserFactory {
    public static User getAdmin() {
        return new User(
                1,
                "admin@mail.com",
                "Administrator",
                "$2a$10$8IHi8NJot3CY5BDlHrivr.cVMJwtznYTNli3p7GcgwOtsF8VxgMWK",
                Role.ADMIN
        );
    }

    public static User getUser() {
        return new User(
                2,
                "user@mail.com",
                "Username",
                "$2a$10$PgBb/VbejOXpdopzGU3AquVu9LDr9PhQ0fcBiGIYsVQeKB.p/paQm",
                Role.USER
        );
    }

    public static User getNewUser() {
        return new User(
                null,
                "New User",
                "new_user@mail.com",
                "pass",
                Role.USER
        );
    }
}
