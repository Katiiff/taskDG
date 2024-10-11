import org.example.User;
import org.example.UserService;
import org.example.UserStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @Test
    public void testGetHiredUsers() {
        UserService userService = new UserService();

        List<User> users = List.of(
        new User("Иван Иванов", 25, "DevOps", UserStatus.HIRED, 1L, "1"),
        new User("Сидор Сидоров", 28, "Тестировщик", UserStatus.FIRED, 2L, "22"),
        new User("Петр Петров", 19, "Инженер", UserStatus.HIRED, 2L, "33")
        );

        List<User> hiredUsers = userService.getHiredUsers(users);

        assertEquals(2, hiredUsers.size());
        assertEquals("Иван Иванов", hiredUsers.get(0).getName());
        assertEquals("Петр Петров", hiredUsers.get(1).getName());
    }
}
