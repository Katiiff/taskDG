package org.example;

import java.util.List;

public class OrganizationService {

    /**
     * Получает организацию по ее уникальному коду.
     *
     * @param code уникальный код организации
     * @return организация с указанным кодом, или null, если такой не найдена
     */
    public Organization getOrganizationByCode(String code) {
        return getAllOrganizations().stream()
                .filter(org -> org.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    /**
     * Получает все организации из базы данных.
     *
     * @return список всех организаций
     */
    public List<Organization> getAllOrganizations() {
        //получение организаций из БД
        return List.of();
    }

}
