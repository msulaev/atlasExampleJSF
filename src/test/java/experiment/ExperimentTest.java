package experiment;

import com.pdffiller.entity.User;
import extension.CustomParameterExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class ExperimentTest {

    @ExtendWith(CustomParameterExtension.class)
    @Test
    void test(User user){
        System.out.println(user.getPwd());
        System.out.println(user.getEmail());
        System.out.println(user.toString());
    }
}
