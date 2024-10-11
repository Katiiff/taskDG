package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class LittleMain {
        private final UserService userService;
        private final OrganizationService organizationService;

    /**
     * Конструктор класса LittleMain.
     *
     * @param userService сервис для работы с пользователями
     * @param organizationService сервис для работы с организациями
     */
    public LittleMain(UserService userService, OrganizationService organizationService) {
            this.userService = userService;
            this.organizationService = organizationService;
    }

    /**
     * Выполняет задачу получения всех не уволенных пользователей и их подразделений.
     *
     * @param users список всех пользователей
     * @param organizations список всех организаций
     * @return коллекция строк с информацией о пользователях и их подразделениях
     */
        public List<String> execute(List<User> users, List<Organization> organizations) {
            List<User> hiredUsers = userService.getHiredUsers(users);

            return hiredUsers.stream()
                    .map(user -> {
                        String departmentCode = user.getDepartmentCode() != null ? user.getDepartmentCode() : "без подразделения";
                        Organization organization = organizationService.getOrganizationByCode(departmentCode);
                        String departmentName = organization != null ? organization.getName() : "без подразделения";
                        return String.format("%s имеет код - %s в %s.", user.getName(), departmentCode, departmentName);
                    })
                    .collect(Collectors.toList());
        }
}