package LMS.Util;

import LMS.exseptions.InvalidInputExceptions;

public class InputUtil {
    public static Long readId(String input) {
        try {
            long id = Long.parseLong(input);

            if (id <= 0) {
                throw new InvalidInputExceptions(
                        "ID нөлдөн чоң болушу керек!"
                );
            }
            return id;
        } catch (NumberFormatException e) {
            throw new InvalidInputExceptions(
                    "ID үчүн сан гана киргизиңиз!"
            );
        }
    }
}


