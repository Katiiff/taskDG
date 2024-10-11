import org.example.Organization;
import org.example.OrganizationService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrganizationServiceTest {

    @Test
    void testGetOrganizationByCode() {
        OrganizationService organizationService = spy(new OrganizationService());

        Organization org1 = new Organization("Microsoft", "1");
        Organization org2 = new Organization("Apple", "2");

        when(organizationService.getAllOrganizations()).thenReturn(List.of(org1, org2));

        Organization result = organizationService.getOrganizationByCode("1");
        assertEquals(org1, result);

        result = organizationService.getOrganizationByCode("100");
        assertNull(result);
    }
}
