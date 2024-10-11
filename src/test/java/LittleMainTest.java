import org.example.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LittleMainTest {

    @Test
    public void testExecute() {
        UserService userService = mock(UserService.class);
        OrganizationService organizationService = mock(OrganizationService.class);

        User user1 = new User("Иван Иванов", 25, "DevOps", UserStatus.HIRED, 1L, "1");
        User user2 = new User("Сидор Сидоров", 28, "Тестировщик", UserStatus.HIRED, 2L, "2");
        User user3 = new User("Петр Петров", 19, "Инженер", UserStatus.FIRED, null, null);

        List<User> users = List.of(user1, user2, user3);

        when(userService.getHiredUsers(users)).thenReturn(List.of(user1, user2));

        Organization org1 = new Organization("Microsoft", "1");
        Organization org2 = new Organization("Apple", "2");

        List<Organization> organizations = List.of(org1, org2);

        when(organizationService.getOrganizationByCode("1")).thenReturn(org1);
        when(organizationService.getOrganizationByCode("2")).thenReturn(org2);
        when(organizationService.getOrganizationByCode("без подразделения")).thenReturn(null);

        LittleMain littleMain = new LittleMain(userService, organizationService);
        List<String> result = littleMain.execute(users, organizations);

        assertEquals(List.of(
                "Иван Иванов имеет код - 1 в Microsoft.",
                "Сидор Сидоров имеет код - 2 в Apple."
        ), result);
    }
}