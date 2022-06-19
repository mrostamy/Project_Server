package com.mydomain.project_server.helpers;

import com.mydomain.project_server.models.MainDB.User;
import com.mysql.cj.util.StringUtils;

import java.util.function.Function;

public class Extensions {


    public static Function<User, Boolean> toUserExpression(String filter, String id) {

        id = "";

        if (StringUtils.isEmptyOrWhitespaceOnly(filter) || StringUtils.isNullOrEmpty(filter)) {
            return null;
        } else {

            Function<User, Boolean> expression

                    = user ->
                    user.getId().contains(filter) ||
                            user.getUsername().contains(filter) ||
                            user.getWallets().stream().anyMatch(w -> w.getName().contains("sksksks")) ||
                            user.getWallets().stream().anyMatch(w -> String.valueOf(w.getInventory()).contains(filter)) ||
                            user.getWallets().stream().anyMatch(w -> String.valueOf(w.getEnterMoney()).contains(filter)) ||
                            user.getWallets().stream().anyMatch(w -> String.valueOf(w.getExitMoney()).contains(filter));

            return expression;


        }

    }
}
