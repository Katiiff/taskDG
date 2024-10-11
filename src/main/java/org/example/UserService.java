package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    /**
     * Получение всех неуволенных пользователей.
     * @return Список неуволенных пользователей
     */
    public List<User> getHiredUsers(List<User> users) {
        return users.stream()
                .filter(user -> user.getStatus() == UserStatus.HIRED)
                .collect(Collectors.toList());
    }

    /**
     * Получает всех пользователей из базы данных.
     *
     * @return список всех пользователей
     */
    public List<User> getAllUsers() {
        //получение пользователей из БД
        return List.of();
    }

}
